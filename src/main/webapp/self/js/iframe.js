/*$(function() {
	$(".li").click( function () { 
		$(this).removeClass("active");
		$(this).addClass("li");
		$(this).addClass("active");
    });

})
*/
/**
 * iframe自适应高度，height为手动设置的最小高度
 */
function initIframeHeight(height){
    var userAgent = navigator.userAgent;
    var iframe = parent.document.getElementById("content");
    var subdoc = iframe.contentDocument || iframe.contentWindow.document;
    var subbody = subdoc.body;
    var realHeight;
    //谷歌浏览器特殊处理
    if(userAgent.indexOf("Chrome") > -1){
        realHeight = subdoc.documentElement.scrollHeight;
    }
    else{
        realHeight = subbody.scrollHeight;
    }
    if(realHeight < height){
        $(iframe).height(height);
    }
    else{
        $(iframe).height(realHeight);
    }
}

function reIframeHeight(ht,id){
    $("#content").attr("src", ht);
    $("li[id^='li-']").removeClass("active");
    $("#li-" + id).addClass("active");
}

