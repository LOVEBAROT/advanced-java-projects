
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import javax.servlet.*;
import javax.servlet.http.Cookie;



public class demoservlet extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext context=getServletContext();
        String name=(String)context.getAttribute("name");
        
        Cookie ck[]=request.getCookies();
        out.print("Cookie Name is "+ck[0].getName());
        out.print("<br><br>");
        out.print("Second Cookie Name is "+ck[1].getName());
          out.print("<br><br>");
        out.print("\nYour Name is "+ck[0].getValue());
          out.print("<br><br>");
        out.print("\nYout Password is "+ck[1].getValue());
          out.print("<br><br>");
        System.out.println("Context Attribu Name is "+name);
        
       // String name=request.getParameter("name");
        out.print("Answer is "+name);
        
    }
        
}
