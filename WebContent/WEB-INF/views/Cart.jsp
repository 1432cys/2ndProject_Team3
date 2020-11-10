<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#btn').click(function() {
			$.ajax(
					{
						type : "get",
						url : "http://192.168.0.3:8090/WebClient_Jquery_Ajax/Ex10_jsonlib_emplist.jsp",			
						dataType : "json", //POINT
						success : function(data) {
						console.log(data);
						
						$.each(data, function(index, obj) {
							$('#emplist').append(
									"<tr><td>" + index
									+ "</td><td>"
									+ obj.empno
									+ "</td><td>"
									+ obj.ename
									+ "</td><td>"
									+ obj.sal
									+ "</td><td>"
									+ obj.job +								
									"</td><td>"
									+ obj.comm
									+ "</td></tr>"
									);
							});
						},
						error : function(xhr) {
							alert(xhr.status + ":ERROR");
							}
						}
					);
			});
	});
</script>

</head>
<body>
	<h3>EMP LIST</h3>
	<input type="button" value="EmpList" id="btn">
	<hr>
	<table id="emplist" border="1">
	</table>

</body>

</html>


