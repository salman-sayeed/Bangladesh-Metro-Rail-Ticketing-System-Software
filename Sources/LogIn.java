package Sources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogIn extends Frame implements ActionListener{
JFrame Login;
JButton LoginBtn;
JButton SignupBtn;
JButton ForgorPass;
JButton AdminPanelBtn;
JLabel UPass;
JLabel UName ;
JTextField UNameTF;
JPasswordField UPassTF;



public LogIn()
{
  Login = new JFrame("Dhaka Mass Transit Company Limited");
  UName = new JLabel("Username ");
  UPass = new JLabel("Password ");
  UNameTF = new JTextField();
  UPassTF = new JPasswordField(); 
  LoginBtn = new JButton("Log In");
  SignupBtn = new JButton("Sign Up");
  ForgorPass = new JButton("Forgot Password?");
  AdminPanelBtn = new JButton("Admin Panel");


  UName.setBounds(40,245,150,30);
  UName.setFont(new Font("Arial", Font.BOLD, 16));
  UPass.setBounds(40, 295, 150, 40);
  UPass.setFont(new Font("Arial", Font.BOLD, 16)); 
  UNameTF.setBounds(160, 249, 180, 30);
  UPassTF.setBounds(160,299,180,30);
  LoginBtn.setBounds(100,370,90,30);
  SignupBtn.setBounds(200,370,90,30);
  ForgorPass.setBounds(120,430,150,30);
  AdminPanelBtn.setBounds(50,720,110,25);

  Login.add(UName);
  Login.add(UPass);
  Login.add(UNameTF);
  Login.add(UPassTF);
  Login.add(LoginBtn);
  Login.add(SignupBtn);
  Login.add(ForgorPass);
  SignupBtn.addActionListener(this);
  ForgorPass.addActionListener(this);
  LoginBtn.addActionListener(this);
  Login.add(AdminPanelBtn);
  AdminPanelBtn.addActionListener(this);


  Login.getContentPane().setBackground(new Color(100, 100, 140));

  Login.setSize(1050,800);
  Login.setLayout(null);
  Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Login.setVisible(true);
  Login.setLocationRelativeTo(null);
  Login.setResizable(false);

  try {
            BufferedImage img = ImageIO.read(new File("Images/mainbg.png"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(img));
            backgroundLabel.setBounds(0, 0, Login.getWidth(), Login.getHeight());
            Login.add(backgroundLabel);
        } catch (Exception ex) {
            System.out.println("Error loading background image: " + ex.getMessage());
        }
        // Set logo
        Login.setIconImage(new ImageIcon("Images/logo.png").getImage());
}

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==SignupBtn)
    {Login.setVisible(false);
    new SignUp();}
    else if(e.getSource()==ForgorPass)
    {String recoveryNumber = JOptionPane.showInputDialog(null, "PLease enter your registered phone number ","recovery phone no",JOptionPane.OK_CANCEL_OPTION);
    if(recoveryNumber==null){JOptionPane.showMessageDialog(null,"Phone number not added");}
    else{JOptionPane.showMessageDialog(null, "Password recovery link sent to your phone."+recoveryNumber);}
    }
    else if (e.getSource() == LoginBtn) {
      String name = UNameTF.getText();
      String pass = new String(UPassTF.getPassword());
      boolean matched = false;
      try {
          FileReader fr = new FileReader(".\\Files\\Info.txt");
          BufferedReader br = new BufferedReader(fr);
          String line;
          while ((line = br.readLine()) != null) {
              String[] words = line.split(" ");
              String check_name = words[0];
              String check_pass = words[1];
              if (name.equals(check_name) && pass.equals(check_pass)) {
                  matched = true;
                  break;
              }
          }
          fr.close();
      } catch (Exception ae) {
      }
      if (matched) {
          JOptionPane.showMessageDialog(null, "login successful");
          Login.setVisible(false);
          new MainPagee().User();
      } else {
          JOptionPane.showMessageDialog(null, "invalid username or password");
      }
    }
  
    else if(e.getSource()==AdminPanelBtn)
    {
    Login.setVisible(false);
    new Admin();
    }
}
public static void main(String[] args) {
    new LogIn();
}
}