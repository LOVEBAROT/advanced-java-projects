
import Model.Demo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class NewServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        int pass1=Integer.parseInt(pass);
        String email = request.getParameter("email");
        
        Demo d = new Demo();
        d.setEmail(email);
        d.setUsername(uname);
        d.setPassword(pass1);
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(d);
        t.commit();
        out.print("Record Inserted");
    }

    

}
