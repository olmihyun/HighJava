<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO memVO = (MemberVO) request.getAttribute("memVO");
%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/updateMember" method="post">
		<table>
		  <tr>
			<td>I D:</td>
			<td><input type="text" name="memId" value="<%=memVO.getMem_id()%>"></td>
		  </tr>
		  	
		  <tr>
			<td>이름:</td>
			<td><input type="text" name="memName" value="<%=memVO.getMem_name()%>"></td>
		  </tr>
		  	
		  <tr>
			<td>전화번호:</td>
			<td><input type="text" name="memTel" value="<%=memVO.getMem_tel()%>"></td>
		  </tr>
		  	
		  <tr>
			<td>주소:</td>
			<td><textarea name="memAddr" value="<%=memVO.getMem_addr()%>"><%=memVO.getMem_addr()%></textarea></td>
		  </tr>
		  	
		</table>
		<input type="submit" value="회원수정">
	
	</form>

</body>
</html>