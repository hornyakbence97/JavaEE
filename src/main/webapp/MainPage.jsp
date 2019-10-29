<%-- 
    Document   : UserHome
    Created on : 2019.09.30., 21:46:59
    Author     : Viki
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    <h1>Logged in: ${user.name}</h1>
    </head>
    <body>
        <h1>Heroes</h1>
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
          <c:forEach var="hero" items="${heroes}">
            <tr>
              <td>
                <c:out default="" value="${hero.name}"></c:out>
              </td>
              <td><a href="modHero?heroid=<c:out default="" value="${hero.id}"> </c:out>">Update</a></td>
              <td><form method="post" action="deleteHero">                
            <input type="hidden"  value="${hero.id}" name="heroid"/>
                  <input type="submit" value="Delete" class="btn" />
                 </form></td>
            </tr>

          </c:forEach>
        </tbody>
      </table>
    </div>
<h2>
    Add new Hero
</h2>
        
          <form method="post" action="newHero" style="border-style: solid;">
    <h2>Add a new hero:</h2>
    <div class="form-group">
      <label for="name">Name of hero:</label>
      <input type="text" name="name" placeholder="Name of hero" class="form-control">
    </div>
    <div class="form-group">
      <label for="description">Description of hero:</label>
      <input type="text" name="desc" placeholder="Description of hero" class="form-control">
    </div>
    <div class="form-group">
      <h3>Species the hero contains:</h3>
      <c:forEach var="specie" items="${species}">
        <div class="form-group">
          <label for="specie_${specie.name}">
            <c:out value="${specie.name}"></c:out>
          </label>
          <input type="text" name="specie_${specie.name}" class="form-control">
        </div>

      </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary">Add new hero</button>
  </form>

<br/>                

        <h1>Empires</h1>
         <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Level</th>
            <th>View</th>
                <th>Modify</th>
                <th>Delete</th>
          </tr>
        </thead>
        <tbody>
               
        <c:forEach var="emp" items="${empires}">
            <tr>
                <td>${emp.name}</td>
                <td>${emp.description}</td>
                <td>${emp.level}</td>                
                
                 <td><a href="manageEmpire?empireid=<c:out default="" value="${emp.id}"> </c:out>">View</a></td>
                 <td><form method="post" action="manageEmpire">                
            <input type="hidden"  value="${emp.id}" name="empireid"/>
                     <input type="submit" value="Modify" class="btn"/>
                 </form></td>
                  <td><form method="post" action="deleteEmpire">                
            <input type="hidden"  value="${emp.id}" name="empireid"/>
                  <input type="submit" value="Delete" class="btn" />
                 </form></td>
    </tr>
</c:forEach>    
</tbody>  
      </table>
    </div>

          <form method="post" action="newEmpire" style="border-style: solid;">
    <h2>Add a new empire:</h2>
    <div class="form-group">
      <label for="name">Name of empire</label>
      <input type="text" name="name" placeholder="Name of empire" class="form-control">
    </div>
    <div class="form-group">
      <label for="desc">Description of empire</label>
      <input type="text" name="desc" placeholder="Description of empire" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">Add new empire</button>
  </form>
    
</body>
</html>