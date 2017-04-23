/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;



/**
 *
 * @author Ioana
 */
public class Products {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
   
    public static void main(String[] args) throws SQLException, IOException {
    Extragere S=new Extragere();
    Hashtable<Integer, ArrayList<String>> data= S.ExtragereDate();
    KnowledgeBase kb=new KnowledgeBase();
    System.out.println("Lista de produse : { ");
    System.out.println("Val | Produs  |     Producator");
    int n=0;
    for(int i=0;i<data.size();i++)
    {
        System.out.println(data.get(i).get(0)+"     "+data.get(i).get(1)+"       "+data.get(i).get(3));
    }
    System.out.print("}");
    System.out.println("");
    System.out.println("Products Knowledge Base:");
    System.out.println("(PrelucrareB(x) or PrelucrareJ(x) or PrelucrareA(x) => PrelucrareX(x))");
    System.out.println("(Types(x) and Top(x) and  not(QualityOfComposition(x)))=> Quality (Worst) )");
    System.out.println("(Types(x) and Top(x) and QualityOfComposition(x) and not(PrelucrareX(x)) )=> Quality (Good))");
    System.out.println("(Types(x) and Top(x) and QualityOfComposition(x) and PrelucrareX(x)) => Quality (Very Good))");
    Scanner in = new Scanner(System.in);
    while(n<22){
    System.out.println("Valoarea atribuita fiecarui produs");
    System.out.println("");
    int a=in.nextInt();
    System.out.print(a+".");
    kb.Quality(data.get(a-1));
    System.out.println("");
    n++;
    }
    /*while(n<22){
    //System.out.println("Valoarea atribuita fiecarui produs");
    System.out.println("");
    System.out.print((n+1)+".");
    kb.Quality(data.get(n));
    System.out.println("");
    n++;
    }*/
}  
}
