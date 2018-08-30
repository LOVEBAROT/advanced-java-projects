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
public class Aadhar extends HttpServlet {

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
            String Add = request.getParameter("ADD");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("Select Hex,ADDLOG from Login where IP = '"+request.getLocalAddr()+"'");           
            if(!rst.next())
            {
                //if ip didn't matches
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error","Your IP has been changed please try later");
                rd.forward(request,response);
            }else if(!rst.getBoolean(2)){
                // if user did referesh the page
                rst = st.executeQuery("Select AN from MAT where Hex ='"+ rst.getString(1)+"'");
                if(rst.next()){
                    if(Add.equals(rst.getString(1))){
                        
                    // if enter Aadhar number is  matched
                        st.executeUpdate("Update Login set AN = '"+Add+"',ADDLOG = true where IP = '"+request.getLocalAddr()+"'");
                        RequestDispatcher rd = request.getRequestDispatcher("votercardform.html");
                        rd.forward(request,response);
                    }else{
                    // if enter Aadhar number is not matched
                        RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                        request.setAttribute("Error","Aadhar Didn't Matched Please try again after few minutes");
                        rd.forward(request,response);
                    }
                }else{
                        RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                        request.setAttribute("Error","No Such Aadhar Number Exist Please try again after few minutes");
                        rd.forward(request,response);
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                request.setAttribute("Error","Refereshing is not allowed in these pages");
                rd.forward(request,response);
            }
            con.close();
        }catch(Exception e){
             RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
             request.setAttribute("Error", e.getMessage());
             rd.forward(request,response);
        }
    }

    
}
