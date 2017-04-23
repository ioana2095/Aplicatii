/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Ioana
 */
public abstract class Account extends Observable implements Serializable{
    
    abstract public String getCont();
    abstract public void setCont(String cont);
    abstract public String getMoneda();
    abstract public void setMoneda(String moneda);
    abstract public float getSuma();
    abstract public void setSuma(float suma);
    @Override
    abstract public boolean equals(Object o);
    @Override
    abstract public int hashCode();
    abstract public int getId();
    abstract public void setId(int id);
    ArrayList <Observer> l=new ArrayList <Observer>();
}
