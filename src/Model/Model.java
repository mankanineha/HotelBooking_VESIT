package Model;

import Model.Customer.ManageCustomer;
import Model.Hotel.ManageLuxuryHotel;
import Model.Reservation.ManageReservation;

public class Model {
    ManageCustomer mc;
    ManageLuxuryHotel mh;
    ManageReservation mr;

    public Model() {
        mc = new ManageCustomer();
        mh = new ManageLuxuryHotel();
        mr = new ManageReservation();
    }

    public ManageCustomer getMc() {
        return mc;
    }

    public ManageLuxuryHotel getMh() {
        return mh;
    }

    public ManageReservation getMr() {
        return mr;
    }

    public void setMc(ManageCustomer mc) {
        this.mc = mc;
    }

    public void setMh(ManageLuxuryHotel mh) {
        this.mh = mh;
    }

    public void setMr(ManageReservation mr) {
        this.mr = mr;
    }
}
