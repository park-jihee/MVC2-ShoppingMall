<%@page import="kr.hs.sdh.money.vo.MoneySale"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MoneySale> saleList = (ArrayList<MoneySale>) request.getAttribute("saleList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 매출 조회</title>
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
		<h2>회원매출 조회</h2>
		<table id="addForm" style="width:800px" align="center">
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%
			for(int i = 0; i < saleList.size(); i++){
				MoneySale vo = saleList.get(i);
		%>
		<tr>
			<td><%= vo.getCustno() %></td>
			<td><%= vo.getCustname() %></td>
			<td><%= vo.getGrade() %></td>
			<td><%= vo.getSumprice() %></td>
		</tr>
		<% } %>
		</table>
	</section>
	<footer id="footer"><p>HRDKOREA Copyright© 2016 All rights reserved. Human Resources Development Service of Korea</p></footer>
</body>
</html>