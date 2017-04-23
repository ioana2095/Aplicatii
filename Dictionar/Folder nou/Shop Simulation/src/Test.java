import javax.swing.UIManager;

public class Test {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
				
		InterfataGrafica intGraf = new InterfataGrafica();
		intGraf.setSize(1224,560);
		intGraf.setVisible(true);
		
		//Magazin magazin = new Magazin(5, 50, 2, 8, 3, 5, 10);
		//magazin.start();
		
    }
}
