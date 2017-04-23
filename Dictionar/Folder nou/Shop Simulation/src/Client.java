import java.util.Date;

public class Client {
	
   private int idClient;
   private Date timpSosire;
   private int  timpServire;
   
   public Client(int idCl, Date timpSos, int timpServ) { 
	   
       this.idClient = idCl;
       this.timpServire = timpServ;
       this.timpSosire = timpSos;
   }
   
   public int getIdClient() {
       return idClient;
   }
   
   Date getTimpSosire() {
       return timpSosire;
   }
   
   public int getTimpServire() {
       return timpServire;
   }
}