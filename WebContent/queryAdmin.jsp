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
	<center><h1><u>Search</u></h1></center>
	<center>
		<div>
			<form action="query" method="POST">
				<table>
					<tr>
						<td>First Name</td>
						<td><input type="text" class="form-control" name="firstName" placeholder="First Name"></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" class="form-control" name="lastName" placeholder="Last Name"></td>
					</tr>
					<tr>
						<td><a style="color:#000000" href="resultAdminAll.jsp" >* Select All Users Here * </a><td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input class="btn btn-success" name="button" type="submit" value="Submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>