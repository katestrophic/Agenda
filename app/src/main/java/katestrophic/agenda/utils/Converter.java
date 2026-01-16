package katestrophic.agenda.utils;

import androidx.room.TypeConverter;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @purpose Room doesn't natively store ArrayList, converter turns directory (directoryNav)
 *          into a single String (and back) for the SQLite database
 */
public class Converter {
    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        if (value == null || value.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(value.split("\\|"))); // Using pipe as delimiter
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        if (list == null || list.isEmpty()) return "";
        return String.join("|", list);
    }
}