package com.bdc.vemser.lista2;

import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        final int numeroEscolhido = random.nextInt(11);
        int numeroDigitado;
        System.out.println("O java vai escolher um numero aleatorio de 0 a 10");
        System.out.println("Sua tarefa é descobrir qual é esse numero!");
        do{
            System.out.println("Escolha um número de 1 a 10!");
            numeroDigitado = scanner.nextInt();
            if(numeroEscolhido > numeroDigitado){
                System.out.println("O numero escolhido é maior que o digitado!");
            }else{
                System.out.println("O numero escolhido é menor que o inserido!");
            }

        }while (numeroDigitado != numeroEscolhido);

        System.out.println("Parabéns!");
    }
}
