<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table >
	<tr>
		<th>sr</th>
		<th>Name</th>
		<th>Email</th>
		<th>Crerate Date</th>
		<th>Update</th>
		<th colspan="3">Action</th>
	</tr>
	<c:forEach var="j" items="${masters}" varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${j.emailId }</td>
				<td>${j.details.firstName }</td>
				<td>${j.createdOn }</td>
				<td>${j.updatedOn }</td>
				<td><a href="<c:url value='/delete'/>?parameter=${j.userid}">Delete</a></td>
				<td><a href="<c:url value='/delete'/>?parameter=${j.userid}">Delete</a></td>
				<td><a href="<c:url value='/delete'/>?parameter=${j.userid}">Delete</a></td>
			
			</tr>
	</c:forEach>

</table>

</body>
</html>