package Model.Hotel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageLuxuryHotel extends FileHandlingHotel implements Displayable {

    ArrayList<LuxuryHotel> hotels = new ArrayList<LuxuryHotel>();

    ObjectMapper objectMapper = new ObjectMapper();

    String file1 = "src/Model/Hotel/Hotel.json";
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public ManageLuxuryHotel(){
        hotels= readLuxuryHotelJsonFile(file1);
    }
    public ArrayList<LuxuryHotel> readLuxuryHotelJsonFile(String file_path) {
        try {
            hotels.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Initialize the list to store hotels

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int luxuryHotel_idNode = node.get("luxuryHotel_id").asInt();
                    String hotel_NameNode = node.get("hotel_Name").asText();
                    String  hotel_LocationNode = node.get("hotel_Location").asText();
                    String hotel_Contact_numNode = node.get("hotel_Contact_num").asText();
                    double hotel_RatingsNode = node.get("hotel_Ratings").asDouble();
                    String  hotelFacilitiesNode = node.get("hotelFacilities").asText();


                    // Check if nodes are not null before extracting values
                    LuxuryHotel hot = new LuxuryHotel(luxuryHotel_idNode, hotel_NameNode, hotel_LocationNode, hotel_Contact_numNode, hotel_RatingsNode,hotelFacilitiesNode);
                    hotels.add(hot);

                }
            }
            return hotels;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // Return an empty list if an error occurs
    }
    public void writeLuxuryHotelJsonFile(String file_path, ArrayList<LuxuryHotel> hotels) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Hotel/Hotel.json").toFile(), hotels);
        this.objectMapper.writeValue(Paths.get(file_path).toFile(),hotels);
        ArrayList<Map<String, Object>> hotels_to_be_written = new ArrayList<>();

        for (int i = 0; i < hotels.size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("luxuryHotel_id", hotels.get(i).getLuxuryHotel_id());
            data.put("hotel_Name", hotels.get(i).getHotel_Name());
            data.put("hotel_Location", hotels.get(i).getHotel_Location());
            data.put("hotel_Contact_num", hotels.get(i).getHotel_Contact_num());
            data.put("hotel_Ratings", hotels.get(i).getHotel_Ratings());
            data.put("hotelFacilities", hotels.get(i).getHotelFacilities());


            hotels_to_be_written.add(data);

        }
        objectMapper.writeValue(Paths.get(file_path).toFile(), hotels);
    }

    public void setHotelsTable(ArrayList<LuxuryHotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Hotel id");
        headers.add("Hotel name");
        headers.add("Hotel location");
        headers.add("Hotel contact number");
        headers.add("Hotel Ratings");
        headers.add("Hotel facilities");



        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> hotel_details = new ArrayList<String>();
        hotel_details.add(String.valueOf(hotels.get(line).getLuxuryHotel_id()));
        hotel_details.add(hotels.get(line).getHotel_Name());
        hotel_details.add(hotels.get(line).getHotel_Location());
        hotel_details.add(hotels.get(line).getHotel_Contact_num());
        hotel_details.add(String.valueOf(hotels.get(line).getHotel_Ratings()));
        hotel_details.add(String.valueOf(hotels.get(line).getHotelFacilities()));


        return hotel_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> hotels_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            hotels_subset.add(getLine(i));
        }
        return hotels_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<LuxuryHotel> getTable() {
        readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");
        return hotels;
    }
    public void addNewHotel(int luxuryHotel_id, String hotel_Name, String hotel_Location, String hotel_Contact_num,double hotel_Ratings, String hotelFacilities) throws IOException {
        readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");
        LuxuryHotel temp_hot = new LuxuryHotel(luxuryHotel_id,hotel_Name,hotel_Location, hotel_Contact_num,hotel_Ratings,hotelFacilities);
        hotels.add(temp_hot);
        writeLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json",hotels);

    }

    public void editHotel(int edit_hotel_idx, Integer luxuryHotel_id, String hotel_Name, String hotel_Location, String hotel_Contact_num,double hotel_Ratings, String hotelFacilities) throws IOException {
        readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");
        hotels.get(edit_hotel_idx).setLuxuryHotel_id_id(luxuryHotel_id);
        hotels.get(edit_hotel_idx).setHotel_Name(hotel_Name);
        hotels.get(edit_hotel_idx).setHotel_Location(hotel_Location);
        hotels.get(edit_hotel_idx).setHotel_Contact_num(hotel_Contact_num);
        hotels.get(edit_hotel_idx).setHotel_Ratings(hotel_Ratings);
        hotels.get(edit_hotel_idx).setHotelFacilities(hotelFacilities);


        writeLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json",hotels);
    }

    public int deleteHotel(int delete_hotel_idx) throws IOException {
        readLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json");
        hotels.remove(delete_hotel_idx);
        int h_id = hotels.get(delete_hotel_idx).getLuxuryHotel_id();
        writeLuxuryHotelJsonFile("src/Model/Hotel/Hotel.json",hotels);
        return h_id;
    }
}