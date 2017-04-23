import java.util.ArrayList;

public class Casa {
	
	 ArrayList <Client> coadaCasa;
		
	public Casa() {
		
		coadaCasa = new ArrayList<Client>();
	}

	public void adaugaClient(Client clientNou) {
	
		coadaCasa.add(clientNou);
	}
	
	public void eliminaClient() {
		
	        if (coadaCasa.isEmpty() == false )
	        	coadaCasa.remove(0);
	}
	
	public boolean coadaGoala() {
	        
		boolean verificare;
	    
		if (coadaCasa.isEmpty() == true)
	            verificare = true;
	    else 
	        	verificare = false;
	        
		return verificare;
	}
	    
	 public int lungimeCoadaClienti() {
	 
		 return coadaCasa.size();
	 }
}