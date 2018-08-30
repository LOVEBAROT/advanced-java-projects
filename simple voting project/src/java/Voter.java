

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

public class Voter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try{
            String VTR = request.getParameter("VTR");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("Select Hex,AN,VTRLOG from Login where IP = '"+request.getLocalAddr()+"'");
            if(rst.next()){
                if(!rst.getBoolean(3)){
                    rst = st.executeQuery("Select VTR from MAT where Hex ='"+ rst.getString(1)+"' AND AN = '"+rst.getString(2)+"'");
                     if(rst.next()){
                        if(VTR.equals(rst.getString(1))){

                        // if enter Aadhar number is  matched
                            st.executeUpdate("Update Login set VTR = '"+VTR+"',VTRLOG = true where IP = '"+request.getLocalAddr()+"'");
                            rst = st.executeQuery("Select VOTED from MAT where VTR = '"+VTR+"'");
                            if(rst.next()){
                                if(rst.getBoolean(1)){
                                   
                        // if enter Voter number is not matched
                            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","You have Already Voted");
                            rd.forward(request, response);
                                }else{
                                    RequestDispatcher rd = request.getRequestDispatcher("City.jsp");
                                    rd.forward(request,response);
                                }
                            }else{                            
                                   
                        // if enter Voter number is not matched
                            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","You have Already Voted");
                            rd.forward(request,response);
                            }
                            
                        }else{
                        // if enter Aadhar number is not matched
                            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","Voter Id didn't match");
                            rd.forward(request,response);
                        }
                    }else{
                        RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","No data about you please try again later");
                        rd.forward(request,response);
                    }
                }else{
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","Refereshing Page is not allowed");
                    rd.forward(request,response);
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                            request.setAttribute("Error","Your IP Address has been Changed");
                    rd.forward(request,response);
            }
            con.close();
        }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            request.setAttribute("Error",e.getMessage());
            rd.forward(request,response);
        }
    }

    
}
