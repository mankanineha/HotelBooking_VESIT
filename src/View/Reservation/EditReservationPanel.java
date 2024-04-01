package View.Reservation;

import javax.swing.*;
import java.awt.*;

public class EditReservationPanel extends JPanel {

    JLabel lbl_luxuryHotel_id;
    JLabel lbl_customer_id;
    JLabel lbl_Reservation_id;
    JLabel lbl_Check_in_Date;
    JLabel lbl_Check_out_Date;
    JLabel lbl_Payment;
    JLabel lbl_Status;

    JTextField txt_get_reservation_idx;
    JButton getReservationBtn;
    JTextField txt_luxuryHotel_id;
    JTextField txt_customer_id;
    JTextField txt_Reservation_id;
    JTextField txt_Check_in_Date;
    JTextField txt_Check_out_Date;
    JTextField txt_Payment;
    JButton editReservationBtn;

    public EditReservationPanel()
    {
        JPanel editReservationJPanel = new JPanel();
        editReservationJPanel.setLayout(new GridLayout(12, 2, 20, 10));
        lbl_luxuryHotel_id = new JLabel("Luxury Hotel id");
        lbl_customer_id = new JLabel("Customer id");
        lbl_Reservation_id = new JLabel("Reservation id");
        lbl_Check_in_Date = new JLabel("Check in Date");
        lbl_Check_out_Date = new JLabel("Check out Date");
        lbl_Payment = new JLabel("Payment");
        lbl_Status = new JLabel("Status");

        txt_luxuryHotel_id = new JTextField();
        txt_customer_id = new JTextField();
        txt_Reservation_id = new JTextField();
        txt_Check_in_Date = new JTextField();
        txt_Check_out_Date = new JTextField();
        txt_Payment = new JTextField();
        editReservationBtn = new JButton("Edit Reservation");
        txt_get_reservation_idx = new JTextField();
        getReservationBtn = new JButton("Get Reservation to Edit");

     /*   txt_luxuryHotel_id.setText("txt_luxuryHotel_id");
        txt_customer_id.setText("txt_customer_id");
        txt_Reservation_id.setText("txt_Reservation_id");
        txt_Check_in_Date.setText("txt_Check_in_Date");
        txt_Check_out_Date.setText("txt_Check_out_Date");
        txt_Payment.setText("txt_Payment");
        txt_get_reservation_idx.setText("get reservation idx");*/

        editReservationJPanel.add(lbl_Reservation_id);
        editReservationJPanel.add(txt_get_reservation_idx);
        editReservationJPanel.add(getReservationBtn);
        editReservationJPanel.add(lbl_Reservation_id);
        editReservationJPanel.add(txt_Reservation_id);
        editReservationJPanel.add(lbl_luxuryHotel_id);
        editReservationJPanel.add(txt_luxuryHotel_id);

        editReservationJPanel.add(lbl_customer_id);
        editReservationJPanel.add(txt_customer_id);


        editReservationJPanel.add(lbl_Check_in_Date);
        editReservationJPanel.add(txt_Check_in_Date);
        editReservationJPanel.add(lbl_Check_out_Date);
        editReservationJPanel.add(txt_Check_out_Date);
        editReservationJPanel.add(lbl_Payment);
        editReservationJPanel.add(txt_Payment);

        editReservationJPanel.add(editReservationBtn);
       // editReservationJPanel.add(lbl_Status);
        add(editReservationJPanel);
    }

    public JTextField getTxt_luxuryHotel_id() {
        return txt_luxuryHotel_id;
    }

    public JTextField getTxt_customer_id() {
        return txt_customer_id;
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

    public JTextField getTxt_get_reservation_idx() {
        return txt_get_reservation_idx;
    }

    public JButton getGetReservationBtn() {
        return getReservationBtn;
    }

    public JButton getEditReservationBtn() {
        return editReservationBtn;
    }

    public void setTxt_luxuryHotel_id(JTextField txt_luxuryHotel_id) {
        this.txt_luxuryHotel_id = txt_luxuryHotel_id;
    }

    public void setTxt_customer_id(JTextField txt_customer_id) {
        this.txt_customer_id= txt_customer_id;
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

    public void setGetReservationBtn(JButton getReservationBtn) {
        this.getReservationBtn = getReservationBtn;
    }

    public void setEditReservationBtn(JButton editReservationBtn) {
        this.editReservationBtn = editReservationBtn;
    }
}
