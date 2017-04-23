/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Ioana
 */
public class ListTopProducts {
    Extragere S=new Extragere();
    Hashtable<Integer, ArrayList<String>> data=S.ExtragereDate();
    ArrayList<String> list=new ArrayList<String>();
public ArrayList<String> Top() throws SQLException
{
    for(int i=0;i<data.size();i++)
    {
        if(verificare(list,data.get(i).get(3).toString())==1)
        list.add(data.get(i).get(3).toString());
       // System.out.println(data.get(i).get(3).toString());
    }
    MakeTop(list);
        return list;
}
private int verificare(ArrayList<String> l,String s)
{
   for(int i=0;i<l.size();i++)
           if(l.get(i).equals(s))
               return 0;
   return 1;
}
private void MakeTop(ArrayList<String> l)
{
    l.add("Nestle");
    l.add("Murfatlar");
    l.add("Boromir");
    l.add("Vel Pitar");
    l.add("Albalact");
    l.add("Coca-Cola");
    l.add("Bunica");
    l.add("Fuchs");  
}
}
