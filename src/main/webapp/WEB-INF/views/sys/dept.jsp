<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>部门管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>bower_components/Ionicons/css/ionicons.min.css">	
<!-- Theme style -->
<link rel="stylesheet" href="<%=basePath%>zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>bower_components/select2/dist/css/select2.min.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
	<script
		src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script
		src="<%=basePath%>bower_components/select2/dist/js/select2.full.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>zTree_v3/js/jquery.ztree.core.js"></script>
			<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.exedit.js"></script>
	<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
	<script src="<%=basePath%>layui/layui.js"></script>
	<script type="text/javascript">
		$(function() {
			 $('#select2').select2();
			
			var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey: "id",
						pIdKey: "pId",
						rootPId: 0
					}
				},
				callback: {
					onClick: onClick
				}
			};
			var zNodes;
			var treeNode_1;
			$.ajax({
				url : 'dept/aJsonObject.do',
				type : 'POST', //GET
				async : false, //或false,是否异步
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
			$("#dept_id").val(treeNode.id);
			$("#dept_sort").val(treeNode.sort);
			$("#sort").val(treeNode.sort);
			$("#dept_level").val(treeNode.dept_level);
			$("#father_id").val(treeNode.pId);
			var roles = $('#select2').select2();
			roles.val(treeNode.role_ids).trigger("change");
			$(".btn").prop({
				  disabled: false
				});
			treeNode_1 = treeNode;
		}	
		
		//一般直接写在一个js文件中
		layui.use(['layer', 'form'], function(){
		  var layer = layui.layer
		  ,form = layui.form;
		});
		
		function removeHoverDom(treeId, treeNode) {
			if(treeNode == '1'){
			var dept_id = $("#dept_id").val();
			if(dept_id == ''){
					layer.msg('请选择要删除的部门',{offset: '250px'}); 
					return false;
			}
			 layer.confirm('确定要删除吗？', {
				  btn: ['删除', '取消'], //可以无限个按钮
				  offset: '100px'
				}, function(index){
					layer.close(index);
					 $.ajax({
							url : 'dept/delete_dept.action',
							type : 'POST', //GET
							async : true, //或false,是否异步
							data : {
								"dept_id" : dept_id
							},
							timeout : 5000, //超时时间
							dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
							success : function(data) {
								$("#"+treeNode_1.tId).remove();
								layer.msg('删除成功',{offset: '250px'});
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
		var flag = 0;
		function add_same_levels(){
			var dept_level = treeNode_1.dept_level;
			$("#dept_level").val(treeNode_1.dept_level);
			var father_id = null;
			if(treeNode_1.pId == null){
				father_id = "0";
			}else{
				father_id = treeNode_1.pId
			}
			$("#father_id").val(father_id);
			flag = 1;
			layer.load(1,{offset: '250px'});
			$.ajax({
				url : 'dept/add_same_level.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"dept_level" : dept_level,
					"father_id" : father_id
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					$("#dept_sort").val(data.maxSort + 1);
					$("#sort").val(data.maxSort + 1);
					$("#dept_id").val('');
					$("#name").val('');
					var roles = $('#select2').select2();
					roles.val("").trigger("change");
					setTimeout(function(){
						  layer.closeAll('loading');
						}, 1000);
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		}
		
		
		function save_dept(){
			var dept_level = $("#dept_level").val();
			var father_id = $("#father_id").val();
			var name = $("#name").val();
			var sort = $("#sort").val();
			var roles = $('#select2').select2();
			var id = $("#dept_id").val();
			var role_id = roles.val().toString();
			layer.load(1,{offset: '250px'});
			$.ajax({
				url : 'dept/save_dept.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"id" : id,
					"role_ids" : role_id,
					"dept_level" : dept_level,
					"father_id" : father_id,
					"name" : name,
					"sort" : sort
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					if( null != id && "" != id){
						var index = treeNode_1.getIndex()
						zTree.removeNode(treeNode_1, false);
						zTree.addNodes(treeNode_1.getParentNode(),index, data.treeNode);
					}else{
						if(flag == 2){
							zTree.addNodes(treeNode_1, data.treeNode);
						}else{
							zTree.addNodes(treeNode_1.getParentNode(), data.treeNode);
						}
						
					}
					
					setTimeout(function(){
						  layer.closeAll('loading');
						}, 1000);
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		}
		
		function add_next_levels(){
			var dept_level = treeNode_1.dept_level;
			dept_level = dept_level + 1;
			$("#dept_level").val(dept_level);
			var father_id = treeNode_1.id;
			$("#father_id").val(father_id);
			$("#father_name").val(treeNode_1.name);
			layer.load(1,{offset: '250px'});
			flag = 2;
			$.ajax({
				url : 'dept/add_same_level.action',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"dept_level" : dept_level,
					"father_id" : father_id
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					setTimeout(function(){
						  layer.closeAll('loading');
						}, 1000);
					$("#dept_sort").val(data.maxSort + 1);
					$("#sort").val(data.maxSort + 1);
					$("#dept_id").val('');
					$("#name").val('');
					var roles = $('#select2').select2();
					roles.val("").trigger("change");
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
.ztree li span.button.pIcon01_ico_open {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/1_open.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.pIcon01_ico_close {
	margin-right: 2px;
	background:
		url(zTree_v3/css/zTreeStyle/img/diy/1_close.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.pIcon02_ico_open, .ztree li span.button.pIcon02_ico_close
	{
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/2.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon01_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/3.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon02_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/4.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon02_ico_close, .ztree li span.button.icon02_ico_open {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/4.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon03_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/10.gif)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon04_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/6.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon05_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/7.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.icon06_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/8.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
} 

.ztree li span.button pIcon01_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/1_open.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}

.ztree li span.button.pIcon01_ico_docu {
	margin-right: 2px;
	background: url(zTree_v3/css/zTreeStyle/img/diy/1_open.png)
		no-repeat scroll 0 0 transparent;
	vertical-align: top;
	*vertical-align: middle
}
</style>
</head>
<body style="background-color: #ecf0f5;">
	<div>


		<!-- Content Wrapper. Contains page content -->
		<div style="background-color: #ecf0f5;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					部门信息 <small>DEPARTMENT INFORMATION</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="javascript:void(0);">系统管理</a></li>
					<li class="active">部门管理</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-3">
						<div class="box box-primary">
							<div class="box-header with-border">
								<i class="ion ion-clipboard"></i>
								<h3 class="box-title">菜单列表</h3>
							</div>
							<div class="box-body">
								<div class="content_wrap">
									<div class="zTreeDemoBackground left">
										<ul id="treeDemo" class="ztree"></ul>
									</div>
								</div>
							</div>
						</div>
					</div>	
					<div class="col-md-9">
						<div class="box box-primary">
						  <div class="box-header with-border">
								<h3 class="box-title">内容</h3>
						  </div>
						  <div class="box-body box-profile">
						  	<div class="btn-group btn-group-justified" role="group" aria-label="..." style="margin-bottom: 20px;width:300px;">
							  <div class="btn-group" role="group">
							    <button id="add_same_level" type="button" onclick="add_same_levels();" class="btn btn-info" disabled="disabled">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							    	添加同级
							    </button>
							  </div>
							  <div class="btn-group" role="group">
							    <button type="button" onclick="add_next_levels();" class="btn btn-info" disabled="disabled">
							    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							  	  添加下级
							    </button>
							  </div>
							  <div class="btn-group" role="group">
							    <button type="button" class="btn btn-info" onclick="removeHoverDom('treeDemo', '1')">
							    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							    	删除
							    </button>
							  </div>
							</div>
						    <div class="input-group" style="margin-bottom: 20px;">
								  <div class="input-group-btn">
								  <button type="button" class="btn btn-default" aria-label="Bold">
								  <!-- <span class="glyphicon glyphicon-king"></span> -->
								  名称
								  </button>
								  </div>
								  <input id="name" type="text" style="width:70%" class="form-control" placeholder="部门名称" aria-describedby="sizing-addon1">
							</div>
							<div class="input-group" style="margin-bottom: 20px;">
								  <div class="input-group-btn">
								  <button  type="button" class="btn btn-default" aria-label="Bold">
								  <!-- <span class="glyphicon glyphicon-pawn"></span> -->
								  父级
								  </button>
								  </div>
								  <input id="father_name" readonly="readonly" type="text" style="width:70%" class="form-control" placeholder="上级部门" aria-describedby="sizing-addon1">
							</div>
							<div class="input-group" style="margin-bottom: 20px;">
								  <div class="input-group-btn">
								  <button type="button" class="btn btn-default" aria-label="Bold">
								  <!-- <span class="glyphicon glyphicon-th-list"></span> -->
								  排序
								  </button>
								  </div>
								  <input id="sort" type="text" style="width:70%" class="form-control" placeholder="编号" aria-describedby="sizing-addon1">
							</div>
				            <div class="input-group" style="margin-bottom: 20px;">
								  <div class="input-group-btn">
								  <button type="button" class="btn btn-default" aria-label="Bold">
								 角色
								  </button>
								  </div>
								  <select class="form-control select2" id="select2" multiple="multiple" data-placeholder="请选择角色"
				                        style="width: 70%;line-height: 100px;" id="role_id">
				                 <c:forEach items="${roleList }" var="list">
				                 <option value="${list.id }">${list.role_name }</option>
				                 </c:forEach>
				                </select>
							</div>
						</div>
						  <div class="box-footer">	 
							<input type="hidden" name="hidden" id="dept_id">
							<input type="hidden" name="hidden" id="dept_sort">
							<input type="hidden" name="hidden" id="dept_level">
							<input type="hidden" name="hidden" id="father_id">
							<p style="margin-left:300px;">
								<button type="button" onclick="save_dept()" class="btn btn-info">
									<span class="glyphicon glyphicon-floppy-save" ></span>
								保存
								</button>
								<button type="reset" class="btn btn-info" style="margin-left:160px;">
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
