<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<table border="1" width="800">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>내용</td>
		<td>날씨</td>
		<td>날짜</td>
	</tr>
	<c:forEach items="${list}" var="vo" varStatus="status">
		<tr background="lime">
			<td>${status.count}</td>
			<td>${vo.name}</td>
			<td width="150">
				<a href="one.memo?_id=${vo._id}">${vo.content}</a>
			</td>
			<td>${vo.weather}</td>
			<td><fmt:formatDate value="${vo.date}" 
                pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</c:forEach>
</table>