/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Ioana
 */
public class ListOfTypes {
    Extragere S=new Extragere();
    Hashtable<Integer, ArrayList<String>> data=S.ExtragereDate();
    ArrayList<String> list=new ArrayList<String>();
public ArrayList<String> Types() throws SQLException
{
    for(int i=0;i<data.size();i++)
    {
        if(verificare(list,data.get(i).get(2).toString())==1)
        list.add(data.get(i).get(2).toString());
    }
        return list;
}
private int verificare(ArrayList<String> l,String s)
{
   for(int i=0;i<l.size();i++)
           if(l.get(i).equals(s))
               return 0;
   return 1;
}
}
