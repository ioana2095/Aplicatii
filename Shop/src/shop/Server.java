/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ioana
 */
public class Server extends Thread {
    private int time;
    private ArrayList<Client> listaClienti;
    private ArrayList<Coada> listaCozii;
    private JFrame mainPanel;
    private JPanel coada;
        
    public Server(int t,ArrayList<Client> lista1,ArrayList<Coada> lista2,JFrame mainPanel)
    {
        this.time=t;
        this.listaClienti=lista1;
        this.listaCozii=lista2;
        this.mainPanel=mainPanel;
    }
    public Coada getCasa(ArrayList<Coada> lista,int time)
    {
        int min=50,coadaMin=0,i=0;
        for(Coada c:lista)
            if(c.getCoada().size()==0)
                return c;
        for(Coada c:lista)
        {
         if(c.getTimpEliberare(time)<min)   
         {
             min=c.getTimpEliberare(time);
             coadaMin=i;
         }
         i++;
        }
        return lista.get(coadaMin);
    }
    public void run()
    {
        coada=new JPanel(new GridBagLayout());
        coada.setBackground(Color.yellow);
        mainPanel.add(coada,BorderLayout.NORTH);
        int index;
        int i=0,j=0;
        coada.removeAll();
        for(Coada c:listaCozii)
        {
          c.showCoada(i,0, coada);
          i++;
        }
        try
        {
            sleep(1000);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    
        for(Client c:listaClienti){
            for(index=0;index<time;index++){
                if(c.getTimpSosire()==index){
                    getCasa(listaCozii,index).addClienti(c);
                }
            }
        }
        int thread=0;
            for(Coada c:listaCozii)
            {
                thread++;
                ManagerCoada m=new ManagerCoada(c.getCoada(),thread,mainPanel);
                m.start();
            }
        int timpServireT=0;
        int nrClienti;
        double timpServireM=0.0;
        int actualTimp;
        for(actualTimp=0;actualTimp<=time;actualTimp++){
            nrClienti=0;
        for(Client c:listaClienti){
            if(c.getTimpSosire()<actualTimp && (c.getTimpServire()+c.getTimpSosire())>=actualTimp)
            {
                timpServireT++;
            }
            if(c.getTimpSosire()<actualTimp)
                nrClienti++;
        } 
        try
        {
            timpServireM=((Number)timpServireT).doubleValue() / nrClienti;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        //String nr=String.valueOf(timpServireM);
        System.out.println("Timpul mediu de servire "+timpServireM);
        try
        {
            sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
                
        }   
            
    }
   
}
