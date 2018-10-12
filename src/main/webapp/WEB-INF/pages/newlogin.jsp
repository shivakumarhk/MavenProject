    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Login Form</title>
    </head>
    <body>
    
	<form:form name="submitForm" method="POST">    
	<div align="center">
	<font color="a06cbd"><b>${msg}</b></font><br><br>
	<table bgcolor="8e745f">
	
    <tr>
    <td>User Name</td>
    <td><input type="text" name="firstName" required/></td>
    </tr>
    <tr>
    <td>Password</td>
    <td><input type="password" name="pass" required/></td>
    </tr>
    <tr>
    <td></td>
    <td><input type="submit" value="Login" /></td>
    </tr>
    </table>
       <br> <a href="http://192.168.10.96:8080/SampleWebApplication/">new user? click for registor</a>
    
    <div style="color: red">${error}</div>
    </div>
    </form:form>
    
    
    </body>
    </html>
