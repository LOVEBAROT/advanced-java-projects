import java.sql.*;  
  
public class simple {  
public static boolean validate(String UNAME,String PASS){  
boolean status=false;  
try{  
 Class.forName("org.apache.derby.jdbc.ClientDriver");
                  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/apollo", "apollo", "root");
      
PreparedStatement ps=con.prepareStatement(  
"select * from REGISTRATION where UNAME=? and PASS=?");  
ps.setString(1,UNAME);  
ps.setString(2,PASS);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  