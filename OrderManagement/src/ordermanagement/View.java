/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

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
    private JTextField adresaClient = new JTextField(50);
    private JTextField numeProdus  = new JTextField(50); 
    private JTextField cantitateProdus  = new JTextField(50);
    private JTextField pretProdus  = new JTextField(50);
    private JTextField IdProdus  = new JTextField(50);
    private JButton adaugareClient = new JButton("ADUGARE_C");
    private JButton afisareClienti = new JButton("AFISARE_C");
    private JButton afisareProduse = new JButton("AFISARE_P");
    private JButton adugareProdus= new JButton("ADUGARE_P");
    private JButton stergereClient = new JButton("STERGERE_C");
    private JButton stergereProdus = new JButton("STERGERE_P");
    private JButton editareP = new JButton("Editare Produs");
    private JButton editareC = new JButton("Editare Client");
    private JButton comanda = new JButton("Comanda");
    private JLabel numeC  = new JLabel("Nume Client");
    private JLabel numeP  = new JLabel("Nume Produs");
    private JLabel adresaC  = new JLabel("Adresa Client");
    private JLabel cantitateP  = new JLabel("Cantitate Produs");
    private JLabel pretP  = new JLabel("Pret Produs");
    private JLabel idProdus  = new JLabel("Id Produs/Client");
    private JTable table;
    private TreeMap T;
    private JScrollPane scrollPane = new JScrollPane();
    private JFrame order=new JFrame("Order");
    private JPanel combo=new JPanel(new GridLayout(0,3,1,1));
    private JPanel lista=new JPanel();
    private JButton adauga=new JButton("Adauga");
    private JTextField cantitate  = new JTextField(50);
    private JTextArea liste=new JTextArea();
    private String s=new String();
    private String nume=new String();
    private JComboBox text=new JComboBox() ;
    
    public View(Customers cost,Warehouse were)
    {
        OPDept dept=new OPDept();
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
        variabile.add(adresaC);
        variabile.add(adresaClient);
        variabile.add(numeP);
        variabile.add(numeProdus);
        variabile.add(cantitateP);
        variabile.add(cantitateProdus);
        variabile.add(pretP);
        variabile.add(pretProdus);
        variabile.add(idProdus);
        variabile.add(IdProdus);
        gbc.gridx=0;
        gbc.gridy=0;
        butoane.add(adaugareClient,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        butoane.add(afisareClienti,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        butoane.add(afisareProduse,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        butoane.add(adugareProdus,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        butoane.add(stergereClient,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        butoane.add(stergereProdus,gbc);
        gbc.gridx=3;
        gbc.gridy=0;
        butoane.add(editareP,gbc);
        gbc.gridx=3;
        gbc.gridy=1;
        butoane.add(editareC,gbc);
        gbc.gridx=4;
        gbc.gridy=0;
        butoane.add(comanda,gbc);
         text=new JComboBox(were.getNumeProduse());
        this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				were.serializareProdus();
                                cost.serializareClient();
			}
		});
         order.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				were.serializareProdus();
                                cost.serializareClient();
			}
		});  
        comanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            for(Object o:cost.getListaClienti())
            if(numeClient.getText().compareTo(((Client)o).getNumeClient())==0){
                order.setVisible(true);
                order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                order.setSize(400,400);
                order.add(combo,BorderLayout.NORTH);
                combo.setBackground(Color.red);
                order.add(lista,BorderLayout.CENTER);
                lista.setBackground(Color.blue);
                combo.add(text);
                combo.add(cantitate);
                combo.add(adauga);
                lista.add(liste);

                if(adresaClient.getText()!="" && numeClient.getText()!="")
                {
                     s=numeClient.getText()+" "+adresaClient.getText();
                    
                }
            }
                
                }
        });
        text.addActionListener(new ActionListener() {
        public  void actionPerformed(ActionEvent e) {
               if(e.getSource()==were.getNumeProduse())
               {
                   JComboBox cb=(JComboBox)e.getSource();
                   nume=(String)cb.getSelectedItem();
                   cantitate.setText(text.getSelectedItem().toString());
               }
             
       }
        });
      
        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
            text.getItemListeners();
            nume=(String)text.getSelectedItem();
            Produse p=new Produse();
            p.setNumeProdus((String)nume);
            p.setCantitateProdus(Integer.parseInt(cantitate.getText()));
            p.setIdProdus(text.getSelectedIndex());
                 for(Object a:were.getTree().values())
                if(((Produse)a).getIdProdus()==text.getSelectedIndex())
                        p.setPretProdus(((Produse)a).getPretProdus());
                if(dept.validareOrder(were,p)==1)
                {
                    int pret=((int)p.getPretProdus())*Integer.parseInt(cantitate.getText());
                    dept.stergereWareHouse(were, p);
                    s=s+" "+nume+" "+cantitate.getText()+" valoare factura "+pret+"\n";
                    liste.setText(s);
                }
                else
                {
                    JOptionPane.showInputDialog("prea mare cantitatea");
                }
                
                    FileOutputStream fos;
                    DataOutputStream dos;
                    try {
                    File file= new File("Factura.txt");
                    fos = new FileOutputStream(file);
                    dos=new DataOutputStream(fos);
                    dos.writeChars(s);
                    } catch (IOException a) 
                    {
                    a.printStackTrace();
                    }

                }
        });
        editareC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(adresaClient.getText()!="" && numeClient.getText()!="" && IdProdus.getText()!="" )
                {
                 cost.editareClient(Integer.parseInt(IdProdus.getText()), numeClient.getText(), adresaClient.getText());
                }
                }
        });
        editareP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(numeProdus.getText()!="" && cantitateProdus.getText()!="" &&pretProdus.getText()!="" && IdProdus.getText()!="")
            {
               were.editareProduse(Integer.parseInt(IdProdus.getText()),numeProdus.getText(),(float)Integer.parseInt(pretProdus.getText()),Integer.parseInt(cantitateProdus.getText()));
            }
    
                }
        });
        adaugareClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Client c=new Client();
                if(adresaClient.getText()!="" && numeClient.getText()!="")
                {
                c.setAdresaClient(adresaClient.getText());
                c.setNumeClient(numeClient.getText());
                c.getIdClient();
                }
                int a=c.getIdClient();
                cost.addClient(c, a);
                cost.serializareClient();
                
                //Inserare(capete,cost.afisare(cost));
                
                
                
                }
        });
        afisareClienti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelul.removeAll();
                String[] capete=new String[3];
                capete[0]="Id";
                capete[1]="Nume";
                capete[2]="Adresa";
                Object[][] nou=cost.afisare(cost);
                table=new JTable(nou,capete);
                scrollPane.setViewportView(table);
                table.setFillsViewportHeight(true);
                table.setVisible(true);
                table.setSize(200,200);
                tabelul.setLayout(new BorderLayout());
                tabelul.add(table.getTableHeader(), BorderLayout.PAGE_START);
                tabelul.add(table, BorderLayout.CENTER);
                tabelul.revalidate();
            }
        });
           
    
    adugareProdus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Produse p=new Produse();
            if(numeProdus.getText()!="" && cantitateProdus.getText()!="" &&pretProdus.getText()!="")
            {
            p.setNumeProdus(numeProdus.getText());
            p.setCantitateProdus(Integer.parseInt(cantitateProdus.getText()));
            p.setPretProdus((float)Integer.parseInt(pretProdus.getText()));
            p.getIdProdus();
            }
            int a=p.getIdProdus();
            were.addProduse(p);
            were.serializareProdus();
    }
    });
    afisareProduse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            tabelul.removeAll();
            String[] capete=new String[4];
            capete[0]="Id";
            capete[1]="Nume";
            capete[2]="Cantitate";
            capete[3]="Pret";
            Object[][] nou=were.afisare(were);
            table=new JTable(nou,capete);
            scrollPane.setViewportView(table);
            table.setFillsViewportHeight(true);
            table.setSize(200,200);
            table.setVisible(true);
            tabelul.setLayout(new BorderLayout());
            tabelul.add(table.getTableHeader(), BorderLayout.PAGE_START);
            tabelul.add(table, BorderLayout.CENTER);
            tabelul.revalidate();
            }
    });
    stergereClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(numeClient.getText()!=""){
                cost.deleteClient(numeClient.getText());
               }
            }
    });
    stergereProdus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(IdProdus.getText()!="")
                were.deleteProduse(Integer.parseInt(IdProdus.getText()));
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
