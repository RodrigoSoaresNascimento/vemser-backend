import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Homework4 {

    public static void main(String[] args) {

        LocalDateTime minhaData = LocalDateTime.parse("14/09/2024 18:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        LocalDateTime dataAteOEvento = minhaData
                .minusYears(LocalDateTime.now().getYear())
                .minusMonths(LocalDateTime.now().getMonthValue())
                .minusDays(LocalDateTime.now().getDayOfMonth())
                .minusHours(LocalDateTime.now().getHour())
                .minusMinutes(LocalDateTime.now().getMinute());

        System.out.printf("Tempo ate o evento %d anos , %d meses , %d dias, e %d:%d ",dataAteOEvento.getYear(),
                dataAteOEvento.getMonthValue()
                        ,dataAteOEvento.getDayOfMonth()
        ,dataAteOEvento.getHour()
        ,dataAteOEvento.getMinute());

    }

}
