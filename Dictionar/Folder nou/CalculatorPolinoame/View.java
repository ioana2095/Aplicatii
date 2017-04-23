/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorpolinoame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ActionListener{
    private JTextField polinom1  = new JTextField(50);
    private JTextField polinom2  = new JTextField(50);
    private JTextField grad1  = new JTextField(10);
    private JTextField grad2  = new JTextField(10);
    private JTextField valor  = new JTextField(10); 
    private JTextField valor1  = new JTextField(10);
    private JButton adunare = new JButton("ADD");
    private JButton scadere = new JButton("SUB");
    private JButton imultire = new JButton("MULTIPLIY");
    private JButton impartire = new JButton("DIVISION");
    private JButton integrala = new JButton("INTEGRAL");
    private JButton derivata = new JButton("DERIVATIVE");
    private JButton afisare = new JButton("AFIS");
    private JButton valoare = new JButton("Rez_VAL");
    private JTextField rezultat  = new JTextField(50);
    private JTextField rezultat1  = new JTextField(50);
    private JLabel rez  = new JLabel("Rezultatul");
    private JLabel rez1  = new JLabel("Rezultatul");
    private JLabel pol  = new JLabel("Polinom1 (sintaxa: +ax^n +bx^(n-1) +... )");
    private JLabel gr  = new JLabel("Grad Polinom1 (obligatoriu)");
    private JLabel val  = new JLabel("Valoare");
    private JLabel valRez  = new JLabel("Valoare_Rezultat");
    
    
    
  public MonoPolinom parsare(String polinom,int grad)
    {
        
        int i,v=0,j,a=1;
        String c=new String();
        String c1=new String();
        int n=grad;
        polinom=polinom+" ";
        MonoPolinom poli=new MonoPolinom(grad);
        int[] coef1= new int[20];
        for(i=0;i<polinom.length();i++){
            if((polinom.charAt(i)=='+' || polinom.charAt(i)=='-') && i < polinom.length()){
               
                if(polinom.charAt(i)=='-'){
                    while(polinom.charAt(i+1)!='x')
                    {
                        c=c+polinom.charAt(i+1);
                        i++;
                    }
                 a=-1;
                }
                else
                {
                  while(polinom.charAt(i+1)!='x')
                    {
                        c=c+polinom.charAt(i+1);
                        i++;
                    }
                    a=1;  
                }
            } 
            else{
               if(polinom.charAt(i)=='^' && i < polinom.length() ){
                   while(polinom.charAt(i+1)!=' ' )
                    {
                        c1=c1+polinom.charAt(i+1);
                        i++;
                    }
                     v=Integer.parseInt(c1);
                coef1[v]=a*Integer.parseInt(c);
                System.out.print(coef1[v]);
                c=new String();
                c1=new String();
                
               }
               }
            }
        
        
        System.out.println();
        poli=new MonoPolinom(grad,coef1);
        return poli;
        
    }   
   
  
    public View(){
        //JFrame frame=new JFrame("Calculator");
        JPanel Variabile=new JPanel(new GridLayout(0,2,1,1));
        JPanel Butoane=new JPanel(new GridBagLayout());
        JPanel calcPanel=new JPanel(new GridLayout(0,2,1,1));
        
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(700, 400);
        setVisible(true);
         
         Variabile.setBackground(Color.green);
         Butoane.setBackground(Color.green);
         calcPanel.setBackground(Color.green);
         GridBagConstraints gbc=new GridBagConstraints();
         gbc.insets=new Insets(10,10,10,10);
         
         Variabile.add(pol,BorderLayout.BEFORE_FIRST_LINE);
         Variabile.add(polinom1);
         Variabile.add(new JLabel("Polinom2 (sintaxa: +ax^n +bx^(n-1) +... )"),BorderLayout.BEFORE_FIRST_LINE);
         Variabile.add(polinom2);
         Variabile.add(gr,BorderLayout.BEFORE_FIRST_LINE);
         Variabile.add(grad1);
         Variabile.add(new JLabel("Grad Polinom2 (obligatoriu)"),BorderLayout.BEFORE_FIRST_LINE);
         Variabile.add(grad2);
         Variabile.add(val);
         Variabile.add(valor);
         gbc.gridx=0;
         gbc.gridy=0;
         Butoane.add(adunare,gbc);
         gbc.gridx=0;
         gbc.gridy=1;
         Butoane.add(scadere,gbc);
         gbc.gridx=1;
         gbc.gridy=0;
         Butoane.add(imultire,gbc);
         gbc.gridx=1;
         gbc.gridy=1;
         Butoane.add(impartire,gbc);
         gbc.gridx=2;
         gbc.gridy=0;
         Butoane.add(integrala,gbc);
         gbc.gridx=2;
         gbc.gridy=1;
         Butoane.add(derivata,gbc);
         gbc.gridx=3;
         gbc.gridy=0;
         Butoane.add(afisare,gbc);
         gbc.gridx=3;
         gbc.gridy=1;
         Butoane.add(valoare,gbc);
         
          calcPanel.add(rez);
          calcPanel.add(rezultat,BorderLayout.BEFORE_FIRST_LINE);
          calcPanel.add(rez1,BorderLayout.BEFORE_FIRST_LINE);
          calcPanel.add(rezultat1,BorderLayout.BEFORE_FIRST_LINE);
          calcPanel.add(valRez);
          calcPanel.add(valor1);
          this.setLayout(new BorderLayout());
          this.add(calcPanel,BorderLayout.SOUTH);
          this.add(Butoane,BorderLayout.CENTER);
          this.add(Variabile,BorderLayout.NORTH);
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
          
          
         adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                int n1,n2;
                String pol1,pol2;
                String rez=new String();
                String rez1=new String();
                n1=getFirstGrad();
                n2=getSecondGrad();
                pol1=getFirstPolinom();
                pol2=getSecondPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        MonoPolinom p2=new MonoPolinom(n2);
        p2=parsare(pol2,n2);
        OperatiiPolinom adunare=new OperatiiPolinom();
        MonoPolinom pol=adunare.adunare(p1,p2);
        int i=pol.getGrad();
        while(i>=0)
        {
            if(pol.getPolinom()[i]>0){
            rez= " + "+pol.getPolinom()[i] + "x^"+ i+" ";
            rez1=rez1+rez;
            rezultat.setText(rez1);
            i--;
            }
            else
            {
               rez=pol.getPolinom()[i] + "x^"+ i+" ";
               rez1=rez1+rez;
            rezultat.setText(rez1);
                i--;    
            }
        }
            }
         });
       
         
      scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                 int n1,n2;
                String pol1,pol2;
                String rez=new String();
                String rez1=new String();
                
                n1=getFirstGrad();
                n2=getSecondGrad();
                pol1=getFirstPolinom();
                pol2=getSecondPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        MonoPolinom p2=new MonoPolinom(n2);
        p2=parsare(pol2,n2);
        OperatiiPolinom scadere=new OperatiiPolinom();
        MonoPolinom pol_scadere=scadere.scadere(p1, p2);
        int j=pol_scadere.getGrad();
        System.out.println();
        while(j>=0)
        {
            if(pol_scadere.getPolinom()[j]>0){
            rez= " + "+pol_scadere.getPolinom()[j] + "x^"+ j+" ";
            rez1=rez1+rez;
            rezultat.setText(rez1);
            j--;
            }
            else
            {
                rez=pol_scadere.getPolinom()[j] + "x^"+ j+" ";
                rez1=rez1+rez;
                rezultat.setText(rez1);
                j--;    
            }
                          
        }
        
            }
      });
      
      
      imultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                 int n1,n2;
                String pol1,pol2;
                String rez=new String();
                String rez1=new String();
                
                n1=getFirstGrad();
                n2=getSecondGrad();
                pol1=getFirstPolinom();
                pol2=getSecondPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        MonoPolinom p2=new MonoPolinom(n2);
        p2=parsare(pol2,n2);
        OperatiiPolinom impultire=new OperatiiPolinom();
        MonoPolinom pol_impultire=impultire.imultire(p1, p2);
        int k=pol_impultire.getGrad()-1;
        int[] pol_imult= pol_impultire.getPolinom();
        System.out.println();
        while(k>=0)
        {
            if(pol_imult[k]>0){
            rez= " + "+pol_imult[k] + "x^"+ k+" ";
            rez1=rez1+rez;
            rezultat.setText(rez1);
            k--;
            }
            else
            {
                rez=pol_imult[k] + "x^"+ k+" ";
                rez1=rez1+rez;
                rezultat.setText(rez1);
                k--;    
            }
                          
        }
            }
      });
      
      impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                 int n1,n2;
                String pol1,pol2;
                String rez=new String();
                String rez1=new String();
                
                n1=getFirstGrad();
                n2=getSecondGrad();
                pol1=getFirstPolinom();
                pol2=getSecondPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        MonoPolinom p2=new MonoPolinom(n2);
        p2=parsare(pol2,n2);
        OperatiiPolinom impartire=new OperatiiPolinom();
        MonoPolinom pol_impartire=impartire.impartire(p1, p2);
        int k=pol_impartire.getGrad()-1;
        int[] pol_impar= pol_impartire.getPolinom();
        while(k>=0)
        {
            if(pol_impar[k]>0){
            rez= " + "+pol_impar[k] + "x^"+ k+" ";
             rez1=rez1+rez;
             rezultat.setText(rez1);
            k--;
            }
            else
            {
                rez=pol_impar[k] + "x^"+ k+" ";
                rez1=rez1+rez;
                rezultat.setText(rez1);
                k--;    
            }
                          
        }
            }
            
            
      });
         
      
      
      derivata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                 int n1,n2;
                String pol1;
                String rez=new String();
                String rez1=new String();
                n1=getFirstGrad();
                pol1=getFirstPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        OperatiiPolinom derivare =new OperatiiPolinom();
        MonoPolinom pol_derivare=derivare.derivare(p1);
        int k=pol_derivare.getGrad()-1;
        int[] pol_deriv= pol_derivare.getPolinom();
        while(k>=0)
        {
            if(pol_deriv[k]>0){
            rez= " + "+pol_deriv[k] + "x^"+ k+" ";
             rez1=rez1+rez;
             rezultat.setText(rez1);
            k--;
            }
            else
            {
                rez=pol_deriv[k] + "x^"+ k+" ";
                rez1=rez1+rez;
                rezultat.setText(rez1);
                k--;    
            }
                          
        }
            }
      });
      
       afisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int n1,n2;
                String pol1,pol2;
                n1=getFirstGrad();
                n2=getSecondGrad();
                pol1=getFirstPolinom();
                pol2=getSecondPolinom();
                rez1.setVisible(true);
                rezultat1.setVisible(true);
                rezultat.setText(pol1);
                rezultat1.setText(pol2);
                valRez.setVisible(false);
                valor1.setVisible(false);
            }
       });
      integrala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          rez1.setVisible(false);
          rezultat1.setVisible(false);
          valRez.setVisible(false);
          valor1.setVisible(false);
                 int n1;
                String pol1;
                String rez=new String();
                String rez1=new String();
                n1=getFirstGrad();
                pol1=getFirstPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        OperatiiPolinom integrare =new OperatiiPolinom();
        MonoPolinom pol_integrare=integrare.integrare(p1);
        int k=pol_integrare.getGrad()-1;
        int[] pol_integ= pol_integrare.getPolinom();
        int dec=k-2;
        while(k>=0)
        {
            if(pol_integ[k]>0){
            rez= " + "+pol_integ[k] +"/"+pol_integ[k-1]+ "x^"+ dec+" ";
             rez1=rez1+rez;
             rezultat.setText(rez1);
            dec--;
            k=k-2;
            }
            else
            {
                rez=pol_integ[k+1] +"/"+pol_integ[k]+ "x^"+ dec+" ";;
                rez1=rez1+rez;
                rezultat.setText(rez1);
                k=k-2; 
                dec--;
            }
        }
            }
       });
      valoare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            rez1.setVisible(false);
            rezultat1.setVisible(false);
            valRez.setVisible(true);
            valor1.setVisible(true);
            int n1,val;
            val=Integer.parseInt(getValoare());
            String pol1;
            n1=getFirstGrad();
            pol1=getFirstPolinom();
        MonoPolinom p1=new MonoPolinom(n1);
        p1=parsare(pol1,n1);
        OperatiiPolinom valoare =new OperatiiPolinom();
        int V_VAL=valoare.Valoare(p1, val);
        valor1.setText(Integer.toString(V_VAL));
        
            }
      });
    }
     public String getValoare()
    {	         
        return valor.getText();
    }	     
    public String getFirstPolinom()
    {	         
        return polinom1.getText();
    }	     
    public String getSecondPolinom()
    {
	return polinom2.getText();
    }
     public int getFirstGrad()
    {	         
        return Integer.parseInt(grad1.getText());
    }	     
    public int getSecondGrad()
    {
	return Integer.parseInt(grad2.getText());
    }
    
    void displayErrorMessage(String errorMessage)
    {
	JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
