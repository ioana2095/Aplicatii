/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Ioana
 */
public class View implements ActionListener{
private JComboBox nrCozi;
private JFrame nouFrame=new JFrame();
private JLabel nrClienti=new JLabel("Nr de clienti");
private JLabel nCozi=new JLabel("Nr de cozi");
private JLabel minSosire=new JLabel("Minim timp sosoire");
private JLabel maxSosire=new JLabel("Maxim timp sosire");
private JLabel minServire=new JLabel("Minim timp servire");
private JLabel maxServire=new JLabel("Maxim timp servire");
private JTextField nrC=new JTextField(50);
private JTextField minSos=new JTextField(50);
private JTextField maxSos=new JTextField(50);
private JTextField minSer=new JTextField(50);
private JTextField maxSer=new JTextField(50);
private JButton Start=new JButton("Start");
private JButton Stop=new JButton("Stop");
private JPanel cozi;
private JPanel variabile;
private ArrayList<Coada> listaCozi;
private ArrayList<Client> listaClienti;
private Server m = null;
private Point point;
private JFrame nou=new JFrame("Case");
public View()
{
    variabile=new JPanel(new GridLayout(0,2,1,1));
    cozi=new JPanel();
    nouFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    nouFrame.setSize(700,700);
    nouFrame.setVisible(true);
    Object[] sir={1,2,3,4,5,6,7};
    nrCozi=new JComboBox(sir);
     nouFrame.add(variabile,BorderLayout.SOUTH);
    // this.add(cozi,BorderLayout.CENTER);
     variabile.setBackground(Color.yellow);
     cozi.setBackground(Color.blue);
     variabile.add(nrClienti);
     variabile.add(nrC);
     variabile.add(nCozi);
     variabile.add(nrCozi);
     variabile.add(minSosire);
     variabile.add(minSos);
     variabile.add(maxSosire);
     variabile.add(maxSos);
     variabile.add(minServire);
     variabile.add(minSer);
     variabile.add(maxServire);
     variabile.add(maxSer);
     variabile.add(Start);
     variabile.add(Stop);
     nouFrame.revalidate();
     Start.addActionListener(new ActionListener() {
         @Override
        public  void actionPerformed(ActionEvent e) {
            
             Random randomGen = new Random();
             //String text;
             int time = 0;
            int nrClienti = Integer.parseInt(nrC.getText());
	    int tMinServire = Integer.parseInt(minSer.getText());
            int tMaxServire = Integer.parseInt(maxSer.getText());
	    int tMinSosire = Integer.parseInt(minSos.getText());
            int tMaxSosire = Integer.parseInt(maxSos.getText());
            listaCozi = new ArrayList<Coada>();
            for (int i = 0; i <= nrCozi.getSelectedIndex(); i++) {
		Coada coada = new Coada();
		ArrayList<Client> aux = new ArrayList<Client>();
		coada.setCoada(aux);
		listaCozi.add(coada);
            }
            listaClienti = new ArrayList<Client>();
		for (int i = 1; i <= nrClienti; i++) {
		String text = "";
		Client c = new Client();
		c.setTimpServire(randomGen.nextInt(tMaxServire - tMinServire+ 1)+ tMinServire);
		c.setTimpSosire(randomGen.nextInt(tMaxSosire - tMinSosire + 1)+ tMinSosire);
		c.setIdClient(i);
		listaClienti.add(c);
                 text = text + "Clientul " + i + ">  cu timpul de sosire "+ c.getTimpSosire() + ", are timpul de servire "+ c.getTimpServire();
                    System.out.println(text);
            }
              
            try{
                time=listaClienti.get(0).getTimpSosire();
                for(Client c:listaClienti)
                {
                    time+=c.getTimpServire();
                }
            }
            catch(Exception e1)
            {
                e1.getMessage();
            }
            time+=2;
            
            m = new Server(time,listaClienti,listaCozi,nouFrame);
            m.start();
            //nouFrame.revalidate();
            //m.run();
            
        }
     });
    Stop.addActionListener(new ActionListener() {
         @Override
        public  void actionPerformed(ActionEvent e) {
            try {
		m.stop();
		m.join();
                } 
            catch (InterruptedException e1) 
                {
		e1.printStackTrace();
                }
            }
    });
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
