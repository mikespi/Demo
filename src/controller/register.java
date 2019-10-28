package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Default.DbManager;

/**
 * Servlet implementation class login
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try (PrintWriter out = response.getWriter()) {
			String regUsername = request.getParameter("registerUsername");
			String regPassword = request.getParameter("registerPassword");
			String role = request.getParameter("role");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String position = request.getParameter("position");
			String address = request.getParameter("address");
			String telephone = request.getParameter("telephone");
			String emergencyContact = request.getParameter("emergency_contact");
			String contactPhone = request.getParameter("contact_phone");
			Statement stmt = DbManager.getConnection().createStatement();
			String query = "SELECT * FROM USERS where username='" + regUsername + "' AND password='" + regPassword + "';";
			ResultSet select = stmt.executeQuery(query);
			Boolean match = false;
			while(select.next()) {
				String username = select.getString("username");
				if(regUsername.equals(username)) {
					match = true;
					System.out.println("There is already an account by that name.");
					response.sendRedirect("register.jsp");
				}
			}
			if(match == false && regUsername != null && regPassword != null) {
				String register = "INSERT into USERS (username, password, role, firstname, lastname, position, address, "
						+ "telephone, emergency_contact, contact_telephone) values "
						+ "('" + regUsername + "', '" + regPassword + "', '" + role + "', '" + firstname + "', '" + lastname + "', '" 
						+ position + "', '" + address + "', '" + telephone + "', '" + emergencyContact + "', '" + contactPhone + "');";
				System.out.println("registered");
				stmt.executeUpdate(register);
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
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
