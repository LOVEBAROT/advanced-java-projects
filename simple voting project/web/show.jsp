<%-- 
    Document   : show.jsp
    Created on : Apr 18, 2018, 6:25:08 PM
    Author     : Lucky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <th>Team</th>
            <th>Votes</th>
            <%@page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, java.sql.DriverManager"%>
            <%
                try{
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/love","root","root");
                    Statement st = con.createStatement();
                    ResultSet rst = st.executeQuery("SELECT TID,COUNT(LID) FROM TEAMLEADER WHERE LID IN (SELECT LID FROM FINALVOTES) GROUP BY TID");
                    while(rst.next()){
                        out.print("<tr><td>"+rst.getString(1)+"</td><td>"+rst.getInt(2)+"</td></tr>");
                    }
                }catch(Exception e){
                    out.print(e.getMessage());
                } 
            %>
            
            
            
        </table>
    </body>
</html>
