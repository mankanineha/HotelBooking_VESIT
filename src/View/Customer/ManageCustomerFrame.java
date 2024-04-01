package View.Customer;

import View.Customer.InitialPanelCustomer;

import javax.swing.*;

public class ManageCustomerFrame extends JFrame {
    InitialPanelCustomer Customer_ip;

    public ManageCustomerFrame()
    {
        super("Manage Customer DashBoard");
        Customer_ip = new InitialPanelCustomer();
        add(Customer_ip);
        pack();
        setSize(1000, 600);
    }

    public void setCustomer_ip(InitialPanelCustomer Customer_ip) {
        this.Customer_ip = Customer_ip;
    }

    public InitialPanelCustomer getCustomer_ip() {
        return Customer_ip;
    }
}
