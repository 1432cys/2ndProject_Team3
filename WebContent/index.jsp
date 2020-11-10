<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="signUp.do">
		userID<input type="text" id="id" name="id"><br>
		P  W  D<input type="password" id="pwd" name="pwd"><br>
		N A M E<input type="text" id="name" name="name"><br>
		H     P<input type="text" id="hp" name="hp"><br>
		ADDRESS<input type="text" id="address" name="address"><br>
		C A R D<input type="text" id="card_num" name="card_num"><br>
		<p><input type="submit"></p>
	</form>
	
	<form action="signIn.do">
			ID<input type="text" id="id" name="id"><br>
		PWD<input type="password" id="pwd" name="pwd"><br>
		<input type="submit" id="SignIn">
	</form>

</body>
</html>