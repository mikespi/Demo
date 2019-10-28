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
@WebServlet("/query")
public class query extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String username;
	private static String password;
	private static String role;
	private static String firstName;	
	private static String lastName;
	private static String position;
	private static String address;
	private static String telephone;
	private static String emergencyContact;
	private static String contactTelephone;
	private static ResultSet select;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public query() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try (PrintWriter out = response.getWriter()) {
			String first = request.getParameter("firstName");
			String last = request.getParameter("lastName");
			String sessionRole = controller.login.getRole();
			Statement stmt = DbManager.getConnection().createStatement();
			String query = "SELECT * FROM users WHERE firstname='" + first + "' AND lastname='" + last + "';";
			select = stmt.executeQuery(query);
			while(select.next()) {
				username = select.getString("username");
				password = select.getString("password");
				role = select.getString("role");
				firstName = select.getString("firstname");
				lastName = select.getString("lastname");
				position = select.getString("position");
				address = select.getString("address");
				telephone = select.getString("telephone");
				emergencyContact = select.getString("emergency_contact");
				contactTelephone = select.getString("contact_telephone");
			}
			if(("user").equals(sessionRole)) {
				response.sendRedirect("resultUser.jsp");
			}
			if(("admin").equals(sessionRole)) {
				response.sendRedirect("resultAdmin.jsp");
			}
			if(("manager").equals(sessionRole)) {
				response.sendRedirect("resultManager.jsp");
			}
		}
		catch (SQLException sql) {
			sql.printStackTrace();
			System.out.println("error");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static String getRole() {
		return role;
	}
	
	public static String getFirstName() {
		return firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static String getPosition() {
		return position;
	}

	public static String getAddress() {
		return address;
	}

	public static String getTelephone() {
		return telephone;
	}

	public static String getEmergencyContact() {
		return emergencyContact;
	}

	public static String getcontactTelephone() {
		return contactTelephone;
	}
}
