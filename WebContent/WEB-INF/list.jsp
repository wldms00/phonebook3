<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("personList");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>
	<h2>리스트</h2>
   
	<p>등록된 전화번호 리스트 입니다.</p>
   
    <!-- 반복문시작 -->
    <%for(int i=0; i<personList.size(); i++){ %>
		<table border="1">
			<tr>
				<td>이름(name)</td><td><%=personList.get(i).getName()%></td>
			</tr>
	   		<tr>
				<td>핸드폰(hp)</td><td><%=personList.get(i).getHp()%></td>
			</tr>
	   		<tr>
				<td>회사(company)</td><td><%=personList.get(i).getCompany()%></td>
			</tr>
			<tr>
				<td>_</td><td><a href="./delete.jsp?id=">삭제</a></td>
				<td></td>
			</tr>
		</table>
		<br>
	<%} %>
	<!-- 반복문 끝 -->
	
	<a href="./write.jsp">전화번호 등록폼</a>
	

</body>
</html>