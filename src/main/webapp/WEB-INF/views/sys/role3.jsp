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
<title>菜单管理</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="<%=basePath%>dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/iCheck/all.css">
<link href="<%=basePath%>self/css/screen.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>self/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>self/css/jquery-ui.css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css"type="text/css"> 
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

<style type="text/css">
.content-wrapper, .main-footer {
	margin-left: 0px;
	position: fixed;
	bottom: 0;
	right: 0;
	width: 100%;
}

table.treetable tr.collapsed span.indenter a {
	background-image:
		url(data:image/png;base64,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);
}

table.treetable tr.expanded span.indenter a {
	background-image:
		url(data:image/png;base64,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);
}

body {
	background-color: #ecf0f5;
}
</style>
</head>
<body>
	<div>
		<div style="background-color: #ecf0f5;">
			<section class="content-header">
				<h1>
					角色信息 <small>ROLE INFORMATION</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="javascript:void(0);">系统管理</a></li>
					<li class="active">角色列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-primary">
								<div class="box-header with-border">
									<i class="ion ion-clipboard"></i>
									<h3 class="box-title">角色列表</h3>
								</div>
								<div class="box-body">
									<div class="col-md-6">
										<div class="btn-group btn-group-justified" role="group"
											aria-label="..." style="margin-bottom: 10px; width: 300px;">
											<div class="btn-group" role="group">
												<button type="button" class="btn btn-info"
													data-toggle="modal" data-target="#myModal">
													<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
													添加
												</button>
											</div>
											<div class="btn-group" role="group">
												<button type="button" id="update_button"
													class="btn btn-info">
													<span class="glyphicon glyphicon-retweet"
														aria-hidden="true"></span> 修改
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
									<div class="col-md-6">
										<div style="width: 200px; float: right; margin-bottom: 10px;"
											class="input-group input-group-sm">
											<input type="text" id="search_text" value="${role_name }"
												class="form-control" placeholder="Search for..."> <span
												class="input-group-btn">
												<button type="button" id="go_search"
													class="btn btn-info btn-flat">Go!</button>
											</span>
										</div>
									</div>
									<table class="table table-bordered table-hover">
										<tr>
											<th width="5%"><input type="checkbox"
												name="roleCheck" id="checkTop" class="minimal"></th>
											<th width="35%">角色名称</th>
											<th width="35%">角色描述</th>
											<th width="25%">操作</th>
										</tr>
										<c:forEach items="${pageInfo.list }" var="roles">
											<tr>
												<td>
												<input type="checkbox" name="roleCheck"
													class="minimal" value="${roles.id }"></td>
												<td id="td-name-${roles.id }">${roles.role_name }</td>
												<td id="td-describe-${roles.id }">${roles.role_describe }</td>
												<td>
													<button type="button" onclick="changeRole(${roles.id })"
														class="btn btn-info btn-sm">
														<span class="glyphicon glyphicon-retweet"
															aria-hidden="true"></span> 修改
													</button>
													<button type="button" name="del_btn"
														onclick="deleteRole(${roles.id })"
														class="btn btn-danger btn-sm">
														<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
														删除
													</button>
													<button type="button" name="del_btn"
														onclick="changeMenu(${roles.id })"
														class="btn btn-success btn-sm">
														<span class="glyphicon glyphicon-modal-window"
															aria-hidden="true"></span> 配置菜单
													</button>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<div class="box-footer with-border">
									<div class="col-md-6">
										当前<span class="label label-primary">${pageInfo.pageNum }</span>
										页，总共当前<span class="label label-primary">${pageInfo.pages }</span>
										页，总共<span class="label label-primary">${pageInfo.total }</span>
										记录
									</div>
									<div class="col-md-6">
										<nav aria-label="Page navigation">
											<input type="hidden" name="pageNum" id="pageNum"
												value="${pageInfo.pageNum}">
											<ul class="pagination  no-margin pull-right">
												<li><a
													href="<%=basePath%>role/role_views.action?pageNum=1">首页</a></li>
												<c:if test="${pageInfo.hasPreviousPage }">
													<li><a
														href="<%=basePath%>role/role_views.action?pageNum=${pageInfo.pageNum-1}&role_name=${role_name}"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>

												<c:forEach items="${pageInfo.navigatepageNums }"
													var="page_num">
													<c:if test="${page_num == pageInfo.pageNum}">
														<li class="active"><a
															href="<%=basePath%>role/role_views.action?pageNum=${page_num}&role_name=${role_name}">${page_num}</a></li>
													</c:if>
													<c:if test="${page_num != pageInfo.pageNum}">
														<li><a
															href="<%=basePath%>role/role_views.action?pageNum=${page_num}&role_name=${role_name}">${page_num}</a></li>
													</c:if>
												</c:forEach>
												<c:if test="${pageInfo.hasNextPage }">
													<li><a
														href="<%=basePath%>role/role_views.action?pageNum=${pageInfo.pageNum+1}&role_name=${role_name}"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>

												<li><a
													href="<%=basePath%>role/role_views.action?pageNum=${pageInfo.pages}&role_name=${role_name}"">末页</a></li>
											</ul>
										</nav>
									</div>
								</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">添加角色</h4>
		      </div>
		      <div class="modal-body">
			        <form id="addRoleForm" class="form-horizontal" action="role/add_role.action" method="post">
	              <div class="box-body">
	                <div class="form-group">
	                  <label for="role_name" class="col-sm-2 control-label">角色名称</label>
	
	                  <div class="col-sm-10">
	                  	<input type="hidden" name="id" id="role_id" >
	                    <input type="text" id="role_name" maxlength="20" name="role_name" class="form-control"  placeholder="角色名称">
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label for="role_describe" class="col-sm-2 control-label">角色描述</label>
	
	                  <div class="col-sm-10">
	                    <textarea class="form-control"  maxlength="255"  id="role_describe" name="role_describe"  rows="3" placeholder="角色描述 ..."></textarea>
	                  </div>
	                </div>
	              </div>
	            </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="save_btn">保存</button>
		      </div>
		    </div>
		  </div>
		</div>
		
				<!-- Modal -->
		<div class="modal fade bs-example-modal-lg" id="myMenu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">菜单权限</h4>
		      </div>
		      <div class="modal-body">
			        <form id="addRoleForm" class="form-horizontal" action="role/add_role.action" method="post">
	              <div class="box-body">
	                <div class="row">
					  <div class="col-md-12">
			  			<table  id="dataTable" class="table table-bordered table-hover">
							<tr>
								<th align="center" width="20%"><input type="checkbox" id="checkMenuTop" class="minimal"></th>
								<th width="30%">菜单名称</th>
								<th width="30%">路径</th>
								<th width="20%">
									操作
							  	</th>
							</tr>
							<c:forEach items="${menusList }" var="menu">
								<c:if test="${menu.father_id == null }">
									<tr data-tt-id="${menu.id }">
								</c:if>
								<c:if test="${menu.father_id != null }">
									<tr data-tt-id="${menu.id }" data-tt-parent-id="${menu.father_id }">
								</c:if>
									<td><input type="checkbox" name="menuCheck-${menu.id }" class="minimal" value="${menu.id }"></td>
									<td id="td-name-${menu.id }">${menu.menu_name }</td>
									<td id="td-describe-${menu.id }">${menu.url }</td>
									<td>
									    <button type="button" name="menu_btn" class="btn btn-success btn-sm">
										    <span class="glyphicon glyphicon-modal-window" aria-hidden="true"></span>
										  	  配置
									    </button>
								    </td>
								</tr>
							</c:forEach>
						</table>
					  </div>
					</div>
	              </div>
	            </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="saveMenu">保存</button>
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
<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=basePath%>bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>bower_components/fastclick/lib/fastclick.js"></script>		
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
 <script src="<%=basePath%>layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" src="<%=basePath%>self/js/jquery.treetable.js"></script>
	<script type="text/javascript">
		layui.use(['layer', 'form'], function(){
			  var layer = layui.layer
			  ,form = layui.form;
			});
		$(function () {
			$("#dataTable").treetable({expandable:true});
			//iCheck for checkbox and radio inputs
		    $('input[type="checkbox"].minimal').iCheck({
		      checkboxClass: 'icheckbox_minimal-blue'
		    })
		    $("#save_btn").click( function () { 
		    	$("#addRoleForm").submit(); 
		    });
		    $("#update_button").click( function () { 
		    	var checkboxs = $('input[type=checkbox]:checked');
		    	if(checkboxs.length == 1){
		    		var id = $('input[type=checkbox]:checked').val();
		    		var role_name = $("#td-name-" + id).text();
		    		var role_describe = $("#td-describe-" + id).text();
		    		$("#role_name").val(role_name)
		    		$("#role_describe").val(role_describe)
		    		$("#role_id").val(id)
		    		$('#myModal').modal('show');
		    	}else if(checkboxs.length < 1){
		    		layer.tips('请选择要修改的角色', '#update_button');
		    	}else{
		    		layer.tips('一次只能修改一个角色', '#update_button');
		    	}
		    	 
		    });
		    $("#del_button").click( function () { 
		    	var checkboxs = $('input[type=checkbox]:checked');
		    	var ids = '';
		    	if(checkboxs.length <1){
		    		layer.tips('请选择要删除的角色', '#del_button');
		    	}else{
		    		$.each( checkboxs, function(i, n){
			    		  if(i == (checkboxs.length - 1)){
			    			  ids += n.value 
			    		  }else{
			    			  ids += n.value +","  
			    		  }
			    		  
			    		});
		    		var pageNum = $("#pageNum").val();
		    		window.location.href="role/role_delete.action?ids="+ids + "&pageNum=" + pageNum; 
		    	}
		    	
		    });
		    $('#checkTop').on('ifChecked', function(event){
		    	$("input[name='roleCheck']").iCheck('check');
		    	});
		    $('#checkTop').on('ifUnchecked', function(event){
		    	$("input[name='roleCheck']").iCheck('uncheck');
		    	});
		    $('#checkMenuTop').on('ifChecked', function(event){
		    	$("input[name^='menuCheck']").iCheck('check');
		    	});
		    $('#checkMenuTop').on('ifUnchecked', function(event){
		    	$("input[name^='menuCheck']").iCheck('uncheck');
		    	});
		    
		    $("#go_search").click( function () { 
		    	var role_name = $("#search_text").val();
		    	var pageNum = $("#pageNum").val();
		    	window.location.href="role/role_views.action?pageNum=" + pageNum + "&role_name=" + role_name;
		    });
		    $("#saveMenu").click( function () { 
		    	var checkboxs = $("input[name^='menuCheck']:checked");
		    	var menus = '';
		    	var role = $("#role_id").val();
		    	$.each( checkboxs, function(i, n){
		    		  if(i == (checkboxs.length - 1)){
		    			  menus += n.value 
		    		  }else{
		    			  menus += n.value +","  
		    		  }
		    		  
		    		});
		    	//当有菜单被选中时，添加角色菜单关系
		    	if(menus.length >0){
		    		$.ajax({
						url : 'menu/save_role_menus.action',
						type : 'POST', //GET
						async : true, //或false,是否异步
						data : {
							"menus" : menus,
							"role" : role
						},
						timeout : 5000, //超时时间
						dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
						success : function(data) {
							$('#myMenu').modal('hide');
						},
						error : function(data) {
							alert("错误");
							console.log('错误')
						}
					}) 
		    	}else{
		    		layer.tips('请选择要添加的菜单', '#saveMenu', {
		    			  tips: [1, '#0FA6D8'] //还可配置颜色
		    			});
		    	}
		    	
		    });
		  })
		  
		  function changeRole(id){
	    		var role_name = $("#td-name-" + id).text();
	    		var role_describe = $("#td-describe-" + id).text();
	    		$("#role_name").val(role_name)
	    		$("#role_describe").val(role_describe)
	    		$("#role_id").val(id)
	    		$('#myModal').modal('show');
			}
		 function deleteRole(id){
				layer.confirm('确定删除该角色吗？', {
		    		  btn: ['是','否'] //按钮
		    		 ,offset: '250px'
		    		}, function(){
		    			var pageNum = $("#pageNum").val();
		        		window.location.href="role/role_delete.action?ids="+id + "&pageNum=" + pageNum; 
		    		}, function(){
		    		});
				
				}
		  function changeMenu(id){
			  $("input[name^='menuCheck']").iCheck('uncheck');
			  $.ajax({
					url : 'menu/query_role_menus.action',
					type : 'POST', //GET
					async : true, //或false,是否异步
					data : {
						"role" : id
					},
					timeout : 5000, //超时时间
					dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data) {
						var list = data.msg;
						$.each( list, function(i, n){
							$("input[name='menuCheck-"+n+"']").iCheck('check');
				    		});
					},
					error : function(data) {
						alert("错误");
						console.log('错误')
					}
				})
	    		$("#role_id").val(id);
	    		$('#myMenu').modal('show');
			}
	</script>
</body>
</html>
