<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<input type="text" name="tno" value="${dto.tno}" readonly>
	</div>
	<div>
		<input type="text" name="title" value="${dto.title}" readonly>
	</div>
	<div>
		<input type="text" name="dueDate" value="${dto.dueDate}" readonly>
	</div>
	<div>
		<input type="text" name="finished" ${dto.finished ? "checked" : ""} readonly>
	</div>
	<div>
		<a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
		<a href="/todo/list">List</a>
	</div>

</body>
</html>