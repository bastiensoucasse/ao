package facade;

import java.text.ParseException;

public class FacadePattern {
    public static void main(String[] args) throws ParseException {
        UserFriendlyDate d = new UserFriendlyDate("1980-08-20");
        System.out.println("Date: " + d.toString());
        d.addDays(20);
        System.out.println("20 days after: " + d.toString());
    }
}
