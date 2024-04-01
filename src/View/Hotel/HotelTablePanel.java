package View.Hotel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HotelTablePanel extends JPanel {

    ArrayList<JButton> hotel_buttons = new ArrayList<>();

    public HotelTablePanel()
    {
        super();
    }

    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setSize(500,50);
            hotel_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void setButtonText(int button_no, String button_text) {
        hotel_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getAllButtons()
    {
        return hotel_buttons;
    }

}


