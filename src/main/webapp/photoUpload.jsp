<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>单图片上传</title>
 </head>
 
 <link href="<%=path%>/ext/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
    
  <script type="text/javascript" src="<%=path%>/ext-4.2.1.883/ext-all.js"></script>
 <script src="<%=path%>/ext/photoUpload.js" type="text/javascript"></script>
 <body>

 
 
 
 <fieldset>
 <legend>图片上传</legend>
 <h2>只能上传单张10M以下的 PNG、JPG、GIF 格式的图片</h2>
 <form action="photoUpload.action" method="post" enctype="multipart/form-data">
     选择文件:<input type="file" name="file"> 
     <input type="submit" value="上传"> 
     <br>
     	考核明细的id
     <input type="text" name="line_id">
     <br>
      	订单的id
     <input type="text" name="header_id">
     
     <br>
     	问题的id
     <input type="text" name="secProblemId">
     
     <br>
    	 创建人
     <input type="text" name="created_by">
     
      <input type="submit" value="提交" class="btn2"  />
  </form>
 </fieldset> 
 </body>
</html>