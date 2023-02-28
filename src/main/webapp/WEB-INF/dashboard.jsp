<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
	<div class="content">
		<h1>Burger Tracker</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachBurger" items="${burgerList}">
					<tr>
						<td><a href="/burgers/${eachBurger.id}/edit"><c:out value="${eachBurger.burgerName}"/></a></td>
						<td><c:out value="${eachBurger.restaurantName}"/></td>
						<td><c:out value="${eachBurger.rating}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="form">
		<h1>New Burger</h1>
		<form:form action="/burgers" method="post" modelAttribute="burger">
    	<p>
        <form:input style="text-align: center" path="burgerName" placeholder="Burger Name"/>
        <br/>
        <form:errors style="color:red" path="burgerName"/>
    	</p>
    	<p>
        <form:input style="text-align: center" path="restaurantName" placeholder="Restaurant Name"/>
        <br/>
        <form:errors style="color:red" path="restaurantName"/>
    	</p>
    	<p>
        <form:input style="text-align: center" type="number" path="rating" placeholder="Rating(1-5)"/>
        <br/>
        <form:errors style="color:red" path="rating"/>
    	</p>
    	<p>
        <form:textarea style="text-align: center" path="description" placeholder="Description"/>
        <br/>
        <form:errors style="color:red" path="description"/> 
    	</p>    
    	<input class="btn btn-primary" type="submit" value="Submit"/>
		</form:form>    
	</div>	
</body>
</html>