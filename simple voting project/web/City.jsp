<%-- 
    Document   : newjsp
    Created on : Apr 4, 2018, 7:19:58 PM
    Author     : Lucky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vote Page</title>
         <link rel="stylesheet" type="text/css" href="css/city.css">
    </head>
    <body style="background-image: url(css/images/6.jpg)">
         <h2 style="background-color: khaki; margin-bottom: 300px  "><marquee>Select your leader and press Submit button for complete the process. </marquee></h2>
        <%@page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, java.sql.DriverManager"%>
        
        <%
            out.print("<center>");
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
                Statement st = con.createStatement();
                ResultSet rst = st.executeQuery("Select Hex,AN,VTR from Login where IP = '"+request.getLocalAddr()+"'");
                if(!rst.next()){
                    out.print("<h1>Sorry you are not allow to vote</h1>");
                }else{
                    out.print("<form method='Post' name='Final' action='Vote'>");                    
                    rst = st.executeQuery("SELECT LID FROM TEAMLEADER WHERE CODE = "
                            + "(SELECT CODE FROM MAT WHERE HEX = '"+rst.getString(1)+"' AND AN = '"+rst.getString(2)+"' AND "
                                    + "VTR = '"+rst.getString(3)+"')");
                    out.print("<select  name='Elected'>");
                    while(rst.next()){
                    out.print("<option name='"+rst.getString(1)+"' value='"+rst.getString(1)+"'>"+rst.getString(1)+"</option>");
                    }
                    out.print("</select>");
                    out.print("<button id='MyBut' onClick='But()' type='button'>Submit</button>");
                    out.print("</form>");
                }
            }catch(Exception e){
                out.print(e.getMessage());
            }
                    out.print("</center>");
                       out.print("<script>"
                               + "function But()"
                               + "{"
                               + "var abc = confirm('Are you sure');"
                               + "if(abc)"
                               + "document.forms['Final'].submit();"
                               + "}"
                               + "</script>");
        
        %>
        
    </body>
</html>
