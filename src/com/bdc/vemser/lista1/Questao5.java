package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o valor da hora do funcionario : ");
        double valorHora = scan.nextDouble();
        System.out.print("Digite o numero das horas trabalhadas : ");
        double horasTrabalhadas = scan.nextDouble();
        System.out.print("Digite o número de horas extras com 50% da remuneração : ");
        double horasExtrasMetade = scan.nextDouble();
        System.out.print("Digite o número de horas extras com 100% da remuneração : ");
        double horasExtrasIntegral = scan.nextDouble();
        System.out.printf("O salario é : %.2f\n",(horasTrabalhadas * valorHora) + (horasExtrasMetade * valorHora * 1.5) + (horasExtrasIntegral * valorHora * 2));
        scan.close();
    }

}
