<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Create a support ticket</title>
	</head>
	<body>
		<h1>University Tech Support</h1>
		
		<h2>Create a support ticket</h2>
		
		<p>Please use this form to create a support ticket for the user.</p>
		
		<form:form modelAttribute="ticket">
			Customer name:<br />
			<form:input path="customerName" /><br /><br />
			
			Customer e-mail address:<br />
			<form:input path="customerEmail" /><br /><br />
			
			Issue description:<br />
			<form:textarea path="description" rows="8" cols="80" /><br /><br />
			
			<input type="submit" value="Submit"></input>
		</form:form>
	</body>
</html>
