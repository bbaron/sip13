<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/WEB-INF/jsp/init.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Ticket list</title>
	</head>
	<body>
		<h1>Ticket list</h1>
		
		<div class="actionBar">
			<span class="add icon"><a href="${newTicketFormUrl}">Create new ticket</a></span>
		</div>
		
		<c:choose>
			<c:when test="${empty ticketList}">
				<p>There aren't currently any tickets.</p>
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>User name</th>
							<th>User e-mail</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ticket" items="${ticketList}">
							<c:set var="email" value="${ticket.userEmail}" />
							<tr>
								<td><c:out value="${ticket.id}" /></td>
								<td><span class="user icon"><c:out value="${ticket.userName}" /></span></td>
								<td><span class="email icon"><a href="mailto:${email}">${email}</a></span></td>
								<td><c:out value="${ticket.description}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>
