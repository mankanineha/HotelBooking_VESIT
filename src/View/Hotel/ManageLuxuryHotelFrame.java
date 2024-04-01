package View.Hotel;
import javax.swing.*;

public class ManageLuxuryHotelFrame extends JFrame {
    InitialPanelHotel LuxuryHotel_ip;

    public ManageLuxuryHotelFrame()
    {
        super("Manage Hotel DashBoard");
        LuxuryHotel_ip = new InitialPanelHotel();
        add(LuxuryHotel_ip);
        pack();
        setSize(1200, 600);
    }

    public void setLuxuryHotel_ip(InitialPanelHotel LuxuryHotel_ip) {
        this.LuxuryHotel_ip = LuxuryHotel_ip;
    }

    public InitialPanelHotel getLuxuryHotel_ip() {
        return LuxuryHotel_ip;
    }
}


