
package bank.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

public class Login extends JFrame implements ActionListener{
    
    JButton Login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login() {
        
        setLayout(null);    
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); 
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
       
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add (text);
        
        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add (cardno);
        
        cardTextField =new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);
        
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220 ,250,30);
        add (pin);
        
        pinTextField =new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);
        
        Login=new JButton("sign in");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        clear=new JButton("clear");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("signup");
        signup.setBounds(375, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("automated teller machine");
        setSize(800,480);   
        setVisible(true);
        
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
             Conn conn=new Conn();
            if(ae.getSource()== clear)
            {
               cardTextField.setText("");
               pinTextField.setText("");
            }else if(ae.getSource()== signup)
            {
                setVisible(false);
                new SignupOne().setVisible(true);
            }else if(ae.getSource()== Login)
            {
                
                String cardnumber=cardTextField.getText();
                String pinnumber=pinTextField.getText();
                String query="select *from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
                try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "incorrect card number  or pin number");
                }
             }catch(Exception e)
             {
                System.out.println(e);
             }
             }
            
}
        
    public static void main(String args[]) {
        new Login();
    }
}
