<%@page import="ourbox.common.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

{
	"tpage" : "${tpage }",
	"epage" : "${epage }",
	"spage" : "${spage }",
	"cpage" : "${cpage }",
	"data"  : 
	
	<c:forEach items="${listvalue }" var="notice">
				"notice_seq"      : "${notice.notice_seq}",			
				"notice_title"    : "${notice.notice_title}",			
				"notice_date" 	  : "${notice.notice_date}",
				"manager_id"	  : "${notice.manager_id}"		
	</c:forEach>
}		
