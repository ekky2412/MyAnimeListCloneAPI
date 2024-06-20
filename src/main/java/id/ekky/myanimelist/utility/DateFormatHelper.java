package id.ekky.myanimelist.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatHelper {
    static Locale loc = new Locale("id", "ID");
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy" , loc);

    public static String dateFormat(LocalDate date){
        return date.format(dateTimeFormatter);
    }
}
