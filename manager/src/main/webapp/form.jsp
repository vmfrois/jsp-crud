<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value="/CreateServlet" var="uri"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <form action="${uri}" method="post">
        Nome: <input type="text" name="name"/>
     
        <br />
        <br />
     
        Data de abertura: <input type="text" name="date"/>
     
        <input type="submit" />
    </form>

</body>
</html>