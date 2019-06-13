<%@page import="kr.hs.sdh.member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<MemberVO> memberList = (ArrayList<MemberVO>) request.getAttribute("memberList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<header id="header">
		<h1>쇼핑몰 회원관리</h1>
	</header>
	<menu id="menu">
		<ul>
			<li><a href="MemberAddCtrl">회원등록</a></li>
			<li><a href="MemberListCtrl">회원목록조회/수정</a></li>
			<li><a href="MemberSaleCtrl">회원매출조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</menu>
	<section id="section">
		<h2>회원목록 조회</h2>
		<table id="addForm" style="width:800px" align="center">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입날짜</td>
			<td>등급</td>
			<td>사는 곳</td>
		</tr>
		<%
			for(int i = 0; i < memberList.size(); i++){
				MemberVO vo = memberList.get(i);
		%>
		<tr>
			<td><a href="MemberUpdateCtrl?custno=<%= vo.getCustno() %>"><%= vo.getCustno() %></a></td>
			<td><%= vo.getCustname() %></td>
			<td><%= vo.getPhone() %></td>
			<td><%= vo.getAddress() %></td>
			<td><%= vo.getJoindate() %></td>
			<td><%= vo.getGrade() %></td>
			<td><%= vo.getCity() %></td>
		</tr>
		<% } %>
		</table>
	</section>
	<footer id="footer"><p>HRDKOREA Copyright© 2016 All rights reserved. Human Resources Development Service of Korea</p></footer>
</body>
</html>