package mainpk;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement smt;
    /**
     * Default constructor. 
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public Signupservlet() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/ep";
    	System.out.println("Connecting to MySQL...");
    	this.con=DriverManager.getConnection(url,"root","kittu2001");
    	System.out.println("Connected to m MySQL\n");
    	this.smt=this.con.prepareStatement("insert into signup values(?,?,?,?)");
    	
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
			this.smt.setString(1, request.getParameter("firstname"));
			this.smt.setString(2, request.getParameter("lastname"));
			this.smt.setString(3, request.getParameter("email"));
			this.smt.setString(4, request.getParameter("password"));
			this.smt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
