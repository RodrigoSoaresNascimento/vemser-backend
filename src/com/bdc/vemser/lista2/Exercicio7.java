package com.bdc.vemser.lista2;

public class Exercicio7 {
    public static void main(String[] args) {
        int[][] matrix = {
                {22,33,66,2},
                {1,8,9,89},
                {99,23,6,8},
                {12,19,3,56}
        };
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
