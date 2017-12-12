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
<title>部门管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">

<link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/sweetalert/sweetalert.css">

<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table-export.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/tableExport.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/jquery.min.js"></script>
</head>
<body>
<table data-pagination="true" data-search="true" data-toggle="table" data-url="answer/selectAnswer.action">
    <thead>
        <tr>
            <th data-field="templateid">模板id</th>
            <th data-field="checkdate">进店日期</th>
            <th data-field="starttime">访问开始时间</th>
            <th data-field="endtime">访问结束时间</th>
        </tr>
    </thead>
</table>
</body>
</html>
