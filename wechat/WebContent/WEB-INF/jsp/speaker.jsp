<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.4.2.js"></script>
<script type="text/javascript" th:inline="javascript">
</script>
</head>
<body>
<%@ include file="_head.jsp" %>

	<form action="${ pageContext.request.contextPath }/speaker/sendtext" method="POST">
		<table>
			<tr>
				<td><input  type="text" name="texture" value=""/> </td>
				<td><input type="submit" value="发送"/> </td>
			</tr>
			<tr>
			<c:forEach items="${msg}" var="text">
				<tr>
					<td>${text.texttime}</td>
					<td>${text.text}</td>
				</tr>
			</c:forEach>
			</tr>
		</table>
	</form>

	</div>
</body>
</html>