/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Ioana
 */
public class Customers implements Serializable{
    private ArrayList<Client> listaClienti;
    public Customers()
    {
        listaClienti=new ArrayList<Client>();
    }
    public void addClient(Client c,int i)
    {
        listaClienti.add(i, c);
    }
    public void deleteClient(String nume)
    {
        for(int i=0;i<listaClienti.size();i++)
            if(listaClienti.get(i).getNumeClient().compareTo(nume)==0)
        listaClienti.remove(listaClienti.get(i));
    }
    public Client getClient(int id)
    {
        return listaClienti.get(id);
    }
    public ArrayList<Client> getListaClienti()
    {
        return this.listaClienti;
    }
     public String[] convertireClient(Client c)
    {
        String[] sir=new String[3];
        sir[0]=((Integer)c.getIdClient()).toString();
        sir[1]=c.getNumeClient().toString();
        sir[2]=c.getAdresaClient().toString();
        return sir;
               
    }
    public String[][] afisare(Customers clienti)
    {
        String[][] produse=new String[clienti.getListaClienti().size()][3];
        Client c;
        String[] sir=new String[3];
        int i,j,k;
            for(i=0;i<clienti.getListaClienti().size();i++){
                c=(Client)clienti.getListaClienti().get(i);
                sir=convertireClient(c);
                for(j=0;j<3;j++)
                    produse[i][j]=sir[j];
        }
        return produse;
    }
    public void editareClient(int id,String nume,String adr)
    {
        Client e=(Client) listaClienti.get(id);
        e.setAdresaClient(adr);
        e.setNumeClient(nume);
        
    }
    public void serializareClient() 
    {
        try
        {
         FileOutputStream fileOut= new FileOutputStream("client.txt");
         ObjectOutputStream out=new ObjectOutputStream(fileOut);
         ArrayList<Client> clienti=listaClienti;
         out.writeObject((Integer)clienti.size());
         for(Client o:clienti)
            out.writeObject(o);
         System.out.println("Serializare datelor a fost salvata in nume");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
