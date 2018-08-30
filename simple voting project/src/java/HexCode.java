import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HexCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try{
            String Hex = request.getParameter("Name");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("Select HEX from LOGIN where IP = '"+request.getLocalAddr()+"'");
            if(rst.next()){
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error","Session Overlap Session Over");
                rd.forward(request,response);
            }else{
                rst = st.executeQuery("Select Hex,VOTED from MAT where Hex ='"+ Hex+"'");
                if(rst.next()){
                    if(!rst.getBoolean(2)){
                    st.executeUpdate("Insert into Login(IP,HEX) Values('"+request.getLocalAddr()+"','"+Hex+"')");
                    RequestDispatcher rd = request.getRequestDispatcher("aadharform.html");
                    rd.forward(request,response);
                    }else{
                    RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                    request.setAttribute("Error","You have already voted");
                    rd.forward(request,response);
                    }
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                    request.setAttribute("Error","No data found about you");
                    rd.forward(request,response);
                }
                
            }
            con.close();
        }catch(Exception e){
            
            out.println(e.getMessage());
        }
        
    }
}
