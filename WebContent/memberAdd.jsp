<%@page import="kr.hs.sdh.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberVO vo = (MemberVO) request.getAttribute("custno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<header id="header">
		<h1>쇼핑몰 회원관리 VER 1.0</h1>
	</header>
	<menu id="menu">
		<ul>
			<li><a href="MemberAddCtrl">회원등록</a></li>
			<li><a href="MemberListCtrl">회원목록조회/수정</a></li>
			<li><a href="">회원매출조회</a></li>
			<li><a href="index.jsp">홈으로</a></li>
		</ul>
	</menu>
	<section id="section">
		<h2>홈쇼핑 회원 등록</h2>
		<form action="AddMemberCtrl">
			<table border="1" id="addForm">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" name="custno" value="<%= vo.getCustno() %>"></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP, B:일반, C:직원]</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><button>확인</button></td>
				</tr>
			</table>
		</form>
	</section>
	<footer id="footer"><p>HRDKOREA Copyright© 2016 All rights reserved. Human Resources Development Service of Korea</p></footer>
</body>
</html>