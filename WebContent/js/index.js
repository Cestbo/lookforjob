function refresh() {
//后面必须加一个随机的参数，否则验证码将不会刷新
	
   imgValidate.src="validate.jsp?"+Math.random();	
}

function show() {
	$("#fade").css(
			{
				"display":"block",
			});
	$("#workinfo").css(
			{
				"display":"block"
			});
}

function hide() {
	$("#fade").css(
			{
				"display":"none",
			});
	$("#workinfo").css(
			{
				"display":"none"
			});
}

function info(prompt)
{

   
   if(prompt!='null')
     alert(prompt);  
}

$(document).ready(function() {
	$("#lookfor").click(function() {
		$(this).css({
			"border-bottom":"2px #ff9500 solid"
		});
		$("#employ").css({
			"border-bottom":"0"
		})
	})
	$("#employ").click(function() {
		$(this).css({
			"border-bottom":"2px #ff9500 solid"
		});
		$("#lookfor").css({
			"border-bottom":"0"
		})
	})
	
	//搜索
	$("#search").click(function()
			{
		        var keyword=$("#keyword").val();
		        keyword=window.encodeURI(window.encodeURI(keyword));
		        window.location.href="JobServlet?action=search&keyword="+keyword;
			})
	//获得工作信息
	$.post("JobServlet?action=select",function(data,status){
		
		var jarray=$.parseJSON(data);
		$.each(jarray, function (i, n)
		{
		    $("#list").append("<li id='"+i+"'>"+n.name+"<span>"+n.time+"</span>"+"</li>");
		    $("#"+i).mouseover(function(){
				  $(this).css("color","blue");
				    }
			      )
			      $("#"+i).mouseout(function(){
				  $(this).css("color","");
				    }
			      )
		    $("#"+i).click(function()
		    		{
		    	         window.location.href="JobServlet?action=detail&id="+n.id;
		    		})
		}
       )
	})
})