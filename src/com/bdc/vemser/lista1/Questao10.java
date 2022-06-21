package com.bdc.vemser.lista1;

import java.util.Locale;
import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o numero de eleitores : ");
        int populacaoTotal = scanner.nextInt();
        System.out.print("Informe o numero de votos em branco : ");
        int votosBrancos = scanner.nextInt();
        System.out.print("Informe o numero de votos em nulos : ");
        int votosNulos = scanner.nextInt();
        System.out.print("Informe o numero de votos em invalidos : ");
        int votosInvalidos = scanner.nextInt();
        if(populacaoTotal <= 0){
            System.out.println("População invalida! informe um valor positivo!");
        }else{
            double porcentagemBrancos = (votosBrancos/(double) populacaoTotal) * 100;
            double porcentagemNulos = (votosNulos/(double) populacaoTotal) * 100;
            double porcentagemInvalidos = (votosInvalidos/(double) populacaoTotal) * 100;
            System.out.printf(Locale.US,"A porcentagem de votos em branco foi de : %.2f %%\n" +
                    "A porcentagem de votos em nulo foi de : %.2f %%\n" +
                    "A porcentagem de votos Invalidos foi de : %.2f %%", porcentagemBrancos,porcentagemNulos,porcentagemInvalidos);
        }

    }

}
