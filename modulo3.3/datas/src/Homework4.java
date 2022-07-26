import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Homework4 {

    public static void main(String[] args) {
        LocalDateTime dataLocal = LocalDateTime.now();
        ZoneId sp = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime agoraZdt = ZonedDateTime.of(dataLocal, sp);
        LocalDateTime dataDoShow = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId londres = ZoneId.of("Europe/London");
        ZonedDateTime showZdt = ZonedDateTime.of(dataDoShow, londres);

        long anos = agoraZdt.until(showZdt, ChronoUnit.YEARS);
        agoraZdt = agoraZdt.plusYears(anos);
        long meses = agoraZdt.until(showZdt, ChronoUnit.MONTHS);
        agoraZdt = agoraZdt.plusMonths(meses);
        long dias = agoraZdt.until(showZdt, ChronoUnit.DAYS);
        agoraZdt = agoraZdt.plusDays(dias);
        long horas = agoraZdt.until(showZdt, ChronoUnit.HOURS);
        agoraZdt = agoraZdt.plusHours(horas);
        long minutos = agoraZdt.until(showZdt, ChronoUnit.MINUTES);
        agoraZdt = agoraZdt.plusMinutes(minutos);
        long segundos = agoraZdt.until(showZdt, ChronoUnit.SECONDS);
        System.out.println("Faltam "+anos+" anos, "+meses+" meses, "+dias+" dias, "+horas
                +" horas, "+minutos+", minutos e "+segundos+" segundos para o evento");
    }

}
