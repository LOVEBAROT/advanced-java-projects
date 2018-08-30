
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;


public class deleteServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String en=request.getParameter("enno");
        int enno=Integer.parseInt(en);
        
        try{  
   
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/nitin", "root", "root");
            PreparedStatement pst = con.prepareStatement("delete from registration1 where enno=?");
            pst.setInt(1, enno);
            int rs=pst.executeUpdate();
            RequestDispatcher rd=request.getRequestDispatcher("view");
            rd.forward(request, response);
            }
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
     
finally{out.close();}
        }
        
        
           
        
    }

    
