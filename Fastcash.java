package bank.management.system1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener {
    JButton rs100,rs1000,rs500,back,rs10000,rs5000;
    String pinnumber;
    
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);    
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); 
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("select the amount u want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway ",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        rs100=new JButton("Rs 100");
        rs100.setBounds(170,415,150,30); 
        rs100.addActionListener(this);
        image.add(rs100);
        
        rs1000=new JButton("Rs 1000");
        rs1000.setBounds(355,415,150,30); 
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        rs500=new JButton("Rs 5000");
        rs500.setBounds(170,450,150,30); 
        rs500.addActionListener(this);
        image.add(rs500);
        
        rs10000=new JButton("Rs 10000");
        rs10000.setBounds(355,450,150,30); 
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        rs5000=new JButton("Rs 5000");
        rs5000.setBounds(170,485,150,30); 
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        back=new JButton("back");
        back.setBounds(355,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
           
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
                int balance=0;
            while(rs.next())
            {
               if(rs.getString("type").equals("Deposit"))
               {
                   balance+=Integer.parseInt(rs.getString("amount"));}
               else{
                   balance-=Integer.parseInt(rs.getString("amount"));
               }

               }
            if(ae.getSource()!=back &&  balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"insufficient balance");
                return;
                
            }
            Date date=new Date();
            String Q="insert into bank values('"+pinnumber+"' , '"+date+"' , 'withdrawl' , '"+amount+"')";
            c.s.executeUpdate(Q);
            JOptionPane.showMessageDialog(null, "Rs "+amount+"amount debited successfully  ");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
    }
    
    public static void main(String args[]) {
    new Fastcash("");    
    }
}
