<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta charset="utf-8" />
	<base href="<%=basePath%>">
	<title>Tables - Ace Admin</title>
	<link href="<%=basePath%>self/css/screen.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>self/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>self/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
</head>

<body style="background-color: white;">
<table id="dataTable">
  <tr data-tt-id="1">
    <td>Parent</td>
  </tr>
  <tr data-tt-id="2" data-tt-parent-id="1">
    <td>Child</td>
  </tr>
  <tr data-tt-id="3" data-tt-parent-id="1">
    <td>Child</td>
  </tr>
  <tr data-tt-id="4" data-tt-parent-id="1">
    <td>Child</td>
  </tr>
  <tr data-tt-id="5" data-tt-parent-id="1">
    <td>Child</td>
  </tr>
</table>

	<script type="text/javascript" src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>self/js/jquery.treetable.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#dataTable").treetable({expandable:true});
});
</script>
</body>
</html>