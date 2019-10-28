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
	<center><h1><u>Create an Account</u></h1></center>
	<center>
		<div>
			<form action="register" method="POST">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" class="form-control" name="registerUsername" placeholder="Username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" class="form-control" name="registerPassword" placeholder="Password"></td>
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
						<td><input type="text" class="form-control" name="firstname" placeholder="First Name"></td>
					</tr>
					<tr>
						<td>Lastname</td>
						<td><input type="text" class="form-control" name="lastname" placeholder="Last Name"></td>
					</tr>
					<tr>
						<td>Position</td>
						<td><input type="text" class="form-control" name="position" placeholder="Position"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" class="form-control" name="address" placeholder="Address"></td>
					</tr>
					<tr>
						<td>Telephone</td>
						<td><input type="text" class="form-control" name="telephone" placeholder="Telephone"></td>
					</tr>
					<tr>
						<td>EmergencyContact</td>
						<td><input type="text" class="form-control" name="emergency_contact" placeholder="Emergency Contact"></td>
					</tr>
					<tr>
						<td>ContactPhone</td>
						<td><input type="text" class="form-control" name="contact_phone" placeholder="Contact's Phone"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input class="btn btn-success" type="submit" value="Register"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>