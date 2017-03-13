<%@page contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>

				<!-- 订单开始 -->
<s:iterator value="#session.cartItems" status="statu">
					<tr>
						<td valign="top">
							<s:property value="#statu.count"/>
						</td>
						<td valign="top">
							<s:property value="book.productName"/>
						</td>
						<td valign="top">
							<s:property value="book.dangPrice"/>
						</td>
						<td valign="top">
							<s:property value="count"/>
						</td>
						<td valign="top">
							<s:property value="count*book.dangPrice"/>
						</td>
					</tr>
</s:iterator>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥
						<s:property value="#session.sumPrice"/></b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="${pageContext.request.contextPath}/cart/cartAction!showCart"><input id="btnClientRegister" class="button_1" name="submit" type="button" value="取消" /></a>
				<input id="btnClientRegister" class="button_1" name="submitButton"	type="button" value="下一步"  onclick="location='${pageContext.request.contextPath}/order/orderAction!toAddress'"/>
			</div>
		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

