<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>

<head>
    <title>Hello</title>
</head>

<body>
<h1>
<%
    System.out.println("Hello, " + SecurityContextHolder.getContext().getAuthentication().getName());
%>
</h1>

</body>
</html>