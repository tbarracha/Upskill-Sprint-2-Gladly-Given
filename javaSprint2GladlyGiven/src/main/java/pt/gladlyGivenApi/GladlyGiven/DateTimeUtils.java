// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class responsible for handling DateTime operations
 */
public class DateTimeUtils {
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public static String getDateTimeNowAsString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateTimeUtils.dateFormat);
        return dateFormat.format(new Date());
    }

    public static Date getDateTimeNow() {
        return new Date();
    }
}
