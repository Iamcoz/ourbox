<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/notice.css">
<link rel="stylesheet" href="/css/public.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>


<body>

	<div id="box">

		<br> <br>

		<div id="noticeList">
			<table id='contentTable'>
					<tr id='tr1'>
						<td class='tdMenu'>제목 :</td>
						<td id='notice_title' seq="${notice.notice_seq }">${notice.notice_title }</td>
						<td class='tdMenu'>작성자 :</td>
						<td id='writer'>${notice.manager_id }</td>
						<td class='tdMenu'>작성일자 :</td>
						<td id='date'>${notice.notice_date}</td>
					</tr>
					<tr>
						<td class='tdMenu content'>내용 :</td>
						<td id='notice_content' colspan='5'>${notice.notice_content }</td>
					</tr>

			</table>
			<br>

			<div id='butgrp3'>

				<button id='updateNotice' type='button' onclick="location.href='${cp }/ourbox/updateNoticeForm?notice_seq=${notice.notice_seq}'">
					글 수정</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button id='deleteNoitce' type='button' onclick="location.href='${cp }/ourbox/deleteNotice?notice_seq=${notice.notice_seq}'">
					글 삭제</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class='backlist' type='button' onclick="location.href='${cp }/ourbox/noticePageList?page=1'">목록으로</button>
			</div>
		</div>

		<br>

		<div id="btngroup1"></div>

	</div>

</body>
</html>






















