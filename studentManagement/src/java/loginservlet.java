
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


public class loginservlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html").include(request, response);
        out.print("<br><br>");
        String e = request.getParameter("enno");
        int enno=Integer.parseInt(e);
        String p = request.getParameter("userPass");
        
         try{  
   
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/nitin", "root", "root");
             //Statement st=con.createStatement();
             PreparedStatement pst = con.prepareStatement("select * from registration1 where enno=?");
             pst.setInt(1, enno);
             ResultSet rs = pst.executeQuery();

     while(rs.next())
    {
        if(rs.getString(3).equals(p))
        {
            Cookie ck= new Cookie("username", rs.getString(2));
            response.addCookie(ck);
            request.getRequestDispatcher("home").forward(request, response);
            
        }
        else
        {
         
            out.print("Sorry You Enter Invalid Password...");
            out.print("<br><br>");
            request.getRequestDispatcher("login.html").include(request, response);
            
        
        }
       
    }
       
       
      }
        catch(Exception e1)
        {
            System.out.println("Error is "+e1.toString());
        }
        
        
           
        }
    }

   
