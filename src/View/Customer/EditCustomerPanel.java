package View.Customer;

import javax.swing.*;
import java.awt.*;

public class EditCustomerPanel extends JPanel {

    JLabel lbl_Customer_id;
    JLabel lbl_First_name;
    JLabel lblL_Last_name;
    JLabel lbl_Email;
    JLabel lbl_Mobile_number;
    JLabel lbl_Identification_type;

    JTextField txt_get_customer_idx;
    JButton getCustomerBtn;
    JTextField txt_Customer_id;
    JTextField txt_First_name;
    JTextField txt_Last_name;
    JTextField txt_Email;
    JTextField txt_Mobile_number;
    JTextField txt_Identification_type;
    JButton editCustomerBtn;

    public EditCustomerPanel() {

        lbl_Customer_id = new JLabel("Customer ID");
        lbl_First_name = new JLabel("First Name");
        lblL_Last_name = new JLabel("Last Name");
        lbl_Email = new JLabel("Email");
        lbl_Mobile_number = new JLabel("Mobile Number");
        lbl_Identification_type = new JLabel("Identification Type");
        this.setLayout(new GridLayout(8,2));
        txt_Customer_id = new JTextField();
        txt_First_name = new JTextField();
        txt_Last_name = new JTextField();
        txt_Email = new JTextField();
        txt_Mobile_number = new JTextField();
        txt_Identification_type = new JTextField();
        editCustomerBtn = new JButton("Edit Customer");
        txt_get_customer_idx = new JTextField();
        getCustomerBtn = new JButton("Get Customer to Edit");

       /* txt_Customer_id.setText("txt_customer_id");
        txt_First_name.setText("txt_First_name");
        txt_Last_name.setText("txt_Last_name");
        txt_Email.setText("txt_Email");
        txt_Mobile_number.setText("txt_Mobile_number");
        txt_Identification_type.setText("txt_Identification_type");
        txt_get_customer_idx.setText("get customer idx");
*/

        add(txt_get_customer_idx);
        add(getCustomerBtn);
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
        add(editCustomerBtn);
    }

    public void setTxt_Customer_id(JTextField txt_Customer_id) {
        this.txt_Customer_id = txt_Customer_id;
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

    public void setTxt_get_customer_idx(JTextField txt_get_customer_idx) {
        this.txt_get_customer_idx = txt_get_customer_idx;
    }

    public void setEditCustomerBtn(JButton editCustomerBtn) {
        this.editCustomerBtn = editCustomerBtn;
    }

    public void setGetCustomerBtn(JButton getCustomerBtn) {
        this.getCustomerBtn = getCustomerBtn;
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

    public JTextField getTxt_get_customer_idx() {
        return txt_get_customer_idx;
    }

    public JButton getEditCustomerBtn() {
        return editCustomerBtn;
    }

    public JButton getGetCustomerBtn() {
        return getCustomerBtn;
    }
}



