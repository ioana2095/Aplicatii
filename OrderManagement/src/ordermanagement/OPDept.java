/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import java.util.*;

/**
 *
 * @author Ioana
 */
public class OPDept {
    private TreeMap tree;
     public void addOrder(Order o)
    {
        tree.put(o.getIdOrder(), o);
    }
    public int validareOrder(Warehouse were,Produse p)
    {
        int ok=0;
        for(Object w:were.getTree().values())
            if(((Produse)w).getIdProdus()==p.getIdProdus())
                if(((Produse)w).getCantitateProdus()!=0 && ((Produse)w).getCantitateProdus()-p.getCantitateProdus()<0)
                    ok=0;
                else
                    ok=1;
        
        return ok;                         
    }
    public void stergereWareHouse(Warehouse were,Produse p)
    {
        for(Object w:were.getTree().values())
            if(((Produse)w).getIdProdusN(p.getNumeProdus())==p.getIdProdus())
                if(((Produse)w).getCantitateProdus()!=0 && ((Produse)w).getCantitateProdus()-p.getCantitateProdus()<0)
                    were.setValoare(((Produse)w).getCantitateProdus(), p.getIdProdus());
                else
                    were.setValoare(((Produse)w).getCantitateProdus()-p.getCantitateProdus(),p.getIdProdus());
    }
}
