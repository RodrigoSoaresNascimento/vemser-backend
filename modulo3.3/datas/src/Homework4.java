import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Homework4 {

    public static void main(String[] args) {
        LocalDateTime dataDoShow = LocalDateTime.parse("2024-09-14T18:30:00.000",
                DateTimeFormatter.ISO_DATE_TIME);

        LocalDateTime diaAtual = LocalDateTime.now();

        long anos = diaAtual.until(dataDoShow, ChronoUnit.YEARS);
        diaAtual = diaAtual.plusYears(anos);

        long meses = diaAtual.until(dataDoShow, ChronoUnit.MONTHS);
        diaAtual = diaAtual.plusMonths(meses);

        long dias = diaAtual.until(dataDoShow, ChronoUnit.DAYS);
        diaAtual = diaAtual.plusDays(dias);

        long horas = diaAtual.until(dataDoShow, ChronoUnit.HOURS);

        diaAtual = diaAtual.plusHours(horas);
        long minutos = diaAtual.until(dataDoShow, ChronoUnit.MINUTES);

        System.out.println("Anos: " + anos);
        System.out.println("Meses: " + meses);
        System.out.println("Dias: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);

    }

}
