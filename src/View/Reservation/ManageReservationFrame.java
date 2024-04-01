package View.Reservation;

import Model.Reservation.ManageReservation;
import View.Hotel.InitialPanelHotel;
import View.Reservation.InitialPanelReservation;

import javax.swing.*;

public class ManageReservationFrame extends JFrame {
    InitialPanelReservation Reservation_ip;

    public ManageReservationFrame()
    {
        super("Manage Reservation DashBoard");
        Reservation_ip = new InitialPanelReservation();
        add(Reservation_ip);
        pack();
        setSize(1200, 600);
    }

    public void setReservation_ip(InitialPanelReservation Reservation_ip) {
        this.Reservation_ip = Reservation_ip;
    }

    public InitialPanelReservation getReservation_ip() {
        return Reservation_ip;
    }
}

