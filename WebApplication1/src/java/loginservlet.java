import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletContext; 
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*; 
import javax.servlet.*;

  
public class loginservlet extends HttpServlet {  
  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

request.getRequestDispatcher("link.html").include(request, response);

String id=request.getParameter("id");      
String pass=request.getParameter("pass");  
if(pass.equals("123"))
    {
        //Cookie name=new Cookie("name", id);
        //response.addCookie(name);
        HttpSession session=request.getSession();
        session.setAttribute("id", id);
        
        
        out.print("<br>");
        out.print("<br>");
        out.print("You are successfully logged in");
        out.print("<a href='logout?name="+id+"'>LOGOUT</a>");
        
        out.print("<br>Welcome "+id);
    }
    else
    {
       out.print("sorry, username or password error!\");  ");
       request.getRequestDispatcher("login.html").include(request, response);
    }
     
}
}  