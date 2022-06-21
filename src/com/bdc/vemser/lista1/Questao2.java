package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        double nota = 0;
        for(int i = 1; i <= 4; i++){
            System.out.printf("Digite a %d° nota\n",i);
            nota += scanner.nextDouble();
        }

        String situacaoAluno = "";
        if(nota <= 5){
            situacaoAluno = "Reprovado";
        }else if (nota < 7){
            situacaoAluno =  "Em exame";
        }else{
            situacaoAluno = "Aprovado";
        }

        System.out.printf("sua média é : %.2f\nÉ sua situação é : %s",(nota) / 4, situacaoAluno);
    }

}
