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
public class Warehouse implements Serializable{
    private int productId;
    private int stock;
    private TreeMap tree;
    public Warehouse()
    {
        tree=new TreeMap();
    }
    
    public void addProduse(Produse p)
    {
        tree.put(p.getIdProdus(), p);
    }
    public void deleteProduse(int id)
    {
        tree.remove(id);
    }
    public TreeMap getTree()
    {
        return this.tree;
    }
    public String[] getNumeProduse()
    {
        String[] produse=new String[tree.size()];
        for(Object w:tree.values())
            produse[((Produse)w).getIdProdus()]=((Produse)w).getNumeProdus();
        return produse;
    }
    public void setValoare(int cantitate,int id)
    {
        Produse d=(Produse)tree.get(id);
        d.setCantitateProdus(cantitate);
        
    }
    public String[] convertire(Produse p)
    {
        String[] sir=new String[4];
        sir[0]=((Integer)p.getIdProdus()).toString();
        sir[2]=((Integer)p.getCantitateProdus()).toString();
        sir[3]=((Float)p.getPretProdus()).toString();
        sir[1]=p.getNumeProdus().toString();
        return sir;
               
    }
    public void editareProduse(int id,String nume,float pret,int cantitate)
    {
        Produse e=(Produse) tree.get(id);
        e.setNumeProdus(nume);
        e.setPretProdus(pret);
        e.setCantitateProdus(cantitate);
        
    }
    public String[][] afisare(Warehouse T)
    {
        ArrayList<Produse> lista=new  ArrayList<Produse>();
        String[][] produse=new String[T.getTree().size()][4];
        Produse p;
        String[] sir=new String[4];
        int i,j,k;
        for(Object a:T.getTree().values())
        {
            lista.add((Produse)a);
        }
            for(i=0;i<lista.size();i++){
                p=(Produse) lista.get(i);
                sir=convertire(p);
                for(j=0;j<4;j++)
                    produse[i][j]=sir[j];
        }
        return produse;
    }
    public void serializareProdus() 
    {
        try
        {
         FileOutputStream fileOut= new FileOutputStream("produse.txt");
         ObjectOutputStream out=new ObjectOutputStream(fileOut);
         ArrayList<Produse> produsul = new ArrayList<>();
         for(Object a:tree.values())
        {
            produsul.add((Produse)a);
        }
         out.writeObject((Integer)produsul.size());
         for(Produse o:produsul)
            out.writeObject(o);
         System.out.println("Serializare datelor a fost salvata in nume");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
