/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ioana
 */
public class Client {
    private int idClient;
    private int timpSosire;
    private int timpServire;
    private JLabel timer;
    private GridBagConstraints gbc=new GridBagConstraints();
    public Client()
    {}
    public Client(int id,int sosire,int servire)
    {
        this.idClient=id;
        this.timpServire=servire;
        this.timpSosire=sosire;
        
    }
    public int getIdClient()
    {
        return this.idClient;
    }
    public int getTimpSosire()
    {
        return this.timpSosire;
    }
    public int getTimpServire()
    {
        return this.timpServire;
    }
    public void setIdClient(int id)
    {
        this.idClient=id;
    }
    public void setTimpServire(int servire)
    {
        this.timpServire=servire;
    }
    public void setTimpSosire(int sosire)
    {
        this.timpSosire=sosire;
    }
    public int esteLaCoada(int acum)
    {
        if(this.getTimpSosire()<acum && (this.getTimpServire()+this.getTimpSosire()>=acum))
            return 1;
        return 0;
    }
    public void showClient(int x,int y,JPanel panel)
    {
        timer = new JLabel("client"+this.getIdClient());
        timer.setBounds(x, y, 50, 50);
	panel.add(timer);
    }
}
