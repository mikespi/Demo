package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String role;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Statement stmt = DbManager.getConnection().createStatement();
			String query = "SELECT * FROM USERS where username='" + username + "' AND password='" + password + "';";
			ResultSet select = stmt.executeQuery(query);
			Boolean match = false;
			while(select.next()) {
				String dbUsername = select.getString("username");
				String dbPassword = select.getString("password");
				role = select.getString("role");
				if(username.equals(dbUsername)) {
					if(password.equals(dbPassword)) {
						match = true;
						if(("admin").equals(role)) {
							response.sendRedirect("queryAdmin.jsp");
							System.out.println("Connection Successful");
							System.out.println("You are logged in as " + role);
						} else {
						response.sendRedirect("query.jsp");
						System.out.println("Connection Successful");
						System.out.println("You are logged in as " + role);
						}
					} 
				} 
			}
			if(match == false) {
				System.out.println("Your username and/or password do not match a known account.");
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static String getRole() {
		return role;
	}
}
