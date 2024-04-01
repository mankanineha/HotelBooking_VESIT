/**
 * Identification comments:
 * Name: S D2B 39
 * Experiment No: 10
 * Experiment Title: Implementing View Class in Java
 using Swing and AWT for your chosen case study using
 MVC Architecture
 * Experiment Date: 19/03/24
 * @version 1.0
 * Beginning comments:
 * Filename: Controller.java
 * @author: Supriya Nayak
 * Overview: This is the Controller class which serves as a
intermediary between the user interface (View) and the
underlying data and logic (Model). In this file we have
achieved the following
 * - It initializes with references to the model (Model) and
view (View) instances to facilitate communication between
them.
 * - It sets up event listeners for user actions, such as button
clicks, in the view components.
 * - Action listeners for buttons like "Add Hotel", "Get Hotel
Details", "Edit Hotel", "Delete Hotel" (similar actions exist for
Reservation and Customer frames) interact with the model to
perform CRUD (Create, Read, Update, Delete) operations
on the data.
 * - When user actions occur, it responds by invoking
appropriate methods from the model to update the data and
then updating the view to reflect those changes.
 * - It manages the visibility of different view components
based on user actions or application state, ensuring a
smooth user experience.
 *
 */
package Controller;

import Model.Model;
import View.View;

import java.awt.event.*;
import java.io.IOException;
public class Controller {
    Model model;
    View view;
    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        view.getFf().getManageLuxuryHotelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hotel Button Clicked");
                view.getFf().setVisible(false);
                view.getMhf().setVisible(true);
            }
        });

        view.getMhf().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMh().setLinesBeingDisplayed(10);
        view.centerInitialSetupLuxuryHotel(model.getMh().getLinesBeingDisplayed(), model.getMh().getHeaders().size());

        model.getMh().setFirstLineToDisplay(0);
        view.centerUpdateHotel(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());
        view.getMhf().getLuxuryHotel_ip().getHtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMh().getFirstLineToDisplay();
                int current_last_line = model.getMh().getLastLineToDisplay();
                int no_of_hotels = model.getMh().getTable().size();
                int no_of_display_lines = model.getMh().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMh().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMh().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_hotels-1)
                {
                    model.getMh().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_hotels-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_hotels - no_of_display_lines)
                    {
                        new_first_line = no_of_hotels -no_of_display_lines;
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateHotel(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());
            }
        });
        view.getMhf().getLuxuryHotel_ip().getAhp().getAddHotelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_LuxuryHotel_id = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_LuxuryHotel_id().getText();
                String txt_Hotel_Name = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_Hotel_Name().getText();
                String txt_Hotel_Location = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_Hotel_Location().getText();
                String txt_Hotel_Contact_num = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_Hotel_Contact_num().getText();
                String txt_Hotel_Ratings = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_Hotel_Ratings().getText();
                String txt_HotelFacilities = view.getMhf().getLuxuryHotel_ip().getAhp().getTxt_HotelFacilities().getText();
                try {
                    model.getMh().addNewHotel(Integer.valueOf(txt_LuxuryHotel_id), txt_Hotel_Name, txt_Hotel_Location, txt_Hotel_Contact_num,  Double.parseDouble(txt_Hotel_Ratings),txt_HotelFacilities);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMhf().getLuxuryHotel_ip().getEhp().getGetHotelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Hotel Details Clicked");
                String txt_hotel_idx = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_get_hotel_idx().getText();
                model.getMh().readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");

                int LuxuryHotel_id = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getLuxuryHotel_id();
                String Hotel_Name = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getHotel_Name();
                String Hotel_Location = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getHotel_Location();
                String Hotel_Contact_num = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getHotel_Contact_num();
                Double Hotel_Ratings = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getHotel_Ratings();
                String HotelFacilities = model.getMh().getTable().get(Integer.valueOf(txt_hotel_idx)).getHotelFacilities();

                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_LuxuryHotel_id().setText(String.valueOf(LuxuryHotel_id));
                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_name().setText(Hotel_Name);
                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Location().setText(Hotel_Location);
                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Contact_number().setText(Hotel_Contact_num);
                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Rating().setText(String.valueOf(Hotel_Ratings));
                view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Facilities().setText(HotelFacilities);


            }
        });

        view.getMhf().getLuxuryHotel_ip().getEhp().getEditHotelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Hotel Button Clicked");
                String txt_edit_hotel_idx = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_get_hotel_idx().getText();
                String txt_luxuryHotel_id = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_LuxuryHotel_id().getText();
                String txt_hotel_Name = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_name().getText();
                String txt_hotel_Location = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Location().getText();
                String txt_hotel_Contact_num = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Contact_number().getText();
                String txt_hotel_Ratings = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Rating().getText();
                String txt_hotelFacilities = view.getMhf().getLuxuryHotel_ip().getEhp().getTxt_Hotel_Facilities().getText();

                try {
                    model.getMh().editHotel(Integer.valueOf(txt_edit_hotel_idx), Integer.valueOf(txt_luxuryHotel_id), txt_hotel_Name, txt_hotel_Location, txt_hotel_Contact_num, Double.parseDouble(txt_hotel_Ratings), txt_hotelFacilities);
                    view.centerUpdateHotel(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMhf().getLuxuryHotel_ip().getDhp().getBtn_del_hotel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Hotel Button Clicked");
                String txt_hotel_idx = view.getMhf().getLuxuryHotel_ip().getDhp().getTxt_del_hotel_idx().getText();
                try {
                    int h_id = model.getMh().deleteHotel(Integer.valueOf(txt_hotel_idx));
                    for (int i = 0; i < model.getMh().getTable().size(); i++) {
                        if (h_id == model.getMh().getTable().get(i).getLuxuryHotel_id()) {
                            {
                                model.getMh().deleteHotel(i);
                                break;
                            }
                        }
                    }
                    //view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());
                    view.centerUpdateHotel(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());
                    view.getMhf().repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getFf().getManageReservationBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reservation Button Clicked");
                view.getFf().setVisible(false);
                view.getMrf().setVisible(true);
            }
        });

        view.getMrf().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMr().setLinesBeingDisplayed(10);
        view.centerInitialSetupReservation(model.getMr().getLinesBeingDisplayed(), model.getMr().getHeaders().size());

        model.getMr().setFirstLineToDisplay(0);
        view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());

        view.getMrf().getReservation_ip().getRtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMr().getFirstLineToDisplay();
                int current_last_line = model.getMr().getLastLineToDisplay();
                int no_of_reservations = model.getMr().getTable().size();
                int no_of_display_lines = model.getMr().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMr().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMr().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMr().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_reservations-1)
                {
                    model.getMr().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_reservations-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_reservations - no_of_display_lines)
                    {
                        new_first_line = no_of_reservations -no_of_display_lines;
                        model.getMr().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMr().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());
            }
        });

        view.getMrf().getReservation_ip().getArp().getAddReservationBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_Payment = view.getMrf().getReservation_ip().getArp().getTxt_Payment().getText();
                String txt_customer_id = view.getMrf().getReservation_ip().getArp().getCustomer_id().getText();
                String txt_luxuryHotel_id = view.getMrf().getReservation_ip().getArp().getLuxuryHotel_id().getText();
                String txt_Check_out_Date = view.getMrf().getReservation_ip().getArp().getTxt_Check_out_Date().getText();
                String txt_Reservation_Id = view.getMrf().getReservation_ip().getArp().getTxt_Reservation_id().getText();
                String txt_Check_in_Date = view.getMrf().getReservation_ip().getArp().getTxt_Check_in_Date().getText();
                try {
                    model.getMr().addNewReservation(Integer.valueOf(txt_Payment),Integer.valueOf(txt_customer_id),Integer.valueOf(txt_luxuryHotel_id), txt_Check_out_Date,Integer.valueOf(txt_Reservation_Id),txt_Check_in_Date);
                    view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMrf().getReservation_ip().getErp().getGetReservationBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Reservation Details Clicked");
                String txt_reservation_idx = view.getMrf().getReservation_ip().getErp().getTxt_get_reservation_idx().getText();
                model.getMr().readReservationJsonFile("src/Model/Reservation/Reservation.json");
                int Payment = model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getPayment();
                int c_id= model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getC_temp().getCustomer_id();
                int h_id= model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getH_temp().getLuxuryHotel_id();
                String Check_out_Date = model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getCheck_out_Date();
                int Reservation_id = model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getReservation_Id();
                String Check_in_Date = model.getMr().getTable().get(Integer.valueOf(txt_reservation_idx)).getCheck_in_Date();
                view.getMrf().getReservation_ip().getErp().getTxt_Payment().setText(String.valueOf(Payment));
                view.getMrf().getReservation_ip().getErp().getTxt_customer_id().setText(String.valueOf(c_id));
                view.getMrf().getReservation_ip().getErp().getTxt_luxuryHotel_id().setText(String.valueOf(h_id));
                view.getMrf().getReservation_ip().getErp().getTxt_Check_out_Date().setText(Check_out_Date);
                view.getMrf().getReservation_ip().getErp().getTxt_Reservation_id().setText(String.valueOf(Reservation_id));
                view.getMrf().getReservation_ip().getErp().getTxt_Check_in_Date().setText(Check_in_Date);
            }
        });

        view.getMrf().getReservation_ip().getErp().getEditReservationBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Reservation Button Clicked");
                String txt_reservation_idx = view.getMrf().getReservation_ip().getErp().getTxt_get_reservation_idx().getText();
                String txt_Payment = view.getMrf().getReservation_ip().getErp().getTxt_Payment().getText();
                String txt_customer_idx = view.getMrf().getReservation_ip().getErp().getTxt_customer_id().getText();
                String txt_hotel_idx = view.getMrf().getReservation_ip().getErp().getTxt_luxuryHotel_id().getText();
                String txt_Reservation_id = view.getMrf().getReservation_ip().getErp().getTxt_Reservation_id().getText();
                String txt_Check_out_Date = view.getMrf().getReservation_ip().getErp().getTxt_Check_out_Date().getText();
                String txt_Check_in_Date = view.getMrf().getReservation_ip().getErp().getTxt_Check_in_Date().getText();
                try {
                    model.getMr().editReservation(Integer.valueOf(txt_reservation_idx), Integer.valueOf(txt_Payment),Integer.valueOf(txt_customer_idx),Integer.valueOf(txt_hotel_idx), txt_Check_out_Date,Integer.valueOf(txt_Reservation_id),txt_Check_in_Date);
                    view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMrf().getReservation_ip().getDrp().getDeleteReservationBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Reservation Button Clicked");
                String txt_reservation_idx = view.getMrf().getReservation_ip().getDrp().getTxt_del_reservation_idx().getText();
                try {
                    model.getMr().deleteReservation(Integer.parseInt(txt_reservation_idx));
                    view.centerUpdateReservation(model.getMr().getLines(model.getMr().getFirstLineToDisplay(), model.getMr().getLastLineToDisplay()), model.getMr().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getFf().getManageCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Customer Button Clicked");
                view.getFf().setVisible(false);
                view.getMcf().setVisible(true);
            }
        });


        view.getMcf().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMc().setLinesBeingDisplayed(10);
        view.centerInitialSetupCustomer(model.getMc().getLinesBeingDisplayed(), model.getMc().getHeaders().size());

        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateCustomer(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
        view.getMcf().getCustomer_ip().getCpc().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_customers = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_customers-1)
                {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_customers-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_customers - no_of_display_lines)
                    {
                        new_first_line = no_of_customers -no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateCustomer(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });

        view.getMcf().getCustomer_ip().getApc().getAddCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_Customer_id = view.getMcf().getCustomer_ip().getApc().getTxt_Customer_id().getText();
                String txt_First_name = view.getMcf().getCustomer_ip().getApc().getTxt_First_name().getText();
                String txt_last_name = view.getMcf().getCustomer_ip().getApc().getTxt_Last_name().getText();
                String txt_Email = view.getMcf().getCustomer_ip().getApc().getTxt_Email().getText();
                String txt_Mobile_number = view.getMcf().getCustomer_ip().getApc().getTxt_Mobile_number().getText();
                String txt_Identification_type = view.getMcf().getCustomer_ip().getApc().getTxt_Identification_type().getText();
                try {
                    model.getMc().addNewCustomer(Integer.parseInt(txt_Customer_id), txt_First_name, txt_last_name,txt_Email,txt_Mobile_number,txt_Identification_type);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMcf().getCustomer_ip().getEcp().getGetCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Customer Details Clicked");
                String txt_customer_idx = view.getMcf().getCustomer_ip().getEcp().getTxt_get_customer_idx().getText();
                model.getMc().readCustomerJsonFile("src/Model/Customer/Customer.json");
                int customer_id = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getCustomer_id();
                String First_name = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getFirst_name();
                String Last_name = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getLast_name();
                String Email = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getEmail();
                String Mobile_number = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getMobile_number();
                String Identification_type = model.getMc().getTable().get(Integer.valueOf(txt_customer_idx)).getIdentification_type();
                view.getMcf().getCustomer_ip().getEcp().getTxt_Customer_id().setText(String.valueOf(customer_id));
                view.getMcf().getCustomer_ip().getEcp().getTxt_First_name().setText(First_name);
                view.getMcf().getCustomer_ip().getEcp().getTxt_Last_name().setText(Last_name);
                view.getMcf().getCustomer_ip().getEcp().getTxt_Email().setText(Email);
                view.getMcf().getCustomer_ip().getEcp().getTxt_Mobile_number().setText(Mobile_number);
                view.getMcf().getCustomer_ip().getEcp().getTxt_Identification_type().setText(Identification_type);
            }
        });

        view.getMcf().getCustomer_ip().getEcp().getEditCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Customer Button Clicked");
                String txt_customer_idx = view.getMcf().getCustomer_ip().getEcp().getTxt_get_customer_idx().getText();
                String txt_Customer_id = view.getMcf().getCustomer_ip().getEcp().getTxt_Customer_id().getText();
                String txt_First_name = view.getMcf().getCustomer_ip().getEcp().getTxt_First_name().getText();
                String txt_Last_name = view.getMcf().getCustomer_ip().getEcp().getTxt_Last_name().getText();
                String txt_Email = view.getMcf().getCustomer_ip().getEcp().getTxt_Email().getText();
                String txt_Mobile_number = view.getMcf().getCustomer_ip().getEcp().getTxt_Mobile_number().getText();
                String txt_Identification_type = view.getMcf().getCustomer_ip().getEcp().getTxt_Identification_type().getText();
                try {
                    model.getMc().editCustomer(Integer.valueOf(txt_customer_idx), Integer.valueOf(txt_Customer_id), txt_First_name, txt_Last_name, txt_Email, txt_Mobile_number, txt_Identification_type);
                    view.centerUpdateCustomer(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMcf().getCustomer_ip().getDcp().getDeleteCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Customer Button Clicked");
                String txt_customer_idx = view.getMcf().getCustomer_ip().getDcp().getTxt_del_customer_idx().getText();
                try {
                    model.getMc().deleteCustomer(Integer.valueOf(txt_customer_idx));
                    view.centerUpdateCustomer(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

