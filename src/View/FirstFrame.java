package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FirstFrame extends JFrame {
    JButton ManageCustomerBtn;
    JButton ManageLuxuryHotelBtn;
    JButton ManageReservationBtn;
    JPanel firstPanel;


    public FirstFrame()
    {
        super("Main DashBoard");
        ManageCustomerBtn = new JButton("Manage Customer");
        ManageLuxuryHotelBtn = new JButton("Manage LuxuryHotel");
        ManageReservationBtn = new JButton("Manage Reservation");

        firstPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load background image
                    Image backgroundImage = ImageIO.read(new File("src/img/hotel1.jpeg"));
                    // Draw the background image
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };




        firstPanel.setLayout(new GridLayout(6,1));
        JLabel label1 = new JLabel("Welcome to Hotel Booking System");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label1.setVerticalTextPosition(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setAutoscrolls(true);

        firstPanel.add(label1);

//JPanel panel is already initialized by the IDE

        JPanel innerpanel = new JPanel();

        innerpanel.setLayout(new GridLayout(1, 3));
        ManageCustomerBtn.setBackground(new Color(111, 78, 55));
        ManageCustomerBtn.setForeground(Color.white);
        innerpanel.add(ManageCustomerBtn);

        ManageLuxuryHotelBtn.setBackground(new Color(111, 78, 55));
        ManageLuxuryHotelBtn.setForeground(Color.white);
        innerpanel.add(ManageLuxuryHotelBtn);


        ManageReservationBtn.setBackground(new Color(111, 78, 55));
        ManageReservationBtn.setForeground(Color.white);
        innerpanel.add(ManageReservationBtn);
        firstPanel.add(innerpanel);
        add(firstPanel);


        pack();
         setSize(1500, 600);
        setVisible(true);
    }

    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }

    public void setManageCustomerBtn(JButton ManageCustomerBtn) {
        this.ManageCustomerBtn = ManageCustomerBtn;
    }

    public void setManageLuxuryHotelBtn(JButton ManageLuxuryHotelBtn) {
        this.ManageLuxuryHotelBtn = ManageLuxuryHotelBtn;
    }

    public void setManageReservationBtnBtn(JButton ManageReservationBtn) {
        this.ManageReservationBtn = ManageReservationBtn;
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public JButton getManageCustomerBtn() {
        return ManageCustomerBtn;
    }

    public JButton getManageLuxuryHotelBtn() {
        return ManageLuxuryHotelBtn;
    }

    public JButton getManageReservationBtn() {
        return ManageReservationBtn;
    }
}
