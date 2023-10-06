package Sources;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Payment implements ActionListener {
    JFrame PaymentFrame;
    JButton bkashBtn;
    JButton nagadBtn;
    JButton backBtn;

    public Payment() {
        PaymentFrame = new JFrame("Dhaka Mass Transit Company Limited");

        JLabel paymentLabel = new JLabel("Payment Options");
        paymentLabel.setBounds(450, 200, 250, 30);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 20));
        paymentLabel.setForeground(Color.WHITE);

        bkashBtn = new JButton(new ImageIcon("Images/obonoti.png"));
        bkashBtn.setBounds(150, 300, 300, 150);
        bkashBtn.addActionListener(this);

        nagadBtn = new JButton(new ImageIcon("Images/Baki.png"));
        nagadBtn.setBounds(550, 300, 300, 150);
        nagadBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(900, 160, 70, 30);
        backBtn.addActionListener(this);

        PaymentFrame.add(paymentLabel);
        PaymentFrame.add(bkashBtn);
        PaymentFrame.add(nagadBtn);
        PaymentFrame.add(backBtn);

        PaymentFrame.getContentPane().setBackground(new Color(100, 100, 140));
        PaymentFrame.setSize(1050, 800);
        PaymentFrame.setLayout(null);
        PaymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaymentFrame.setVisible(true);
        PaymentFrame.setLocationRelativeTo(null); // Center the JFrame
        PaymentFrame.setResizable(false);

        try {
            BufferedImage img = ImageIO.read(new File("Images/paymentbg.png"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(img));
            backgroundLabel.setBounds(0, 0, PaymentFrame.getWidth(), PaymentFrame.getHeight());
            PaymentFrame.add(backgroundLabel);
        } catch (Exception ex) {
            System.out.println("Error loading background image: " + ex.getMessage());
        }

        // Set logo
        PaymentFrame.setIconImage(new ImageIcon("Images/logo.png").getImage());

    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bkashBtn) {
            PaymentFrame.setVisible(false);
             new Bkash();
        } else if (e.getSource() == nagadBtn) {
            PaymentFrame.setVisible(false);
             new Nagad();
        } else if(e.getSource()== backBtn){
            PaymentFrame.setVisible(false);
            new MainPagee().User();
        }
    }
    public static void main(String[] args) {
        new Payment();
    }

}
