<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Create a support ticket</title>
	</head>
	<body>
		<h1>Create a support ticket</h1>
		
		<p>Please use this form to create a support ticket for the user.</p>
		
		<form:form modelAttribute="ticket" cssClass="main">
			<div class="formItem">
				<div>User name:</div>
				<div><form:input path="userName" cssClass="medium" /></div>
				<form:errors path="userName">
					<div class="fieldError">
						<form:errors path="userName" />
					</div>
				</form:errors>
			</div>
			<div class="formItem">
				<div>User e-mail address:</div>
				<div><form:input path="userEmail" cssClass="medium" /></div>
				<form:errors path="userEmail">
					<div class="fieldError">
						<form:errors path="userEmail" />
					</div>
				</form:errors>
			</div>
			<div class="formItem">
				<div>Issue description:</div>
				<div><form:textarea path="description" rows="8" /></div>
				<form:errors path="description">
					<div class="fieldError">
						<form:errors path="description" />
					</div>
				</form:errors>
			</div>
			<div class="formItem submit"><input type="submit" value="Create"></input></div>
		</form:form>
	</body>
</html>
