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
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table-export.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/tableExport.js"></script>
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
<script type="text/javascript">
	$(function () {  
    $('#dataTable').on('click-row.bs.table', function (e, row, element) {
    	queryAnswerLine(row);       
    }); 
    function queryAnswerLine(row){    	 
    	$.post("answer/queryAnswerLine.action",{templateid:row.templateid},function(result){
  			$.each(result,function(i,item){
  				
  			});
    	},'json');
    	$('#myModal').modal("show");
    }
}) 

function template(v){
	if(v=='11'){return '模板二';}
	if(v=='12'){return '模板三';}
}
</script>
</head>
<body>
<!-- 模态框start -->
	<div class="container">
    <form method="post" action="#" class="form-horizontal" role="form" id="myForm" onsubmit="return ">
        <div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <!-- 定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
               <!--   显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                     <!-- 显示模态框白色背景，所有内容都写在这个div里面  -->
                    <div class="btn-info modal-header">                       
                        <button type="button" class="close" data-dismiss="modal">&times;</button>                        
                        <h4>答案详情</h4>                        
                    </div>
                    <div class="modal-body">
                         <!-- 模态框内容，我在此处添加一个表单 -->
                        <form class="form-horizontal" role="form">
                            <ul class="list-group">
							  <li class="list-group-item">未使用的合同、带看单是否乱丢乱放
         						<input type="radio" class="toggle" value="1"> 
       						  </li>
							  <li class="list-group-item">已签合同、带看单、单据等是否统一分类收入文件柜管理</li>
							  <li class="list-group-item">初勘、带看工具是否统一收纳指定区域</li>
							  <li class="list-group-item">VI形象着装、形象、状态精神面貌</li>
							  <li class="list-group-item">中住礼是否行礼及是否标准</li>
							</ul>
                        </form>
                    </div>
                    <div class="modal-footer">
                         <!-- 模态框底部样式，一般是提交或者确定按钮 -->                       
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div> 
    </form>
	</div> 
<!-- 模态框end -->

	
		<div style="background-color: #ecf0f5;">
			<section class="content-header">
				<h1>
					答案信息 <small>ANSWER_LINE INFORMATION</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">督查管理</a></li>
					<li class="active">答案管理</li>
				</ol>
			</section>
			
		</div>
		<section class="content">
			<div class="box">
				<table id="dataTable" class="table-bordered"  data-pagination="true" data-search="true" data-toggle="table" 
				 data-striped=true data-show-columns="true" data-url="answer/selectAnswer.action">
				    <thead>
				        <tr>
				        	<th data-field="template_id" data-formatter="template">模板</th>
				            <th data-field="store_id">门店</th>
				            <th data-field="check_date">进店日期</th>
				            <th data-field="docking_man">对接人</th>
				            <th data-field="start_time">访问开始时间</th>
				            <th data-field="end_time">访问结束时间</th>
				        </tr>
				    </thead>
				</table>
			</div>
		</section>
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
	
</body>
</html>
