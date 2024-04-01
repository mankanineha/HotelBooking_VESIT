package Model.Reservation;

import Model.Hotel.*;
import Model.Hotel.ManageLuxuryHotel;
import Model.Customer.*;
import Model.Customer.ManageCustomer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageReservation extends FileHandlingReservation implements Displayable {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    ArrayList<LuxuryHotel> hotels = new ArrayList<LuxuryHotel>();

    ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    String file2 = "src/Model/Reservation/Reservation.json";

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    LuxuryHotel h_temp_obj = new LuxuryHotel();
    Customer c_temp_obj = new Customer();


    public ManageReservation(){
        ManageCustomer mc1 = new ManageCustomer();
        customers = mc1.readCustomerJsonFile("src/Model/Customer/Customer.json");
        ManageLuxuryHotel mh1 = new ManageLuxuryHotel();
        hotels = mh1.readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");
        readReservationJsonFile(file2);
    }
    @Override
    public ArrayList<Reservation> readReservationJsonFile(String file_path) {
        try {
            reservations.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));


            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int Payment = node.get("Payment").asInt();
                    int c_temp = node.get("C_temp").asInt();
                    int h_temp = node.get("H_temp").asInt();
                    String Check_out_Date = node.get("Check_out_Date").asText();
                    int Reservation_Id = node.get("Reservation_Id").asInt();
                    String Check_in_Date = node.get("Check_in_Date").asText();




                    for (Customer customer : customers) {
                        if (c_temp == customer.getCustomer_id()) {
                            c_temp_obj = customer;
                        }
                    }

                    for (LuxuryHotel hotel : hotels) {
                        if (h_temp == hotel.getLuxuryHotel_id()) {
                            h_temp_obj = hotel;
                        }
                    }

                    Reservation r_temp = new Reservation(Payment,c_temp_obj,h_temp_obj,Check_out_Date,Reservation_Id,Check_in_Date);
                    reservations.add(r_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    @Override
    public void writeReservationJsonFile(String file_path, ArrayList<Reservation> reserve_al)  {

        ArrayList<Map<String,Object>> reservation_to_be_written = new ArrayList<>();

        for(int i = 0; i < reserve_al.size(); i++)
        {
            HashMap<String, Object> data = new HashMap<>();
            data.put("Payment",reserve_al.get(i).getPayment());
            data.put("C_temp",reserve_al.get(i).getC_temp().getCustomer_id());
            data.put("H_temp",reserve_al.get(i).getH_temp().getLuxuryHotel_id());
            data.put("Check_out_Date",reserve_al.get(i).getCheck_out_Date());
            data.put("Reservation_Id",reserve_al.get(i).getReservation_Id());
            data.put("Check_in_Date",reserve_al.get(i).getCheck_in_Date());



            reservation_to_be_written.add(data);
        }


        try {
            objectMapper.writeValue(Paths.get(file_path).toFile(), reservation_to_be_written);
        }
        catch (Exception c){
            System.out.println(c);
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Payment");
        headers.add("Customer Id");
        headers.add("LuxuryHotel Id");
        headers.add("Check Out Date");
        headers.add("Reservation ID");
        headers.add("Check in Date");


        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> reservation_details = new ArrayList<String>();
        reservation_details.add(String.valueOf(reservations.get(line).getPayment()));
        reservation_details.add(String.valueOf(reservations.get(line).getC_temp().getCustomer_id()));
        reservation_details.add(String.valueOf(reservations.get(line).getH_temp().getLuxuryHotel_id()));
        reservation_details.add(reservations.get(line).getCheck_out_Date());
        reservation_details.add(String.valueOf(reservations.get(line).getReservation_Id()));
        reservation_details.add(reservations.get(line).getCheck_in_Date());


        return reservation_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> hotels_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            hotels_subset.add(getLine(i));
        }
        return hotels_subset;
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

    public ArrayList<Reservation> getTable() {
        readReservationJsonFile("src/Model/Reservation/Reservation.json");
        return reservations;
    }
    public void addNewReservation(int Payment,int customer_id,int luxuryHotel_id,String Check_out_Date, int Reservation_id,String Check_in_Date) throws IOException {
        readReservationJsonFile("src/Model/Reservation/Reservation.json");
        Reservation temp_reserve = new Reservation(Payment,customers.get(customer_id),hotels.get(luxuryHotel_id),Check_out_Date, Reservation_id,Check_in_Date);
        reservations.add(temp_reserve);
        writeReservationJsonFile("src/Model/Reservation/Reservation.json",reservations);
    }

    public void editReservation(int edit_reservation_idx, int Payment, int customer_id,int luxuryHotel_id,String Check_out_Date, int Reservation_id, String Check_in_Date) throws IOException {
        readReservationJsonFile("src/Model/Reservation/Reservation.json");
        reservations.get(edit_reservation_idx).setPayment(Payment);
        reservations.get(edit_reservation_idx).setC_temp(customers.get(customer_id));
        reservations.get(edit_reservation_idx).setH_temp(hotels.get(luxuryHotel_id));
        reservations.get(edit_reservation_idx).setCheck_out_Date(Check_out_Date);
        reservations.get(edit_reservation_idx).setReservation_Id(Reservation_id);
        reservations.get(edit_reservation_idx).setCheck_in_Date(Check_in_Date);




        writeReservationJsonFile("src/Model/Reservation/Reservation.json",reservations);
    }

    public void deleteReservation(int delete_reservation_idx) throws IOException {
        readReservationJsonFile("src/Model/Reservation/Reservation.json");
        reservations.remove(delete_reservation_idx);
        writeReservationJsonFile("src/Model/Reservation/Reservation.json",reservations);
    }
}

