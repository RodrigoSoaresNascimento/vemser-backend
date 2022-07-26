import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe sua data de aniversario : ");
        String dataAniversario = scanner.next();

        LocalDate dateTime = LocalDate.parse(dataAniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        Period dataAteAniversario =  Period.between(dateTime,LocalDate.now());

        System.out.println("faltam : "+Math.abs(dataAteAniversario.getMonths()) + "Meses e dias : "+Math.abs(dataAteAniversario.getDays()));

    }


}
