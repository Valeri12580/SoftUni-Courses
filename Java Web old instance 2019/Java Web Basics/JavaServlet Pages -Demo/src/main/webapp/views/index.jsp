<%--
  Created by IntelliJ IDEA.
  User: Valer
  Date: 15.4.2020 г.
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index</title>
</head>
<body>
<form method="post">
    <p>Number</p>
    <input type="text" name="number"/>
    <p>Info</p>
    <input type="text" name="info"/>
    <button>Submit</button>
</form>




<%if(request.getAttribute("number")!=(null)){%>
<%
    if (Integer.parseInt( (String)request.getAttribute("number")) > 0) {%>
<p>The number is greater than 0</p>
<%} else {%>
<p>The number is equal or below zero!</p>
<%}%>
    <%}else{%>
        <p>Null!</p>
    <%}%>


<p><%=request.getSession().getAttribute("info")%></p>

</body>
</html>
