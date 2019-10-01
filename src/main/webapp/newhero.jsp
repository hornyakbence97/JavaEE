<%@page import="com.mycompany.mavenproject2.User"%>
<%@page import="com.mycompany.mavenproject2.Species"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hős</title>
</head>

<body>
    <h1>Hős felvitel</h1>


    <c:out default="????" value="${sessionScope['user'].name}"> </c:out>
    <c:forEach var="hero" items="${sessionScope['user'].heroes}">
        <c:out default="????" value="${hero.name}"> </c:out>

    </c:forEach>

    <form method="post" action="hero">
        <input type="text" name="name" placeholder="name of hero">
        <input type="text" name="description" placeholder="description"> <br>

        <c:forEach var="onespecies" items="${species}">
            <c:out value="${onespecies.name}"></c:out>
            <input type="number" name="pspec_${onespecies.id}">
            <br>
        </c:forEach>

        <input type="submit" value="save">
    </form>
</body>

</html>