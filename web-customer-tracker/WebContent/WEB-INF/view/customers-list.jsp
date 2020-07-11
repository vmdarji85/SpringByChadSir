<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib 	uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<title>CustomerList</title>
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"
></link>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Code for Add Customer button -->
			<input type="button" value="Add Customer" 
				Onclick="window.location.href='showFormForAdd';return false;"
				class="add-button"
				/>
			<!-- Add search form -->
			<form:form action="search" method="GET">
			Search customer: <input type="text" name="theSearchName"/>
			<input type="submit" value="Search" class="add-button" />
			</form:form>
	
			<!-- add html table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print all customers  -->
				
				<c:forEach var="tempCustomer" items="${customers}">
				<!-- construct an update link with customer id  --> 
				<!-- /customer/showFormForUpdate?customerId=1 -->
				<c:url var="updateLink" value ="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
						<tr>
							<td>${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName}</td>
							<td>${tempCustomer.email} </td>
							<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" 
								onClick="if(!(confirm('Are you sure you want to delete customer?'))) return false">Delete</a>
							</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>