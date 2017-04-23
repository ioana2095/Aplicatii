/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionar;
import java.util.regex.Pattern;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
public class View extends JFrame implements ActionListener,ItemListener{
    private JTextField cuvant  = new JTextField(50);
    private JTextField sinonim1  = new JTextField(50); 
    private JTextField sinonim2  = new JTextField(50);
    private JButton adaugareCuvant = new JButton("Adaugare Cuvant");
    private JButton afisare = new JButton("Afisare");
    private JButton adugareSinonim= new JButton("Adaugare Sinonim");
    private JButton stergereCuvant = new JButton("Stergere Cuvant");
    private JLabel  Cuvant  = new JLabel("Cuvant");
    private JLabel Sinonim1  = new JLabel("Sinonim1");
    private JLabel Sinonim2  = new JLabel("Sinomim2");
    private JTextArea cuvinte=new JTextArea();
    
    public View(Dictionar dictionar)
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
	this.setSize(500, 500);
        setVisible(true);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        variabile.add(Cuvant);
        variabile.add(cuvant);
        variabile.add(Sinonim1);
        variabile.add(sinonim1);
        variabile.add(Sinonim2);
        variabile.add(sinonim2);
        gbc.gridx=0;
        gbc.gridy=0;
        butoane.add(adaugareCuvant,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        butoane.add(afisare,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        butoane.add(adugareSinonim,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        butoane.add(stergereCuvant,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        tabelul.add(cuvinte);
        this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
                           
                                dictionar.punereFisier();
                            
                                
			}
		});
        stergereCuvant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Word b=new Word();
                if(cuvant.getText()!="")
                {
                    b.setWord(cuvant.getText());
                    dictionar.deleteWord(b);
                }
                }
        });
        adugareSinonim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Word a=new Word();
                Word b=new Word();
                if(cuvant.getText()!="" && sinonim1.getText()!="")
                {
                    a.setWord(cuvant.getText());
                    b.setWord(sinonim1.getText());
                    try {
                        dictionar.defineWord(a, b);
                    } catch (IOException ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                }
        });
        adaugareCuvant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Word> w=new ArrayList<Word>();
                Word cuv=new Word();
                Word a=new Word();
                Word b=new Word();
                if(cuvant.getText()!="" && sinonim1.getText()!="" && sinonim2.getText()!="")
                {
                    cuv.setWord(cuvant.getText());
                    a.setWord(sinonim1.getText());
                    b.setWord(sinonim2.getText());
                    w.add(a);
                    w.add(b);
                    dictionar.addWord(cuv, w);
                }
                }
        });
      afisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              cuvinte.removeAll();
              Word cuv=new Word();
              String a=new String();
              String a2=new String();
              //Matcher m=null;
              if(cuvant.getText()!="")
              {
                  cuv.setWord(cuvant.getText());
                  a2=cuvant.getText();
                  for(int i=0;i<a2.length();i++){
                      if(a2.charAt(i)=='*'){
                        a2=a2.replace("*", ".*");
                        //break;
                        i=i+1;
                      }
                  }
                  for(int i=0;i<a2.length();i++){
                      if(a2.charAt(i)=='?'){
                        a2=a2.replace('?', '.');
                        break;
                      }
                  }
                  for(Word patt:dictionar.getDictionar().keySet()){  
                  if(Pattern.matches(a2, patt.getWord()))
                {
                    a=a+patt.getWord()+"-  ";
                  if(dictionar.listWord(patt)!=null)
                 {
                  ArrayList<Word> cuv1=new ArrayList<Word>();
                  cuv1=dictionar.listWord(patt);
                  for(int i=0;i<cuv1.size();i++)
                  {
                     a=a+cuv1.get(i).getWord()+" ";
                  }
                  cuvinte.setText(a);
                 }
                   a=a+"\n";
                }  
                  }
              }
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
