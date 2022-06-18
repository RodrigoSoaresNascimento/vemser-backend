package lista1;

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        double nota = 0;
        for(int i = 1; i <= 4; i++){
            System.out.printf("Digite a %d° nota\n",i);
            nota += scanner.nextDouble();
        }

        System.out.printf("sua média é : %.2f\n É sua situação é : %s",calcularMedia(nota), situacaoAluno(calcularMedia(nota)));
    }
    public static double calcularMedia (double nota){
        return (nota) / 4;
    }

    public static String situacaoAluno (double nota){
        if(nota <= 5){
            return "Reprovado";
        }else if (nota < 7){
            return  "Em exame";
        }else{
            return "Aprovado";
        }
    }
}
