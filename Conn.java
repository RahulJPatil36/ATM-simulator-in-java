package bank.management.system1;

import java.sql.*;

public class Conn {

   Connection m;
   Statement s;
   
    public Conn(){
            
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver"); 
            //String jdbcUrl = "jdbc:mysql://localhost:3306/bankmanagementsystem";

            m=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","vibgyor@123");
            s=m.createStatement();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    
}
}
