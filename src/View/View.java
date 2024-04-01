/**
 * Identification comments:
 * Name: Supriya Nayak D2B 39
 * Experiment No: 10
 * Experiment Title: Implementing View Class in Java
 using Swing and AWT for your chosen case study using
 MVC Architecture
 * Experiment Date: 19/03/24
 * @version 1.0
 * Beginning comments:
 * Filename: View.java
 * @author: Supriya Nayak
 * Overview: The View class represents the user interface of
an application, and it is responsible for presenting data to
the
 * user and receiving input from them. It is typically
used in the Model-View-Controller (MVC) architectural
pattern,
 * where the View is the part of the application that
interacts with the user and displays information.
 *The class provides methods for setting up initial layouts
for LuxuryHotel,Customer, and Reservation panels, as well as updating
the display with new data. Specifically:
 * - centerInitialSetupLuxuryHotel(linesBeingDisplayed, size):
Sets up the initial layout for the LuxuryHotel panel.
 * - centerInitialSetupCustomer(linesBeingDisplayed, size):
Sets up the initial layout for the Customer panel.
 * - centerInitialSetupReservation(linesBeingDisplayed, size): Sets
up the initial layout for the Reservation panel.
 * - centerUpdateLuxuryHotel(lines, headers): Updates the luxuryHotel
panel with new data.
 * - centerUpdateCustomer(lines, headers): Updates the Customer
panel with new data.
 * - centerUpdateReservation(lines, headers): Updates the
Reservation panel with new data.
 * It also provides getter and setter methods for accessing
and modifying the frames and panels within the application.
 */


package View;

import View.Customer.ManageCustomerFrame;
import View.Hotel.ManageLuxuryHotelFrame;
import View.Reservation.ManageReservationFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManageCustomerFrame mcf;
    ManageLuxuryHotelFrame mhf;

    ManageReservationFrame mrf;

    // Load the background image
    BufferedImage backgroundImage = null;


    public View()
    {

        ff = new FirstFrame();
        mcf = new ManageCustomerFrame();
        mhf = new ManageLuxuryHotelFrame();
        mrf = new ManageReservationFrame();
    }

    public void centerInitialSetupCustomer(int linesBeingDisplayed, int size) {
        mcf.getCustomer_ip().getCpc().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mcf.getCustomer_ip().getCpc().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerInitialSetupLuxuryHotel(int linesBeingDisplayed, int size) {
        mhf.getLuxuryHotel_ip().getHtp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mhf.getLuxuryHotel_ip().getHtp().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerInitialSetupReservation(int linesBeingDisplayed, int size) {
        mrf.getReservation_ip().getRtp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mrf.getReservation_ip().getRtp().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdateHotel(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mhf.getLuxuryHotel_ip().getHtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int hotel_row_no = 0; hotel_row_no < lines.size(); hotel_row_no++)
        {
            for (int hotel_col_no = 0; hotel_col_no < headers.size(); hotel_col_no++)
            {
                int button_no = hotel_row_no * headers.size() + headers.size() + hotel_col_no;
                String button_txt = lines.get(hotel_row_no).get(hotel_col_no);

                mhf.getLuxuryHotel_ip().getHtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdateReservation(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mrf.getReservation_ip().getRtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int reservation_row_no = 0; reservation_row_no < lines.size(); reservation_row_no++)
        {
            for (int reservation_col_no = 0; reservation_col_no < headers.size(); reservation_col_no++)
            {
                int button_no = reservation_row_no * headers.size() + headers.size() + reservation_col_no;
                String button_txt = lines.get(reservation_row_no).get(reservation_col_no);
                if(mrf.getReservation_ip().getRtp().getAllButtons().size() == button_no){
                    break;
                }

                mrf.getReservation_ip().getRtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdateCustomer(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mcf.getCustomer_ip().getCpc().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int customer_row_no = 0; customer_row_no < lines.size(); customer_row_no++)
        {
            for (int customer_col_no = 0; customer_col_no < headers.size(); customer_col_no++)
            {
                int button_no = customer_row_no * headers.size() + headers.size() + customer_col_no;
                String button_txt = lines.get(customer_row_no).get(customer_col_no);

                mcf.getCustomer_ip().getCpc().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

    public void setMcf(ManageCustomerFrame mcf) {
        this.mcf = mcf;
    }

    public ManageCustomerFrame getMcf() {
        return mcf;
    }

    public void setMhf(ManageLuxuryHotelFrame mhf) {
        this.mhf = mhf;
    }

    public ManageLuxuryHotelFrame getMhf() {
        return mhf;
    }

    public void setMrf(ManageReservationFrame mrf) {
        this.mrf = mrf;
    }
    public ManageReservationFrame getMrf() {
        return mrf;
    }
}

