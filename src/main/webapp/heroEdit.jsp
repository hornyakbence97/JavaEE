
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>     
                  <form method="post" action="modHero" style="border-style: solid;">
    <div class="form-group">
        <label for="name">Name of hero: <h1>${selectedHero.name}</h1></label>
      <input type="hidden" name="heroid" value="${selectedHero.id}" class="form-control">
    </div>
    <div class="form-group">
      <label for="desc">Description of hero:</label>
      <input type="text" name="desc" placeholder="Description of hero" value="${selectedHero.description}" class="form-control">
    </div>
            <c:forEach var="hyb" items="${hybrids}">
                    <div class="form-group">
      <label for="name">${hyb.species.name}: </label>
      <input type="text" name="${hyb.species.name}" value="${hyb.percent}" class="form-control">
    </div>
            </c:forEach>
    <button type="submit" class="btn btn-primary">Modify hero</button>
  </form>
        
        
         
        
    </body>
</html>
