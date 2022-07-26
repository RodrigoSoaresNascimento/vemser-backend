import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe uma data : ");
        String data1 = scanner.nextLine();

        System.out.print("Informe outra data : ");
        String data2 = scanner.nextLine();

        LocalDate dateTime = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dateTime2 = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period diferençaEntreDatas =  Period.between(dateTime,dateTime2);

        System.out.println("A difereça entre as datas é : "+Math.abs(diferençaEntreDatas.getMonths()) + " Meses e dias : "+Math.abs(diferençaEntreDatas.getDays())+ " anos :"+Math.abs(diferençaEntreDatas.getYears()));

        scanner.close();
    }
}
