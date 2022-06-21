package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {22,33,66,1,78,99,36,45,50,14};
        System.out.print("Informe o número inteiro a ser pesquisado : ");
        int numero = scanner.nextInt();
        boolean achouNumero = false;
        int posicao = 0;
        for(int busca = 0; busca < array.length; busca++){
            if(array[busca] == numero){
                achouNumero = true;
                posicao = busca;
            }
        }
       if(achouNumero){
           System.out.printf("O numero %d está na lista na posição %d",numero,(posicao+1));
       }else{
           System.out.println("O numero não se encontra na lista ");
       }
    }
}
