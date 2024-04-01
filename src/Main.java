import Controller.Controller;
import Model.Customer.Customer;
import Model.Customer.ManageCustomer;
import Model.Reservation.*;
import Model.Model;
import Model.Hotel.Hotel;
import Model.Hotel.ManageLuxuryHotel;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);



    }
}