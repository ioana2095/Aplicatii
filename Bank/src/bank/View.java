/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class View extends JFrame implements ActionListener,ItemListener{
    private JTextField numeClient  = new JTextField(50);
    private JTextField prenumeClient  = new JTextField(50); 
    private JTextField cont  = new JTextField(50);
    private JTextField idCont  = new JTextField(50);
    private JTextField moneda  = new JTextField(50);
    private JTextField suma  = new JTextField(50);
    private JTextField CNP=new JTextField(50);
    private JTextField serie=new JTextField(50);
    private JButton adaugareClient = new JButton("Adaugare Client");
    private JButton afisare = new JButton("Afisare");
    private JButton adugareCont= new JButton("Adaugare Cont");
    private JButton stergereCont = new JButton("Stergere Cont");
    private JButton stergereClient = new JButton("Stergere Client");
    private JButton adaugareBaniCont=new JButton("Adaugare Bani Cont");
    private JButton retragereBaniCont=new JButton("Retragere Bani Cont");
    private JLabel numeC  = new JLabel("Nume Client");
    private JLabel prenumeC  = new JLabel("Prenume Client");
    private JLabel contC  = new JLabel("Cont");
    private JLabel IdCont = new JLabel("Id Cont(0-saving, 1-spending)");
    private JLabel Moneda  = new JLabel("Moneda");
    private JLabel Suma  = new JLabel("Suma");
    private JLabel cnp=new JLabel("CNP");
    private JLabel Serie =new JLabel("Nr si serie buletin");
    private JTable table;
    
    public View(Bank banca)
    {
        
        JPanel variabile=new JPanel(new GridLayout(0,2,1,1));
        JPanel tabelul=new JPanel();
        JPanel butoane=new JPanel(new GridBagLayout());
        variabile.setBackground(Color.yellow);
        tabelul.setBackground(Color.green);
        butoane.setBackground(Color.red);
        this.add(variabile,BorderLayout.NORTH);
        this.add(tabelul,BorderLayout.CENTER);
        this.add(butoane,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(700, 700);
        setVisible(true);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        variabile.add(numeC);
        variabile.add(numeClient);
        variabile.add(prenumeC);
        variabile.add(prenumeClient);
        variabile.add(cnp);
        variabile.add(CNP);
        variabile.add(Serie);
        variabile.add(serie);
        variabile.add(contC);
        variabile.add(cont);
        variabile.add(IdCont);
        variabile.add(idCont);
        variabile.add(Moneda);
        variabile.add(moneda);
        variabile.add(Suma);
        variabile.add(suma);
        gbc.gridx=0;
        gbc.gridy=0;
        butoane.add(adaugareClient,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        butoane.add(afisare,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        butoane.add(adugareCont,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        butoane.add(retragereBaniCont,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        butoane.add(stergereClient,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        butoane.add(adaugareBaniCont,gbc);
        gbc.gridx=3;
        gbc.gridy=0;
        butoane.add(stergereCont,gbc);
        
        this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				banca.serializare();
                                
			}
		});
        retragereBaniCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!="" && cont.getText()!="" && moneda.getText()!="" && suma.getText()!="" && CNP.getText()!="" && serie.getText()!="")
                {
                     p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    if(Integer.parseInt(idCont.getText())==0)
                {
                    SavingAccount ac=new SavingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.scoatereBaniSpending(p, ac,Float.parseFloat(suma.getText()));
                }
                else
                {
                    SpendingAccount ac=new SpendingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.scoatereBaniSpending(p, ac,Float.parseFloat(suma.getText()));
                }  
                }
                }
        });
        adaugareBaniCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!="" && cont.getText()!="" && moneda.getText()!="" && suma.getText()!="" && CNP.getText()!="" && serie.getText()!="")
                {
                     p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    if(Integer.parseInt(idCont.getText())==0)
                {
                    SavingAccount ac=new SavingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.adaugareBaniSaving(p, ac,Float.parseFloat(suma.getText()));
                }
                else
                {
                    SpendingAccount ac=new SpendingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.adaugareBaniSpending(p, ac,Float.parseFloat(suma.getText()));
                }  
                }
            }
                });
        stergereCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!="" && cont.getText()!="" && moneda.getText()!="" && suma.getText()!=""&& CNP.getText()!="" && serie.getText()!="")
                {
                     p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    if(Integer.parseInt(idCont.getText())==0)
                {
                    SavingAccount ac=new SavingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.removeCont(p, ac);
                }
                else
                {
                    SpendingAccount ac=new SpendingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.removeCont(p, ac);
                }  
                }
                }
        });
                
        stergereClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!=""&& CNP.getText()!="" && serie.getText()!="")
                {
                    p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    banca.removePerson(p);
                }
               
                }
        });
        adugareCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!="" && cont.getText()!="" && moneda.getText()!="" && suma.getText()!=""&& CNP.getText()!="" && serie.getText()!="")
                {
                     p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    if(Integer.parseInt(idCont.getText())==0)
                {
                    SavingAccount ac=new SavingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.addCont(p, ac);
                }
                else
                {
                    SpendingAccount ac=new SpendingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    banca.addCont(p, ac);
                }  
                }
                
                        
                
                }
        });
        adaugareClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p=new Person();
                ArrayList<Account> c=new ArrayList<Account>();
                //Account acount=null;
                
                if(numeClient.getText()!="" && prenumeClient.getText()!="" && cont.getText()!="" && moneda.getText()!="" && suma.getText()!=""&& CNP.getText()!="" && serie.getText()!="")
                {
                     p.setNume(numeClient.getText());
                    p.setPrenume(prenumeClient.getText());
                    p.setCnp(CNP.getText());
                    p.setSerie(serie.getText());
                    if(Integer.parseInt(idCont.getText())==0)
                {
                    SavingAccount ac=new SavingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    c.add(ac);
                }
                else
                {
                    SpendingAccount ac=new SpendingAccount();
                    ac.setCont(cont.getText());
                    ac.setMoneda(moneda.getText());
                    ac.setSuma(Float.parseFloat(suma.getText()));
                    ac.setId(Integer.parseInt(idCont.getText()));
                    c.add(ac);
                }  
                }
                banca.addPerson(p, c);
                numeClient.setText("");prenumeClient.setText("");
                cont.setText(""); moneda.setText("");suma.setText(""); 
                CNP.setText(""); serie.setText("");
                JOptionPane.showMessageDialog(null,"Persoana a fost adugat",null,JOptionPane.INFORMATION_MESSAGE);
                }
        });
       afisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelul.removeAll();
                String[] capete=new String[6];
                capete[0]="Id";
                capete[1]="Nume";
                capete[2]="Prenume";
                capete[3]="Conturi";
                capete[4]="Monede";
                capete[5]="Suma";
                Object[][] nou=banca.afisare(banca);
                table=new JTable(nou,capete);
                table.setFillsViewportHeight(true);
                table.setVisible(true);
                table.setSize(200,200);
                tabelul.setLayout(new BorderLayout());
                tabelul.add(table.getTableHeader(), BorderLayout.PAGE_START);
                tabelul.add(table, BorderLayout.CENTER);
                tabelul.revalidate();
            }
        }); 
    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
