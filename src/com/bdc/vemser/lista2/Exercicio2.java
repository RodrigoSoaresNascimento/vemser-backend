package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int numeroEscolhido = 55;
        int numeroDigitado;

        do{
            System.out.print("Digite um número inteiro aleatorio : ");
            numeroDigitado = scanner.nextInt();
            if(numeroDigitado > 100){
                System.out.println("O numero está muito longe reduza o valor da sua busca!");
            }
            if(numeroDigitado < 100 && numeroDigitado > 80){
                System.out.println("O número está muito maior continue reduzindo o valor!");
            }
            if(numeroDigitado <= 80 && numeroDigitado >= 60){
                System.out.println("O numero ainda está maior mas está se aproximando!");
            }
            if(numeroDigitado < 60 && numeroDigitado > 30){
                System.out.println("Continue está muito mais proximo!");
            }
            if(numeroDigitado < 30){
                System.out.println("O numero está muito menor aumente o valor da busca");
            }

        }while (numeroDigitado != numeroEscolhido);

        System.out.println("Parabéns!");
    }
}
