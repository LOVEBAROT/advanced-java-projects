
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class logout extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html").include(request, response);
        out.print("<br><br>");
        Cookie ck = new Cookie("username", "");
        ck.setMaxAge(0);
        response.addCookie(ck);
        out.print("you are successfully logged out!");  
        }
    }

  
