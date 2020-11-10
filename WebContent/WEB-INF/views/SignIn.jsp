


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String ctxPath = (String) request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<script type="text/javascript" src="<%=ctxPath %>/script/jquery/jquery-1.11.0.min.js"></script>
<!-- 순서에 유의 -->
<script type="text/javascript" src="<%=ctxPath %>/script/RSA/rsa.js"></script>
<script type="text/javascript" src="<%=ctxPath %>/script/RSA/jsbn.js"></script>
<script type="text/javascript" src="<%=ctxPath %>/script/RSA/prng4.js"></script>
<script type="text/javascript" src="<%=ctxPath %>/script/RSA/rng.js"></script>
 
<script type="text/javascript">    
    function login(){
        var id = $("#USER_ID_TEXT");
        var pw = $("#USER_PW_TEXT");
    
        if(id.val() == ""){
            alert("아이디를 입력 해주세요.");
            id.focus();
            return false;
        }
        
        if(pw.val() == ""){
            alert("비밀번호를 입력 해주세요.");
            pw.focus();
            return false;
        }
        
        // rsa 암호화
        var rsa = new RSAKey();
        rsa.setPublic($('#RSAModulus').val(),$('#RSAExponent').val());
        
        $("#USER_ID").val(rsa.encrypt(id.val()));
        $("#USER_PW").val(rsa.encrypt(pw.val()));
        
        id.val("");
        pw.val("");
 
        return true;
    }
</script>
</head>
<body>
    <form name="frm" method="post" action="<%=ctxPath%>/login.do" onsubmit="return login()">
        <input type="hidden" id="RSAModulus" value="${RSAModulus}"/>
        <input type="hidden" id="RSAExponent" value="${RSAExponent}"/>    
        <input type="text" placeholder="아이디" id="USER_ID_TEXT" name="USER_ID_TEXT" />
        <input type="password" placeholder="비밀번호" id="USER_PW_TEXT" name="USER_PW_TEXT" />
        <input type="hidden" id="USER_ID" name="USER_ID">
        <input type="hidden" id="USER_PW" name="USER_PW">
        <input type="submit" value="로그인" />
    </form>
</body>
</html>

