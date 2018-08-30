import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        
       // Cookie ck= new Cookie("name", "");
        //ck.setMaxAge(0);
        //response.addCookie(ck);
        String name=request.getParameter("name");
        HttpSession session=request.getSession();
        session.invalidate();
        out.print("You are Sucessfully Logout...."+name);
        
        }
    }


