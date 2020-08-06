<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
	<form id="itemForm" action="${pageContext.request.contextPath }/items/addItemSubmit.action" method="post">
		<input type="hidden" name="id" value="${id }" />
		添加：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime" value="<fmt:formatDate value="${createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>"/></td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>