package datacenter.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateService {

    public static String getFormattedDateUniversal(String unformattedDate) throws ParseException {
        if (unformattedDate.substring(0,15).contains(":")) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(unformattedDate.substring(0,10));
            return new SimpleDateFormat("yyyyMMdd").format(date);
        }
        else {
            Date date = new SimpleDateFormat("EEE MMM dd yyyy").parse(unformattedDate.substring(0,15));
            return new SimpleDateFormat("yyyyMMdd").format(date);
        }
    }

}
