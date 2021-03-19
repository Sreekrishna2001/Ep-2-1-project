package mainpk;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement smt;
    /**
     * Default constructor. 
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public Loginservlet() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/ep";
    	System.out.println("Connecting to MySQL...");
    	this.con=DriverManager.getConnection(url,"root","kittu2001");
    	System.out.println("Connected to m MySQL\n");
    	this.smt=this.con.prepareStatement("select Email,Password from signup where Email=? and Password=?");
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.smt.setString(1, request.getParameter("email"));
			this.smt.setString(2, request.getParameter("password"));
			ResultSet i=this.smt.executeQuery(); 
//			System.out.print(i.nex);
			if(i.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("Homepage.html");  
				rd.forward(request, response);
				response.getWriter().append("You are logged in!");
				}
			else{
				response.getWriter().append("incorrect credentials");
			}
//			response.getWriter().append("You are logged in!"+request.getParameter("email")+request.getParameter("password")+i.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		doGet(request, response);
	}

}
