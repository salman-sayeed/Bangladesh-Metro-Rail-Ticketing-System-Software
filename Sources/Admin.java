package Sources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Admin implements ActionListener{
JFrame AdminFrame;

AdminLog Admins[];
AdminLog a1,a2,a3,a4;

JLabel AdminName;
JLabel AdminPass;

JTextField AdminNameTF;
JTextField AdminPassTF;

JButton B1;
JButton Back;

public Admin(){

a1 = new AdminLog("Abrar","1111");
a2 = new AdminLog("Salman", "2222");
a3 = new AdminLog("Kaiser", "3333");
a4 = new AdminLog("Nahid", "4444");
Admins = new AdminLog[4];
Admins[0]=a1;
Admins[1]=a2;
Admins[2]=a3;
Admins[3]=a4;

    AdminFrame = new JFrame("Admin");
    AdminName = new JLabel("Admin Name ");
    AdminPass = new JLabel("Admin Pass");
    AdminNameTF = new JTextField();
    AdminPassTF = new JPasswordField();
    Back = new JButton("Back");
    B1 = new JButton("Login");

    AdminName.setBounds(115, 370, 100, 40);
    AdminPass.setBounds(115, 420, 100, 40);
    AdminNameTF.setBounds(200, 380, 200, 30);
    AdminPassTF.setBounds(200,430, 200, 30);
    B1.setBounds(175, 500, 70, 30); //login button
    Back.setBounds(275,500,70,30);

    AdminFrame.add(AdminPass);
    AdminFrame.add(AdminName);
    AdminFrame.add(AdminNameTF);
    AdminFrame.add(AdminPassTF);
    AdminFrame.add(Back);
    Back.addActionListener(this);
   AdminFrame.add(B1);
   B1.addActionListener(this);


AdminFrame.setSize(1050,800);
AdminFrame.setLayout(null);
AdminFrame.setResizable(false);
AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
AdminFrame.setVisible(true);
AdminFrame.setLocationRelativeTo(null);

try {
    ImageIcon gifIcon = new ImageIcon("Images/gear.gif");
    JLabel gifLabel1 = new JLabel(gifIcon);
    gifLabel1.setBounds(110, -100, AdminFrame.getWidth(), AdminFrame.getHeight());
    AdminFrame.add(gifLabel1);
} catch (Exception ex) {
    System.out.println("Error loading background image: " + ex.getMessage());
}
try {
    ImageIcon gifIcon = new ImageIcon("Images/salman.gif");
    JLabel gifLabel = new JLabel(gifIcon);
    gifLabel.setBounds(221, 140, AdminFrame.getWidth(), AdminFrame.getHeight());
    AdminFrame.add(gifLabel);
} catch (Exception ex) {
    System.out.println("Error loading background image: " + ex.getMessage());
}
try {
    BufferedImage img = ImageIO.read(new File("Images/adminlogin.png"));
    JLabel backgroundLabel = new JLabel(new ImageIcon(img));
    backgroundLabel.setBounds(0, 0, AdminFrame.getWidth(), AdminFrame.getHeight());
    AdminFrame.add(backgroundLabel);
} catch (Exception ex) {
    System.out.println("Error loading background image: " + ex.getMessage());
}
// Set logo
AdminFrame.setIconImage(new ImageIcon("Images/logo.png").getImage());

}
public void actionPerformed(ActionEvent e){
    if(e.getSource()==B1){int check = 0;
        String name = AdminNameTF.getText();
        String pass = AdminPassTF.getText();
        if(name.isEmpty()==false && pass.isEmpty()==false){
        for(int i=0;i<Admins.length;i++){
        if(Admins[i] != null) {if(name.equals(Admins[i].getU_name()) && pass.equals(Admins[i].getU_pass())){check =1;JOptionPane.showMessageDialog(null,"Login Successful");break;}else{JOptionPane.showMessageDialog(null,"Admin Name/Pass does not match");}}
        else{JOptionPane.showMessageDialog ( null,"Please fill all the information");}
        }
        }
    if(check==1){
        new MainPagee().Admin();
        AdminFrame.setVisible(false);}
    }
else if(e.getSource()==Back){
    AdminFrame.setVisible(false);
    new LogIn();
}
}


public static void main(String[] args) {
    new Admin();
}
}