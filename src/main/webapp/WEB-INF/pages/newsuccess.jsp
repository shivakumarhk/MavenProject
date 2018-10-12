<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>

<!-- 	<font color="green">Hello</font>
 -->	${msg} ,<br><br>You have successfully logged in.<br><br>To view list click link
	
	<a href="<%=request.getContextPath() %>/useractivelist">Active Users</a>
	<p id="demo"></p>

<script>
var countDownDate = new Date().getTime()+10000;
var x = setInterval(function() {

    var now = new Date().getTime();
    
    var distance = countDownDate - now;
    

    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    

    document.getElementById("demo").innerHTML = seconds + "s ";
    
    if (distance < 0) {
        clearInterval(x);

        document.getElementById("demo").innerHTML = "EXPIRED";
        
    }
}, 10);
</script>
</body>
</html>