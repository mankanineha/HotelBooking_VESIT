package Model.Customer;

import java.util.ArrayList;

public class Customer extends Person{
    private static int Customer_count = 0;
    int customer_id;
    String identification_type;

    public static int getCustomer_count()
    {
        return Customer_count;
    }

    public Customer(){
        Customer_count++;
        this.setCustomer_id(customer_id);
    }

    public Customer(String first_name, String last_name, String email,  String mobile_number,String identification_type)
    {
        super(first_name, last_name, email, mobile_number);
        Customer_count++;
        this.setIdentification_type(identification_type);

    }
    public Customer(int customer_id, String first_name ,String last_name,String email, String mobile_number,String identification_type)
    {
        super(first_name, last_name, email, mobile_number);
        Customer_count++;
        this.setCustomer_id(customer_id);
        this.setIdentification_type(identification_type);

    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public String getIdentification_type() {
        return identification_type;
    }


    public void display()
    {
        System.out.println("Customer Id: "+ getCustomer_id());
        System.out.println("Customer Identification type: "+ getIdentification_type());
        super.display();

    }

}
