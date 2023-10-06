package Sources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp implements ActionListener{
    JFrame signFrame;

JLabel UName;
JLabel UPass;
JLabel ConPass;
JLabel Mobileno;
JLabel Gender;

JButton Confirm;
JButton GoBackToLoginBtn;

JTextField UNameTF;
JPasswordField UPassTF;
JPasswordField ConPassTF;
JTextField Mno;
ButtonGroup bg ;

JRadioButton M;
JRadioButton F;
JRadioButton R;

JCheckBox Accept;

public SignUp(){
  signFrame = new JFrame("Dhaka Mass Transit Company Limited");
  UName = new JLabel("Name");
  UPass = new JLabel("Password");
  Mobileno = new JLabel("Mobile No.");
  Gender = new JLabel("Gender");
  UNameTF = new JTextField(30);
  UPassTF = new JPasswordField(30);
  ConPass = new JLabel("Confirm PassWord");
  ConPassTF = new JPasswordField();
  Mno = new JTextField(11);
  M = new JRadioButton("Male");
  F = new JRadioButton("Female");
  R = new JRadioButton("Rather not say");
  Confirm = new JButton("Signup");
  Accept = new JCheckBox("Do you Agree to the terms and Services?");
  GoBackToLoginBtn = new JButton("Back");

  bg = new ButtonGroup();
  bg.add(M);bg.add(F);bg.add(R);


  UName.setBounds(60, 250, 200, 40);
  UNameTF.setBounds(260, 250, 210, 40);
  UPass.setBounds(60, 300, 210, 40);
  UPassTF.setBounds(260,300,210,40);
  ConPass.setBounds(60, 350, 200, 40);
  ConPassTF.setBounds(260, 350, 210, 40);
  Mobileno.setBounds(60, 400, 200, 40);
  Mno.setBounds(260, 400, 210, 40);
  Gender.setBounds(60, 450, 200, 40);
  M.setBounds(230, 450, 70, 40);
  F.setBounds(310, 450, 80, 40);
  R.setBounds(400, 450, 150, 40);
  Accept.setBounds(60, 500, 300, 40);
  Confirm.setBounds(225, 550, 120, 30);
  GoBackToLoginBtn.setBounds(900, 180, 65, 30);

  signFrame.add(UName);
  signFrame.add(UNameTF);
  signFrame.add(UPass);
  signFrame.add(UPassTF);
  signFrame.add(ConPass);
  signFrame.add(ConPassTF);
  signFrame.add(Mobileno);
  signFrame.add(Mno);
  signFrame.add(Gender);
  signFrame.add(M);
  signFrame.add(F);
  signFrame.add(R);
  signFrame.add(Accept);
  signFrame.add(Confirm);
  signFrame.add(GoBackToLoginBtn);
  GoBackToLoginBtn.addActionListener(this);
  Confirm.addActionListener(this);

  signFrame.setSize(1050,800);
  signFrame.setLayout(null);
  signFrame.setResizable(false);
  signFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  signFrame.setVisible(true);
  signFrame.setLocationRelativeTo(null);

  try 
  {
    BufferedImage img = ImageIO.read(new File("Images/signupbg.png"));
    JLabel backgroundLabel = new JLabel(new ImageIcon(img));
    backgroundLabel.setBounds(0, 0, signFrame.getWidth(), signFrame.getHeight());
  signFrame.add(backgroundLabel);
  } 
  catch (Exception ex) 
  {
    System.out.println("Error loading background image: " + ex.getMessage());
  }
  // Set logo
  signFrame.setIconImage(new ImageIcon("Images/logo.png").getImage());
}

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Confirm) {
        String name = UNameTF.getText();
        String mobile = Mno.getText();
        String password = new String(UPassTF.getPassword());
        String confirmPassword = new String(ConPassTF.getPassword());
    
        if (name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || mobile.isEmpty()) {
          JOptionPane.showMessageDialog(null, "please fill up all the information");
        } else if (mobile.length() != 11) {
          JOptionPane.showMessageDialog(null, "Enter Valid mobile number of 11 digits", "mobile no", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(confirmPassword)) {
          JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (password.length() < 6) {
          JOptionPane.showMessageDialog(null, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          // Save the data in a text file
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(".\\Files\\Info.txt", true))) {
            //writer.newLine();
            writer.write(name+" ");
            writer.write(password+" ");
            writer.write(mobile);
            writer.newLine();
            writer.flush();
            JOptionPane.showMessageDialog(null, "Successfully created a new account", "Success", JOptionPane.INFORMATION_MESSAGE);
            signFrame.dispose(); // dispose the signFrame
            new LogIn(); // call the LogIn() method
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error occurred while creating a new account", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      } else if (e.getSource() == GoBackToLoginBtn) {
        signFrame.dispose(); // dispose the signFrame
        new LogIn(); // calls the LogIn()
      }
    }
  public static void main(String[] args) {
     new SignUp();
  }
}
