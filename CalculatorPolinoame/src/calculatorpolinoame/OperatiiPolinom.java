/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorpolinoame;

/**
 *
 * @author Ioana
 */
public class OperatiiPolinom {

    
    public MonoPolinom adunare(MonoPolinom p1,MonoPolinom p2)
    {
        int i,j;
        int[] pol1=p1.getPolinom();
        int[] pol2=p2.getPolinom();
       for(i=p1.getGrad();i>=0;i--)
           for(j=p2.getGrad();j>=0;j--)
               if(i==j)
                   pol1[i]=pol1[i]+pol2[j];  
     
       return p1;
       
    }
     public MonoPolinom scadere(MonoPolinom p1,MonoPolinom p2)
    {
        int i,j;
        int[] pol1=p1.getPolinom();
        int[] pol2=p2.getPolinom();
        
       for(i=p1.getGrad();i>=0;i--){
           for(j=p2.getGrad();j>=0;j--){
               if(i==j)
                   pol1[i]=pol1[i]-pol2[j];  
           }
       }
       return p1;
       
    }
      public MonoPolinom imultire(MonoPolinom p1,MonoPolinom p2)
    {
        int i,j,k;
        int[] pol1=p1.getPolinom();
        int[] pol2=p2.getPolinom();
        int a=p1.getGrad()+p2.getGrad()+1;
        MonoPolinom rez=new MonoPolinom(a);
        int[] rez1=rez.getPolinom();
        for(i=0;i<rez.getGrad();i++){
            for(j=0;j<=p1.getGrad();j++){
                for(k=0;k<=p2.getGrad();k++){
                    if(i==j+k){
                        rez1[i]=rez1[i]+(pol1[j]*pol2[k]);
                        
                    }
                }
            }
        }
           return rez;    
    }
    
       public MonoPolinom impartire(MonoPolinom p1,MonoPolinom p2)
    {
        MonoPolinom impartitor;
	MonoPolinom rest;
        MonoPolinom cat;
        int[]rest1;
        int[]cat1;
        int[]imparti;
		if (p1.getGrad() > p2.getGrad()) {
		 rest = new MonoPolinom(p1.getGrad()+1);
		 impartitor = new MonoPolinom(p2.getGrad()+1);
		 cat = new MonoPolinom(p1.getGrad() - p2.getGrad()+1);	
                 rest1=rest.getPolinom();
                 cat1=cat.getPolinom();
                 imparti=impartitor.getPolinom();
		
		int c, r;
		int i=0;
		while(i < p1.getGrad()+1) {
			rest.getPolinom()[i]= p1.getPolinom()[i];
			i++;
		}
		
		i=0;
		while(i < p2.getGrad()+1) {
			impartitor.getPolinom()[i]= p2.getPolinom()[i];
			i++;
		}
		i=0;
		while(i < p1.getGrad() - p2.getGrad()) {
			cat.getPolinom()[i]=1;
			i++;
		}
                if(rest.getGrad()>0 && rest.getGrad()>impartitor.getGrad())
                {
                    int a=rest1[rest.getGrad()-1];
                    int b=imparti[impartitor.getGrad()-1];
                    int coef=a/b;
                    cat1[rest.getGrad()-impartitor.getGrad()]=(int)coef;
                int j=0;
                while(j<p2.getGrad()+1)
                {
                    c=coef*imparti[impartitor.getGrad()-j-1];
                    r=rest1[rest.getGrad()-j-1]-c;
                    rest1[rest.getGrad()-j-1]=r;
                    j++;
                }
                if( (rest.getGrad() >= 0) && (rest.getPolinom()[rest.getGrad() -1] == 0) ){
			rest.setGrad(rest.getGrad() -1);
                
                }
                }

				
		}
				
		else {
                        
                     rest=new MonoPolinom(p1.getGrad()) ;
                     cat=new MonoPolinom(1);;
                    rest1=rest.getPolinom();
                    cat1=cat.getPolinom();
		
			int i = 0;
			
			while (i < p1.getGrad()) {
				rest1[i]= p1.getPolinom()[i];
				i++;
			}	
			cat1[0]=0;
				
                }
  		return cat;
    }
       public MonoPolinom derivare(MonoPolinom p1) {
           
		int[] pol =  p1.getPolinom();
                int i ;
		if (p1.getGrad() > 0) {
			i=0;
			while (i < p1.getGrad() ) {
				pol[i] = pol[i+1] * (i+1);
				p1.getPolinom()[i]=pol[i];
				i++;
			}
			
			return p1;	
		}
		
		else {
			
			p1.getPolinom()[0]=1;
			
			return p1;	
		}
		
	}
       public MonoPolinom integrare(MonoPolinom p1) {
		
		MonoPolinom rez  = new MonoPolinom(2*p1.getGrad()+2);
                int i=0;
                while (i < p1.getGrad()+1) {
			rez.getPolinom()[i]= p1.getPolinom()[i];
			i++;
		}
                int[] rez1=rez.getPolinom();
		int j=0;
                i=0;
		int v=0;
                j=i;
		while (i < p1.getGrad()+1){
			if ( i == 0) 
                            rez1[j]=0;
                             v=p1.getPolinom()[i];
                            rez1[j+1]=v;
                            rez1[j]=i+1;
                            j=j+2;
                            i++;
                }
                return rez;
	}
       public int Valoare(MonoPolinom p1,int val) {
		
           int i,j,vVal=val;
           int[]pol=p1.getPolinom();
           for(i=0;i<p1.getGrad();i++){
               for(j=0;j<i;j++)
               {
                 vVal*=val;  
               }
             pol[i]=pol[i]*vVal;
           }
           vVal=0;
           for(i=0;i<p1.getGrad();i++)
               vVal+=pol[i];
            
         return vVal;
	}
}
