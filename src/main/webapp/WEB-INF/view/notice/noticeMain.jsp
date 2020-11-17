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

<script>
$(document).ready(function() {
 		$(".trtab").on("click", function() {
 			var notice_seq = $(this).data("notice_seq");

 			document.location = "/ourbox/detailNotice?notice_seq="+notice_seq;
		});

 		$("#searchNotice").on("click", function() {
 			var searchElement = $("#searchKeyWord").val();

 			document.location = "/ourbox/searchNotice?searchElement="+searchElement;
		}); 
	}); 
</script>

</head>


<body>
	<div id="box">
		<h1>
			<img alt="공지아이콘.png" src="/images/공지아이콘.png">공지 관리
		</h1>

		<div id="menuBox">
			<button id="insertNotice" type="button" onclick="location.href='${cp}/ourbox/insertNoticeForm'">글 쓰기</button>

		</div>

		<br> <br>

		<div id="noticeList">
			<table class='list'>
				<tr id='tr1'>
					<td id='titleTd' class='bold'>제목</td>
					<td id='writerTd' class='bold'>작성자</td>
					<td id='dateTd' class='bold'>작성일자</td>
				</tr>
				<c:forEach items="${listvalue }" var="notice">
					<tr class='trtab' data-notice_seq="${notice.notice_seq}">
						<td class='notice_title' seq="${notice.notice_seq}">${notice.notice_title }</td>
						<td>${notice.manager_id}</td>
						<td>${notice.notice_date}</td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align: center;">
				<c:choose>
					<c:when test="${spage>1 }">
						<span class="previous"><a href="#">Previous</a></span>
					</c:when>
				</c:choose>
				<c:forEach begin="${spage }" end="${epage }" step="1" var="i">
					<c:choose>
						<c:when test="${cpage==i }">
							<a class="paging" href="#">${i }</a>&nbsp;&nbsp;
		</c:when>
						<c:otherwise>
							<a href="#" class="paging">${i }</a>&nbsp;&nbsp;
		</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>

		<br>

		<div id="btngroup1"></div>

	</div>

</body>
</html>