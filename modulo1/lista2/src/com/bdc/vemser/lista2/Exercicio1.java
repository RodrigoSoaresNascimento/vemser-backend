package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto : ");
        String nomeProduto = scanner.nextLine();
        while (nomeProduto.equals(null)){
            System.out.print("O nome do produto não pode ser nulo insira novamente : ");
            nomeProduto = scanner.nextLine();
        }
        System.out.print("Digite o valor do item : ");
        double precoProduto = scanner.nextDouble();
        while(precoProduto <= 0){
            System.out.println("O preço de cadastro do item não pode ser 0 ou negativo : ");
            precoProduto = scanner.nextDouble();
        }
        double desconto = 0.05;
        System.out.println("Produto "+ nomeProduto);
        System.out.println("Preço R$ : "+precoProduto);
        System.out.println("Promoção "+nomeProduto);
        double precoDesconto = precoProduto  * desconto;
        for(int i = 1; i <= 10; i++){
            System.out.printf("%d x R$ %.2f = R$ %.2f\n",i,(precoProduto - precoDesconto * i),(( (precoProduto - precoDesconto * i)  * i)));
            desconto += desconto;
        }
        scanner.close();
    }
}
