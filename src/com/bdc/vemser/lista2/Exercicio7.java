package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[4][4];
        for(int linha = 0; linha < matrix[0].length; linha++){
            for(int coluna = 0; coluna < matrix.length; coluna++ ){
                System.out.print("Digite um numero inteiro : ");
                matrix[linha][coluna] = scanner.nextInt();
            }
        }
        int contador = 0;
        for(int linha = 0; linha < matrix[0].length; linha++){
            for(int coluna = 0; coluna < matrix.length; coluna++ ){
                if(matrix[linha][coluna] > 10){
                    contador++;
                }
            }
        }
        System.out.printf("A matriz possui %d numeros maiores do que 10",contador);
    }
}
