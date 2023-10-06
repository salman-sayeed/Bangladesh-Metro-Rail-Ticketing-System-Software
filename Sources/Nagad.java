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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Nagad implements ActionListener {
    JFrame NagadFrame;
    JButton confirmBtn;
    JButton backBtn;
    JLabel phoneNo;
    JLabel pinNo;
    JTextField tPhoneno;
    JPasswordField tPinNo;

    public Nagad() {

        NagadFrame = new JFrame("Dhaka Mass Transit Company Limited");

        JLabel paymentLabel = new JLabel("by clicking 'Confirm' you agree to the terms & conditions");
        paymentLabel.setBounds(360, 500,300, 30);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 10));
        paymentLabel.setForeground(new Color(240, 240, 240));

        phoneNo = new JLabel("Phone Number");
        phoneNo.setBounds(360, 390, 90, 30);
        phoneNo.setForeground(Color.WHITE);

        pinNo = new JLabel("PIN");
        pinNo.setBounds(380, 450, 90, 30);
        pinNo.setForeground(Color.WHITE);

        tPhoneno = new JTextField();
        tPhoneno.setBounds(480, 390, 150, 30);

        tPinNo = new JPasswordField();
        tPinNo.setBounds(480, 450, 150, 30);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(410, 560, 80, 30);
        confirmBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(510, 560, 80, 30);
        backBtn.addActionListener(this);

        NagadFrame.add(paymentLabel);
        NagadFrame.add(confirmBtn);
        NagadFrame.add(backBtn);
        NagadFrame.add(pinNo);
        NagadFrame.add(phoneNo);
        NagadFrame.add(tPhoneno);
        NagadFrame.add(tPinNo);

        NagadFrame.getContentPane().setBackground(new Color(100, 100, 140));
        NagadFrame.setSize(1050, 800);
        NagadFrame.setLayout(null);
        NagadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NagadFrame.setVisible(true);
        NagadFrame.setLocationRelativeTo(null); // Center the JFrame
        NagadFrame.setResizable(false);

        try {
            BufferedImage img = ImageIO.read(new File("Images/Nagadbg.png"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(img));
            backgroundLabel.setBounds(0, 0, NagadFrame.getWidth(), NagadFrame.getHeight());
            NagadFrame.add(backgroundLabel);
        } catch (IOException ex) {
            System.out.println("Error loading background image: " + ex.getMessage());
        }

        // Set icons
        ImageIcon logoIcon = new ImageIcon("Images/logo.png");
        NagadFrame.setIconImage(logoIcon.getImage());
        }   

    public static void main(String[] args) {
        new Nagad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmBtn) {
            String phoneNumber = tPhoneno.getText();
            String pin = new String(tPinNo.getPassword());
            
            if (phoneNumber.length() != 11) {
                JOptionPane.showMessageDialog(NagadFrame, "Phone number must be 11 digits.");
            } else if (pin.length() != 5) {
                JOptionPane.showMessageDialog(NagadFrame, "Pin number must be 5 characters.");
            } else {
                JOptionPane.showMessageDialog(NagadFrame, "Payment successful");
                NagadFrame.setVisible(false);
                new Confirm();
            }
        } else if (e.getSource() == backBtn) {
            NagadFrame.setVisible(false);
            new Payment();
        }
    }
}
