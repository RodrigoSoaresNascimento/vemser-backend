package runAplication;

import entities.Praia;
import entities.PraiaBrava;
import entities.PraiaCalma;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Praia> praias = new ArrayList<>();

        PraiaBrava praiaBrava1 = new PraiaBrava(5000, "Praia do Patacho", 5);
        PraiaBrava praiaBrava2 = new PraiaBrava(22000, "Praia de Boa Viagem", 10);

        praias.add(praiaBrava1);
        praias.add(praiaBrava2);

        PraiaCalma praiaCalma1 = new PraiaCalma(7000,"Praia da Baía do Sancho",true);
        PraiaCalma praiaCalma2 = new PraiaCalma(12000,"Praias dos Lençóis Maranhenses",false);

        praias.add(praiaCalma1);
        praias.add(praiaCalma2);

        list(praias);
        listGeneric(praias);

    }

    public static void list (List<Praia> praiaList) {

        for(Praia praia : praiaList){
            System.out.println(praia.getNome());
            System.out.println(praia.getExtensao());
        }
    }

    public static <T> void listGeneric(List<T> praiaList) {
        praiaList.forEach(System.out::println);
    }
}
