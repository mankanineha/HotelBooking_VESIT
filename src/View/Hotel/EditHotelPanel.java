package View.Hotel;

import javax.swing.*;
import java.awt.*;

public class EditHotelPanel extends JPanel {

    JLabel lbl_Hotel_id;
    JLabel lbl_Hotel_name;
    JLabel lbl_Hotel_Location;
    JLabel lbl_Hotel_Rating;
    JLabel lbl_Hotel_Contact_number;
    JLabel lbl_Hotel_Facilities;
    JTextField txt_hotel_id;
    JTextField txt_get_hotel_idx;
    JTextField txt_Hotel_name;
    JTextField txt_Hotel_Location;
    JTextField txt_Hotel_Rating;
    JTextField txt_Hotel_Contact_number;
    JTextField txt_Hotel_Facilities;
    JButton editHotelBtn;
    JButton getHotelBtn;

    public EditHotelPanel() {

        lbl_Hotel_id = new JLabel("Hotel ID");
        lbl_Hotel_name = new JLabel("Hotel Name");
        lbl_Hotel_Location = new JLabel("Hotel Location");
        lbl_Hotel_Facilities = new JLabel("Hotel Facilities");
        lbl_Hotel_Contact_number = new JLabel("Hotel Contact Number");
        lbl_Hotel_Rating = new JLabel("Hotel Rating");

        this.setLayout(new GridLayout(8, 2));
        txt_hotel_id = new JTextField();
        txt_Hotel_name = new JTextField();
        txt_Hotel_Location = new JTextField();
        txt_Hotel_Rating = new JTextField();
        txt_Hotel_Contact_number = new JTextField();
        txt_Hotel_Facilities = new JTextField();
        editHotelBtn = new JButton("Edit Hotel");

        txt_get_hotel_idx = new JTextField();
        getHotelBtn = new JButton("Get Hotel");

        add(txt_get_hotel_idx);
        add(getHotelBtn);
        add(lbl_Hotel_id);
        add(txt_hotel_id);

        add(lbl_Hotel_name);
        add(txt_Hotel_name);
        add(lbl_Hotel_Location);
        add(txt_Hotel_Location);
        add(lbl_Hotel_Rating);
        add(txt_Hotel_Rating);
        add(lbl_Hotel_Contact_number);
        add(txt_Hotel_Contact_number);
        add(lbl_Hotel_Facilities);
        add(txt_Hotel_Facilities);
        add(editHotelBtn);
    }

    public JButton getGetHotelBtn() {
        return getHotelBtn;
    }


    public JTextField getTxt_get_hotel_idx() {
        return txt_get_hotel_idx;
    }

    public JTextField getTxt_Hotel_name() {
        return txt_Hotel_name;
    }

    public JTextField getTxt_Hotel_Location() {
        return txt_Hotel_Location;
    }

    public JTextField getTxt_Hotel_Rating() {
        return txt_Hotel_Rating;
    }

    public JTextField getTxt_Hotel_Contact_number() {
        return txt_Hotel_Contact_number;
    }

    public JTextField getTxt_Hotel_Facilities() {
        return txt_Hotel_Facilities;
    }

    public JButton getEditHotelBtn() {
        return editHotelBtn;
    }

    public void setTxt_hotel_id(JTextField txt_hotel_id) {
        this.txt_hotel_id = txt_hotel_id;
    }


    public void setTxt_Hotel_name(JTextField txt_Hotel_name) {
        this.txt_Hotel_name = txt_Hotel_name;
    }


    public void setTxt_Hotel_Location(JTextField txt_Hotel_Location) {
        this.txt_Hotel_Location = txt_Hotel_Location;
    }


    public void setTxt_Hotel_Rating(JTextField txt_Hotel_Rating) {
        this.txt_Hotel_Rating = txt_Hotel_Rating;
    }


    public void setTxt_Hotel_Contact_number(JTextField txt_Hotel_Contact_number) {
        this.txt_Hotel_Contact_number = txt_Hotel_Contact_number;
    }


    public void setTxt_Hotel_Facilities(JTextField txt_Hotel_Facilities) {
        this.txt_Hotel_Facilities = txt_Hotel_Facilities;
    }

    public void setEditHotelBtn(JButton editHotelBtn) {
        this.editHotelBtn = editHotelBtn;
    }

    public void setGetHotelBtn(JButton getHotelBtn) {
        this.getHotelBtn = getHotelBtn;
    }


    public void setTxt_get_hotel_idx(JTextField txt_get_hotel_idx) {
        this.txt_get_hotel_idx = txt_get_hotel_idx;
    }


    public JTextField getTxt_hotel_id() {
        return txt_hotel_id;
    }

    public JTextField getTxt_LuxuryHotel_id() {
        return txt_hotel_id;
    }


}


