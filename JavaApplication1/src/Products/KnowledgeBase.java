/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Ioana
 */
public class KnowledgeBase {
    ListTopProducts prod=new ListTopProducts();
    ListOfTypes prodType=new ListOfTypes();
    QualityOfComposition prodQ=new QualityOfComposition();
    Prelucrare produse=new Prelucrare();
private Boolean VerifyTheTypes(ArrayList<String> l) throws SQLException
{
     ArrayList<String> nl=prodType.Types();
    for(int i=0;i<nl.size();i++)
        if(l.get(2).toString().equals(nl.get(i).toString()))
            return true;
    return false;
}
private Boolean VerifyTheTops(ArrayList<String> l) throws SQLException
{
    ArrayList<String> nl=prod.Top();
    for(int i=0;i<nl.size();i++)
        if(l.get(3).toString().equals(nl.get(i).toString()))
            return true;
    return false;
}
private Boolean VerifyTheComposition(ArrayList<String> l) throws SQLException
{
    if(prodQ.VerifyProduct(Integer.parseInt(l.get(0).toString())))
            return true;
    return false;
}
private void proof(String s,String produs)
{
    if (s.equals("Worst"))
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|Step | Proof                                                                |Justification                                                                   |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|1    | Types(x) and Top(x) and  not(QualityOfComposition(x))=> Quality (y)  |Current Goal Quality("+s+"), {y="+s+",x="+produs+"}  ");
        System.out.println("|2    | Types(x)                                                             |Current Goal Types("+produs+"), {x="+produs+"} ,x has one of the types like B,J,A =>TRUE  ");
        System.out.println("|3    | Top(x)                                                               |Current Goal Top("+produs+"), {x="+produs+"} ,x has a producer in the top =>TRUE   ");
        System.out.println("|4    | not(QualityOfComposition(x))                                         |Current Goal QualityOfComposition("+produs+"), {x="+produs+"}, x does not repect the composition criteria => FALSE   ");
        
    }
    if (s.equals("Good"))
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|Step | Proof                                                                                   |Justification                                                                                            |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|1    | Types(x) and Top(x) and  QualityOfComposition(x) and not(PrelucrareX(x))=> Quality (y)  |Current Goal Quality("+s+"), {y="+s+",x="+produs+"}  ");
        System.out.println("|2    | Types(x)                                                                                |Current Goal Types("+produs+"), {x="+produs+"} ,x has one of the types like B,J,A =>TRUE  ");
        System.out.println("|3    | Top(x)                                                                                  |Current Goal Top("+produs+"), {x="+produs+"} ,x has a producer in the top =>TRUE   ");
        System.out.println("|4    | QualityOfComposition(x)                                                                 |Current Goal QualityOfComposition("+produs+"), {x="+produs+"}, x repect the composition criteria => TRUE   ");
        System.out.println("|5    | PrelucrareB(x) or PrelucrareJ(x) or PrelucrareA(x) => PrelucrareX(x)                    |Current Goal PrelucrareX("+produs+"), {x="+produs+"}, x can be process and only one of the methods will be took in consideration => FALSE   ");
        System.out.println("|6    | not(PrelucrareX(x))                                                                     |Current Goal PrelucrareX("+produs+"), {x="+produs+"}, x does not fall within the set criteria => FALSE   ");
        
    }
    if (s.equals("Very Good"))
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|Step | Proof                                                                                   |Justification                                                                                            |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|1    | Types(x) and Top(x) and  QualityOfComposition(x) and PrelucrareX(x)=> Quality (y)       |Current Goal Quality("+s+"), {y="+s+",x="+produs+"}  ");
        System.out.println("|2    | Types(x)                                                                                |Current Goal Types("+produs+"), {x="+produs+"} ,x has one of the types like B,J,A =>TRUE  ");
        System.out.println("|3    | Top(x)                                                                                  |Current Goal Top("+produs+"), {x="+produs+"} ,x has a producer in the top =>TRUE   ");
        System.out.println("|4    | QualityOfComposition(x)                                                                 |Current Goal QualityOfComposition("+produs+"), {x="+produs+"}, x repect the composition criteria => TRUE   ");
        System.out.println("|5    | PrelucrareB(x) or PrelucrareJ(x) or PrelucrareA(x) => PrelucrareX(x)                    |Current Goal PrelucrareX("+produs+"), {x="+produs+"}, x can be process and only one of the methods will be took in consideration => TRUE   ");
        System.out.println("|6    | PrelucrareX(x)                                                                          |Current Goal PrelucrareX("+produs+"), {x="+produs+"}, x does not fall within the set criteria => TRUE   ");
        
    }
    
    
}
public void Quality(ArrayList<String> l) throws SQLException
{
     System.out.print("Types("+l.get(1)+")");
    if(VerifyTheTypes(l))
    {
        System.out.print(" -> true");
        System.out.println();
        System.out.print("Top("+l.get(1)+")");
        if(VerifyTheTops(l))
        {
            System.out.print(" -> true");
            System.out.println();
            System.out.print("QualityOfComposition("+l.get(1)+")");
            if(VerifyTheComposition(l))
            {
                System.out.print(" -> true");
                System.out.println();
                System.out.print("PrelucrareB("+l.get(1)+")");
            if(l.get(2).toString().equals("B")){
                if(produse.prelucrareB(l)){
                        System.out.print(" -> true");
                        System.out.println();
                        System.out.println("Very Good");
                        proof("Very Good",l.get(1).toString());
                        return;
                }
                else
                {
                    System.out.print(" -> false");
                    System.out.println();
                }
            //return;
            }
            else
            {
                System.out.print(" -> Doesn't matter");
                System.out.println();
            }
                System.out.print("PrelucrareJ("+l.get(1)+")");
            if(l.get(2).toString().equals("J")){
                    if(produse.prelucrareJ(l)){
                        System.out.print(" -> true");
                        System.out.println();
                        System.out.println("Very Good");
                        proof("Very Good",l.get(1).toString());
                        return;
                }
                else
                {
                    System.out.print(" -> false");
                   System.out.println();
                }
            //return;
            }
            else
            {
                System.out.print(" -> Doesn't matter");
                System.out.println();
            }
                System.out.print("PrelucrareA("+l.get(1)+")");
            if(l.get(2).toString().equals("A")){
                    if(produse.prelucrareA(l)){
                       System.out.print(" -> true");
                       System.out.println();
                        System.out.println("Very Good");
                        proof("Very Good",l.get(1).toString());
                        return;
                    }
                    else
                    {
                       System.out.print(" -> false");
                       System.out.println();
                    }
                //return;
            }
            else
            {
                System.out.print(" -> Doesn't matter");
                System.out.println();
            }
            System.out.println();
            System.out.println("Good");
            proof("Good",l.get(1).toString());
            }
            else
            {
                System.out.print(" -> false");
                System.out.println();
                System.out.println("Worst");
                proof("Worst",l.get(1).toString());
            }
        }
        else
            {
                System.out.print(" -> false");
                System.out.println();
                System.out.println("Worst");
            }
    }
    else
        {
                System.out.print(" -> false");
                System.out.println();
        }
}

}
