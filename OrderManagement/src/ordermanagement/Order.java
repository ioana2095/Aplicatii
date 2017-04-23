/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import java.util.List;

/**
 *
 * @author Ioana
 */
public class Order {
    private static int cont=0;
    private Client c1;
    private List<Produse> p1;
    private int idOrder;
    public Order()
    {
        idOrder=cont;
        cont++;
    }
    public Order(Client c,List<Produse> p,int id)
    {
        this.c1=c;
        this.p1=p;
        this.idOrder=cont;
        cont++;
        
    }
    public int getIdOrder()
    {
        return this.idOrder;
    }
    public void addProdus(Produse p)
    {
        this.p1.add(p);
    }
    public List<Produse> getList()
    {
        return this.p1;
    }
}
