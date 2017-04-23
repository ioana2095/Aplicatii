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
public class MonoPolinom {
   private int grad;
   private int[] polinom=new int[40];
   private int i;
    public MonoPolinom(int grad)
    {
        this.grad=grad;
        this.polinom=new int[grad];
    }
    public MonoPolinom(int grad,int[] pol)
    {
        this.grad=grad;
        for(i=0;i<=grad;i++)       
           polinom[i]=pol[i];
    }
    public int getGrad()
    {
        return this.grad;
    }
    public void setGrad(int grad)
    {
       this.grad=grad;
    }
    public int[] getPolinom()
    {
        return polinom;
    }
    public void setPolinom(int[] pol)
    {
       for(i=0;i<=grad;i++)       
            this.polinom[i]=pol[i];
    }
    
    
}
