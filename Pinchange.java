package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    
    Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280, 500,35);
        image.add(text);
        
        
        JLabel pintext=new JLabel("eneter PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,340, 180,25);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,340, 180,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-eneter PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,390, 180,25);
        image.add(repintext);
        
         repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,390, 180,25);
        image.add(repin);
        
         change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
         back=new JButton("BACK");
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
        if(ae.getSource()==change){
            try{
                String npin=pin.getText();
                String rpin= repin.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW PIN");
                    return; 
                }
                
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"PLEASE RE-ENETER NEW PIN");
                    return;
                }
                Conn conn=new Conn();
                String q1=  "update bank set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String q2=  "update login set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String q3=  "update signupthree set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"'";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
             
    }
    }
    
    public static void main(String args[]) {
        
        new Pinchange("");

    }
}
