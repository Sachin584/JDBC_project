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
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			PreparedStatement ps = con.prepareStatement("select * from record");
			ResultSet rs = ps.executeQuery();
			out.println("<table border='1'>");
			 out.println("<tr>"
			 		+ "<th>id</th>"
			 		+ "<th>x</th>"
			 		+ "<th>last</th>"
			 		+ "<th>mail</th>"
			 		+ "<th>pwd</th>"
			 		+ "<th>address</th>"
			 		+ "</tr>");
			
			while(rs.next())
			{
				String s1 = rs.getString("id");
				String s2 = rs.getString("x");
				String s3 = rs.getString("last");
				String s4 = rs.getString("mail");
				String s5 = rs.getString("pwd");
				String s6 = rs.getString("address");
				
			    out.println("<tr><td>" + s1 + "</td>"
			    		+ "<td>" + s2 + "</td>"
			    				+ "<td>" + s3 + "</td>"
			    						+ "<td>" + s4 + "</td>"
			    								+ "<td>" + s5 + "</td>"
			    										+ "<td>" + s6 + "</td>"
			    												+ "</tr>"); 
	
				
				/*out.println(s1);
				out.println(s2);
				out.println(s3);
				out.println(s4);
				out.println(s5);
				out.println(s6);*/
				
			}
			
			out.print("</table>");
			out.print("</html></body>");
		
		
	}catch(Exception e)
     {
		out.print(e);
     }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		}

}
