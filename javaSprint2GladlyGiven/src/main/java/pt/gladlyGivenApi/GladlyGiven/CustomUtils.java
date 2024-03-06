package pt.gladlyGivenApi.GladlyGiven;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomUtils {
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public static String getDateAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CustomUtils.dateFormat);
        return dateFormat.format(new Date());
    }
}
