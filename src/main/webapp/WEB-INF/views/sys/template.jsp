<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>菜单管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="<%=basePath%>zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css" type="text/css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
	<script
		src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>zTree_v3/js/jquery.ztree.core.js"></script>
			<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.exedit.js"></script>
	<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
	<script src="<%=basePath%>layui/layui.js"></script>
	<script type="text/javascript">
		$(function() {
			var setting = {
				data : {
					simpleData : {
						enable : true
					}
				},
				callback: {
					onClick: onClick
					
				}
			};
			var zNodes;
			var treeNode_1;
			$.ajax({
				url : 'jc_house/fke_template.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					name : 'yang',
					age : 25
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					zNodes = data.zNodes;
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
					
				}
			})

		})
		
		function onClick(event, treeId, treeNode, clickFlag) {
			$("#name").val(treeNode.name);
			 /* alert(treeNode.getParentNode());  */
			 if(treeNode.getParentNode() != null){
				 $("#father_name").val(treeNode.getParentNode().name);
			 }else{
				 $("#father_name").val(''); 
			 }
			$("#menu_id").val(treeNode.id);
			$("#sort").val(treeNode.sort);
			$("#menu_level").val(treeNode.menu_level);			
			$("#score").val(treeNode.score);
			$(".btn").prop({
				  disabled: false
				});
			treeNode_1 = treeNode;
			return false;
		}	
		
		//一般直接写在一个js文件中
		layui.use(['layer', 'form'], function(){
		  var layer = layui.layer
		  ,form = layui.form;
		});
		
		function removeHoverDom(treeId, treeNode) {
			if(treeNode == '1'){
			var template_id = $("#menu_id").val();
			if(template_id == ''){
					layer.msg('请选择要删除的模板'); 
					return false;
			}
			 layer.confirm('确定要删除吗？', {
				  btn: ['删除', '取消'], //可以无限个按钮
				  offset: '100px'
				}, function(index){
					layer.close(index);
					 $.ajax({
							url : 'jc_house/delete_template.action',
							type : 'POST', //GET
							async : true, //或false,是否异步
							data : {
								"template_id" : template_id
							},
							timeout : 5000, //超时时间
							dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
							success : function(data) {
								$("#"+treeNode_1.tId).remove();
							},
							error : function(data) {
								alert("错误");
								console.log('错误')
							}
						}) 
						
				}, function(index){
				  //按钮【按钮二】的回调
				});
			}
			
		};
		
		function add_same_levels(){
			var menu_level = treeNode_1.menu_level;
			$("#menu_level").val(treeNode_1.menu_level);
			var father_id = null;
			if(treeNode_1.pId == null){
				father_id = "0";
			}else{
				father_id = treeNode_1.pId
			}
			$("#father_id").val(father_id);
			$.ajax({
				url : 'menu/add_level.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"menu_level" : menu_level,
					"father_id" : father_id
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					$("#menu_sort").val(data.maxSort + 1);
					$("#sort").val(data.maxSort + 1);
					$("#menu_id").val('');
					$("#name").val('');
					$("#menu_url").val('');
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		}
		
		
		function save_template(){
			var menu_level = $("#menu_level").val();
			var father_name = $("#father_name").val();
			var name = $("#name").val();
			var score = $("#score").val();
			var id = $("#menu_id").val();			
			var url = null;
			
			if(id == null || id ==''){
				url = "jc_house/save_next_template.action";
			}else{
				url = "jc_house/save_template.action";
			}			
			$.ajax({
				url : url,
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"menu_level" : menu_level,
					"father_name" : father_name,
					"name" : name,
					"score" : score,
					"id":id
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					 /* var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					alert(treeNode_1.getParentNode() + "----" + data.treeNode.name);
					if(treeNode_1.getParentNode() == null){
						zTree.addNodes(treeNode_1, data.treeNode);
					}else{
						zTree.addNodes(treeNode_1.getParentNode(), data.treeNode);
					}  */
					 if(data.success){
						alert("更新成功");
						location.reload();
					}
					else{
						alert("fail")
					} 
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		}
		
		 function add_next_levels(){
			var menu_level = treeNode_1.menu_level;
			menu_level = menu_level + 1;
			$("#menu_level").val(menu_level);
			var father_id = treeNode_1.id;
			$("#father_id").val(father_id);
			$("#father_name").val(treeNode_1.name);
			$.ajax({
				url : 'menu/add_level.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"menu_level" : menu_level,
					"father_id" : father_id
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					$("#menu_sort").val(data.maxSort + 1);
					$("#sort").val(data.maxSort + 1);
					$("#menu_id").val('');
					$("#name").val('');
					$("#menu_url").val('');
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		} 
	</script>
<style type="text/css">
.content-wrapper, .main-footer {
	margin-left: 0px;
	position: fixed;
	bottom: 0;
	right: 0;
	width: 100%;
}

body {
	background-color: #ecf0f5;
}

.ztree li span.button.pIcon01_ico_open {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/1_open.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.pIcon01_ico_close {
	margin-right: 2px;
	background:
		url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/1_close.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.pIcon02_ico_open, .ztree li span.button.pIcon02_ico_close
	{
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/2.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon01_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/3.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon02_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/4.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon03_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/5.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon04_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/6.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon05_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/7.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon06_ico_docu {
	margin-right: 2px;
	background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/8.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}
</style>
</head>
<body style="overflow: hidden">
	<div>

		<!-- Content Wrapper. Contains page content -->
		<div style="background-color: #ecf0f5;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					模板管理 <small>TEMPLATE INFORMATION</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">模板管理</a></li>
					<li class="active">模板列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box" style="height:893px;">
							<div class="panel panel-primary"
								style="width: 100%; min-height: 40%;float:left;">
								<div class="panel-heading">模板列表</div>
								<div class="content_wrap">
									<div class="zTreeDemoBackground left">
										<ul id="treeDemo" class="ztree"></ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default" style="float:right;width: 100%;height:100%;">
							  <div class="panel-body" style="padding-left: 10px;">
							  	<div class="btn-group btn-group-justified" role="group" aria-label="..." style="margin-bottom: 20px;width:300px;">
								  <div class="btn-group" role="group">
								    <button id="add_same_level" type="button" onclick="add_same_levels();" class="btn btn-primary active" disabled="disabled">
								    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								    	添加同级
								    </button>
								  </div>
								  <div class="btn-group" role="group">
								    <button type="button" onclick="add_next_levels();" class="btn btn-primary active" disabled="disabled">
								    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								  	  添加下级
								    </button>
								  </div>
								  <div class="btn-group" role="group">
								    <button type="button" class="btn btn-primary active" onclick="removeHoverDom('treeDemo', '1')">
								    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								    	删除
								    </button>
								  </div>
								</div>
							    <div class="input-group input-group-lg" style="margin-bottom: 20px;">
									  <div class="input-group-btn">
									  <button type="button" class="btn btn-default" aria-label="Bold">
									  <span class="glyphicon glyphicon-king">内容</span>
									  </button>
									  </div>
									  <input id="name" type="text" style="width:70%" class="form-control" placeholder="考核内容" aria-describedby="sizing-addon1">
								</div>
								<div class="input-group input-group-lg" style="margin-bottom: 20px;">
									  <div class="input-group-btn">
									  <button  type="button" class="btn btn-default" aria-label="Bold">
									  <span class="glyphicon glyphicon-pawn">类别</span>
									  </button>
									  </div>
									  <input id="father_name" readonly="readonly" type="text" style="width:70%" class="form-control" placeholder="考核类别" aria-describedby="sizing-addon1">
								</div>
								<div class="input-group input-group-lg" style="margin-bottom: 20px;">
									  <div class="input-group-btn">
									  <button type="button" class="btn btn-default" aria-label="Bold">
									  <span class="glyphicon glyphicon-th-list">级别</span>
									  </button>
									  </div>
									  <input id="menu_level" type="text" style="width:70%" class="form-control" placeholder="级别" aria-describedby="sizing-addon1">
								</div>
								<div class="input-group input-group-lg" style="margin-bottom: 20px;">
									  <div class="input-group-btn">
									  <button type="button" class="btn btn-default" aria-label="Bold">
									  <span class="glyphicon glyphicon-th-list">分数</span>
									  </button>
									  </div>
									  <input id="score" type="text" style="width:70%" class="form-control" placeholder="分数" aria-describedby="sizing-addon1">
								</div>
								</div>
								<input type="hidden" name="hidden" id="menu_id">
								<input type="hidden" name="hidden" id="menu_sort">
								<input type="hidden" name="hidden" id="menu_level">
								<input type="hidden" name="hidden" id="father_id">
								<p style="margin-left:50px;">
									<button type="button" onclick="save_template()" class="btn btn-primary  btn-lg">
										<span class="glyphicon glyphicon-floppy-save" ></span>
									保存
									</button>
									<button type="reset" class="btn btn-primary  btn-lg" style="margin-left:160px;">
										<span class="glyphicon glyphicon-refresh"></span>
									清除
									</button>
								</p>
							  </div>
							</div>
						</div>
					</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>版本</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2017-2022 <a
				href="http://www.jnhouse.com/" target="_blank">中住地产有限公司</a>.
			</strong> 版权所有.
		</footer>
		<div class="control-sidebar-bg"></div>
	</div>
</body>
</html>
