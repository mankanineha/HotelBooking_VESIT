package Model.Reservation;

import Model.Hotel.LuxuryHotel;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingReservation {
    protected abstract ArrayList<Reservation> readReservationJsonFile(String file_path);
    protected abstract void writeReservationJsonFile(String file_path, ArrayList<Reservation> reservations) throws IOException;
}
