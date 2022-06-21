package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        //questão 1
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome : ");
        String nome = scan.nextLine();
        System.out.print("Digite sua idade : ");
        int idade = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite sua cidade : ");
        String cidade = scan.nextLine();
        System.out.print("Digite seu estado : ");
        String estado = scan.nextLine();

        System.out.print(String.format("Olá seu nome %s, você tem %d anos," +
                "é da cidade de %s, situada no estado de %s ",nome,idade,cidade,estado));
    }

}
