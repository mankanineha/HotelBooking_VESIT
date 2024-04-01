package View.Customer;

import javax.swing.*;
import java.awt.*;

public class DeleteCustomerPanel extends JPanel {

    JTextField txt_del_customer_idx;
    JButton deleteCustomerBtn;
    JLabel lbl_del_customer_idx;

    public DeleteCustomerPanel()
    {

        txt_del_customer_idx = new JTextField();
        deleteCustomerBtn = new JButton("Delete Customer");
        lbl_del_customer_idx = new JLabel("Customer ID");
        this.setLayout(new GridLayout(4, 2));

        add(lbl_del_customer_idx);
        add(txt_del_customer_idx);
        add(deleteCustomerBtn);

    }

    public JButton getDeleteCustomerBtn() {
        return deleteCustomerBtn;
    }

    public JTextField getTxt_del_customer_idx() {
        return txt_del_customer_idx;
    }

    public void setDeleteCustomerBtn(JButton deleteCustomerBtn) {
        this.deleteCustomerBtn = deleteCustomerBtn;
    }

    public void setTxt_del_customer_idx(JTextField txt_del_customer_idx) {
        this.txt_del_customer_idx = txt_del_customer_idx;
    }
    public JTextField getLbl_del_customer_idx() {
        return txt_del_customer_idx;
    }

    public void setLbl_del_customer_idx(JLabel lbl_del_customer_idx) {
        this.lbl_del_customer_idx = lbl_del_customer_idx;
    }

}
