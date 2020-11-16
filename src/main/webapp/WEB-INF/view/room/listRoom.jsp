<%@page import="ourbox.common.vo.RoomVO"%>
<%@page import="java.util.List"%>
<%@page import="ourbox.common.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/ourbox/css/rightmouse.css">
<link rel="stylesheet" href="/ourbox/css/public.css">	
<script src="/ourbox/js/rightmouse.js"></script>

<script type="text/javascript">

	$(function() {
		
			memId = "${sessionScope.vo.mem_id}";
		
		$('.panel-title').mousedown(function() {
			event.stopPropagation()
			//$('.contextmenu').show();
			roomSeq = $(this).attr('roomSeq');
		})
	})
	
</script>

<style type="text/css">

	html, body {
		height: 100%;
		background: #E6E6E6;
	}
	
	 a:link, a:visited{
 		text-decoration: none;
 		color: black;
 	}
 	
 	img{
 		width: 20px;
 		height: 20px;
 		margin-right: 1px;
		vertical-align: middle;
 	}
 	
 	td{
 		height: 35px;
 	}

</style>



<title>Insert title here</title>
</head>
<body>
	<table>
	<c:choose>
		<c:when test="${roomList!=null}">
			<c:forEach items="${roomList }" var="room">
				<tr>
					<td>
						<img alt="그룹아이콘.png" src="/ourbox/images/그룹아이콘.png">
						<span class="bold">${room.room_name}</span>
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td>생성한 그룹이 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
		<tr>
			<td></td>
		</tr>
	</table>
	
	
	<ul class="contextmenu">
	  <li><a href="#" id="inviteMember">초대하기</a></li>
	  <li><a href="#" id="deleteGroup">그룹탈퇴</a></li>
	</ul>
	
	
</body>
</html>