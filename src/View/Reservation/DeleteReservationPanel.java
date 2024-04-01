package View.Reservation;

import javax.swing.*;
import java.awt.*;

public class DeleteReservationPanel extends JPanel {

    JTextField txt_del_reservation_idx;
    JButton deleteReservationBtn;

    public DeleteReservationPanel()
    {

        txt_del_reservation_idx = new JTextField();
        deleteReservationBtn = new JButton("Delete Reservation");

      //  txt_del_reservation_idx.setText("txt_reservation_idx");
        this.setLayout(new GridLayout(13, 2));
        add(new JLabel("Enter Reservations Index to Delete:"));
        add(txt_del_reservation_idx);
        add(deleteReservationBtn);
    }

    public JButton getDeleteReservationBtn() {
        return deleteReservationBtn;
    }

    public JTextField getTxt_del_reservation_idx() {
        return txt_del_reservation_idx;
    }

    public void setDeleteReservationBtn(JButton deleteReservationBtn) {
        this.deleteReservationBtn = deleteReservationBtn;
    }

    public void setTxt_del_reservation_idx(JTextField txt_del_reservation_idx) {
        this.txt_del_reservation_idx = txt_del_reservation_idx;
    }
}
