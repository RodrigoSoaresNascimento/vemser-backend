package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double maiorNota = 0;
        double[][] matrix = new double[5][4];
        double somatorio = 0;
        double MatriculaMaiorNota = 0;
        for (int coluna = 0; coluna < matrix.length; coluna++) {
            for (int linha = 0; linha < matrix[0].length; linha++) {
                    if (linha == 0) {
                        System.out.println("Informe o número da matricula");
                        matrix[coluna][linha] = scanner.nextInt();
                    }
                    if (linha == 1) {
                        System.out.println("Informe a média das provas");
                        matrix[coluna][linha] = scanner.nextDouble();
                    }
                    if (linha == 2) {
                        System.out.println("Informe a media dos trabalhos");
                        matrix[coluna][linha] = scanner.nextDouble();
                    }
                    if (linha == 3) {
                        matrix[coluna][linha] = (matrix[coluna][1] * 0.6) + (matrix[coluna][2] * 0.4);
                        somatorio += matrix[coluna][linha];
                        if (matrix[coluna][linha] > maiorNota) {
                            maiorNota = matrix[coluna][linha];
                            MatriculaMaiorNota = matrix[coluna][0];
                        }
                    }
                }
            }
            System.out.printf("A matricula que teve a maior nota final foi : %.0f\n", MatriculaMaiorNota);
            System.out.printf("A media das notas finais é de : %.2f", (somatorio / matrix.length));
        }

    }
