package Model.Customer;

import Model.Reservation.Reservation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageCustomer extends FileHandlingCustomer implements Displayable {

    ArrayList<Customer> customers = new ArrayList<Customer>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    String file = "src/Model/Customer/Customer.json";
    public ManageCustomer(){
        readCustomerJsonFile(file);
    }
    public ArrayList<Customer> readCustomerJsonFile(String file_path) {

        customers.removeAll(customers);
        try {

            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int customer_id = node.get("customer_id").asInt();
                    String first_name = node.get("first_name").asText();
                    String last_name = node.get("last_name").asText();
                    String email = node.get("email").asText();
                    String mobile_number = node.get("mobile_number").asText();
                    String identification_type = node.get("identification_type").asText();

                    // Check if all necessary nodes are present before creating a Customer object


                    Customer cust = new Customer(customer_id,first_name, last_name, email, mobile_number,identification_type);
                    customers.add(cust);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            // Log or handle the exception as needed
        }

        return customers;
    }
    public void writeCustomerJsonFile(String file_path, ArrayList<Customer> customers) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Customer/Customer.json").toFile(), customers);
        objectMapper.writeValue(Paths.get(file_path).toFile(), customers);
    }

//    public void setCustomersTable(ArrayList<Customer> customers) {
//        this.customers = customers;
//    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Email");
        headers.add("Mobile_number");
        headers.add("Identification type");

        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> customer_details = new ArrayList<String>();

        customer_details.add(String.valueOf(customers.get(line).getCustomer_id()));
        customer_details.add(customers.get(line).getFirst_name());
        customer_details.add(customers.get(line).getLast_name());
        customer_details.add(customers.get(line).getEmail());
        customer_details.add(customers.get(line).getMobile_number());
        customer_details.add(customers.get(line).getIdentification_type());

        return customer_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> customers_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            customers_subset.add(getLine(i));
        }
        return customers_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Customer> getTable() {
        readCustomerJsonFile("src/Model/Customer/Customer.json");
        return customers;
    }
    public void addNewCustomer(int customer_id, String first_name, String last_name, String email, String mobile_number, String identification_type) throws IOException {
        readCustomerJsonFile("src/Model/Customer/Customer.json");
        Customer temp_cust = new Customer(customer_id,first_name, last_name, email, mobile_number, identification_type);
        customers.add(temp_cust);
        writeCustomerJsonFile("src/Model/Customer/Customer.json",customers);

    }

    public void editCustomer(int edit_customer_idx, int customer_id, String first_name, String last_name, String email, String mobile_number, String identification_type) throws IOException {
        readCustomerJsonFile("src/Model/Customer/Customer.json");
        customers.get(edit_customer_idx).setCustomer_id(customer_id);
        customers.get(edit_customer_idx).setFirst_name(first_name);
        customers.get(edit_customer_idx).setLast_name(last_name);
        customers.get(edit_customer_idx).setEmail(email);
        customers.get(edit_customer_idx).setMobile_number(mobile_number);
        customers.get(edit_customer_idx).setIdentification_type(identification_type);
        writeCustomerJsonFile("src/Model/Customer/Customer.json",customers);
    }

    public void deleteCustomer(int delete_customer_idx) throws IOException {
        readCustomerJsonFile("src/Model/Customer/Customer.json");
        customers.remove(delete_customer_idx);
        writeCustomerJsonFile("src/Model/Customer/Customer.json",customers);
    }
}