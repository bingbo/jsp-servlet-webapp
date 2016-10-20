<%@page import="com.ibingbo.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>servlet demo</title>
<%@ include file="./../header.html"%>
</head>
<body>
	<div class="container">
		<center>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>username</th>
						<th>password</th>
						<th>email</th>
					</tr>
				</thead>
				<tbody>
					<%
						List users = (List) session.getAttribute("users");
						for (int i = 0; i < users.size(); i++) {
							out.print("<tr>");
							User user = (User) users.get(i);
							out.print("<td>" + user.getId() + "</td>");
							out.print("<td>" + user.getName() + "</td>");
							out.print("<td>" + user.getPassword() + "</td>");
							out.print("<td>" + user.getEmail() + "</td>");
							out.println("</tr>");
						}
					%>
				</tbody>
			</table>


		</center>
	</div>
</body>
<%@ include file="./../footer.html"%>
</html>