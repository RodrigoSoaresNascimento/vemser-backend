package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a idade em anos desta pessoa : ");
        int idade = scanner.nextInt();
        System.out.print("Digite o mês atual : ");
        int mes = scanner.nextInt();
        System.out.print("Digite a data do dia de hoje : ");
        int dia = scanner.nextInt();
        int anosEmDias = 365 * idade;
        int mesesEmDias = 30 * mes;
        System.out.printf("A idade em dias desta pessoa é de : %d",anosEmDias + mesesEmDias + dia);

    }

}
