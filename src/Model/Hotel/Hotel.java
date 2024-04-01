package Model.Hotel;
public class Hotel {
    private String hotel_Name;
    private String hotel_Location;
    private String hotel_Contact_num;
    private double hotel_Ratings;

    public Hotel() {
        System.out.println("Creating a Hotel");

    }
    public Hotel(String hotel_Name, String hotel_Location, String hotel_Contact_num, double hotel_Ratings) {
        this.setHotel_Name(hotel_Name);
        this.setHotel_Location(hotel_Location);
        this.setHotel_Contact_num(hotel_Contact_num);
        this.setHotel_Ratings(hotel_Ratings);
    }
    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }


    public void setHotel_Location(String hotel_Location) {
        this.hotel_Location = hotel_Location;
    }

    public void setHotel_Contact_num(String hotel_Contact_num) {
        this.hotel_Contact_num = hotel_Contact_num;
    }
    public void setHotel_Ratings(double hotel_Ratings) {
        this.hotel_Ratings = hotel_Ratings;
    }

    public String getHotel_Name()
    {
        return hotel_Name;
    }
    public String getHotel_Location()
    {
        return hotel_Location;
    }
    public String getHotel_Contact_num()
    {
        return hotel_Contact_num;
    }
    public double getHotel_Ratings()
    {
        return hotel_Ratings;
    }

    public void display()
    {

        System.out.println("Enter Hotel's name:"+ getHotel_Name());
        System.out.println("Enter Hotel's location:"+ getHotel_Location());
        System.out.println("Enter Hotel's contact_num:"+ getHotel_Contact_num());

        System.out.println("Enter Hotel's ratings:"+ getHotel_Ratings());

    }

}