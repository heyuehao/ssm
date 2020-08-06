<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored ="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询商品列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/items/queryItem.action" method="post">
		查询条件:
		<select name="condition">
			<option value="name">商品名称</option>
		</select>
		<table width="100%" border=1>
			<tr>
				<td>
					<input type="text" name="textValue">
					<input type="submit" value="查询" formaction="${pageContext.request.contextPath }/items/findBy.action"/>
				</td>
			</tr>
		</table>
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td colspan="2" align="center">操作</td>
			</tr>
			<c:forEach items="${itemsList }" var="item">
				<tr>
					<td>${item.name }</td>
					<td>${item.price }</td>
					<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${item.detail }</td>
					<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id }">修改</a></td>
					<td><a href="${pageContext.request.contextPath }/items/deleteItemSubmit.action?id=${item.id }">删除</a></td>
				</tr>
			</c:forEach>
			<tr align="right">
				<td colspan="4"></td>
				<td colspan="2" align="center"><a href="${pageContext.request.contextPath }/items/addItem.action">添加</a></td>
			</tr>
		</table>
	</form>
</body>
</html>