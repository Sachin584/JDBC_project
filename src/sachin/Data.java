package sachin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
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
		
		int i = 0 ;
		PrintWriter out = response.getWriter();
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			PreparedStatement ps = con.prepareStatement("insert into record(id,x,last,mail,pwd,address) values(null,?,?,?,?,?)");
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3,mail);
			ps.setString(4, pwd);
			ps.setString(5, address);
			i = ps.executeUpdate();
					
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print(e);
		}
		if(i>0)
		{
			out.println("successfully inserted");
		}
		else
		{
			out.print("data not inserted");
		}
		
		
		
	}

}
