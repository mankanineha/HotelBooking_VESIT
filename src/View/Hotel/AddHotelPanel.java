package View.Hotel;

import javax.swing.*;
import java.awt.*;


public class AddHotelPanel extends JPanel
{
    JTextField txt_LuxuryHotel_id;
    JTextField txt_Hotel_Name;
    JTextField txt_Hotel_Location;
    JTextField txt_Hotel_Contact_num;
    JTextField txt_Hotel_Ratings;
    JTextField txt_HotelFacilities;
    JButton addHotelBtn;
    JLabel lbl_LuxuryHotel_id;
    JLabel lbl_Hotel_Name;
    JLabel lbl_Hotel_Location;
    JLabel lbl_Hotel_Contact_num;
    JLabel lbl_Hotel_Ratings;
    JLabel lbl_HotelFacilities;
    public AddHotelPanel()
    {
        txt_LuxuryHotel_id = new JTextField();
        txt_Hotel_Name = new JTextField();
        txt_Hotel_Location = new JTextField();
        txt_Hotel_Contact_num = new JTextField();
        txt_Hotel_Ratings = new JTextField();
        txt_HotelFacilities = new JTextField();
        addHotelBtn = new JButton("Add Hotel");
        lbl_LuxuryHotel_id = new JLabel("Luxury Hotel ID");
        lbl_Hotel_Name = new JLabel("Hotel Name");
        lbl_Hotel_Location = new JLabel("Hotel Location");
        lbl_Hotel_Contact_num = new JLabel("Hotel Contact Number");
        lbl_Hotel_Ratings = new JLabel("Hotel Ratings");
        lbl_HotelFacilities = new JLabel("Hotel Facilities");
        this.setLayout(new GridLayout(8, 2));
        add(lbl_LuxuryHotel_id);
        add(txt_LuxuryHotel_id);
        add(lbl_Hotel_Name);
        add(txt_Hotel_Name);
        add(lbl_Hotel_Location);
        add(txt_Hotel_Location);
        add(lbl_Hotel_Contact_num);
        add(txt_Hotel_Contact_num);
        add(lbl_Hotel_Ratings);
        add(txt_Hotel_Ratings);
        add(lbl_HotelFacilities);
        add(txt_HotelFacilities);
        add(addHotelBtn);

    }
    public void setAddHotelBtn(JButton addHotelBtn) {
        this.addHotelBtn = addHotelBtn;
    }

    public void setTxt_Hotel_Ratings(JTextField txt_Hotel_Ratings) {
        this.txt_Hotel_Ratings = txt_Hotel_Ratings;
    }
    public void setTxt_Hotel_Contact_num(JTextField txt_Hotel_Contact_num) {
        this.txt_Hotel_Contact_num = txt_Hotel_Contact_num;
    }
    public void setTxt_HotelFacilities(JTextField txt_HotelFacilities) {
        this.txt_HotelFacilities = txt_HotelFacilities;
    }

    public void setTxt_Hotel_Location(JTextField txt_Hotel_Location) {
        this.txt_Hotel_Location = txt_Hotel_Location;
    }

    public void setTxt_Hotel_Name(JTextField txt_Hotel_Name) {
        this.txt_Hotel_Name = txt_Hotel_Name;
    }
    public void setTxt_LuxuryHotel_id(JTextField txt_LuxuryHotel_id) {
        this.txt_LuxuryHotel_id = txt_LuxuryHotel_id;
    }


    public JTextField getTxt_Hotel_Ratings() {
        return txt_Hotel_Ratings;
    }

    public JTextField getTxt_Hotel_Contact_num() {
        return txt_Hotel_Contact_num;
    }
    public JTextField getTxt_Hotel_Location() {
        return txt_Hotel_Location;
    }

    public JTextField getTxt_Hotel_Name() {
        return txt_Hotel_Name;
    }

    public JTextField getTxt_LuxuryHotel_id() {
        return txt_LuxuryHotel_id;
    }
    public JTextField getTxt_HotelFacilities() {
        return txt_HotelFacilities;
    }
    public JButton getAddHotelBtn() {
        return addHotelBtn;
    }

}






