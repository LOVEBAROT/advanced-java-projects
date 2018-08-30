
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addition extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        request.getRequestDispatcher("link.html").include(request, response);
        
        String fnum=request.getParameter("fnum");
        String snum=request.getParameter("snum"); 
        
       out.print("Answer is "+fnum);
       out.print("<form action='demoservlet' method='GET'>");
       out.print("<input type='hidden' name='name' value="+fnum+">");
       out.print("<input type='submit' value='GO'>");
        out.print("</form>");
    }
    
    
    
}
