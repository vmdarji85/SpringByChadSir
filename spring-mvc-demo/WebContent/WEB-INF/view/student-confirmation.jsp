<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>
	The student is confirmed : ${student.firstName} ${student.lastName}
	<br>
	Country : ${student.country}
	<br>
	The student's favorite language is : ${student.favoriteLanguage}
	<br>
	Operating Systems Known:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
		<li>${temp}</li>
		</c:forEach>
	</ul>
	
	
	
</body>
</html>