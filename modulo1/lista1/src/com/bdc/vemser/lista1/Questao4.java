package com.bdc.vemser.lista1;

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha um estado : Paraíba, Pernambuco, Rio Grande do Norte : ");
        String estado = scanner.nextLine();
        String cidade;
        if(estado.equalsIgnoreCase("paraíba")){
            System.out.println("Escolha entre Campina Grande ou Esperança");
            cidade = scanner.nextLine();
            System.out.printf(dadosDaCidade(cidade));
        }else if(estado.equalsIgnoreCase("pernambuco")){
            System.out.println("Escolha entre Recife ou Olinda");
            cidade = scanner.nextLine();
            System.out.printf(dadosDaCidade(cidade));
        }else if (estado.equalsIgnoreCase("Rio Grande do Norte")){
            System.out.println("Escolha entre Natal ou Mossoró");
            cidade = scanner.nextLine();
            System.out.printf(dadosDaCidade(cidade));
        }else{
            System.out.println("Escolha um estado valido!");
        }
        scanner.close();

    }
   public static String dadosDaCidade (String cidade){

        cidade = cidade.toLowerCase();

        switch (cidade){
            case "esperança" -> {
                return "População estimada [2021] 33.386 pessoas\n" +
                        "Principal festa : São joão\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,623\n"+
                        "PIB per capita [2019] R$ 13.352,01\n" +
                        "Bioma [2019] Caatinga \n";
            }
            case "campina grande" -> {
                return "População estimada [2021] 413.830 pessoas\n" +
                        "Principal festa : São joão\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,720\n"+
                        "PIB per capita [2019] R$ 23.210,44\n" +
                        "Bioma [2019] Caatinga \n";
            }
            case "recife" -> {
                return "População estimada [2021] 1.661.017 pessoas\n" +
                        "Principal festa : Festa da Pitomba\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,772\n"+
                        "PIB per capita [2019] R$ 33.232,26\n" +
                        "Bioma [2019] Mata Atlântica \n";
            }
            case "olinda" -> {
                return "População estimada [2021] 393.734 pessoas\n" +
                        "Principal festa : Carnaval\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,735\n"+
                        "PIB per capita [2019] R$ 14.713,81\n" +
                        "Bioma [2019] Mata Atlântica \n";
            }
            case "natal" ->{
                return "População estimada [2021] 896.708 pessoas\n" +
                        "Principal festa : Festival MADA\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,763 \n"+
                        "PIB per capita [2019] R$ 28.113,21\n" +
                        "Bioma [2019] Caatinga, Mata Atlântica \n";
            }
            case "mossoró" -> {
                return "População estimada [2021] 303.792 pessoas\n" +
                        "Principal festa : Festa sem dó\n"+
                        "IDH (Indice de desenvolvimento humano) : 0,720 \n"+
                        "PIB per capita [2019] R$ 23.290,37\n" +
                        "Bioma [2019] Caatinga\n";
            }
            default -> {
                return "Escolha uma cidade valida!";
            }
        }

   }

}
