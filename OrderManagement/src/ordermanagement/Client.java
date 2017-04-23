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
public class Client implements Serializable{
    private static int count=0;
    private int idClient;
    private String numeClient;
    private String adresa;
    public Client()
    {
        
        idClient=count;
        count++;
        
    }
    public Client(String nume,String adr)
    {
        this.idClient=count;
        count++;
        this.numeClient=nume;
        this.adresa=adr;
    }
    public int getIdClient()
    {
        return this.idClient;
    }
    public String getNumeClient()
    {
        return this.numeClient;
    }
    public void setNumeClient(String nume)
    {
        this.numeClient=nume;
    }
    public String getAdresaClient()
    {
        return this.adresa;
    }
    public void setAdresaClient(String adr)
    {
        this.adresa=adr;
    }
    
}
