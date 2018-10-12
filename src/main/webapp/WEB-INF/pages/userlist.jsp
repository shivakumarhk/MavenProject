<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Verify Users</title>
    <center><h3><font color="6b3304"> List of Active Users</font></h3></center>
    
</head>
<body>
<br><table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="ff9033">
<td><b>id</b></td>
<td><b>First Name</b></td>
<td><b>Last Name</b></td>
<td><b>Email</b></td>
<td><b>Dob</b></td>
</tr>
${list}
<tr><a href="<%=request.getContextPath()%>/newlogin">Logout</a></tr></table>
<%-- <table>
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>  --%>

<!--     <h2>Please enter the Username of the user you want to verify</h2>
 -->    <!-- <form action="loginform" method="POST">
        <label>User To Verify: <input type="text" name="userToVerify" id="userToVerify" /></label><br />
        <input type="submit" value="Submit" name="submit" />
    </form> -->

</body>