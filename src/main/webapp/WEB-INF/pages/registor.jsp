    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registor Form</title>
    </head>
    <body>
    
	<form:form name="submitForm" method="POST" action="registor">    
	<div align="center">
	<font color="a06cbd"><b>${msg}</b></font><br><br>
	<table bgcolor="8e745f">
	
    <tr>
    <td>User First Name</td>
    <td><input type="text" name="firstName" checked="checked" required/></td>
    </tr>
    <tr>
    <td>User Last Name</td>
    <td><input type="text" name="lastName" required/></td>
    </tr>
    <tr>
    <td>User Email Id</td>
    <td><input type="text" name="email" required/></td>
    </tr>
    <tr>
    <td>dob</td>
    <td><input type="date" name="dob" required/></td>
    </tr>
     <tr>
    <td>Password</td>
    <td><input type="password" name="pass" checked="checked" required/></td>
    </tr>
    <tr>
    <td></td>
    <td><input type="submit" style="background-color:#72A4D2;" value="Registor" /></td>
    </tr>
    </table>
    <br> <a href="<%=request.getContextPath() %>/newlogin">old user? click for login</a>
     <div style="color: green">${useAdd}</div>
    </div>
    <div style="color: red">${error}</div>
    
    </form:form>
    </body>
    </html>
