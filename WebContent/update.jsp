<%@page import="controller.update"%>
<%@page import="Default.DbManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
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
	<center><h1><u>Update</u></h1></center>
	<center>
		<div>
			<form action="update" method="POST">
				<table>
				<%			
				String regUsername = request.getParameter("username");
				try{ 
					Statement stmt = DbManager.getConnection().createStatement();
					String query ="SELECT * FROM users WHERE username = '" + regUsername + "';";
					ResultSet select = stmt.executeQuery(query);
					while(select.next()){
						String username = select.getString("username");
						%>
					<tr>
						<td>Username</td>
						<td><input type="text" class="form-control" name="username" placeholder="<%=select.getString("username")%>" value="<%=select.getString("username")%>"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" class="form-control" name="password" placeholder="<%=select.getString("password")%>"></td>
					</tr>
					<tr>
						<td>Role</td>
						<td>
							<select name="role">
								<option value="user">User</option>
								<option value="manager">Manager</option>
								<option value="admin">Admin</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Firstname</td>
						<td><input type="text" class="form-control" name="firstname" placeholder="<%=select.getString("firstname")%>"></td>
					</tr>
					<tr>
						<td>Lastname</td>
						<td><input type="text" class="form-control" name="lastname" placeholder="<%=select.getString("lastname")%>"></td>
					</tr>
					<tr>
						<td>Position</td>
						<td><input type="text" class="form-control" name="position" placeholder="<%=select.getString("position")%>"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" class="form-control" name="address" placeholder="<%=select.getString("address")%>"></td>
					</tr>
					<tr>
						<td>Telephone</td>
						<td><input type="text" class="form-control" name="telephone" placeholder="<%=select.getString("telephone")%>"></td>
					</tr>
					<tr>
						<td>EmergencyContact</td>
						<td><input type="text" class="form-control" name="emergency_contact" placeholder="<%=select.getString("emergency_contact")%>"></td>
					</tr>
					<tr>
						<td>ContactPhone</td>
						<td><input type="text" class="form-control" name="contact_phone" placeholder="<%=select.getString("contact_telephone")%>"></td>
					</tr>
					<%
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
					<tr>
						<td colspan="2" style="text-align: center"><input class="btn btn-success" type="submit" value="Update"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>