<%@page import="com.mycompany.mavenproject2.User"%>
<%@page import="com.mycompany.mavenproject2.Species"%>
<%@page import="com.mycompany.mavenproject2.Hero"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Update hero</title>
</head>

<body>
  <h1>Logged in: <c:out default="????" value="${sessionScope['user'].name}"> </c:out>
  </h1>

  <form method="post" action="heroUpdate" style="border-style: solid;">
    <h2>Update hero:</h2>
    <div class="form-group">
      <label for="name">Name of hero:</label>
      <input type="text" name="name" placeholder="Name of hero" class="form-control" readonly="readonly"
        value="<c:out default=" ????" value="${sessionScope['currentHero'].name}"></c:out>">
    </div>
    <div class="form-group">
      <label for="description">Description of hero:</label>
      <input type="text" name="description" placeholder="Description of hero" class="form-control"
        value="<c:out default=" ????" value="${sessionScope['currentHero'].description}"></c:out>">
    </div>
    <div class="form-group">
      <h3>Species the hero contains:</h3>
      <c:forEach var="specie" items="${sessionScope['species']}">
        <div class="form-group">
          <label for="specie_<c:out value=" ${specie.id}"></c:out>"><c:out value="${specie.name}"></c:out></label>
          <input type="number" value="0" name="specie_<c:out value='${specie.id}'></c:out>" class="form-control">
        </div>
      </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary">Update hero</button>
  </form>
</body>

</html>