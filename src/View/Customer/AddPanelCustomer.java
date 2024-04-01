package View.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddPanelCustomer extends JPanel {
    JTextField txt_Customer_id;
    JTextField txt_First_name;
    JTextField txt_Last_name;
    JTextField txt_Email;
    JTextField txt_Mobile_number;
    JTextField txt_Identification_type;
    JButton addCustomerBtn;

    JLabel lbl_Customer_id;
    JLabel lbl_First_name;
    JLabel lblL_Last_name;
    JLabel lbl_Email;
    JLabel lbl_Mobile_number;
    JLabel lbl_Identification_type;


    public AddPanelCustomer()
    {

        txt_Customer_id= new JTextField();
        txt_First_name = new JTextField();
        txt_Last_name = new JTextField();
        txt_Email = new JTextField();
        txt_Mobile_number = new JTextField();
        txt_Identification_type = new JTextField();
        addCustomerBtn = new JButton("Add Customer");
        lbl_Customer_id = new JLabel("Customer ID");
        lbl_First_name = new JLabel("First Name");
        lblL_Last_name = new JLabel("Last Name");
        lbl_Email = new JLabel("Email");
        lbl_Mobile_number = new JLabel("Mobile Number");
        lbl_Identification_type = new JLabel("Identification Type");
        this.setLayout(new GridLayout(8,2));
        add(lbl_Customer_id);
        add(txt_Customer_id);
        add(lbl_First_name);
        add(txt_First_name);
        add(lblL_Last_name);
        add(txt_Last_name);

        add(lbl_Email);
        add(txt_Email);
        add(lbl_Mobile_number);
        add(txt_Mobile_number);
        add(lbl_Identification_type);
        add(txt_Identification_type);
        add(addCustomerBtn);
    }

    public void setTxt_Customer_id(JTextField txt_Customer_id)
    {
        this.txt_Customer_id = txt_Customer_id;
    }

    public void setAddCustomerBtn(JButton addCustomerBtn) {
        this.addCustomerBtn = addCustomerBtn;
    }

    public void setTxt_First_name(JTextField txt_First_name) {
        this.txt_First_name = txt_First_name;
    }

    public void setTxt_Last_name(JTextField txt_Last_name) {
        this.txt_Last_name = txt_Last_name;
    }

    public void setTxt_Email(JTextField txt_Email) {
        this.txt_Email = txt_Email;
    }

    public void setTxt_Mobile_number(JTextField txt_Mobile_number) {
        this.txt_Mobile_number = txt_Mobile_number;
    }

    public void setTxt_Identification_type(JTextField txt_Identification_type) {
        this.txt_Identification_type = txt_Identification_type;
    }

    public JTextField getTxt_Customer_id() {
        return txt_Customer_id;
    }

    public JTextField getTxt_First_name() {
        return txt_First_name;
    }

    public JTextField getTxt_Last_name() {
        return txt_Last_name;
    }

    public JTextField getTxt_Email() {
        return txt_Email;
    }

    public JTextField getTxt_Mobile_number() {
        return txt_Mobile_number;
    }

    public JTextField getTxt_Identification_type() {
        return txt_Identification_type;
    }

    public JButton getAddCustomerBtn() {
        return addCustomerBtn;
    }
}
