/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 *
 * @author Ioana
 */
public class Bank implements BankProc,Observer {

    public  HashMap<Person,ArrayList<Account>> map=new HashMap<Person,ArrayList<Account>>();
    public Bank(HashMap<Person,ArrayList<Account>> map)
    {
        this.map=map;
    }

    public Bank() {
        
    }
    public HashMap getHash()
    {
        return this.map;
    }
    public boolean isWellFormed() {
		boolean ok = true;
		for (Map.Entry<Person, ArrayList<Account>> entry : map.entrySet()) {
			if (entry.getValue().isEmpty()) {
				ok = false;
			}
		}
		return ok;
	}
    public String[] convertire(Person p,ArrayList<Account> c)
    {
        String[] sir=new String[6];
        sir[0]=((Integer)p.getId()).toString();
        sir[1]=(p.getNume()).toString();
        sir[2]=(p.getPrenume()).toString();
        sir[3]="";
        sir[4]="";
        sir[5]="";
        for(int i=0;i<c.size();i++){
        sir[3]=sir[3]+"<"+(c.get(i).getCont()).toString()+">";
        sir[4]=sir[4]+"<"+(c.get(i).getMoneda()).toString()+">";
        sir[5]=sir[5]+"<"+((Float)c.get(i).getSuma()).toString()+">";
        }
        return sir;
               
    }
    public String[][] afisare(Bank T)
    {
        ArrayList<Person> lista=new  ArrayList<Person>();
        ArrayList<ArrayList<Account>> cont=new ArrayList<ArrayList<Account>>();
        String[][] conturi=new String[T.getHash().size()][6];
        String[] sir=new String[6];
        int i,j,k;
        for(Object p:T.getHash().keySet())
            lista.add((Person)p);
        for(Object e:T.getHash().values())
            cont.add((ArrayList<Account>)e);
            for(i=0;i<lista.size() && i<cont.size();i++){
                sir=convertire(lista.get(i),cont.get(i));
                for(j=0;j<6;j++)
                    conturi[i][j]=sir[j];
        }
        return conturi;
    }
    @Override
    public void update(Observable o, Object o1) {
        System.out.println("S-a schimbat valoarea sumei");
    }
    public void serializare() 
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("bank.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(getHash());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in bank.ser");
            } catch (IOException i) {
		i.printStackTrace();
            }
    }
    @Override
     public void addPerson(Person p,ArrayList<Account> a) {
        assert isWellFormed();
        for(Object v:a)
            ((Account)v).addObserver(p);
        getHash().put(p,a);
        assert isWellFormed();
    }
    @Override
    public void removePerson(Person p) {
        assert isWellFormed();
        getHash().remove(p);
        assert isWellFormed();
    }

    @Override
    public void addCont(Person p,Account c){
       assert isWellFormed();
       c.addObserver(p);
       map.get(p).add(c);
       assert isWellFormed();
    }

    @Override
    public void removeCont(Person p,Account c) {
       assert isWellFormed();
       c.addObserver(p);
       map.get(p).remove(c);
       assert isWellFormed();
    }

    @Override
    public void adaugareBaniSaving(Person p, Account c,float suma) {
        assert isWellFormed();
        c.addObserver(p);
        int a=map.get(p).indexOf(c);
       ((SavingAccount) map.get(p).get(a)).addSuma(suma);
       assert isWellFormed();
    }

    @Override
    public void adaugareBaniSpending(Person p, Account c,float suma) {
        assert isWellFormed();
        c.addObserver(p);
         int a=map.get(p).indexOf(c);
       ((SpendingAccount) map.get(p).get(a)).addSumaAccount(suma);
       assert isWellFormed();
    }

    @Override
    public void scoatereBaniSpending(Person p, Account c,float suma) {
        assert isWellFormed();
        try{
        c.addObserver(p);
        int a=map.get(p).indexOf(c);
       ((SpendingAccount) map.get(p).get(a)).getSumaAccount(suma);
        }catch(Exception e)
        {
            e.getMessage();
        }
        assert isWellFormed();
    }

    
}
