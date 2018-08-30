import javax.faces.bean.ManagedBean;  
import javax.faces.bean.SessionScoped;
 
@ManagedBean (name="obj")  
@SessionScoped
public class User{  
String name;  
String quantity;  
String price;

 
public String getName() {  
return name;  
}  
public void setName(String name) {  
this.name = name;  
}  
public String getquantity() {  
return quantity;  
}  
  
public void setquantity(String quantity) {  
this.quantity = quantity;  
}  
public String getprice() {  
return price;  
}  
public void setprice(String price) {  
this.price = price;  
}  
 
 public String add()
{
    System.out.println("Product Inserted...");
    System.out.println(name + "" + quantity + "" + price);
    return "response";
}
}  