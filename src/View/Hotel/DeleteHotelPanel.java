package View.Hotel;

import javax.swing.*;
import java.awt.*;


public class DeleteHotelPanel extends JPanel
{
    JTextField txt_del_hotel_idx;
    JButton btn_del_hotel;
    JLabel lbl_del_hotel_idx;
    public DeleteHotelPanel()
    {
        txt_del_hotel_idx = new JTextField();
        btn_del_hotel = new JButton("Delete Hotel");
        lbl_del_hotel_idx = new JLabel("Hotel ID:");
        this.setLayout(new GridLayout(3, 2));
        add(lbl_del_hotel_idx);
        add(txt_del_hotel_idx);
        add(btn_del_hotel);

    }
    public JButton getBtn_del_hotel()
    {
        return btn_del_hotel;
    }

    public JTextField getTxt_del_hotel_idx()
    {
        return txt_del_hotel_idx;
    }
    public void setBtn_del_hotel(JButton btn_del_hotel)
    {
        this.btn_del_hotel = btn_del_hotel;
    }

    public void setTxt_del_hotel_idx(JTextField txt_del_hotel_idx)
    {
        this.txt_del_hotel_idx = txt_del_hotel_idx;
    }
    public JLabel getLbl_del_hotel_idx()
    {
        return lbl_del_hotel_idx;
    }

    public void setLbl_del_hotel_idx(JLabel lbl_del_hotel_idx)
    {
        this.lbl_del_hotel_idx = lbl_del_hotel_idx;
    }




}