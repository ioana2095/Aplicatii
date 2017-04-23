/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Ioana
 */
public class Main {
     public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Person, ArrayList<Account>> map = null;
      try
      {
         FileInputStream fis = new FileInputStream("bank.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized HashMap..");
      Bank b=new Bank(map);
      //Bank b=new Bank();
      //53647282898789
      //cj765
      
    View v=new View(b);
       
    }
}
