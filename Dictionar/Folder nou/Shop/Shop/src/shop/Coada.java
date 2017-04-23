/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import static java.lang.Thread.sleep;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Ioana
 */
public class Coada extends Thread {
     private ArrayList<Client> coada;
    private int time;
    private int nrCoada;
    private JFrame client;
    private JPanel panel;
    public Coada(ArrayList<Client> listaClienti,int coada,JFrame client)
    {
    this.coada=listaClienti;
    this.nrCoada=coada;
    this.client=client;
    
    }
    public Coada()
    {
        this.coada=new ArrayList<>();
    }
    public ArrayList<Client> getCoada()
    {
        return this.coada;
    }
    public void addClienti(Client c)
    {
        this.coada.add(c);
    }
    public void setCoada(ArrayList<Client> coada)
    {
        this.coada=coada;
    }
    public int getTimpEliberare(int time)
    {
        int eliberareCasa=0;
        int i;
        int aux=time;
        try
        {
           for(i=0;i<=aux;i++){
               for(Client c:coada){
                   if(c.getTimpSosire()<i && (c.getTimpServire()+c.getTimpSosire())>=i)
                   {
                       eliberareCasa+=2;
                       aux+=2;
                   }
               }
           }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return eliberareCasa;
    }
   public void run()
{
    panel=new JPanel();
    panel.setBounds(nrCoada*80, 0,150, 310);
    client.add(panel);
    try{
        time=coada.get(0).getTimpSosire();
        for(Client c:coada)
        {
            time+=c.getTimpServire();
        }
        
    }catch(Exception e)
    {
        e.getMessage();
    }
    
    int timpActual;
    int k,y;
    for(timpActual=0;timpActual<time;timpActual++)
    {
        panel.removeAll();
        y=0;k=0;
        for(Client c:coada)
        {
            k++;
            if(c.esteLaCoada(timpActual)==1)
            {
                y++;
                if(y>1)
                {
                    c.setTimpServire(c.getTimpServire()+2);
                }
                c.showClient(0, y*50, panel);
            }
        }
        panel.repaint();
    try{
        sleep(1000);
    }catch(InterruptedException e)
    {
       e.printStackTrace();
    }
    }
    panel.removeAll();
    panel.repaint();
            
}
}
