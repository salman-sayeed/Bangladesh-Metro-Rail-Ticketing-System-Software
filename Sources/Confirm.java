package Sources;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Confirm implements ActionListener {
    JFrame ConfirmFrame;
    JButton mainBtn;
    JButton loutBtn; //JButton confirmBtn;
    JLabel paymentS;
    JLabel trxID;
    JLabel eMsg;
    
    public Confirm() {

        ConfirmFrame = new JFrame("Dhaka Mass Transit Company Limited");
        
        mainBtn = new JButton("Main Page"); //confirmBtn = new JButton("Confirm");
        mainBtn.setBounds(400, 600, 100, 30);// confirmBtn.setBounds(410, 560, 80, 30);
        mainBtn.addActionListener(this); // confirmBtn.addActionListener(this);


        loutBtn = new JButton("Logout");
        loutBtn.setBounds(550, 600, 80, 30); 
        loutBtn.addActionListener(this);

        paymentS = new JLabel("Transaction Completed Successfully");
        paymentS.setBounds(380, 380, 300, 30);
        paymentS.setFont(new Font("Arial", Font.BOLD, 16));
        paymentS.setForeground(Color.decode("#FFFFFF"));

        trxID = new JLabel("Transaction number - 7657483920");
        trxID.setBounds(420, 410, 250, 20);
        trxID.setFont(new Font("Arial", Font.BOLD, 12));
        trxID.setForeground(Color.decode("#A7AFB8"));

        eMsg = new JLabel("<html><center>Thank you for your payment.<br/>We are pleased to inform you that<br/>your ticket has been successfully<>processed and emailed to you.</center></html>");
        eMsg.setBounds(420, 450, 350, 100);
        eMsg.setFont(new Font("Arial", Font.BOLD, 13));
        eMsg.setForeground(Color.decode("#6F7C80"));

        ConfirmFrame.add(mainBtn); // BkashFrame.add(confirmBtn);
        ConfirmFrame.add(loutBtn); 
        ConfirmFrame.add(paymentS);
        ConfirmFrame.add(trxID);
        ConfirmFrame.add(eMsg);

        ConfirmFrame.getContentPane().setBackground(new Color(100, 100, 140));
        ConfirmFrame.setSize(1050, 800);
        ConfirmFrame.setLayout(null);
        ConfirmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConfirmFrame.setVisible(true);
        ConfirmFrame.setLocationRelativeTo(null); // Center the JFrame
        ConfirmFrame.setResizable(false);

        try {
            ImageIcon gifIcon = new ImageIcon("Images/success.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(445, 200, gifIcon.getIconWidth(), gifIcon.getIconHeight());
            ConfirmFrame.add(gifLabel);
        } catch (Exception ex) {
            System.out.println("Error loading GIF image: " + ex.getMessage());
        }

        try {
            BufferedImage img = ImageIO.read(new File("Images/paymentsuccess.png"));
            ImageIcon pictureIcon = new ImageIcon(img);
            JLabel pictureLabel = new JLabel(pictureIcon);
            pictureLabel.setBounds(340, 175, img.getWidth(), img.getHeight());
            ConfirmFrame.add(pictureLabel);
        } catch (IOException ex) {
            System.out.println("Error loading picture: " + ex.getMessage());
        }

        try {
            BufferedImage img = ImageIO.read(new File("Images/mainbg.png"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(img));
            backgroundLabel.setBounds(0, 0, ConfirmFrame.getWidth(), ConfirmFrame.getHeight());
            ConfirmFrame.add(backgroundLabel);
        } catch (IOException ex) {
            System.out.println("Error loading background image: " + ex.getMessage());
        }

        // Set icons
        ImageIcon logoIcon = new ImageIcon("Images/logo.png");
        ConfirmFrame.setIconImage(logoIcon.getImage());

    }

    public static void main(String[] args) {
        new Confirm();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainBtn) {
            ConfirmFrame.setVisible(false);
            new MainPagee().User();

        } else if (e.getSource() == loutBtn) {
            ConfirmFrame.setVisible(false);
             new LogIn();
        }
    }

}
