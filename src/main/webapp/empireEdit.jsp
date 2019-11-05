<%-- 
    Document   : empire
    Created on : 2019.10.01., 22:02:34
    Author     : Viki
--%>
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
        <h1>Empire details:</h1>
        <form method="post" action="manageEmpire">
            Name:<h2>${selectedEmpire.name}</h2>
            <input type="hidden" name="empireName" value="${selectedEmpire.name}" />
            Description:<h4>${selectedEmpire.description}</h4>
            Level:<h4>${selectedEmpire.level}</h4>
                <h2>Produce: </h2><br/>
                <table class="table">
                    <thead>
                        <tr>
                            <th>naturalAsset Name</th>
                            <th>Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="stock" items="${selectedEmpire.produce}">
                            <tr>                            
                                <td>${stock.naturalAsset.name}</td>
                                <td>${stock.naturalAsset.name}</td>
                                <td>${stock.quantity}</td>                            
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                 <h2>Warehouse: </h2><br/>
                <table  class="table">
                    <thead>
                        <tr>
                            <th>naturalAsset Name</th>
                            <th>Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="stock" items="${selectedEmpire.warehouse}">
                            <tr>                            
                                <td>${stock.naturalAsset.name}</td>
                                <td>${stock.naturalAsset.name}</td>
                                <td>${stock.quantity}</td>                            
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                 <h2>Population: </h2><br/>
                <table  class="table">
                    <thead>
                        <tr>
                            <th>People Name</th>
                            <th>People Description</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pop" items="${selectedEmpire.population}">
                            <tr>                            
                                <td>${pop.people.name}</td>
                                <td>${pop.people.description}</td>
                                <td>${pop.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </br>
        </form>
    </body>
</html>
