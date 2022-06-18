package lista1;

import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a idade em anos desta pessoa : ");
        int idade = scanner.nextInt();
        System.out.print("Digite o numero equivalente ao mês atual : ");
        int mes = scanner.nextInt();
        System.out.print("Digite a data do dia de hoje : ");
        int dia = scanner.nextInt();
        System.out.println(calcularIdadeDias(idade,mes,dia));

    }

    public static String calcularIdadeDias (int anos, int meses, int dias){

        int anosEmDias = 365 * anos;
        int mesesEmDias = 30 * meses;

        return String.format("A idade em dias desta pessoa é de : %d", (anosEmDias + mesesEmDias + dias));
    }

}
