package pl.tgrzybowski.dreamclinic.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private final static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Date format(Date date) {
        try {
            return formatter.parse(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
