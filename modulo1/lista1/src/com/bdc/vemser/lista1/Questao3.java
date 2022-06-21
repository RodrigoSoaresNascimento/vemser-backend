package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor total da conta : ");
        double totalConsumido = scanner.nextDouble();
        System.out.print("Digite o valor que foi recebido do cliente : ");
        double valorPago = scanner.nextDouble();
        if(valorPago < totalConsumido){
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido!");
        }else{
            System.out.println(String.format("O seu troco é de : %.2f.", (valorPago - totalConsumido)));
        }

    }

}
