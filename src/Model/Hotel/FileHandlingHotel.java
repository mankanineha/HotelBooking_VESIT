package Model.Hotel;
import java.io.IOException;
import java.util.ArrayList;
public abstract class FileHandlingHotel{
    protected abstract ArrayList<LuxuryHotel> readLuxuryHotelJsonFile(String file_path);
    protected abstract void writeLuxuryHotelJsonFile(String file_path, ArrayList<LuxuryHotel> hotels) throws IOException;
}
