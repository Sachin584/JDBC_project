package sachin;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServ
 */
@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ() {
        super();
        // TODO Auto-generated constructor stub
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
		doGet(request, response);
		response.setContentType("text/html");
		
		String s1 = request.getParameter("id");
		int id = Integer.parseInt(s1);
		String s2 = request.getParameter("first");
		String s3 = request.getParameter("last");
		String s4 = request.getParameter("mail");
		String s5 = request.getParameter("pwd");
		String s6 = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			PreparedStatement ps = con.prepareStatement("update record set x=?,last=?,mail=?,pwd=?,address=? where id= ?");
			
		
			ps.setString(1, s2);
			ps.setString(2, s3);
			ps.setString(3, s4);
			ps.setString(4, s5);
			ps.setString(5, s6);
			ps.setInt(6, id);
			ps.executeUpdate();
			
			
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
