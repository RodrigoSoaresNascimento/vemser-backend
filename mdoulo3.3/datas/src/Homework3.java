import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Homework3 {

    public static void main(String[] args) {

        LocalDateTime minhaData = LocalDateTime.now();
        System.out.println(minhaData.getDayOfYear());
        minhaData = minhaData.plusDays(15);
        minhaData.plusHours(10);
        System.out.printf("%s",minhaData.getDayOfWeek());
        System.out.println(" dias do ano corrido : "+minhaData.getDayOfYear());
    }


}
