package Model.Hotel;

public class LuxuryHotel extends Hotel {
    private static int LuxuryHotel_count = 0;
    private int luxuryHotel_id;
    private String hotelFacilities;

    public static int getLuxuryHotel_count() {
        return LuxuryHotel_count;
    }

    public LuxuryHotel() {
        LuxuryHotel_count++;
        this.setLuxuryHotel_id_id(LuxuryHotel_count);
    }

    public LuxuryHotel( String hotel_Name, String hotel_Location, String hotel_Contact_num, double hotel_Ratings,String hotelFacilities) {
        super(hotel_Name, hotel_Location, hotel_Contact_num, hotel_Ratings);
        LuxuryHotel_count++;
        this.setLuxuryHotel_id_id(LuxuryHotel_count);
        this.setHotelFacilities(hotelFacilities);
    }

    public LuxuryHotel(int luxuryHotel_id, String hotel_Name, String hotel_Location, String hotel_Contact_num, double hotel_Ratings,String hotelFacilities) {
        super(hotel_Name, hotel_Location, hotel_Contact_num, hotel_Ratings);
        LuxuryHotel_count++;
        this.setLuxuryHotel_id_id(luxuryHotel_id);
        this.setHotelFacilities(hotelFacilities);
    }

    public void setLuxuryHotel_id_id(int luxuryHotel_id) {
        this.luxuryHotel_id = luxuryHotel_id;
    }

    public void setHotelFacilities(String hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }


    public int getLuxuryHotel_id() {
        return luxuryHotel_id;
    }

    public String getHotelFacilities() {
        return hotelFacilities;
    }

    public void display() {
        System.out.println("Luxury Hotel Id: " + getLuxuryHotel_id());
        System.out.println("Hotel Facilities: " + getHotelFacilities());
        super.display();
    }
}

