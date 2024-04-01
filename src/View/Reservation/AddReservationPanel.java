package View.Reservation;

import javax.swing.*;
import java.awt.*;

public class AddReservationPanel extends JPanel {



    JLabel lbl_luxuryHotel_id;
    JLabel lbl_customer_id;
    JLabel lbl_Reservation_id;
    JLabel lbl_Check_in_Date;
    JLabel lbl_Check_out_Date;
    JLabel lbl_Payment;
    JLabel lbl_Status;
    JTextField luxuryHotel_id;
    JTextField customer_id;
    JTextField txt_Reservation_id;
    JTextField txt_Check_in_Date;
    JTextField txt_Check_out_Date;
    JTextField txt_Payment;
    JButton addReservationBtn;

    public AddReservationPanel()
    {   JPanel editReservationPanel = new JPanel();
        editReservationPanel.setLayout(new GridLayout(9, 2, 20, 10));
        lbl_luxuryHotel_id = new JLabel("luxurHotel id");
        lbl_customer_id = new JLabel("Customer id");
        lbl_Reservation_id = new JLabel("Reservation id");
        lbl_Check_in_Date = new JLabel("Check in Date");
        lbl_Check_out_Date = new JLabel("Check out Date");
        lbl_Payment = new JLabel("Payment");
        lbl_Status = new JLabel("Status");

        txt_Payment = new JTextField();
        customer_id= new JTextField();
        luxuryHotel_id = new JTextField();
        txt_Reservation_id = new JTextField();
        txt_Check_out_Date = new JTextField();
        txt_Check_in_Date = new JTextField();
        addReservationBtn = new JButton("Add Reservation");


        editReservationPanel.add(lbl_luxuryHotel_id);
        editReservationPanel.add(luxuryHotel_id);

        editReservationPanel.add(lbl_customer_id);
        editReservationPanel.add(customer_id);
        editReservationPanel.add(lbl_Reservation_id);
        editReservationPanel.add(txt_Reservation_id);

        editReservationPanel.add(lbl_Check_in_Date);
        editReservationPanel.add(txt_Check_out_Date);

        editReservationPanel.add(lbl_Check_out_Date);
        editReservationPanel.add(txt_Check_in_Date);

        editReservationPanel.add(lbl_Payment);
        editReservationPanel.add(txt_Payment);

        editReservationPanel.add(addReservationBtn);
        add(editReservationPanel);
    }

    public JTextField getLuxuryHotel_id() {
        return luxuryHotel_id;
    }

    public JTextField getCustomer_id() {
        return customer_id;
    }

    public JTextField getTxt_Reservation_id() {
        return txt_Reservation_id;
    }

    public JTextField getTxt_Check_in_Date() {
        return txt_Check_in_Date;
    }

    public JTextField getTxt_Check_out_Date() {
        return txt_Check_out_Date;
    }
    public JTextField getTxt_Payment(){
        return txt_Payment;
    }

    public JButton getAddReservationBtn() {
        return addReservationBtn;
    }

    public void setLuxuryHotel_id(JTextField luxuryHotel_id) {
        this.luxuryHotel_id = luxuryHotel_id;
    }

    public void setCustomer_id(JTextField customer_id) {
        this.customer_id = customer_id;
    }

    public void setTxt_Reservation_id(JTextField txt_Reservation_id) {
        this.txt_Reservation_id = txt_Reservation_id;
    }

    public void setTxt_Check_in_Date(JTextField txt_Check_in_Date) {
        this.txt_Check_in_Date = txt_Check_in_Date;
    }

    public void setTxt_Check_out_Date(JTextField txt_Check_out_Date) {
        this.txt_Check_out_Date = txt_Check_out_Date;
    }

    public void setTxt_Payment(JTextField txt_Payment) {
        this.txt_Payment = txt_Payment;
    }

    public void setAddReservationBtn(JButton addReservationBtn) {
        this.addReservationBtn = addReservationBtn;
    }
}
