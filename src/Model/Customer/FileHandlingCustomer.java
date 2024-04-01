package Model.Customer;

import Model.Customer.Customer;
import Model.Hotel.Hotel;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingCustomer {
    protected abstract ArrayList<Customer> readCustomerJsonFile(String file_path);
    protected abstract void writeCustomerJsonFile(String file_path, ArrayList<Customer> students) throws IOException;
}