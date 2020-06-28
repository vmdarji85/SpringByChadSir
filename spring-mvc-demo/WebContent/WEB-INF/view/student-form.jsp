<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	<body>
		<form:form action="processform" modelAttribute="student">
			First Name : <form:input path="firstName"/>
			<br><br>
			Last Name : <form:input path = "lastName"/>
			<br><br>
			Country :
			<form:select path="country">
				<form:options items="${theCountryOptions}" />
			</form:select>
			<br><br>
			FavoriteLanguage: 
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
			
			<br><br>
			
			Operating Systems:
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			Mac OS <form:checkbox path="operatingSystems" value="MacOS"/>
			Windows <form:checkbox path="operatingSystems" value="Windows"/>
			<br><br>
			<input type="submit" value= "Submit"/>
		</form:form>
	</body>
</html>