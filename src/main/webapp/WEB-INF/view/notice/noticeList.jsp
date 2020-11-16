<%@page import="ourbox.common.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../../css/notice.css">
<link rel="stylesheet" href="../../css/public.css">
<script src="../../js/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
currentpage = 1;

var updateNotice = function(notice) {
	$.ajax({
		url : '/ourbox/updateNotice',
		type : 'get',
		data : notice,
		dataType : 'json',
		success : function(res) {
		}
	})
}

var deleteNoitce = function(notice_seq) {
	
	$.ajax({
		url : '/ourbox/deleteNotice',
		type : 'get',
		data : { "notice_seq" : notice_seq},
		dataType : 'json',
		success : function(res) {
			
		}
		
	})
	
}


var detailNotice = function(notice_seq) {
	
	$.ajax({
		url : '/ourbox/detailNotice',
		type : 'get',
		dataType : 'json',
		data : { "notice_seq" : notice_seq },
		success : function(res) {
			
			code = "<table id='contentTable'>"
			code += "<tr id='tr1'>"
			code += "<td class='tdMenu'>제목 :</td>"
			code += "<td id='notice_title' seq="+ res.notice_seq +" >"+ res.notice_title + "</td>\n"
			code += "<td class='tdMenu'>작성자 :</td>"
			code += "<td id='writer'> "+ res.manager_id + "</td>\n"
			code += "<td class='tdMenu'> 작성일자 : </td>"
			code += "<td id='date'> "+ res.notice_date + "</td>\n"
			code += "</tr>"
			code += "<tr>"
			code += "<td class='tdMenu content'>  내용 : </td>"
			code += "<td id='notice_content' colspan='5'>" +res.notice_content+ "</td>\n"
			code += "</tr>"
			code += "</table><br>"
			code += "<div id='butgrp3'>"
			code += "<button seq="+ res.notice_seq +" id='updateNotice' type='button'> 글 수정 </button>&nbsp;&nbsp;&nbsp;&nbsp;"
			code += "<button seq="+ res.notice_seq +" id='deleteNoitce' type='button'> 글 삭제 </button>&nbsp;&nbsp;&nbsp;&nbsp;"
			code += "<button class='backlist' type='button'>목록으로</button>"
			code += "</div>"
			
			$('#noticeList').empty();
			$('#noticeList').append(code);

		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}
	})
	
}


var searchNotice = function(searchElement) {
	
	$.ajax({
	
		url : '/ourbox/searchNotice',
		data : searchElement,
		type : 'get',
		dataType : 'json',
		success : function(res) {
			
			
			
			code = "<table class='list'>"
			code += "  <tr id='tr1'>"
			code += "    <td id='titleTd'class='bold'>제목</td>"
			code += "    <td id='writerTd'class='bold'>작성자</td>"
			code += "	 <td id='dateTd' class='bold'>작성일자</td>"
			code += "  </tr>"
				
			$.each(res, function(i,v) {
				code += "<tr>";
				code += "<td class='notice_title' seq='"+ v.notice_seq +"'>" + v.notice_title + "</td>\n";
				code += "<td>" + v.manager_id + "</td>\n";
				code += "<td>" + v.notice_date + "</td>\n";
				code += "</tr>\n";
			})
			
			code += "</table>"
				
			$('#noticeList').empty();
			$('#noticeList').append(code);
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
	})

}

var insertNotice = function(notice) {
	
	$.ajax({
		url : '/ourbox/insertNotice',
		type : 'get',
		data : notice,
		dataType : 'json',
		success : function(res) {
			location.href="noticeMain.html";
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
		
	})
	
}

var noticePageList = function(cpage) {
	
	$.ajax({
		url : '/ourbox/noticePageList',
		type : 'get',
		data : { "page" : cpage },
		dataType : 'json',
		success : function(res) {
			
			$('#noticeList').empty();
			
			/* code = "<table class='list'>"
			code += "  <tr id='tr1'>"
			code += "    <td id='titleTd'class='bold'>제목</td>"
			code += "    <td id='writerTd'class='bold'>작성자</td>"
			code += "	 <td id='dateTd' class='bold'>작성일자</td>"
			code += "  </tr>"
				
			$.each(res.data, function(i, v) {
				code += "  <tr class='trtab'>"
				code += "    <td class='notice_title' seq='"+ v.notice_seq +"'>"+v.notice_title+"</td>"
				code += "    <td>"+v.manager_id+"</td>"
				code += "	 <td>"+v.notice_date+"</td>"
				code += "  </tr>"
				
			})
			code += "</table>" */
				
			$('#noticeList').append(code);
			
			totalpage = res.tpage;
			startpage = res.spage;
			endpage = res.epage;
			currentpage = res.cpage;
			
			//이전 버튼 출력
			$('#btngroup1').empty();
			
			if ( startpage > 1 ) {
				pager = '  <span class="previous"><a href="#">Previous</a></span>&nbsp;&nbsp;&nbsp;&nbsp;';
				$(pager).appendTo('#btngroup1');
			}
			
			
			//페이지 번호 출력
			pager = '';
			for (i = startpage ; i <= endpage; i++) {
				
				if (currentpage == i) {
					pager += '<a class="paging" href="#">'+i+'</a>&nbsp;&nbsp;';
				}else {
					pager += '<a href="#" class="paging">'+i+'</a>&nbsp;&nbsp;';
				}
			}
			
			$(pager).appendTo('#btngroup1');	
			
			//다음버튼 출력
			if(endpage < totalpage) {
				pager = '  <span class="next" ><a href="#">Next</a></span>';
				$(pager).appendTo('#btngroup1');	
			}
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}
	})	
}



	$(function() {
		//noticeList()
		
		noticePageList(1)
		
		// 페이지 번호 클릭 하면 이벤트 설정
		$('#btngroup1').on('click','.paging', function() {
			
			currentpage = $(this).text().trim();
			noticePageList(currentpage);
			
		})
		
		// 이전버튼 클릭하면
		$('#btngroup1').on('click','.previous a', function() {

			currentpage = parseInt($('.paging:first').text().trim())-1;
			noticePageList(currentpage);
			
			
		})
		// 다음버튼 클릭하면
		$('#btngroup1').on('click','.next a', function() {

			currentpage = parseInt($('.paging:last').text().trim()) + 1;
			noticePageList(currentpage);
			
		})
		
		// 글쓰기 버튼 클릭하면
		$('#insertNotice').on('click', function() {
			
			$('#noticeList').empty();
			
			code = "<table class='tableBorder'>"
			code += "	<tr id='firstLine'>"
			code += "		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목 :&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='inputTitle' id='insertTitle' type='text' value=''></td>";
			code += "	</tr>";
			code += "	<tr>"
			code += "		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내용 :&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea class='textareaContent' id='insertContent' rows='27' cols='155'></textarea></td>";
			code += "	</tr>";
			code += "</table><br>"
			code += "<div id='butgrp4'>"
			code += "<button class='backlist' type='button'>목록으로</button>&nbsp;&nbsp;&nbsp;&nbsp;"
			code += '<input type="button" id="insert" value="글 등록">'		
			code += '</div>'
			
			$('#noticeList').append(code);
			
			$('#menuBox').hide();
			$('#btngroup1').hide();
		})
		
		// 글 등록버튼 클릭하면
		$('#noticeList').on('click','#insert', function() {
			
			insertTitle = $('#insertTitle').val();
			insertContent = $('#insertContent').val();
			
			notice = {
						"insertTitle" : insertTitle,
						"insertContent" : insertContent
					 }
			
			insertNotice(notice);
			
						
		})
		
		$('#searchNotice').on('click', function(){
			
			searchOption = $('#selectBox option:selected').val();
			searchKeyWord = $('#searchKeyWord').val();
			
			searchElement = { 
								"searchOption" : searchOption,
							 	"searchKeyWord" : searchKeyWord
							}
			
			searchNotice(searchElement);
			
		})
		
		// 공지 제목을 누르면
		$('#noticeList').on('click','.notice_title',function() {
			
			notice_seq = $(this).attr('seq');
			
			detailNotice(notice_seq);
			
			$('#menuBox').hide();
			$('#btngroup1').hide();
				
		})
		
		// 목록으로 버튼 누르면
		$('#noticeList').on('click', '.backlist', function() {
			
			$('#noticeList').empty();
			noticePageList(1)
			
			$('#menuBox').show();
			$('#btngroup1').show();
			
		})
		
		// 삭제버튼 누르면
		$('#noticeList').on('click', '#deleteNoitce', function() {
		
			notice_seq = $(this).attr('seq');
			
			deleteNoitce(notice_seq);
			
			$('#noticeList').empty();
			noticePageList(1)
			
		})
		
		// 글 수정 버튼을 누르면
		$('#noticeList').on('click', '#updateNotice', function() {
			
			notice_seq = $(this).attr('seq');
			notice_title = $(this).parents('#noticeList').find('#notice_title').text();
			notice_content = $(this).parents('#noticeList').find('#notice_content').html();
			
			notice_content = notice_content.replace(/<br>/g, "\n");
			
			$('#noticeList').empty();
		
			
			code = "<table class='tableBorder'>"
			code += "	<tr id='firstLine'>"
			code += "		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목 :&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='inputTitle' id='updateTitle' type='text' value='"+notice_title+"'></td>";
			code += "	</tr>";
			code += "	<tr>"
			code += "		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내용 :&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea class='textareaContent' id='updateContent' rows='27' cols='155'>"+notice_content+"</textarea></td>";
			code += "	</tr>";
			code += "</table><br>"
			code += "<div id='butgrp4'>"
			code += "<button class='backlist' type='button'>목록으로</button>&nbsp;&nbsp;&nbsp;&nbsp;"
			code += '<input type="button" seq='+notice_seq+' id="update" value="글 수정">'		
			code += "</div>"
		
			$('#noticeList').append(code);
			
			$('#menuBox').hide();
			$('#btngroup1').hide();
			
		})
		
		// 수정 등록버튼을 누르면
		$('#noticeList').on('click', '#update', function() {
			
			notice_seq = $(this).attr('seq');
			updateTitle = $('#updateTitle').val();
			updateContent = $('#updateContent').val();
			
			notice = {
						"notice_seq" : notice_seq,
						"updateTitle" : updateTitle,
						"updateContent" : updateContent
					 }
			
			updateNotice(notice);
			
			$('#noticeList').empty();
			detailNotice(notice_seq);
			
		})
		
	})
	


</script>
</head>
<body>
		<div id="box">
		
			<h1><img alt="공지아이콘.png" src="/ourbox/images/공지아이콘.png">공지 관리</h1>
			
			<div id="menuBox">
			<select id="selectBox">
				<option>글제목만</option>
				<option>글내용만</option>
				<option>글제목 + 내용</option>
			</select>
			
			
			<input id="searchKeyWord" type="text" value="">
			<button id="searchNotice" type="button">검색</button>
			<button id="insertNotice" type="button">글 쓰기</button>
			
			</div>
			
			<br><br>
			
			<div id="noticeList">
				<table class='list'>
			<tr id='tr1'>
			<td id='titleTd'class='bold'>제목</td>
			<td id='writerTd'class='bold'>작성자</td>
			<td id='dateTd' class='bold'>작성일자</td>
			</tr>
				
				<tr class='trtab'>
			<c:forEach items="${listvalue }" var="notice">
			notice : ${notice.notice_seq }
				<td class='notice_title' seq='${notice.notice_seq }'>"+${notice.notice_title }"</td>
				<td>"+${notice.manager_id }+"</td>
				<td>"+${notice.notice_date }+"</td>
			</c:forEach>
				</tr>
			</table>
				
			</div>
			<br>
			
			<div id="btngroup1"></div>
		
		</div>
	
</body>
</html>