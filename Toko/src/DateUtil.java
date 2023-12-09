import java.text.SimpleDateFormat;
import java.util.Date;

//Methods for String
class DateUtil {
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    public static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss Z");
        return timeFormat.format(new Date());
    }

    public static String getCurrentDateTime() {
        String formattedDate = getCurrentDate();
        String formattedTime = getCurrentTime();
        return "Tanggal : " + formattedDate + "\nWaktu   : " + formattedTime;
    }

}