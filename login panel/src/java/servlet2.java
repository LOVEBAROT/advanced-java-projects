
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
         HttpSession session=request.getSession();
        String name =(String)session.getAttribute("id");
         if(name!=null)
            {
                out.print("WelCome TO Dream Project  "+name);
                out.println("<br>");
                out.println(" <a href=\"view1\">VIEW YOUR DATA</a></br>");
                request.getRequestDispatcher("link.html").include(request, response);
            }
            
        
        
    }
}