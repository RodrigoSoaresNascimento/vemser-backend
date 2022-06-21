package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[20];
        for(int i = 0; i < array.length; i++){
            System.out.printf("Informe o %d° numero inteiro : ",(i+1));
            array[i] = scanner.nextInt();
        }
        System.out.println("Imprimindo na ordem iversa os números da lista : ");
        for(int j = array.length - 1 ; j >= 0; j--){
            System.out.println(array[j]);
        }
    }
}
