<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "list.memo",
			success : function(table) {
				$('#result').html(table)
			}
		})
		$('#push').click(function () {
			$.ajax({
				url : "insert.memo",
				data : {
					name: $('#name').val(),
					content: $('#content').val(),
					weather: $('#weather').val()
				},
				success : function() {
					$.ajax({
						url : "list.memo",
						success : function(table) {
							$('#result').html(table)
						}
					})
					$('#name').val('')
					$('#content').val('')
					$('#weather').val('')
				}
			})
		})
	})
</script>
<style type="text/css">
h3 {
	width: 800px;
	height: 35px;
	background: orange;
}
</style>
</head>
<body>
	<h3>멀티 메모장</h3>
	<hr color="blue">
		작성자 : <input id="name" value="win"> 
		내용 : <input id="content" value="win">
		날씨 : <input id="weather" value="win">
		<button id="push">등록</button>
	<hr color="blue">
	<div id="result" style=""></div>
</body>
</html>