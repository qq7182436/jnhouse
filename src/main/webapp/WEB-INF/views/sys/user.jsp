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
<!-- Theme style -->
<link rel="stylesheet" href="<%=basePath%>zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="<%=basePath%>dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/iCheck/all.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
	<script
		src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="<%=basePath%>bower_components/fastclick/lib/fastclick.js"></script>	
		<script
		src="<%=basePath%>bower_components/select2/dist/js/select2.full.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>zTree_v3/js/jquery.ztree.core.js"></script>
			<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.exedit.js"></script>
	<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
	<script src="<%=basePath%>layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath%>plugins/iCheck/icheck.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('input[type="checkbox"].minimal').iCheck({
			      checkboxClass: 'icheckbox_minimal-blue'
			    })
			var zNodes;
			var treeNode_1;
			//点击添加按钮
			 $("#add").click( function () { 
				 var dept_id = $("#dept_id").val();
				 if(null != dept_id && "" != dept_id){
					 $("#search_user").val("");
					 clickPage(1); 
				 }else{
					 layer.msg('请选择部门或职位', {offset: '250px'}); 
				 }
				 
			    });
			//点击添加按钮
			 $("#del_button").click( function () { 
				 var checkboxs = $("input[name^='userCheck-']:checked");
				 alert(checkboxs.length)
				 if(checkboxs.length >0){
					 var users = '';
					 $.each( checkboxs, function(i, n){
			    		  if(i == (checkboxs.length - 1)){
			    			  users += n.value 
			    		  }else{
			    			  users += n.value +","  
			    		  }
			    		});
					 $.ajax({
							url : 'user/delete_user.do',
							type : 'POST', //GET
							async : true, //或false,是否异步
							data : {
								"users" : users
							},
							timeout : 5000, //超时时间
							dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
							success : function(data) {
								find_deptUser(1);
							},
							error : function(data) {
								alert("错误");
								console.log('错误')
							}
						})
				 }else{
					 layer.msg('请选择要删除的员工', {offset: '250px'}); 
				 }
				 
			    });
			 
			//点击模态框搜索按钮
			 $("#go_search").click( function () { 
				 find_deptUser(1);
			    });
			//点击模态框搜索按钮
			 $("#go_search_user").click( function () { 
				 clickPage(1);
			    });
			 
			 $('#checkMenuTop').on('ifChecked', function(event){
			    	$("input[name^='menuCheck-']").iCheck('check');
			    	});
		    $('#checkMenuTop').on('ifUnchecked', function(event){
		    	$("input[name^='menuCheck-']").iCheck('uncheck');
		    	});
		    $('#checkuserTop').on('ifChecked', function(event){
		    	$("input[name^='userCheck-']").iCheck('check');
		    	});
		    $('#checkuserTop').on('ifUnchecked', function(event){
		    	$("input[name^='userCheck-']").iCheck('uncheck');
		    	});
			
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
			
			$.ajax({
				url : 'dept/aJsonObject.action',
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
			treeNode_1 = treeNode;
			$("#dept_id").val(treeNode_1.id);
			find_deptUser(1);
		}	
		
		//一般直接写在一个js文件中
		layui.use(['layer', 'form'], function(){
		  var layer = layui.layer
		  ,form = layui.form;
		});
		
		
		function save_user(){
			var checkboxs = $("input[name^='menuCheck-']:checked");
			var users = '';
			var dept_id = treeNode_1.id;
			if(checkboxs.length == 0){
				layer.msg('请选择要添加的用户', {offset: '250px'}); 
				return false;
			}
			$.each( checkboxs, function(i, n){
	    		  if(i == (checkboxs.length - 1)){
	    			  users += n.value 
	    		  }else{
	    			  users += n.value +","  
	    		  }
	    		  
	    		});
			layer.load(1,{offset: '250px'});
			$.ajax({
				url : 'user/save_user.do',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"dept_id" : dept_id,
					"users" : users
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					setTimeout(function(){
						  layer.closeAll('loading');
						});
					$('#myModal').modal('hide');
					find_deptUser(1);
				},
				error : function(data) {
					alert("错误");
					console.log('错误')
				}
			})
		}
		
		function clickPage(pageNum){
			var username = $("#search_user").val();
			 $("#dataTable tbody").empty();
			$("#myModal .col-md-4").remove();
			$("#myModal .col-md-8").remove();
			 $.ajax({
					url : 'user/find_allUsers.do',
					type : 'POST', //GET
					async : true, //或false,是否异步
					data : {
						"username" : username,
						"pageNum" : pageNum
					},
					timeout : 5000, //超时时间
					dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data) {
						var mess = '';
						var pms = '';
						var pageInfo = data.userInfo;
						var userList = pageInfo.list;
						for (var i = 0; i < userList.length; i++) {
							mess += "<tr><td>";
							mess += "<input type='checkbox'  name='menuCheck-" + userList[i].id + "' class='minimal' value='" + userList[i].id+"' ></td>"
							mess += "<td>" + userList[i].realname + "</td>";
							mess += "<td>" + userList[i].broker_mobile + "</td>";
							mess += "<td>" + userList[i].avatar + "</td></tr>";
						}

						$("#dataTable tbody").append(mess);
						if(userList.length > 0 ){
							pms += "<div class='col-md-4'>";
							pms += "当前<span class='label label-primary'>" + pageInfo.pageNum + "</span>";
							pms += "页，当前共<span class='label label-primary'>" + pageInfo.pages + "</span>";
							pms += "页，总共<span class='label label-primary'>" + pageInfo.total + "</span>记录</div>";
							pms += "<div class='col-md-8'>";
							pms += "<nav aria-label='Page navigation'>";
							pms += "<ul class='pagination  no-margin pull-right'>";
							pms += "<li><a href='javascript:void(0);' onclick='clickPage("+pageInfo.pageNum+")'>首页</a></li>";
							if(pageInfo.hasPreviousPage){
								pms += "<li><a href='javascript:void(0);' onclick='clickPage("+ (pageInfo.pageNum -1) +")' aria-label='Previous'>"
								pms += "<span aria-hidden='true'>&laquo;</span></a></li>";
							}
							var nums = pageInfo.navigatepageNums;
							for (var i = 0; i < nums.length; i++) {
								if(nums[i] == pageInfo.pageNum){
									pms += "<li class='active'><a href='javascript:void(0);' onclick='clickPage("+nums[i]+")'>"+nums[i]+"</a></li>";
								}else{
									pms += "<li><a href='javascript:void(0);' onclick='clickPage("+nums[i]+")'>"+nums[i]+"</a></li>";
								}
							}
							if(pageInfo.hasNextPage){
								pms += "<li><a href='javascript:void(0);' onclick='clickPage("+ (pageInfo.pageNum + 1) +")' aria-label='Previous'>"
								pms += "<span aria-hidden='true'>&raquo;</span></a></li>";
							}
							pms += "<li><a href='javascript:void(0);' onclick='clickPage("+pageInfo.pages+")'>末页</a></li></ul></nav></div>";
							$("#dataTable").after(pms);	
							  
						}
						checkbox("menuCheck-","checkMenuTop");
						$('#myModal').modal('show');
					},
					error : function(data) {
						alert("错误");
						console.log('错误')
					}
				})
		}
		//重新加载iCheck
		function checkbox(name,topId){
			$('input[type="checkbox"].minimal').iCheck({
			      checkboxClass: 'icheckbox_minimal-blue'
			    })
			$('#' + topId).on('ifChecked', function(event){
		    	$("input[name^='"+name+"']").iCheck('check');
		    	});
		    $('#' + topId).on('ifUnchecked', function(event){
		    	$("input[name^='"+name+"']").iCheck('uncheck');
		    	});
		}
		
		function find_deptUser(pageNum){
			var dept_id = $("#dept_id").val();
			var username = $("#search_text").val();
			$("#userTable tbody").empty();
			$(".col-md-4").not(".panel-body .col-md-4").remove();
			$(".col-md-8").not(".panel-body .col-md-8").remove();
			layer.load(1,{offset: '250px'});
			$.ajax({
				url : 'user/find_deptUser.do',
				type : 'POST', //GET
				async : true, //或false,是否异步
				data : {
					"dept_id" : dept_id,
					"pageNum" : pageNum,
					"username" : username
				},
				timeout : 5000, //超时时间
				dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					var mess = '';
					var pms = '';
					var pageInfo = data.msg;
					var userList = pageInfo.list;
					for (var i = 0; i < userList.length; i++) {
						mess += "<tr><td>";
						mess += "<input type='checkbox'  name='userCheck-" + userList[i].id + "' class='minimal' value='" + userList[i].id+"' ></td>"
						mess += "<td><img src='" + ('http://pic.jnhouse.com:90\/' + userList[i].photo) + "' alt='User Image' class='img-thumbnail' style='width:120px;height:100px;'></td>";
						mess += "<td>" + userList[i].realname + "</td>";
						mess += "<td>" + userList[i].mobile + "</td>";
						mess += "<td>" + userList[i].realname + "</td></tr>";
					}

					$("#userTable tbody").append(mess);
					if(userList.length > 0 ){
						pms += "<div class='col-md-4'>";
						pms += "当前<span class='label label-primary'>" + pageInfo.pageNum + "</span>";
						pms += "页，当前共<span class='label label-primary'>" + pageInfo.pages + "</span>";
						pms += "页，总共<span class='label label-primary'>" + pageInfo.total + "</span>记录</div>";
						pms += "<div class='col-md-8'>";
						pms += "<nav aria-label='Page navigation'>";
						pms += "<ul class='pagination  no-margin pull-right'>";
						pms += "<li><a href='javascript:void(0);' onclick='clickPage("+pageInfo.pageNum+")'>首页</a></li>";
						if(pageInfo.hasPreviousPage){
							pms += "<li><a href='javascript:void(0);' onclick='clickPage("+ (pageInfo.pageNum -1) +")' aria-label='Previous'>"
							pms += "<span aria-hidden='true'>&laquo;</span></a></li>";
						}
						var nums = pageInfo.navigatepageNums;
						for (var i = 0; i < nums.length; i++) {
							if(nums[i] == pageInfo.pageNum){
								pms += "<li class='active'><a href='javascript:void(0);' onclick='clickPage("+nums[i]+")'>"+nums[i]+"</a></li>";
							}else{
								pms += "<li><a href='javascript:void(0);' onclick='clickPage("+nums[i]+")'>"+nums[i]+"</a></li>";
							}
						}
						if(pageInfo.hasNextPage){
							pms += "<li><a href='javascript:void(0);' onclick='clickPage("+ (pageInfo.pageNum + 1) +")' aria-label='Previous'>"
							pms += "<span aria-hidden='true'>&raquo;</span></a></li>";
						}
						pms += "<li><a href='javascript:void(0);' onclick='clickPage("+pageInfo.pages+")'>末页</a></li></ul></nav></div>";
						$(".panel-body").after(pms);	
						  
					} 
					checkbox("userCheck-","checkuserTop"); 
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
	</script>
<style type="text/css">

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
.col-md-3, .col-md-9{
	padding-right: 0px;
	padding-left: 0px;
}
</style>
</head>
<body style="overflow: hidden;background-color: white;">
	<div>


		<!-- Content Wrapper. Contains page content -->
		<div style="background-color: #ecf0f5;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					用户信息 <small>USER INFORMATION</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">系统管理</a></li>
					<li class="active">用户管理</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-3">
						<div class="box" style="height:893px;">
							<div class="panel panel-info">
								<div class="panel-heading">部门列表</div>
								<div class="content_wrap">
									<div class="zTreeDemoBackground left">
										<ul id="treeDemo" class="ztree"></ul>
									</div>
								</div>
							</div>
						</div>
					</div>	
					<div class="col-md-9">
						<div class="panel panel-default" style="height:893px;">
						  <div class="panel-body">
						  	<div class="col-md-4">
								<div class="btn-group btn-group-justified" role="group" aria-label="..." style="margin-bottom: 10px;">
									  <div class="btn-group" role="group">
									    <button type="button" class="btn btn-info" id="add">
									    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>
									    	添加
									    </button>
									  </div>
									  <div class="btn-group" role="group">
									    <button type="button" class="btn btn-info" id="del_button">
									    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									    	删除
									    </button>
									  </div>
									</div>
								</div>
								<div class="col-md-8">
								 <div style="width:40%;float:right;margin-bottom: 10px;" class="input-group input-group-sm">
					                <input type="text" id="search_text" value="" class="form-control"  placeholder="Search for...">
					                    <span class="input-group-btn">
					                      <button type="button" id="go_search" class="btn btn-info btn-flat">Go!</button>
					                    </span>
					              </div>
					              </div>
					              <input type="hidden" name="dept_id" id="dept_id">
						   		 <table id="userTable" class="table table-bordered table-hover">
									<thead>
									<tr>
										<th width="5%"><input type="checkbox" name="userCheck" id="checkuserTop" class="minimal"></th>
										<th width="25%">用户头像</th>
										<th width="30%">用户名</th>
										<th width="30%">手机号</th>
										<th width="10%">操作</th>
									</tr>
									</thead>
									<tbody></tbody>
								</table>
						</div>
							
					  </div>
					</div>
						
					</div>
			</section>
			<!-- /.content -->
		</div>
		
		<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">用户</h4>
		      </div>
		      <div class="modal-body">
			        <form id="addRoleForm" class="form-horizontal" action="role/add_role.action" method="post">
	              <div class="box-body">
              		 <div class="row">
						<div class="col-md-12">
							<div style="width: 300px; float: left; margin-bottom: 10px;"
								class="input-group input-group-sm">
								<input type="text" id="search_user" value=""
									class="form-control" placeholder="请输入用户姓名或者手机号..."> <span
									class="input-group-btn">
									<button type="button" id="go_search_user"
										class="btn btn-info btn-flat">Go!</button>
								</span>
							</div>
						</div>
						<div class="col-md-12">
			  			<table  id="dataTable" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th align="center" width="10%"><input type="checkbox" id="checkMenuTop" class="minimal"></th>
									<th width="30%">用户名称</th>
									<th width="30%">手机号</th>
									<th width="30%">
										操作
								  	</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					  </div>
					</div>
	              </div>
	            </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="saveMenu" onclick="save_user();">保存</button>
		      </div>
		    </div>
		  </div>
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
