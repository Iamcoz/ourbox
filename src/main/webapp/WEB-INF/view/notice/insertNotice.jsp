<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../../css/notice.css">
<link rel="stylesheet" href="../../css/public.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>


<body>

	<div id="box">
	
		<br> <br>

		<div id="noticeList">
		<form id="insertform" action="${cp }/ourbox/insertNotice" method="post">
			<table class='tableBorder'>
				<tr id='firstLine'>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목 :&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='inputTitle'
						name='insertTitle' type='text' value=''>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내용 :&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea
							class='textareaContent' name='insertContent' rows='27' cols='155'></textarea>
					</td>
				</tr>
			</table>
			<br>
			<div id='butgrp4'>
				<button class='backlist' type='button' onclick="location.href='${cp }/ourbox/noticePageList?page=1'">목록으로</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="insert">글 등록</button>
			</div>
			</form>
		</div>

		<br>

		<div id="btngroup1"></div>

	</div>

</body>
</html>