package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[3];
        for(int i = 0; i < array.length; i++){
            System.out.printf("Informe o %d° numero inteiro : ",(i+1));
            array[i] = scanner.nextInt();
        }

        int posicao = 0;
        int menor = array[0];
        for(int j = 0; j < array.length; j++){

            if(array[j] < menor){
                posicao = j;
            }
        }
        System.out.println("O menor numero se encontra na posição de : "+posicao);
    }
}
