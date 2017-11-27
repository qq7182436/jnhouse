<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>部门</title>
	 <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>menu/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>menu/css/default.css">
	<link rel='stylesheet prefetch' href='<%=basePath%>menu/css/foundation.css'>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>menu/css/styles.css">
	 
	<!--[if IE]>
		<script src="http://libs.baidu.com/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="panel panel-primary" style="width:300px;">
	<div class="panel-heading">部门</div>
	<div class="htmleaf-container">
		
		<div class="htmleaf-content bgcolor-3">
			<!-- This is mtree list -->
			<ul class=mtree>
			  <li><a href="alert(1);">中住地产总部</a>
			    <ul>
			      <li><a href="#">技术部</a></li>
			      <li><a href="#">编辑部</a></li>
			      <li><a href="#">培训部</a></li>
			      <li><a href="#">财务部</a></li>
			      <li><a href="#">人力资源部</a></li>
			      <li><a href="#">督察部</a></li>
			      <li><a href="#">后勤部</a></li>
			    </ul>
			  </li>
			  <li><a href="#">东部战区</a>
			    <ul>
			      <li><a href="#">东部一区</a></a>
			        <ul>
			          <li><a href="#">凤凰路一店</a></li>
			          <li><a href="#">万象一店</a>
			            <!--  <ul>
			             <li><a href="#">New York</a></li>
			              <li><a href="#">California</a>
			                <ul>
			                  <li><a href="#">Los Angeles</a></li>
			                  <li><a href="#">San Diego</a></li>
			                  <li><a href="#">Sacramento</a></li>
			                  <li><a href="#">San Francisco</a></li>
			                  <li><a href="#">Bakersville</a></li>
			                </ul>
			              </li>
			              <li><a href="#">万象二店</a></li>
			              <li><a href="#">凤凰路二店</a></li>
			              <li><a href="#">万象理想郡店</a></li>
			            </ul> -->
			          </li>
			          <li><a href="#">万象二店</a></li>
			          <li><a href="#">凤凰路二店</a></li>
			          <li><a href="#">万象理想郡店</a></li>
			        </ul>
			      </li>
			      <li><a href="#">Middle-America</a>
			        <ul>
			          <li><a href="#">Mexico</a></li>
			          <li><a href="#">Honduras</a></li>
			          <li><a href="#">Guatemala</a></li>
			         </ul>
			      </li>
			      <li><a href="#">South-America</a>
			        <ul>
			          <li><a href="#">Brazil</a></li>
			          <li><a href="#">Argentina</a></li>
			          <li><a href="#">Uruguay</a></li>
			          <li><a href="#">Chile</a></li>
			        </ul>
			      </li>
			    </ul>
			  </li>
			  <li><a href="#">Asia</a>
			    <ul>
			      <li><a href="#">China</a></li>
			      <li><a href="#">India</a></li>
			      <li><a href="#">Malaysia</a></li>
			      <li><a href="#">Thailand</a></li>
			      <li><a href="#">Vietnam</a></li>
			      <li><a href="#">Singapore</a></li>
			      <li><a href="#">Indonesia</a></li>
			      <li><a href="#">Mongolia</a></li>
			   </ul>
			  </li>
			  <li><a href="#">Europe</a>
			    <ul>
			      <li><a href="#">North</a>
			        <ul>
			          <li><a href="#">Norway</a></li>
			          <li><a href="#">Sweden</a></li>
			          <li><a href="#">Finland</a></li>
			        </ul>
			      </li>
			      <li><a href="#">East</a>
			        <ul>
			          <li><a href="#">Romania</a></li>
			          <li><a href="#">Bulgaria</a></li>
			          <li><a href="#">Poland</a></li>
			        </ul>
			      </li>
			      <li><a href="#">South</a>
			        <ul>
			          <li><a href="#">Italy</a></li>
			          <li><a href="#">Greece</a></li>
			          <li><a href="#">Spain</a></li>
			        </ul>
			      </li>
			      <li><a href="#">West</a>
			        <ul>
			          <li><a href="#">France</a></li>
			          <li><a href="#">England</a></li>
			          <li><a href="#">Portugal</a></li>
			        </ul>
			      </li>
			   </ul>
			  </li>
			  <li><a href="#">Oceania</a>
			    <ul>
			      <li><a href="#">Australia</a></li>
			      <li><a href="#">New Zealand</a></li>
			    </ul>
			  </li>
			  <li><a href="#">Arctica</a></li>
			  <li><a href="#">Antarctica</a></li>
			</ul>
		</div>
	</div>
	</div>
	
	
	<script src='<%=basePath%>menu/js/stopExecutionOnTimeout.js?t=1'></script>
	 <!-- jQuery 3 -->
	<script src="<%=basePath%>bower_components/jquery/dist/jquery.js"></script>
	<script src='<%=basePath%>menu/js/jquery.velocity.min.js'></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="<%=basePath%>bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script>
	;(function ($, window, document, undefined) {
	    if ($('ul.mtree').length) {
	        var collapsed = true;
	        var close_same_level = false;
	        var duration = 400;
	        var listAnim = true;
	        var easing = 'easeOutQuart';
	        $('.mtree ul').css({
	            'overflow': 'hidden',
	            'height': collapsed ? 0 : 'auto',
	            'display': collapsed ? 'none' : 'block'
	        });
	        var node = $('.mtree li:has(ul)');
	        node.each(function (index, val) {
	            $(this).children(':first-child').css('cursor', 'pointer');
	            $(this).addClass('mtree-node mtree-' + (collapsed ? 'closed' : 'open'));
	            $(this).children('ul').addClass('mtree-level-' + ($(this).parentsUntil($('ul.mtree'), 'ul').length + 1));
	        });
	        $('.mtree li > *:first-child').on('click.mtree-active', function (e) {
	            if ($(this).parent().hasClass('mtree-closed')) {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().addClass('mtree-active');
	            } else if ($(this).parent().hasClass('mtree-open')) {
	                $(this).parent().removeClass('mtree-active');
	            } else {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().toggleClass('mtree-active');
	            }
	        });
	        node.children(':first-child').on('click.mtree', function (e) {
	            var el = $(this).parent().children('ul').first();
	            var isOpen = $(this).parent().hasClass('mtree-open');
	            if ((close_same_level || $('.csl').hasClass('active')) && !isOpen) {
	                var close_items = $(this).closest('ul').children('.mtree-open').not($(this).parent()).children('ul');
	                if ($.Velocity) {
	                    close_items.velocity({ height: 0 }, {
	                        duration: duration,
	                        easing: easing,
	                        display: 'none',
	                        delay: 100,
	                        complete: function () {
	                            setNodeClass($(this).parent(), true);
	                        }
	                    });
	                } else {
	                    close_items.delay(100).slideToggle(duration, function () {
	                        setNodeClass($(this).parent(), true);
	                    });
	                }
	            }
	            el.css({ 'height': 'auto' });
	            if (!isOpen && $.Velocity && listAnim)
	                el.find(' > li, li.mtree-open > ul > li').css({ 'opacity': 0 }).velocity('stop').velocity('list');
	            if ($.Velocity) {
	                el.velocity('stop').velocity({
	                    height: isOpen ? [
	                        0,
	                        el.outerHeight()
	                    ] : [
	                        el.outerHeight(),
	                        0
	                    ]
	                }, {
	                    queue: false,
	                    duration: duration,
	                    easing: easing,
	                    display: isOpen ? 'none' : 'block',
	                    begin: setNodeClass($(this).parent(), isOpen),
	                    complete: function () {
	                        if (!isOpen)
	                            $(this).css('height', 'auto');
	                    }
	                });
	            } else {
	                setNodeClass($(this).parent(), isOpen);
	                el.slideToggle(duration);
	            }
	            e.preventDefault();
	        });
	        function setNodeClass(el, isOpen) {
	            if (isOpen) {
	                el.removeClass('mtree-open').addClass('mtree-closed');
	            } else {
	                el.removeClass('mtree-closed').addClass('mtree-open');
	            }
	        }
	        if ($.Velocity && listAnim) {
	            $.Velocity.Sequences.list = function (element, options, index, size) {
	                $.Velocity.animate(element, {
	                    opacity: [
	                        1,
	                        0
	                    ],
	                    translateY: [
	                        0,
	                        -(index + 1)
	                    ]
	                }, {
	                    delay: index*(duration/size/2),
	                    duration: duration,
	                    easing: easing
	                });
	            };
	        }
	        if ($('.mtree').css('opacity') == 0) {
	            if ($.Velocity) {
	                $('.mtree').css('opacity', 1).children().css('opacity', 0).velocity('list');
	            } else {
	                $('.mtree').show(200);
	            }
	        }
	    }
	}(jQuery, this, this.document));
	$(document).ready(function () {
	    var mtree = $('ul.mtree');
	    mtree.wrap('<div class=mtree-demo></div>');
	    var skins = [
	        'bubba',
	        'skinny',
	        'transit',
	        'jet',
	        'nix'
	    ];
	    mtree.addClass('bubba');
	});
	</script>
</body>
</html>
