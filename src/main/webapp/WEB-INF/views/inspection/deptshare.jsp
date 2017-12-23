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
<link rel="stylesheet" href="<%=basePath%>zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet" href="<%=basePath%>plugins/sweetalert/sweetalert.css">
<link rel="stylesheet" href="<%=basePath%>dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="<%=basePath%>layui/css/layui.css" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<link href="<%=basePath%>self/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>self/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/bootstrap-table-export.js"></script>
<script src="<%=basePath%>plugins/bootstrap-table/tableExport.js"></script>
<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="<%=basePath%>zTree_v3/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript" src="<%=basePath%>self/js/jquery.treetable.js"></script>
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
#myModal{
	overflow-y: auto;
}
</style>
<script type="text/javascript">
	layui.use(['layer', 'form'], function(){
	  var layer = layui.layer
	  ,form = layui.form;
	});
	$(function () {
	$('#myModal').on('hidden.bs.modal', function (e) {
		 $("#box").html(""); 
	});				
	/*模态框点击 事件
	$('#dataTable').on('click-row.bs.table', function (e, row, element) {
   		queryAnswerLine(row);     
   	}); */  
   	//$("#example-advancedd").treetable({expandable:true});
	 $("#dataTable").bootstrapTable({   		 
    		url:'answer/selectDeptShareAnswer.action',
    		pagination:true,//分页
    		striped:true,//隔行变色
    		search:true,
    		toggle:"table",
    		showColumns:true,//显示 内容列下拉框
    		singleSelect:true,//禁止多选
    		clickToSelect:true,
    		columns: [{
    			checkbox:true    			
 		    }, 
 		    {
 		    	field:'id',
 		    	title:'id',
 		    	visible:false
 		    },
 		    {
 		    	field: 'menu_title',
 		        title: '模板'	 		       
 		        
 		    },{	 		    	
 		        field: 'store_name',
 		        title: '门店'
 		    }, {
 		        field: 'check_date',
 		        title: '进店日期'		       
 		    },{
 		        field: 'docking_man',
 		        title: '对接人'	 		       
 		    },
 		   {
 		        field: 'start_time',
 		        title: '访问开始时间'	 		       
 		    },
 		  {
 		        field: 'end_time',
 		        title: '访问结束时间'	 		       
 		    },
 		   {
 		        field: 'cz',
 		        title: '操作',
 		       	align:'center',
 		        
 		        formatter:function (v,r,i){
 		    	   var a = '<button type="button" class="btn btn-danger" id="buttona">删除 </button>';
 		    	   var b ='<button type="button" class="btn btn-primary" id="buttonb" style="margin-left:10px;">查看</button> ';
 		    	   return a+ b;
 		       },events: {
                   'click #buttona': function (e, value, row, index) {                   	   
                       //删除操作\
                      layer.confirm('答案明细将会一并删除,确定要删除吗？', {
						  btn: ['删除', '取消'], //可以无限个按钮
						  offset: '100px'
						}, function(index){
							layer.close(index);
							 $.post('answer/deleteDeptHeader.action',{id:row.id,dept_id:row.dept_id,header_id:row.header_id},function(data){
                            	if(data.success){
	                            	layer.msg("删除成功!");
	                            	$("#dataTable").bootstrapTable('remove',{field: 'id',values: [row.id]});
                            	}else{
                            		 layer.msg("删除失败 !请联系技术人员 ");
                            	 }
                               },'json') 
                               
                           
							},function(index){
								  //按钮【按钮二】的回调
							});                       	                         
                },
                	'click #buttonb': function (e, value, row, index) {
                		queryAnswerLine(row);
                }
                
 		       }
 		    }]	 		    
 		});    
}) ;

function queryAnswerLine(row){
	  $.post('answer/answerList.action',{template_id:row.template_id},function(data){
		  $("#basic-addon1").val(row.store_name);
		  $("#basic-addon2").val(row.docking_man);
		  $("#basic-addon3").val(row.check_date);
		  $("#basic-addon4").val(row.menu_title);
		  $("#basic-addon5").val(row.start_time);
		  $("#basic-addon6").val(row.end_time);
		  $("#basic-addon7").val(row.broker_num);
		  $("#basic-addon8").val(row.customer_num);
		  $("#basic-addon9").val(row.store_around);   	  
		  $.each(data,function(i,item){  		  
				  var str = "<div class='panel panel-primary'>"+
				    "<div class='panel-heading' role='tab' id='"+i+"'>"+
				      "<h4 class='panel-title'>"+
				        "<a class='collapsed' role='button' data-toggle='collapse' data-parent='#accordion' href='#collapse"+i+"' aria-expanded='false' aria-controls='collapse"+i+"'>"+
				          	item.menu_title +
				        "</a>"+
				      "</h4>"+
				    "</div>"+
				    "<div id='collapse"+i+"' class='panel-collapse collapse' role='tabpanel' aria-labelledby='"+i+"'>"+
				      "<div class='panel-body' >"+
				       "<table  class='table_' ></table>"+ 
				      "</div>"+
				    "</div>"+
				"</div>";	
				
			$("#box").append(str); 			
			$(".table_").bootstrapTable({   		 
	    		url:'answer/temAnswer.action?template_id='+item.id+"&header_id="+row.header_id,
	    		//showHeader:false,不展示表头
	 			columns: [{
	 		        field: 'title',
	 		        title: '内容'
	 		    }, {
	 		    	field:'score',
	 		    	title:'分数',
	 		    	formatter:function(v){
	 		    		if(v==''||v==null){
	 		    			return'无分数展示';
	 		    		}else{
	 		    			return v;
	 		    		}
	 		    	}
	 		    },{
	 		    	field:'answer',
	 		    	title:'答案详情 '
	 		    },{
	 		        field: 'answerNum',
	 		        title: '答案类型 ',
	 		        formatter:function(v){
	 		        	if(v=="1"){
	 		        		return '是';
	 		        	}else if(v=='2'){
	 		        		return '否';
	 		        	}else{
	 		        		return '其他';
	 		        	}
	 		        }
	 		    }, {
	 		        field: 'xq',
	 		        title: '详情',
	 		       	align:'right',
	 		        formatter:function (v,r,i){
	 		    	   return '<button type="button" class="btn btn-primary" id="buttonc">查看</button> ';
	 		       },
	 		       events:{
	 		    	   'click #buttonc' : function (e, value, rw, index) {
	 		    		  showDetails(rw,row);
	 		    	   }
	 		       } 
	 		    }]
	 		    
	 		}); 
		  });
		     	    	   	 
	},'json');     
	  
	$('#myModal').modal("show");
	 $("#share").on('click',function(){
		 shareEnter(row); 
	  });
}

function showDetails(rw,row){	
	$("#answerDetail").val(rw.answer);
	var path = rw.fileUrl+rw.fileName;
	var img = '<img alt="暂无图片" src="'+path+'" />'; 
	$("#picture").empty();
	$("input[name='checkbox']").each(function(){
		$(this).removeAttr("checked");
		if($(this).val() ==rw.answerNum){       	
	        $(this).attr("checked", true);
	        $(this).attr("readonly", "readonly");
	    }
	});
	$("#picture").append(img);
	$('#myModaltwo').modal("show"); 		
}

function answer_num(v){
	if(v=='0'){
		return '否';
		}else if(v=='1'){
			return '是';
		}else{
			return '其他';
		}
	} 
function onClick(event, treeId, treeNode, clickFlag){
	$("#hidden").val(treeNode.id);
	$("#hid").val(treeNode.name);
}
</script>
</head>

<body>
<!-- 模态框start -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document" style="width: 80%;">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">详情</h4>
	      </div>
	      <div class="modal-body">
	      <div class="box">
	        <div class="row">
			  <div class="col-md-6">
			  	<div class="panel panel-primary">
				  <div class="panel-heading">(￣_,￣ )</div>
				    <div class="input-group">
					  <span class="input-group-addon">门店</span>
					  <input type="text" class="form-control" id="basic-addon1" placeholder="门店" aria-describedby="basic-addon1" readonly>
					</div>
					<div class="input-group">
					  <span class="input-group-addon">对接</span>
					  <input type="text" class="form-control" id="basic-addon2" placeholder="对接人" aria-describedby="basic-addon1" readonly>
					</div>
				  
				</div>
			  </div>
			  <div class="col-md-6">
			  	<div class="panel panel-primary">
			  	<div class="panel-heading">(￣_,￣ )</div>				  
				    <div class="input-group">
					  <span class="input-group-addon" >进店时间</span>
					  <input type="text" class="form-control" id="basic-addon3" placeholder="进店时间" aria-describedby="basic-addon1" readonly>
					</div>
					<div class="input-group">
					  <span class="input-group-addon">模板选择</span>
					  <input type="text" class="form-control" id="basic-addon4" placeholder="模板选择" aria-describedby="basic-addon1" readonly>
					</div>				  
				</div>
			  </div>
			</div>			
			<div class="row">
			  <div class="col-md-6">
			  	<div class="panel panel-primary">
				  <div class="panel-heading">(￣_,￣ )</div>
				    <div class="input-group">
					  <span class="input-group-addon" >开始时间</span>
					  <input type="text" class="form-control" id="basic-addon5" placeholder="开始时间" aria-describedby="basic-addon1" readonly>
					</div>
					<div class="input-group">
					  <span class="input-group-addon" >结束时间</span>
					  <input type="text" class="form-control" id="basic-addon6" placeholder="结束时间" aria-describedby="basic-addon1" readonly>
					</div>				  
				</div>
			  </div>
			  <div class="col-md-6">
			  	<div class="panel panel-primary">
				  <div class="panel-heading">(￣_,￣ )</div>
				    <div class="input-group">
					  <span class="input-group-addon" >顾问数量</span>
					  <input type="text" class="form-control" id="basic-addon7" placeholder="顾问数量" aria-describedby="basic-addon1" readonly>
					</div>
					<div class="input-group">
					  <span class="input-group-addon">顾客数量</span>
					  <input type="text" class="form-control" id="basic-addon8" placeholder="顾客数量" aria-describedby="basic-addon1" readonly>
					</div>				  
				</div>
			  </div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">店铺环境(￣_,￣ )</div>		
					<textarea class="form-control" rows="3" name=textarea id="basic-addon9" readonly></textarea>				
			</div>
			</div>			
			<div class="box" id="box">				     				   					     								  
			</div>	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>	        
	      </div>
	    </div>
	    
	  </div>
	</div>
<!-- 模态框end -->
<!-- 详情模态框start -->
<div class="modal fade" id="myModalfour" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<div id="boxt">
	      	<table id="tb"></table>	
	      	</div>      	
	     </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>

	<div class="modal fade" id="myModaltwo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	答案类型:
	      	<span style="width:50px;margin: auto;"><input type="radio" name="checkbox" value="1" disabled="disabled"/>是</span>	      	
			<span style="width:50px;margin: auto;"><input type="radio" name="checkbox" value="2" disabled="disabled"/>否</span>
			<span style="width:50px;margin: auto;"><input type="radio" name="checkbox" value="3" disabled="disabled"/>其他  </span> 		       
		       <form id="form">
		       <p>
		       <span>		       
		       		描述:
		       		<textarea class="form-control" rows="3" name=textarea id="answerDetail" readonly></textarea>		       
		       </span>
		       	</p>
		       	<span>图片:<div id="picture"></div></span>
		       </form>		       		    
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>	
<!-- 详情模态框end -->

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
				<table id="dataTable"></table>
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