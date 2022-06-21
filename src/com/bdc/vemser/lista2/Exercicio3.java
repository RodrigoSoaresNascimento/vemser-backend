package com.bdc.vemser.lista2;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int jogadoresCadastrados = 0;
        double somaAlturas = 0;
        double maiorPeso = 0;
        int maiorIdade = 0;
        double maiorAltura = 0;
        String jogador = "";
        while (true){
            System.out.print("Digite o nome do jogador ou digite a palavra (sair) para encerrar o cadastro : ");
            String nomeJogador = scanner.nextLine();
            if(nomeJogador.equalsIgnoreCase("sair")){
                break;
            }
            while (nomeJogador.equals(null)){
                System.out.print("O nome do jogador não pode ser nulo insira novamente : ");
                nomeJogador = scanner.nextLine();
            }
            System.out.print("Digite a altura do jogador : ");
            double alturaJogador = scanner.nextDouble();
            while(alturaJogador <= 0){
                System.out.println("A altura do jogador não pode ser 0 ou negativo : ");
                alturaJogador = scanner.nextDouble();
            }
            if(alturaJogador > maiorAltura){
                maiorAltura = alturaJogador;
                jogador = nomeJogador;
            }
            somaAlturas += alturaJogador;
            System.out.print("Digite a idade do jogador : ");
            int idadeJogador = scanner.nextInt();
            while(idadeJogador <= 0){
                System.out.println("A idade do jogador não pode ser 0 ou negativo : ");
                idadeJogador = scanner.nextInt();
            }
            if(idadeJogador > maiorIdade){
                maiorIdade = idadeJogador;
                jogador = nomeJogador;
            }
            System.out.print("Digite o peso do jogador : ");
            double pesoJogador = scanner.nextDouble();
            while(pesoJogador <= 0){
                System.out.println("O peso do jogador não pode ser 0 ou negativo : ");
                pesoJogador = scanner.nextInt();
            }
            if(pesoJogador > maiorPeso){
                maiorPeso = pesoJogador;
                jogador = nomeJogador;
            }
            scanner.nextLine();
            jogadoresCadastrados++;

        }

        System.out.println("Informações cadastrais : ");
        System.out.printf("O numero de jogadores cadastrados é : %d\n",jogadoresCadastrados);
        System.out.printf("O maior jogador tem uma altura de : %.2f e seu nome é %s\n",maiorAltura,jogador);
        System.out.printf("O jogador mais velho tem uma idade de : %de e seu nome é %s\n",maiorIdade,jogador);
        System.out.printf("O jogador mais pesado tem um peso de : %.2f e seu nome é %s\n",maiorPeso,jogador);
        System.out.printf("A media das alturas do jogador é : %.2f\n",somaAlturas/jogadoresCadastrados);
        scanner.close();
    }
}
