<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Board</title>
</head>
<body>
<h1>글등록</h1>
<a href="logout.do">Log Out</a><hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<td>업로드</td>
			<td><input type="file" name="uploadFile"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="새글 등록"/></td>
		</tr>
	</table>
</form><hr>
<a href="getBoardList.do">글 목록으로 가기</a>
</body>
</html>