/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Ioana
 */
public class OrderManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
       Customers people=new Customers();
     //  Warehouse w=new Warehouse();
       Client c=new Client();
       try{
         FileInputStream fileIn = new FileInputStream("client.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         Object obj = in.readObject();
         int numberC=(Integer)obj;
         for(int i=0;i<numberC;i++)
         {
             obj=in.readObject();
             c=(Client) obj;
             people.addClient(c, i);
         }
         
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }
        //Deserializare Produse
       Warehouse w=new Warehouse();
       Produse p=new Produse() ;
       try
       {
          FileInputStream fileIn=new FileInputStream("produse.txt");
          ObjectInputStream in=new ObjectInputStream(fileIn);
          Object obj=in.readObject();
          int numberP=(Integer)obj;
          
          for(int i=0;i<numberP;i++)
          {
              obj=in.readObject();
              p=(Produse)obj;
              w.addProduse(p);
          }
          in.close();
          fileIn.close();
       }catch(Exception i)
       {
           i.printStackTrace();
           return;
       }
        View v1=new View(people,w);
        v1.setVisible(true);
    }
    
}
