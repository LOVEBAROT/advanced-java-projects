
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class registrationservlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String dob=request.getParameter("dob");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
       // int phone1=Integer.parseInt(phone);
        String email=request.getParameter("email");
        String zip=request.getParameter("zip");
        System.out.println("Connection "+zip);
         System.out.println("Connection "+fname);
          System.out.println("Connection "+lname);
         
        try
        {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/college", "root", "root");
        PreparedStatement pst=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?)");
            System.out.println("Connection "+con);
        pst.setString(1, fname);
        pst.setString(2 , lname);
        pst.setString(3, dob);
        pst.setString(4, address);
        pst.setString(5, phone);
        pst.setString(6, email);
        pst.setString(7, zip);
        
        int rs=pst.executeUpdate();
            System.out.println("Record Inserted....."+rs);
            
            
        }
        
        catch(Exception e)
        {
            System.out.println("Error is "+e.toString());
        }
        
        
        }
    }

