<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="controller.query"%>
<%@page import="Default.DbManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Search</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<style>
		td{
			padding: 10px;
		}
		div{
			width: 50%;
			border: 1px solid black;
			border-radius: 5px;
			background-color: #778899;
		}
	</style>	
</head>
<body>
	
	<h2 align="center"><font><strong>Employee Contact List</strong></font></h2>
	<p align="center">*This information is sensitive and for emergency reference only*</p>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr>
	
		  <tr>
		    <th>Username</th>
		    <th>Password</th>
		    <th>Role</th>
		    <th>First Name</th>
		    <th>Last Name</th> 
		    <th>Position</th>
		    <th>Address</th>
		    <th>Telephone</th>
		    <th>Emergency Contact</th>
		    <th>Contact's Number</th>
		  </tr>
			  <%
				try{ 
					Statement stmt = DbManager.getConnection().createStatement();
					String query ="SELECT * FROM users";	
					ResultSet select = stmt.executeQuery(query);
					while(select.next()){
						String username = select.getString("username");
						%>				
						<td><%=username%></td>
						<td><%=select.getString("password")%></td>
						<td><%=select.getString("role")%></td>
						<td><%=select.getString("firstname")%></td>
						<td><%=select.getString("lastname")%></td>
						<td><%=select.getString("position")%></td>
						<td><%=select.getString("address")%></td>
						<td><%=select.getString("telephone")%></td>
						<td><%=select.getString("emergency_contact")%></td>
						<td><%=select.getString("contact_telephone")%></td>
						<td><a href=delete?username=<%=username%>.jsp>Delete</a>
						<td><a href=update.jsp?username=<%=username%>>Update</a>
						<br>
						</tr>
						<% 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				%>			 		
		</tr>	
	</table>
	<br>
	<tr>
		<center>
			<form action="queryAdmin.jsp" method="POST">
				<td colspan="6" style="text-align: center"><input class="btn btn-success" name="button" type="submit" value="Search Again"></td>
			</form>
	</center>
	</tr>
	<center><p><a href="index.jsp">Exit </a><p></center>
</body>
	
	