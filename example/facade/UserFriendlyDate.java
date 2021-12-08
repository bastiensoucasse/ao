package facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserFriendlyDate {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public UserFriendlyDate(String isodateYMD) throws ParseException {
        Date date = sdf.parse(isodateYMD);
        cal.setTime(date);
    }

    public void addDays(int days) {
        cal.add(Calendar.DAY_OF_MONTH, days);
    }

    public String toString() {
        return sdf.format(cal.getTime());
    }
}
