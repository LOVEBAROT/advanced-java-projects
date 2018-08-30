<%-- 
    Document   : Error
    Created on : Apr 10, 2018, 6:16:41 PM
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
        <h1><% out.print(request.getAttribute("Error")); %></h1>
    </body>
</html>
