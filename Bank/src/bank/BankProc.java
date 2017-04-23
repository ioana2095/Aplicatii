/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Ioana
 */
public interface BankProc  {
    public void addPerson(Person p,ArrayList<Account> a);
    public void removePerson(Person p);
    public void addCont(Person p,Account c);
    public void removeCont(Person p,Account c);
    public void adaugareBaniSaving(Person p,Account c,float suma);
    public void adaugareBaniSpending(Person p,Account c,float suma);
    public void scoatereBaniSpending(Person p,Account c,float suma);
    
}
