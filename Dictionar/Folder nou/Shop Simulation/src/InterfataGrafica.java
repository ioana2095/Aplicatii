import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InterfataGrafica extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JTextField tTimpSim,tTimpLibMax,tTimpLibMin,tTimpMin, tTimpMax,tNrClienti;
	private JTextArea afisConsola;
	private JLabel lTimpSim,lTimpLibMax,lTimpLibMin,lTimpMin, lTimpMax, lNrClienti;
	private JButton start, stop;
	
	public InterfataGrafica() {
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.white);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(5,10,5,10);
		
		lTimpSim= new JLabel("Timp Simulare : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(lTimpSim, constraint);
		
		lTimpLibMin= new JLabel("Timp Liber Casa Min : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 1;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		panel.add(lTimpLibMin, constraint);
		
		lTimpLibMax= new JLabel("Timp Liber Casa Max : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 2;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(lTimpLibMax, constraint);
		
		lTimpMin= new JLabel("Timp Min Servire : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 3;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(lTimpMin, constraint);
		
		lTimpMax= new JLabel("Timp Max Servire : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 4;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(lTimpMax, constraint);
		
		lNrClienti = new JLabel("Numar Clienti : ");
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 5;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(lNrClienti, constraint);
		
		tTimpSim = new JTextField();
		tTimpSim.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tTimpSim, constraint);
		
		tTimpLibMin = new JTextField();
		tTimpLibMin.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 1;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tTimpLibMin, constraint);
		
		tTimpLibMax = new JTextField();
		tTimpLibMax.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 2;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tTimpLibMax, constraint);
		
		tTimpMin = new JTextField();
		tTimpMin.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 3;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tTimpMin, constraint);
		
		tTimpMax = new JTextField();
		tTimpMax.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 4;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tTimpMax, constraint);
		
		tNrClienti = new JTextField();
		tNrClienti.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 5;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(tNrClienti, constraint);
		
		start = new JButton("Start");
		start.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 6;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		panel.add(start, constraint);
		
		stop = new JButton("Stop");
		stop.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 6;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		panel.add(stop, constraint);
		
		afisConsola = new JTextArea(20,50);
		afisConsola.setEditable(false);
	//	afisConsola.addActionListener(new Handler() );
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 0.1;
		constraint.weighty = 0.1;
		constraint.gridx = 4;
		constraint.gridy = 3;
		constraint.gridwidth = 3;
		JScrollPane scrollAfisConsola = new JScrollPane(afisConsola);
		panel.add(scrollAfisConsola, constraint);
		this.add(panel);
	}
	
	public class Handler implements ActionListener{
		
		private int timpMin, timpMax, timpSim, timpLibMin, timpLibMax;
		private int nrCoziMaxime = 3;
		private int nrClientiMaxim;
		//PrintStream printStream = new PrintStream(afisConsola);
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == start) {
				timpMin = Integer.parseInt(tTimpMin.getText());
				timpMin = Integer.parseInt(tTimpMin.getText());
				timpMax = Integer.parseInt(tTimpMax.getText());
				timpLibMin = Integer.parseInt(tTimpLibMin.getText());
				timpLibMax = Integer.parseInt(tTimpLibMax.getText());
				nrClientiMaxim = Integer.parseInt(tNrClienti.getText());
				timpSim = Integer.parseInt(tTimpSim.getText());

				Magazin magazin = new Magazin(nrCoziMaxime, timpSim, timpMin, timpMax, timpLibMin, timpLibMax, nrClientiMaxim);
				magazin.start();
				//System.out.println("Test:" +nrCoziMaxime +"m" + timpSim +"m" + timpMin +"m"+ timpMax +"m"+ timpLibMin +"m"+ timpLibMax +"m"+ nrClientiMaxim);
				
			}
			
			if(e.getSource() == stop) {
				System.exit(1);
			}
		}
	}
}
