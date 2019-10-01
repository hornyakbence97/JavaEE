<%@page import="com.mycompany.mavenproject2.User"%>
<%@page import="com.mycompany.mavenproject2.Species"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Main page</title>
</head>

<body>
  <h1>Logged in: <c:out default="????" value="${sessionScope['user'].name}"> </c:out>
  </h1>

  <div style="border-style: solid;">
    <h2>Your heros:</h2>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="hero" items="${sessionScope['user'].getHeroes()}">
            <tr>
              <td>
                <c:out default="" value="${hero.name}"> </c:out>
              </td>
              <td><a href="heroUpdate?id=<c:out default="" value=" ${hero.name}"> </c:out>">Update</a></td>
              <td><a href="heroDelete?id=<c:out default="" value=" ${hero.name}"> </c:out>">Delete</a></td>
            </tr>

          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

  <br />


  <form method="post" action="heroCreate" style="border-style: solid;">
    <h2>Add a new hero:</h2>
    <div class="form-group">
      <label for="name">Name of hero:</label>
      <input type="text" name="name" placeholder="Name of hero" class="form-control">
    </div>
    <div class="form-group">
      <label for="description">Description of hero:</label>
      <input type="text" name="description" placeholder="Description of hero" class="form-control">
    </div>
    <div class="form-group">
      <h3>Species the hero contains:</h3>
      <c:forEach var="specie" items="${species}">
        <div class="form-group">
          <label for="specie_${specie.id}">
            <c:out value="${specie.name}"></c:out>
          </label>
          <input type="number" value="0" name="specie_${specie.id}" class="form-control">
        </div>

      </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary">Add new hero</button>
  </form>
</body>

</html>