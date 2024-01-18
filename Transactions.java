package bank.management.system1;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    String pinnumber;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        System.out.println(pinnumber);
        setLayout(null);    
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your transaction:");
        text.setForeground(Color.white);
        text.setBounds(215,300,700,35);
        text.setFont(new Font("Raleway ",Font.BOLD,16));
        image.add(text);
        
        
        deposit=new JButton("deposit");
        deposit.setBounds(170,415,150,30); 
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30); 
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("fast cash");
        fastcash.setBounds(170,450,150,30); 
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("mini statement");
        ministatement.setBounds(355,450,150,30); 
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("pin change");
        pinchange.setBounds(170,485,150,30); 
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("balance enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("exit");
        exit.setBounds(355,520,150,30); 
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            System.out.println(pinnumber);
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            System.out.println(pinnumber);
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
             setVisible(false);
             new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
             setVisible(false);
             new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry)
        {
             setVisible(false);
             new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
             new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        new Transactions("");
        
    }
}
