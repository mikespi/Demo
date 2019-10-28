package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Default.DbManager;

/**
 * Servlet implementation class login
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try (PrintWriter out = response.getWriter()) {
			String query = "UPDATE users SET ";
			String username = request.getParameter("username");
			if(!("").equals(username))
				query = query + "username = '" + username + "', ";
			String password = request.getParameter("password");
			if(!("").equals(password))
				query = query + "password = '" + password + "', ";
			String role = request.getParameter("role");
			if(!("").equals(role))
				query = query + "role = '" + role + "', ";
			String firstname = request.getParameter("firstname");
			if(!("").equals(firstname))
				query = query + "firstname = '" + firstname + "', ";
			String lastname = request.getParameter("lastname");
			if(!("").equals(lastname))
				query = query + "lastname = '" + lastname + "', ";
			String position = request.getParameter("position");
			if(!("").equals(position))
				query = query + "position = '" + position + "', ";
			String address = request.getParameter("address");
			if(!("").equals(address))
				query = query + "address = '" + address + "', ";
			String telephone = request.getParameter("telephone");
			if(!("").equals(telephone))
				query = query + "telephone = '" + telephone + "', ";
			String emergencyContact = request.getParameter("emergency_contact");
			if(!("").equals(emergencyContact))
				query = query + "emergency_contact = '" + emergencyContact + "', ";
			String contactPhone = request.getParameter("contact_phone");
			if(!("").equals(contactPhone))
				query = query + "contact_telephone = '" + contactPhone + "', ";

			query = query.substring(0, query.length() - 2) + " WHERE username = '" + username + "';";			
			Statement stmt = DbManager.getConnection().createStatement();
			stmt.executeUpdate(query);
			response.sendRedirect("resultAdminAll.jsp");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
			response.sendRedirect("register.jsp");
		}

	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
