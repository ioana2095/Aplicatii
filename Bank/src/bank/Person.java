/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Ioana
 */
public class Person implements Serializable,Observer{
    static int count=0;
    private int id;
    private String nume,prenume;
    private String CNP,nrSerie;
    private int nrConturi;
    public Person()
    {
        this.id=count;
        count++;
    }
    public Person(String nume,String prenume,String CNP,String nrSerie)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.CNP=CNP;
        this.nrSerie=nrSerie;
        this.id=count;
        count++;
    }
    public int getNrConturi()
    {
        return this.nrConturi;
    }
    public void setNrConturi(int nr)
    {
        this.nrConturi=nr;
    }
    public int getId()
    {
        return this.id;
    }
    public void setNume(String nume)
    {
        this.nume=nume;
    }
    public String getNume()
    {
        return this.nume;
    }
    public void setPrenume(String prenume)
    {
        this.prenume=prenume;
    }
    public String getPrenume()
    {
        return this.prenume;
    }
    public void setCnp(String cnp)
    {
        this.CNP=cnp;
    }
    public String getCnp()
    {
        return this.CNP;
    }
    public void setSerie(String serie)
    {
        this.nrSerie=serie;
    }
    public String getSerie()
    {
        return this.nrSerie;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (this.getNume() == null) {
            if (other.getNume() != null)
                return false;
        } else if (!getNume().equals(other.getNume()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nume);
        hash = 17 * hash + Objects.hashCode(this.prenume);
        return hash;
    }

    

    
    @Override
    public void update(Observable o, Object o1) {
            System.out.println("S-a realizat modificari");
    }
}
