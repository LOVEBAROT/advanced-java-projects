import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
       // Cookie ck= new Cookie("name", "");
        //ck.setMaxAge(0);
        //response.addCookie(ck);
      //  String name1=request.getParameter("name");
        HttpSession session=request.getSession();
        session.invalidate();
        out.print("You are Sucessfully Logout....");
         out.println("<br>");
         request.getRequestDispatcher("index.html").include(request, response);
        
        }
    }


