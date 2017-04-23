/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Ioana
 */
public class Extragere {
   private ArrayList<String> list=new ArrayList<String>();
   private ArrayList<String> listClone=new ArrayList<String>();
   private Hashtable<Integer, ArrayList<String>> data= new Hashtable<Integer, ArrayList<String>>();
public Hashtable<Integer, ArrayList<String>> ExtragereDate()
{
     // Create a variable for the connection string.  
      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=Produse;integratedSecurity=true;"; 
  
      // Declare the JDBC objects.  
      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;  
      int i=0;
      try {  
         // Establish the connection.  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         con = DriverManager.getConnection(connectionUrl);  
  
         // Create and execute an SQL statement that returns some data.  
        String SQL = "SELECT  * FROM dbo.Produse";  
         stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);    
         while(rs.next())
    {
        list.clear();
    	list.add(0,rs.getString(1));
    	list.add(1,rs.getString(2));
    	list.add(2,rs.getString(3));
    	list.add(3,rs.getString(4));
    	list.add(4,rs.getString(5));
    	list.add(5,rs.getString(6));
    	list.add(6,rs.getString(7));
    	list.add(7,rs.getString(8));
    	list.add(8,rs.getString(9));
    	list.add(9,rs.getString(10));
        listClone=(ArrayList<String>) list.clone();
    	data.put(i, listClone);
    	i++;
    }
      }  
  
      // Handle any errors that may have occurred.  
      catch (Exception e) {  
         e.printStackTrace();  
      }  
      finally {  
         if (rs != null) try { //rs.close();
         } catch(Exception e) {}  
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
         if (con != null) try { con.close(); } catch(Exception e) {}  
      }  
      return data;
}
}
