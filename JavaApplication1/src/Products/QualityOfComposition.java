/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Ioana
 */
public class QualityOfComposition {
    Extragere S=new Extragere();
    Hashtable<Integer, ArrayList<String>> data=S.ExtragereDate();
    ArrayList<String> list=new ArrayList<String>();
public Boolean VerifyProduct(int s)
{
    Boolean aspect1=data.get(s-1).get(6).toString().equals("Placut");
    Boolean aspect2=data.get(s-1).get(6).toString().equals("Foarte placut");
    Boolean tip=data.get(s-1).get(2).toString().equals("B");
        if(tip)
        {
            String comp=data.get(s-1).get(8).toString();
            Boolean compozitie1=comp.equals("combinatie de cereale");
            //System.out.println(data.get(s-1).get(8));
            Boolean compozitie2=comp.equals("fructe rosi de padure");
            Boolean compozitie3=comp.equals("hamei");
            if(compozitie1 || compozitie2 || compozitie3)
                if(aspect1 || aspect2)
                {
                        return true;
                }
        }
        if(data.get(s-1).get(2).toString().equals("J"))
        {
            Boolean compozitie1=data.get(s-1).get(8).toString().equals("lemn");
            Boolean compozitie2=data.get(s-1).get(8).toString().equals("carton");
            Boolean compozitie3=data.get(s-1).get(8).toString().equals("plastic");
            if(compozitie1 || compozitie2 || compozitie3)
                if(aspect1 || aspect2)
                return true;
        }
        if(data.get(s-1).get(2).toString().equals("A"))
        {
            if(verificare(data.get(s-1).get(8).toString())) 
                    if(aspect1 || aspect2)
                        return true;
        }
    return false;
}
public Boolean verificare(String s)
{
    String[] split=s.split(" ");
    if(split.length==1)
        return true;
    return false;
        
}
}
