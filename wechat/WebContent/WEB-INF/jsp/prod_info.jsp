<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/prodInfo.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.js"></script>
	<script>
		$(function(){
			$("buyNumInp").blur(function(){
				var reg= /^[1-9][0-9]*$/;
				var buyNum=$(this).val();
				if(!reg.test(buyNum)){
					alert("您输入的购买数量不合法!");
					$(this).val(1);
					return ;
				}
			});
		
		$("#delNum").click(function(){
			var $buyNumInp=$("#buyNumInp");
			var buyNum=$buyNumInp.val();
			if(buyNum>1){
				$buyNumInp.val(parseInt(buyNum)-1);
			}
		});
		
		$("#addNum").click(function(){
			var $buyNumInp=$("#buyNumInp");
			var buynum=$buyNumInp.val();
			$buyNumInp.val(parseInt(buyNum)+1);
		});
	});
	</script>
</head>
<body>
	<%@ include file="_head.jsp" %>
	<div id="warp">
		<div id="left">
			<div id="left_top">
				<img src="${pageContext.request.contextPath }${product.imgurl}"/>
			</div>
			<div id="left_bottom">
				<img id="lf_img" src="img/prodInfo/lf.jpg"/>
				<img id="mid_img" src="${pageContext.request.contextPath }${product.imgurl}" width="60px" height="60px"/>
				<img id="rt_img" src="img/prodInfo/rt.jpg"/>
			</div>
		</div>
	<form action="${ pageContext.request.contextPath }/cart/addCart"  method="post">
		<div id="right">
			<div id="right_top">
				<span id="prod_name">${product.name } <br/></span>
				<br>
				<span id="prod_desc">${product.description }<br/></span>
			</div>
			<div id="right_middle">
				<span id="right_middle_span">
					EasyMall 价：
				<span class="price_red">￥${product.price}
				<br/>
			    运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：满 100 免运费<br />
			    服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：由EasyMall负责发货，并提供售后服务<br />
			    购买数量：
	            <a href="javascript:void(0)" id="delNum" onclick="">-</a>
	            <input type="text" id="buyNumInp" name="buyNum" value="1">
		        <a href="javascript:void(0)" id="addNum" onclick="">+</a>
			</div>
			<div id="right_bottom">
				<input type="hidden" name="pid" value="${product.id }"/>
				<input class="add_cart_but" type="submit" value=""/>	
			</div>
		</div>
	</form>
	</div>
	<%@ include file="_foot.jsp" %>
</body>
</html>