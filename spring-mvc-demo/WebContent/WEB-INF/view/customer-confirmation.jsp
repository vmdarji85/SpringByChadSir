<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html>
<head>
	<title>Customer Confirmation Page</title>
</head>
<body>
	The Customer is Confirmed : ${customer.firstName} ${customer.lastName} 
	<br>
	Free Passes : ${customer.freePasses}
	<br>
	Postal Code : ${customer.postalCode}
	<br>
	Course Code : ${customer.courseCode}
</body>
</html>