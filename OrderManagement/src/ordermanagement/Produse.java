/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import java.io.Serializable;

/**
 *
 * @author Ioana
 */
public class Produse implements Serializable{
   private static int idCounter=0;
   private int idProdus;
   private String numeProdus;
   private int cantitateProdus;
   private float pretProdus;
    public Produse()
    {   
        idProdus=idCounter;
        idCounter++;
    }
    public Produse(String nume,int cantitate,float pret)
    {
        this.idProdus=idCounter;
        idCounter++;
        this.cantitateProdus=cantitate;
        this.numeProdus=nume;
        this.pretProdus=pret;
    }
    public int getIdProdus()
    {
        return this.idProdus;
    }
    public void setIdProdus(int id)
    {
        this.idProdus=id;
    }
     public int getIdProdusN(String nume)
    {
       if(this.numeProdus==nume)
        return this.idProdus;
      return 0;
    }
     public int getCantitateProdus()
    {
        return this.cantitateProdus;
    }
    public void setCantitateProdus(int cantitate)
    {
        this.cantitateProdus=cantitate;   
    }
     public String getNumeProdus()
    {
        return this.numeProdus;
    }
    public void setNumeProdus(String nume)
    {
        this.numeProdus=nume;   
    }
     public float getPretProdus()
    {
        return this.pretProdus;
    }
    public void setPretProdus(float pret)
    {
        this.pretProdus=pret;   
    }
    
}
