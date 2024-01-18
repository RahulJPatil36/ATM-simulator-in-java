package bank.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField,adharnoTextField;
    
    JButton next;
    JRadioButton no1,yes1,no,yes;
    JComboBox category1,category2,category3,category4;
    String formno;
    
     SignupTwo(String formno){
        this.formno=formno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    
        JLabel additionaldetails=new JLabel("Page 2: Additional details:");
        additionaldetails.setFont(new  Font("Raleway",Font.BOLD,38));
        additionaldetails.setBounds(140,20,600,40);
        add(additionaldetails);
        
        JLabel religion=new JLabel("Religion: ");
        religion.setFont(new  Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,90,100,30);
        add(religion);
        
        String religioncategory[]={"Hindu","Sikh","other"};
         category1=new JComboBox(religioncategory);
        category1.setBounds(300,90,400,30);
        category1.setBackground(Color.white);
        add(category1);
                
        JLabel category=new JLabel("Category: ");
        category.setFont(new  Font("Raleway",Font.BOLD,20));
        category.setBounds(100,140,200,30);
        add(category);
        
        String setcategory[]={"obc","sbc","other"};
         category2=new JComboBox(setcategory);
        category2.setBounds(300,140,400,30);
        category2.setBackground(Color.white);
        add(category2);
        
        JLabel educational=new JLabel("Educational");
        educational.setFont(new  Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,190,200,30);
        add(educational);
        
        JLabel details=new JLabel("details:");
        details.setFont(new  Font("Raleway",Font.BOLD,20));
        details.setBounds(100,220,200,30);
        add(details);
        
        String seteducategory[]={"ug","pg","other"};
         category3=new JComboBox(seteducategory);
        category3.setBounds(300,220,400,30);
        category3.setBackground(Color.white);
        add(category3);
        
        JLabel occupation=new JLabel("Occupation: ");
        occupation.setFont(new  Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,290,200,30);
        add(occupation);
        
        String setoccpcategory[]={"farmer","job","other"};
         category4=new JComboBox(setoccpcategory);
        category4.setBounds(300,290,400,30);
        category4.setBackground(Color.white);
        add(category4);
        
        JLabel panno=new JLabel("Pan no: ");
        panno.setFont(new  Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,340,200,30);
        add(panno);
        
         panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,340,400,30);
        add(panTextField);
        
        JLabel adharno=new JLabel("Adhar no:");
        adharno.setFont(new  Font("Raleway",Font.BOLD,20));
        adharno.setBounds(100,390,200,30);
        add(adharno);
        
         adharnoTextField=new JTextField();
        adharnoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharnoTextField.setBounds(300,390,400,30);
        add(adharnoTextField);
        
        JLabel seniorcitizen=new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new  Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,440,200,30);
        add(seniorcitizen);
        
         yes = new JRadioButton("yes");
        yes.setBounds(300,440,120,30);
        yes.setBackground(Color.white);
        add(yes);
        
         no= new JRadioButton("no");
        no.setBounds(450,440,120,30);
        no.setBackground(Color.white);
        add(no);
        
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(yes);
        citizenGroup.add(no);
        
        JLabel existingaccount=new JLabel("Existing account: ");
        existingaccount.setFont(new  Font("Raleway",Font.BOLD,20));
        existingaccount.setBounds(100,490,200,30);
        add(existingaccount);
        
        
         yes1 = new JRadioButton("yes");
        yes1.setBounds(300,490,120,30);
        yes1.setBackground(Color.white);
        add(yes1);
        
         no1= new JRadioButton("no");
        no1.setBounds(450,490,120,30);
        no1.setBackground(Color.white);
        add(no1);
        
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(yes1);
        accountGroup.add(no1);
        
        
         next=new JButton("next");
        next.setBounds(620,540,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new  Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
        
        setSize(800,700);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)category1.getSelectedItem();
        String scategory=(String)category2.getSelectedItem();
        String seducation=(String)category3.getSelectedItem();
        String soccupation=(String)category4.getSelectedItem();
        String span=panTextField.getText();
        String sadhar=adharnoTextField.getText();
        String seniorcitizen =null;
        if(yes.isSelected()){
            seniorcitizen="yes";
            
        }else if(no.isSelected()){
            seniorcitizen="no";
            
        }
        String existinaccount =null;
        if(yes1.isSelected()){
            existinaccount="yes";
            
        }else if(no1.isSelected()){
            existinaccount="no";
            
        }
       
        
         try{
              Conn c=new Conn();
                String query1="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existinaccount+"')";
                c.s.executeUpdate(query1);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
         }
         catch(Exception e)
         {
             System.out.println(e);
         } 
    }

    public static void main(String args[]) {
        new SignupTwo("");

    }
}
