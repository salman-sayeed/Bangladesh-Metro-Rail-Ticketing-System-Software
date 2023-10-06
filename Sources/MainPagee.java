package Sources;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//mainpage
public class MainPagee implements ActionListener{
   JFrame F1;
   JPanel AdminP;
   JPanel MainP;
   JPanel UserP;
   JPanel seats;
   JTextField Tid;
   JTextField Tfrom;
   JTextField Tto;
   JTextField TDepTime;
   JTextField TTPrice;
   JTextArea DisplaySeat;
   JTextArea DisplayFromLocation;
   JTextArea DisplayToLocation;
   JTextArea DisplayFare;
   JTextArea DisplaySeatNum;
   JTextArea DisplayDiscount;
   JLabel id;
   JLabel from;
   JLabel to;
   JLabel depTime;
   JLabel Start,Reach;
   JLabel TPrice;
   JLabel StudentDis;
   JButton AddBtn;
   JButton DeleteBtn;
   JButton Back;
   JButton Fare;
   JButton Clear;
   DefaultTableModel trains;
   JTable table;
   ArrayList<String> Locations;
   JComboBox<String> FromLocations;
   JComboBox <String> ToLocations;
   JCheckBox a1,b1,c1,d1,e1,f1,g1,h1,i1,j1,a2,b2,c2,d2,e2,f2,g2,h2,i2,j2;
   JButton Confirm;
   JButton ResetSeat;
   JButton StuVerify;
   JButton Payment;
   int numCheckBoxes = 0;
   int P ;
    int M11;
    int KP;
    int SP;
    int AG;
    int BS;
    int FG;
    int studentCheck = 0;
    String selectedValue;

   public MainPagee(){
    
F1= new JFrame("Operation page");
AddBtn = new JButton("Add Train");
DeleteBtn = new JButton("Delete Train");
Back = new JButton("Back");
Tid = new JTextField();
Tfrom = new JTextField();
depTime = new JLabel("Set Departure Time");
Tto = new JTextField();
TDepTime = new JTextField();
id = new JLabel("Set Train ID");
from = new JLabel("From Location");
to = new JLabel("To Location");
FromLocations = new JComboBox<>();
ToLocations = new JComboBox<>();
Start = new JLabel("Select your Station");
Reach = new JLabel("Select where you want to go");
seats = new JPanel();
a1 = new JCheckBox("a1");
b1 = new JCheckBox("b1");
c1 = new JCheckBox("c1");
d1 = new JCheckBox("d1");
e1 = new JCheckBox("e1");
f1 = new JCheckBox("f1");
g1 = new JCheckBox("g1");
h1 = new JCheckBox("h1");
i1 = new JCheckBox("i1");
j1 = new JCheckBox("j1");
a2 = new JCheckBox("a2");
b2 = new JCheckBox("b2");
c2 = new JCheckBox("c2");
d2 = new JCheckBox("d2");
e2 = new JCheckBox("e2");
f2 = new JCheckBox("f2");
g2 = new JCheckBox("g2");
h2 = new JCheckBox("h2");
i2 = new JCheckBox("i2");
j2 = new JCheckBox("j2");

Confirm = new JButton("Confirm");
DisplaySeat = new JTextArea();
DisplayFromLocation = new JTextArea();
DisplayToLocation = new JTextArea();
DisplayFare = new JTextArea();
DisplaySeatNum = new JTextArea();
ResetSeat = new JButton("Reset");
Fare = new JButton("Confirm ");
Clear = new JButton("Clear");
TPrice = new JLabel("Set Fare");
TTPrice = new JTextField();
StudentDis = new JLabel("Verify for student discount");
StuVerify = new JButton("Verify");
DisplayDiscount = new JTextArea();
Payment = new JButton("Payment");

DisplaySeat.setEditable(false);
DisplaySeat.setLineWrap(true);
DisplaySeat.setWrapStyleWord(true);
DisplayFromLocation.setLineWrap(true);
DisplayFromLocation.setWrapStyleWord(true);
DisplayToLocation.setLineWrap(true);
DisplayToLocation.setWrapStyleWord(true);

String columnNames[] = {"ID","From","to","Departure Time","Fare"};
trains = new DefaultTableModel(columnNames,0);
trains.addRow(new Object[]{"UN-US","Uttara North","Uttara South","9 am","20 taka"});
trains.addRow(new Object[]{"US-P","Uttara South","Pallabi","9.30 am","30 taka"});
trains.addRow(new Object[]{"P-M11","Pallabi","Mirpur 11","10 am","30 taka"});
trains.addRow(new Object[]{"M11-KP","Mirpur 11","KaziPara","10.35 am","40 taka"});
trains.addRow(new Object[]{"KP-SP","KaziPara","ShewraPara","11.15 am","50 taka"});
trains.addRow(new Object[]{"SP-Agaon","Shewrapara","AgarGaon","11.45 am","60 taka"});
trains.addRow(new Object[]{"Agaon-BS","AgarGaon","BijoySarani","12.05 pm","70 taka"});
trains.addRow(new Object[]{"BS-FG","BijoySarani","FarmGate","12.20 pm","80 taka"});

AdminP = new JPanel();
MainP = new JPanel();
UserP = new JPanel();
table = new JTable(trains);
JScrollPane SP = new JScrollPane(table);

AdminP.setLayout(null);
MainP.setLayout(null);
UserP.setLayout(null);
seats.setLayout(null);

//Combobox Locations
Locations = new ArrayList<String>();
Locations.add("Uttara");
Locations.add("Pallabi");
Locations.add("Mirpur 11");
Locations.add("Kazipara");
Locations.add("ShewraPara");
Locations.add("AgarGaon");
Locations.add("Bijoy Sarani");
Locations.add("FarmGate");
Locations.add("Karwan Bazar");
Locations.add("ShahBagh");
Locations.add("Dhaka University");
Locations.add("Bangladesh Secretariat");
Locations.add("Motijheel");

FromLocations = new JComboBox<>();
FromLocations.addItem("Uttara");
ToLocations = new JComboBox<>();
for(String item : Locations){ToLocations.addItem(item);}


selectedValue = (String) FromLocations.getSelectedItem();
DisplayFromLocation.setText("You are traveling from:: "+selectedValue);


AdminP.setBounds(30, 20,420, 300);
MainP.setBounds(30, 350, 650, 380);
UserP.setBounds(700, 120, 320, 610);
seats.setBounds(465, 20, 220, 300);
AddBtn.setBounds(30, 15, 100, 30);
DeleteBtn.setBounds(145, 15, 110, 30);
Back.setBounds(930, 30, 70, 30);
id.setBounds(50, 60, 100, 30);
Tid.setBounds(200, 60, 180, 30);
from.setBounds(50, 100, 100, 30);
Tfrom.setBounds(200, 100, 180, 30);
to.setBounds(50, 140, 100, 30);
Tto.setBounds(200, 140, 180, 30);
depTime.setBounds(50, 180, 130, 30);
TDepTime.setBounds(200, 180, 180, 30);
TPrice.setBounds(50,220,100,30);
TTPrice.setBounds(200,220,180,30);
table.setBounds(30, 30, 500, 250);
FromLocations.setBounds(20, 40, 200, 30);
ToLocations.setBounds(20, 110, 200, 30);
Start.setBounds(30, 7, 200, 30);
Reach.setBounds(30, 77, 200, 30);
a1.setBounds(50, 20, 40, 20);
b1.setBounds(50, 40, 40, 20);
c1.setBounds(50,60, 40, 20);
d1.setBounds(50, 80, 40, 20);
e1.setBounds(50, 100, 40, 20);
f1.setBounds(50, 120, 40, 20);
g1.setBounds(50, 140, 40, 20);
h1.setBounds(50, 160, 40, 20);
i1.setBounds(50, 180, 40, 20);
j1.setBounds(50, 200, 40, 20);
a2.setBounds(115, 20, 40, 20);
b2.setBounds(115,40,40,20);
c2.setBounds(115,60,55,20);
d2.setBounds(115,80,55,20);
e2.setBounds(115,100,55,20);
f2.setBounds(115,120,55,20);
g2.setBounds(115,140,55,20);
h2.setBounds(115,160,55,20);
i2.setBounds(115,180,55,20);
j2.setBounds(115,200,55,20);


id.setForeground(Color.WHITE);
from.setForeground(Color.WHITE);
to.setForeground(Color.WHITE);
depTime.setForeground(Color.WHITE);
TPrice.setForeground(Color.WHITE);
Start.setForeground(Color.WHITE);
Reach.setForeground(Color.WHITE);
StudentDis.setForeground(Color.WHITE);

Confirm.setBounds(115, 260, 80, 30);
ResetSeat.setBounds(30, 260, 80, 30);
DisplaySeat.setBounds(30, 370, 270, 40);
DisplaySeatNum.setBounds(30,330,270,40);
DisplayFromLocation.setBounds(30, 410, 270, 40);
DisplayToLocation.setBounds(30, 450, 270, 40);
DisplayFare.setBounds(30,490, 270, 40);
Clear.setBounds(130,285,70,30);
Payment.setBounds(210,285,90,30);
Fare.setBounds(30,285,90,30);
StudentDis.setBounds(30,195,180,40);
StuVerify.setBounds(210,200,90,30);
DisplayDiscount.setBounds(30,530,270,40);

MainP.add(table);
F1.add(AdminP);
F1.add(MainP);
F1.add(UserP);
F1.add(seats);
F1.add(Back);
AdminP.add(AddBtn);
AdminP.add(DeleteBtn);
AdminP.add(Tid);
AdminP.add(Tfrom);
AdminP.add(Tto);
AdminP.add(TDepTime);
AdminP.add(id);
AdminP.add(from);
AdminP.add(to);
AdminP.add(depTime);
AdminP.add(TPrice);
AdminP.add(TTPrice);
AddBtn.addActionListener(this);
DeleteBtn.addActionListener(this);
Confirm.addActionListener(this);
Back.addActionListener(this);
ResetSeat.addActionListener(this);
Fare.addActionListener(this);
Clear.addActionListener(this);
StuVerify.addActionListener(this);
Payment.addActionListener(this);



UserP.add(FromLocations);
UserP.add(ToLocations);
UserP.add(Start);
UserP.add(Reach);
seats.add(a1);
seats.add(b1);
seats.add(c1);
seats.add(d1);
seats.add(e1);
seats.add(f1);
seats.add(g1);
seats.add(h1);
seats.add(i1);
seats.add(j1);
seats.add(a2);
seats.add(b2);
seats.add(c2);
seats.add(d2);
seats.add(e2);
seats.add(f2);
seats.add(g2);
seats.add(h2);
seats.add(i2);
seats.add(j2);
seats.add(Confirm);
UserP.add(DisplaySeat);
UserP.add(DisplaySeatNum);
UserP.add(DisplayFromLocation);
UserP.add(DisplayToLocation);
UserP.add(DisplayFare);
seats.add(ResetSeat);
UserP.add(Fare);
UserP.add(Clear);
UserP.add(StudentDis);
UserP.add(StuVerify);
UserP.add(DisplayDiscount);
UserP.add(Payment);


AdminP.setBackground(Color.darkGray);
MainP.setBackground(Color.DARK_GRAY);
UserP.setBackground(Color.DARK_GRAY);
F1.add(SP,BorderLayout.CENTER);
F1.getContentPane().setBackground(new Color(50,170, 200));
F1.setSize(1050,800);
F1.setLayout(null);
F1.setResizable(false);
F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
F1.setVisible(true);
F1.setLocationRelativeTo(null);

try {
    BufferedImage img = ImageIO.read(new File("Images/singlebg.png"));
    JLabel backgroundLabel = new JLabel(new ImageIcon(img));
    backgroundLabel.setBounds(0, 0, F1.getWidth(), F1.getHeight());
    F1.add(backgroundLabel);
} catch (IOException ex) {
    System.out.println("Error loading background image: " + ex.getMessage());
}

// Set icons
ImageIcon logoIcon = new ImageIcon("Images/logo.png");
F1.setIconImage(logoIcon.getImage());

}
public void actionPerformed(ActionEvent e){
    if(e.getSource()==AddBtn){
    String id = Tid.getText();
    String from = Tfrom.getText();
    String to = Tto.getText();
    String dep = TDepTime.getText();
    String fare = TTPrice.getText();
   // table.setCellSelectionEnabled(false);
        if(id.isEmpty()==false && from.isEmpty()==false && to.isEmpty()==false && dep.isEmpty()==false && fare.isEmpty()==false){
    trains.addRow(new Object[]{id,from,to,dep,fare});
    Tid.setText("");
    Tfrom.setText("");
    Tto.setText("");
    TDepTime.setText("");
    TTPrice.setText("");JOptionPane.showConfirmDialog(null,"Train added Successfully","Success", JOptionPane.OK_OPTION);}
    else{JOptionPane.showMessageDialog(null,"PLease fill up all the information","Failure",JOptionPane.ERROR_MESSAGE);}
        }
else if(e.getSource()==DeleteBtn){int selectedRow =table.getSelectedRow();
    if(selectedRow != -1){trains.removeRow(selectedRow);}
    else{JOptionPane.showMessageDialog(null,"Train removal unsuccessful");
}}

else if(e.getSource()==StuVerify){
    String Code =JOptionPane.showInputDialog(null,"Enter Student Discount Code:","Student Verification",JOptionPane.OK_OPTION);
         if(Code.equals("student")){JOptionPane.showMessageDialog(null,"Discount Added :)");
           }
         else{JOptionPane.showMessageDialog(null,"Stop lying bruh !");}
     }
else if(e.getSource()==Back){F1.setVisible(false); new LogIn();}
else if(e.getSource()==Confirm){
           String result = " ";
           if(a1.isSelected()){result+=a1.getText()+",";}
           if(a2.isSelected()){result+=a2.getText()+",";}
           if(b1.isSelected()){result+=b1.getText()+",";}
           if(b2.isSelected()){result+=b2.getText()+",";}
           if(c1.isSelected()){result+=c1.getText()+",";}
           if(c2.isSelected()){result+=c2.getText()+",";}
           if(d1.isSelected()){result+=d1.getText()+",";}
           if(d2.isSelected()){result+=d2.getText()+",";}
           if(e1.isSelected()){result+=e1.getText()+",";}
           if(e2.isSelected()){result+=e2.getText()+",";}

           if(f1.isSelected()){result+=f1.getText()+",";}
           if(f2.isSelected()){result+=f2.getText()+",";}
           if(g1.isSelected()){result+=g1.getText()+",";}
           if(g2.isSelected()){result+=g2.getText()+",";}
           if(h1.isSelected()){result+=h1.getText()+",";}
           if(h2.isSelected()){result+=h2.getText()+",";}
           if(i1.isSelected()){result+=i1.getText()+",";}
           if(i2.isSelected()){result+=i2.getText()+",";}
           if(j1.isSelected()){result+=j1.getText()+",";}
           if(j2.isSelected()){result+=j2.getText()+",";}
           DisplaySeat.setText("Selected Seats::"+result+"\n");

    for (Component component : seats.getComponents()) {
        if (component instanceof JCheckBox) {
            JCheckBox checkBox = (JCheckBox) component;
            if (checkBox.isSelected()) {
                numCheckBoxes++;
                
            }}}

           
           DisplaySeatNum.setText("Number of seats ::"+numCheckBoxes);     
           
}
else if(e.getSource()==ResetSeat){DisplaySeat.setText(" ");
        a1.setSelected(false);
        a2.setSelected(false);
        b1.setSelected(false);
        b2.setSelected(false);
        c1.setSelected(false);
        c2.setSelected(false);
        d1.setSelected(false);
        d2.setSelected(false);
        e1.setSelected(false);
        e2.setSelected(false);
        f1.setSelected(false);
        f2.setSelected(false);
        g1.setSelected(false);
        g2.setSelected(false);
        h1.setSelected(false);
        h2.setSelected(false);
        i1.setSelected(false);
        i2.setSelected(false);
        j1.setSelected(false);
        j2.setSelected(false);

        numCheckBoxes=0;
        DisplaySeatNum.setText(" ");

   }
   else if(e.getSource()==Fare){
       // if(studentCheck==0){
    int P = 20*numCheckBoxes;
    int M11 = 30*numCheckBoxes;
    int KP = 40*numCheckBoxes;
    int SP = 50*numCheckBoxes;
    int AG = 60*numCheckBoxes;
    int BS = 70*numCheckBoxes;
    int FG = 80*numCheckBoxes;

     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="Pallabi"){DisplayFare.setText("Your total fare is ::"+P);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="Mirpur 11"){DisplayFare.setText("Your total fare is ::"+M11);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="Kazipara"){DisplayFare.setText("Your total fare is ::"+KP);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="ShewraPara"){DisplayFare.setText("Your total fare is ::"+SP);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="AgarGaon"){DisplayFare.setText("Your total fare is ::"+AG);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="BijoySarani"){DisplayFare.setText("Your total fare is ::"+BS);}
     if(FromLocations.getSelectedItem()=="Uttara" && ToLocations.getSelectedItem()=="FarmGate"){DisplayFare.setText("Your total fare is ::"+FG);}
        }
 
else if(e.getSource()==Clear){

DisplayToLocation.setText(" ");
DisplayFare.setText(" ");
}   
else if(e.getSource()==Payment){F1.setVisible(false);new Payment();}
}
      
       public  void Admin(){
         AdminP.setVisible(true);
         MainP.setVisible(true);
         UserP.setVisible(false);
       }
         public void User(){
        AdminP.setVisible(false);
        MainP.setVisible(true);
        UserP.setVisible(true);}
        
public static void main(String[] args) {
    new MainPagee();
}}
