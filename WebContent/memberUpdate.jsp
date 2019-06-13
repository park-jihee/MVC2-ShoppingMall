<%@page import="kr.hs.sdh.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% MemberVO vo = (MemberVO) request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>홈쇼핑 회원 정보 수정</h2>
		<form action="=">
			<table border="1" id="addForm" style="width:800px" align="center">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" name="custno" value="<%= vo.getCustno() %>"></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname" value="<%= vo.getCustname() %>"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone" value="<%= vo.getPhone() %>"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address" value="<%= vo.getAddress() %>"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate" value="<%= vo.getJoindate() %>"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP, B:일반, C:직원]</td>
					<td><input type="text" name="grade" value="<%= vo.getGrade() %>"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city" value="<%= vo.getCity() %>"></td>
				</tr>
				<tr>
					<td colspan="2"><button>확인</button></td>
				</tr>
			</table>
		</form>
</body>
</html>