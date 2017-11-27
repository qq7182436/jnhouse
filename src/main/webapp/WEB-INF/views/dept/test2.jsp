<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<title>测试</title>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=basePath%>bootstrap-table-master/dist/bootstrap-table.css">
  <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
  
  <script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
  

<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.core.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<SCRIPT type="text/javascript">
	$(function () {
		
		var setting = {
				data: {
					simpleData: {
						enable: true
					}
				}
			};
		
		$.ajax({
		    url:'aJsonObject.action',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		        name:'yang',age:25
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	$.fn.zTree.init($("#treeDemo"), setting, data.zNodes);
		    },
		    error:function(data){
		    	alert("错误");
		        console.log('错误')
		    }
		})

	  })
	</SCRIPT>
	<style type="text/css">
.ztree li span.button.pIcon01_ico_open{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/1_open.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.pIcon01_ico_close{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/1_close.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.pIcon02_ico_open, .ztree li span.button.pIcon02_ico_close{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/2.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon01_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/3.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon02_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/4.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon03_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/5.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon04_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/6.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon05_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/7.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
.ztree li span.button.icon06_ico_docu{margin-right:2px; background: url(<%=basePath%>zTree_v3/css/zTreeStyle/img/diy/8.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
	</style>
</head>
<body>
<div class="box box-primary">
<div class="panel panel-primary" style="width:300px;min-height: 300px;">
	<div class="panel-heading">部门</div>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>
</div>

</div>

</body>
</html>