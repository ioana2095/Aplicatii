import java.util.Random;
import java.util.Date;
import java.util.Timer;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Lock;

public class Magazin extends Thread {

	private int nrCase;
	static int intSimulare;
	private int timpServMin;
	private int timpServMax;
	private int timpLibMin;
	private int timpLibMax;
	private int pozitie;
	private Timer timer = new Timer();
	
	
	int cElim = 1;
	int cAdd = 0;
	static int nrClienti = 0;
	private Casa[] vectCasa;
	
	public Magazin(int nrCase, int intSimulare, int timpServMin, int timpServMax, int timpLibMin, int timpLibMax, int cAdd) {
		
		vectCasa = new Casa[nrCase];
		this.nrCase = nrCase;
		Magazin.intSimulare = intSimulare;
		this.timpServMax = timpServMax;
		this.timpServMin = timpServMin;
		this.timpLibMax = timpLibMax;
		this.timpLibMin = timpLibMin;
		this.cAdd=  cAdd;
		 
		int i = 0;
		
		while (i< nrCase) {
			vectCasa[i] = new Casa();
			i++;
		}	
	}
	
	public int getNrCase() {
		return nrCase;
	}
	
	public int getIntSim() {
		return intSimulare;
	}
	
	public Casa getVectCasa(int i) {
		return vectCasa[i];
	}
	/*
	public void setInt () {
	
	}
	
	public int getInt() { 
		return
	}*/
		
	public void run() {
		synchronized(timer) {
		int timpPauza; 
		
		while((intSimulare > 0) || (cElim < cAdd)) {
			Random rand1 = new Random();
			timpPauza = rand1.nextInt(timpLibMax - timpLibMin) + timpLibMin;
			//System.out.println("DASSADASDSAD " +cElim+ " " + cAdd);
			
			if (intSimulare > 0 || (cElim < cAdd)) {
				
				for (int i = 0; i< nrCase;i++) { 
					
					Random rand = new Random();
					Casa casaClienti; 
					nrClienti++;
					Client c = new Client(nrClienti, new Date(), rand.nextInt(timpServMax- timpServMin) + timpServMin);
					casaClienti = vectCasa[i];
					
					System.out.println("Am adaugat la casa "+ i + " clientul cu nr "+
										 nrClienti +" la data " + c.getTimpSosire() + " cu timpul de servire " +
										c.getTimpServire()); 
					
					casaClienti.adaugaClient(c);
					try{
						sleep(c.getTimpServire() *1000);
						elimina();
					}
					catch(InterruptedException e) {
						System.out.println(Magazin.class.getName());
					}
					
					
					//elimina();
					timpPauza = rand.nextInt(timpLibMax - timpLibMin) + timpLibMin;
					try { 
						
						sleep(timpPauza * 100);
					}
					
					catch(InterruptedException e) {
						System.out.println(Magazin.class.getName());
					}
				
					Magazin.intSimulare -= timpPauza; }
					
					//elimina();**/
				}elimina();
			/**
			Random rand = new Random();
			Casa casaClienti; 
			nrClienti++;
			Client c = new Client(nrClienti, new Date(), rand.nextInt(timpServMax- timpServMin) + timpServMin);
			casaClienti = vectCasa[minCoada()];
			
			System.out.println("Am adaugat la casa "+ minCoada() + " clientul cu nr "+
								 nrClienti +" la data " + c.getTimpSosire() + " cu timpul de servire " +
								c.getTimpServire()); 
			
			casaClienti.adaugaClient(c);
	
			try{
				sleep(c.getTimpServire() *100);
				elimina();
			}
			catch(InterruptedException e) {
				System.out.println(Magazin.class.getName());
			}
			
			
			//elimina();
			timpPauza = rand.nextInt(timpLibMax - timpLibMin) + timpLibMin;
			try { 
				
				sleep(timpPauza * 10);
			}
			
			catch(InterruptedException e) {
				System.out.println(Magazin.class.getName());
			}
		
			Magazin.intSimulare -= timpPauza; }
			
			//elimina();**/
		}
		}
	}
		
	
	public void elimina() {
		synchronized(timer){
		 Thread t = new Thread(new Runnable() {           
			 public void run() { 
				 int max = 0;
				 int pozitie = 0;
				 int i = 0;
				 for (i = 0; i < nrCase; i++) { 
					 if (vectCasa[i].lungimeCoadaClienti() > max) {
						 max = vectCasa[i].lungimeCoadaClienti();
						 pozitie = i;
					 }
			
				 }
		
				 Casa casaClient = vectCasa[pozitie];
				 if (casaClient.coadaGoala() == false ) {
					 Client c = (casaClient.coadaCasa.get(0));
					/** try {
						 sleep(c.getTimpServire()*100);
					 }
					 catch(InterruptedException e) {
						 System.out.println(Casa.class.getName());
					 }**/
					 
				Magazin.intSimulare -= c.getTimpServire();
				casaClient.eliminaClient();
				cElim++;
				System.out.println("Clientul: " + c.getIdClient() + "pleaca! Ora: " + new Date() );
				}	
	        }
		 });  
	     t.start();}
	}
		
	public int minCoada() {
		
		int min = vectCasa[0].lungimeCoadaClienti();
		pozitie = 0;
		int i = 0;
		for (i = 0; i < nrCase; i++) {
			if (vectCasa[i].lungimeCoadaClienti() < min) {
				min = vectCasa[i].lungimeCoadaClienti();
				pozitie = i;
			}
		}
		return pozitie;	
	}
	
	/**
	public void elimina2() {
        Thread t = new Thread(new Runnable() {           
            public void run() { 
            		
            	//
    			Casa casaClienti = vectCasa[minCoada()];
    			//System.out.println("Min Coada  "+ minCoada());
            	    			
            	if( casaClienti.coadaGoala() == false) {
   	    		 
   	    		Client c = (casaClienti.coadaCasa.get(0));
   	    		 try {
   	    			 
   	    		 sleep(c.getTimpServire()*100);
   	    		 }
   	    		 
   	    		 catch(InterruptedException e) {
   	    			 System.out.println(Casa.class.getName());
   	    		 }
   	    		 
   	    		 Magazin.intSimulare -= c.getTimpServire();
   	    		 casaClienti.eliminaClient();
   	    		 cElim++;
   	    		 System.out.println("Clientul: " + c.getIdClient() + "pleaca! Ora: " + new Date() );
   	        }	
            	 	
            }
        });
        
        t.start();
    }
	**/
	/**
	public int minCoada() {
		int sum = 0;
		int min = 99999 * nrClienti + 1;
		int casaMin = 0;
		Casa casa;
		Client client;
		for(int i = 0; i < nrCase; i++) {
			//min = 9999999;
			sum = 0;
			casa = vectCasa[i];
			for(int j = 0; j < vectCasa[i].lungimeCoadaClienti(); j++) {
				
				if(! casa.coadaCasa.isEmpty()) {
					client = ((Client)(casa.coadaCasa).get(j));
					sum += client.getTimpServire();
				}
			}
			if(min > sum){
				min = sum;
				casaMin = i;
			}
		}
		return casaMin;
	}**/
}
