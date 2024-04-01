package Model.Reservation;

import Model.Customer.Customer;
import Model.Hotel.LuxuryHotel;

public class Reservation {
    LuxuryHotel h_temp;
    Customer c_temp;
    int Reservation_Id;
    String Check_in_Date;
    String Check_out_Date;
    int Payment;

    public Reservation(){

    }

    public Reservation( int Payment,Customer c,LuxuryHotel h,String Check_out_Date, int Reservation_Id,String Check_in_Date)
    {
        setPayment(Payment);
        setC_temp(c);
        setH_temp(h);
        setCheck_out_Date(Check_out_Date);
        setReservation_Id(Reservation_Id);
        setCheck_in_Date(Check_in_Date);


    }



    public void setC_temp(Customer c_temp) {
        this.c_temp = c_temp;
    }

    public void setH_temp(LuxuryHotel h_temp) {
        this.h_temp = h_temp;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public void setReservation_Id(int reservation_Id) {
        Reservation_Id = reservation_Id;
    }

    public void setCheck_in_Date(String check_in_Date) {
        Check_in_Date = check_in_Date;
    }

    public void setCheck_out_Date(String check_out_Date) {
        Check_out_Date = check_out_Date;
    }

    public Customer getC_temp() {
        return c_temp;
    }

    public LuxuryHotel getH_temp() {
        return h_temp;
    }

    public String getCheck_in_Date() {
        return Check_in_Date;
    }

    public String getCheck_out_Date() {
        return Check_out_Date;
    }

    public int getPayment() {
        return Payment;
    }

    public int getReservation_Id() {
        return Reservation_Id;
    }
}
