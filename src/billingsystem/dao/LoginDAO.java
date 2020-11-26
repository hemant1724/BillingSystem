/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import billingsystem.GetConnection;
import billingsystem.model.LoginModel;

/**
 *
 * @author hp
 */
public class LoginDAO {
    
     public static boolean authenticateAdmin(LoginModel admin)
    {
       Connection con=null;
       boolean status=false;
       try
       {
         con=GetConnection.getConnection();
         String sql= "select * from admin where username=? and password=?";
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1,admin.getUsername());
         ps.setString(2,admin.getPassword());
       
       
         ResultSet rs= ps.executeQuery();
       
         if(rs.next())
         {
            status=true;
         }
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
       finally
       {
         try
         {
           con.close();
         }
         catch(Exception e)
         {
           e.printStackTrace();
         }
       }
       return status;
    }
    
    
}
