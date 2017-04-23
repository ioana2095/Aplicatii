/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Ioana
 */
public class Coada {
    private ArrayList<Client> coada;
    private JLabel icon;
    private GridBagConstraints gbc=new GridBagConstraints();
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
           for(i=0;i<=aux;i++)
               for(Client c:coada)
                   if(c.getTimpSosire()<i && (c.getTimpServire()+c.getTimpSosire())>=i)
                   {
                       eliberareCasa+=2;
                       aux+=2;
                   }
                       
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return eliberareCasa;
    }
    public void showCoada(int x,int y,JPanel panel)
    {
       gbc.insets=new Insets(10,10,10,10);
       icon = new JLabel("casa");
       gbc.gridx=x;
       gbc.gridy=y;
	panel.add(icon,gbc);
    }
}
