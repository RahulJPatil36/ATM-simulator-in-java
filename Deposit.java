package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Deposit extends JFrame implements ActionListener{
     
    JButton back,deposit;
     String pinnumber;
     JTextField pin;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        System.out.println(pinnumber);
        setLayout(null);    
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("select the amount u want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway ",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        pin=new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(180,340, 300,25);
        image.add(pin);
        
        deposit=new JButton("deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Date date=new Date();
        try{
        
        if(ae.getSource()==deposit)
        {
            String amount = pin.getText();
             if(pin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
             else{
                  Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
             }
        }
        else  if(ae.getSource()==back)
        {
            new Transactions(pinnumber).setVisible(true);
        }
        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) {
        new Deposit("");
        
    }
}
