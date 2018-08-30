

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


public class profile extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           request.getRequestDispatcher("link.html").include(request, response);
      // Cookie ck[]=request.getCookies();
        // out.print("WelCome TO Dream Project  "+ck[0].getValue());  
           
           
        HttpSession session=request.getSession();
        String name =(String)session.getAttribute("id");
         if(name!=null)
            {
                out.print("WelCome TO Dream Project  "+name);
            }
            else
            {
            out.print("Please First Login..");
            request.getRequestDispatcher("login.html").include(request, response);
            }
        
        
        
        }
    }


