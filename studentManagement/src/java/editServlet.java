
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;


public class editServlet extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.include(request, response);
          String en=request.getParameter("enno");
        int enno=Integer.parseInt(en); 
        
         try{  
   
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/nitin", "root", "root");
            PreparedStatement pst = con.prepareStatement("select * from registration1 where enno=?");
            pst.setInt(1, enno);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
            out.println("<form action=\"updateServlet\" method=\"GET\"> ");
            
                out.println("<input type=\"hidden\" name=\"enno\" value=" + rs.getInt(1) + ">");
                out.print("<br/> <br/>");
                out.print("Name:<input type=\"text\" name=\"userName\"value=" + rs.getString(2) + " />");
                out.print("<br/><br/> ");
                out.print("Password:<input type=\"password\" name=\"userPass\"value=" + rs.getString(3) + " />");
                out.print("<br/> <br/>");
                out.print("Email Id:<input type=\"text\" name=\"userEmail\"value=" + rs.getString(4) + " />");
                out.print("<br/> <br/>");
                out.print("City:  \n" +
                         "<select name=\"city\">  \n"
                        + "<option>Ahmedabad</option>  \n"
                        + "<option>Surat</option>  \n"
                        + "<option>other</option>  \n"
                        + "</select> ");
         out.print("<br/> <br/>");
         out.print("<input type=\"submit\" value=\"register\"/>");
          out.print("<br/><br/> ");
          out.print("</form>");
// RequestDispatcher rd=request.getRequestDispatcher("view");
            //rd.forward(request, response);
            }
         }
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
finally{out.close();}
    }
}
   