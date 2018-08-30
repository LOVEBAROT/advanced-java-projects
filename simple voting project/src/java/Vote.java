/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Lucky
 */
public class Vote extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       try{
           String elected = request.getParameter("Elected");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select VTRLOG,ADDLOG,VOTED,HEX,AN,VTR from LOGIN where IP = '"+request.getLocalAddr()+"'");
            if(!rs.next()){
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error", "Your IP has been Changed Please Try Later");
                rd.forward(request,response);
            }else if(rs.getBoolean(1)&&rs.getBoolean(2)&&(!rs.getBoolean(3))){
                String HEX = rs.getString(4);
                String AN = rs.getString(5);
                String VTR = rs.getString(6);
                int rowaffected = st.executeUpdate("UPDATE  MAT SET VOTED = TRUE WHERE HEX = '"+HEX+"' AND AN = '"+AN+"' AND VTR = '"+VTR+"' ");
                if(rowaffected==1){
                rowaffected = st.executeUpdate("UPDATE LOGIN SET VOTED = TRUE WHERE HEX = '"+HEX+"' AND AN = '"+AN+"' "
                         + "AND VTR = '"+VTR+"' AND IP = '"+request.getLocalAddr()+"'");
                
                if(rowaffected==1){
                    rowaffected = st.executeUpdate("INSERT INTO FINALVOTES VALUES('"+HEX+"','"+AN+"','"+VTR+"','"+elected+"')");
                    rowaffected = st.executeUpdate("DELETE FROM LOGIN WHERE IP = '"+request.getLocalAddr()+"'");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request,response);
                    
                }else{
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error", "Not successfully voted");
                rd.forward(request,response);                    
                }
                
                } else{
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error", "Not successfully voted");
                rd.forward(request,response);
                }
            }else{
                
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error", "Your Have already voted or try again later");
                rd.forward(request,response);
            }
       }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            request.setAttribute("Error",e.getMessage());
            rd.forward(request,response);
           
       }
    }
}
