package lista1;

import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o comprimento da base do retângulo : ");
        double base = scanner.nextDouble();
        System.out.print("Digite o comprimento da altura do retângulo : ");
        double altura = scanner.nextDouble();
        System.out.println(calcularAreaRetanngulo(base,altura));

    }

    public static String calcularAreaRetanngulo (double base, double altura){

        return String.format("A área deste retangulo é : %.2f", (base * altura));
    }
}
