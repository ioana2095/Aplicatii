/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observer;

/**
 *
 * @author Ioana
 */
public class SpendingAccount  extends Account implements Serializable{
    private int id;
    private String cont;
    private String moneda;
    private float suma;
    @Override
    public int getId()
    {
        return this.id;
    }
    @Override
    public void setId(int id)
    {
        this.id=id;
    }
   @Override
    public String getCont() {
        return this.cont;
    }

    @Override
    public void setCont(String cont) {
        this.cont=cont;
    }

    @Override
    public String getMoneda() {
        return this.moneda;
    }

    @Override
    public void setMoneda(String moneda){
        this.moneda=moneda;
    }

    @Override
    public float getSuma() {
        return this.suma;
    }

    @Override
    public void setSuma(float suma) 
    {
        this.suma=suma;
        //setChanged();
        
    }
    public void getSumaAccount(float suma)
    {
        float rez=0;
        int ok=0;
        rez=getSuma()-suma;
        if(rez<=5)
            ok=1;
        else
        {
            ok=0;
            setSuma(rez);
        }
        setChanged();
        notifyObservers();
    }
    public void addSumaAccount(float suma)
    {
        setSuma(getSuma()+suma);
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpendingAccount other = (SpendingAccount) obj;
        if (this.getCont() == null) {
            if (other.getCont() != null)
                return false;
        } else if (!getCont().equals(other.getCont()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cont);
        return hash;
    }

    
}