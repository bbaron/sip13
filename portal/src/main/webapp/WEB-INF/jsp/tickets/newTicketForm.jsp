<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/jsp/urls.jspf" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Contact technical support</title>
	</head>
	<body>
		<ul id="breadcrumbs">
			<li><a href="${homeUrl}">Home</a></li>
		</ul>
		
		<h1>Contact technical support</h1>
		
		<p>If you are having technical difficulties and can't find the answer you need in the Knowledge Base, please
		contact technical support using the form below. We will get back to you within one business day.</p>
		
		<form:form modelAttribute="ticket" action="${ticketsUrl}" cssClass="main">
			<div class="panel grid">
				<div class="gridRow yui-gf">
					<div class="fieldLabel yui-u first">Your name:</div>
					<div class="yui-u">
						<div><form:input path="userName" cssClass="medium" /></div>
						<form:errors path="userName">
							<div class="errorMessage"><form:errors path="userName" /></div>
						</form:errors>
					</div>
				</div>
				<div class="gridRow yui-gf">
					<div class="fieldLabel yui-u first">Your e-mail:</div>
					<div class="yui-u">
						<div><form:input path="userEmail" cssClass="medium" /></div>
						<form:errors path="userEmail">
							<div class="errorMessage"><form:errors path="userEmail" /></div>
						</form:errors>
					</div>
				</div>
				<div class="gridRow yui-gf">
					<div class="fieldLabel yui-u first">Please describe the issue:</div>
					<div class="yui-u">
						<div><form:textarea path="description" cssClass="long" rows="8" /></div>
						<form:errors path="description">
							<div class="errorMessage"><form:errors path="description" /></div>
						</form:errors>
					</div>
				</div>
				<div class="gridRow yui-gf">
					<div class="yui-u first"></div>
					<div class="yui-u">
						<input type="submit" value="Submit" />
					</div>
				</div>
			</div>
		</form:form>
	</body>
</html>
