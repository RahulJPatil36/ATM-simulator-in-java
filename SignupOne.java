package bank.management.system1;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton married,male,female,unmarried;
    JDateChooser dateChooser;
    JButton next;
        
    SignupOne(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%900L)+1000L  );
        
        JLabel formno=new JLabel("Application form no: "+random);
        formno.setFont(new  Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        
        JLabel personalDetails=new JLabel("page 1: personal details");
        personalDetails.setFont(new  Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("name: ");
        name.setFont(new  Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
                
        JLabel fname=new JLabel("father's name: ");
        fname.setFont(new  Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of birth: ");
        dob.setFont(new  Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new  Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
         male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
         female= new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email=new JLabel("Email: ");
        email.setFont(new  Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital=new JLabel("mariatal status: ");
        marital.setFont(new  Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
         married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.white);
        add(married);
        
         unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new  Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
         addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City: ");
        city.setFont(new  Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel State=new JLabel("State: ");
        State.setFont(new  Font("Raleway",Font.BOLD,20));
        State.setBounds(100,540,200,30);
        add(State);
        
         stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pincode: ");
        pincode.setFont(new  Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
         pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
         next=new JButton("next");
        next.setBounds(620,660,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new  Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender =null;
        if(male.isSelected()){
            gender="male";
            
        }else if(female.isSelected()){
            gender="female";
            
        }
        
        String email=emailTextField.getText();
        String marital =null;
        if(married.isSelected()){
            marital="married";
            
        }else if(unmarried.isSelected()){
            gender="unmarried";
            
        }
        
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "name is required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                new SignupTwo(formno).setVisible(true);
                setVisible(false);
            }
                
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupOne();
        
    }
}
