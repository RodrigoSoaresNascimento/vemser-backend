package lista1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a palavra a ser traduzida : ");
        String palavra = scanner.next();
        System.out.print("A palavra traduzida é : ");
        System.out.println(traduzirPalavra(palavra));
        scanner.close();

    }

    public static String traduzirPalavra (String palavra){

        List <String> palavrasPortugues = Arrays.asList("Cachorro", "Tempo", "Amor", "Cidade",
                "Feliz", "Triste", "Deveria", "Poderia");

        List <String> palavrasIngles = Arrays.asList("Dog", "Time", "Love", "City",
                "Happy", "Sad", "Should", "Could");

        int index = 0;
        //se o usuario digitar tudo minusculo coloca a primeira letra em maisculo
        palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);

        if(palavrasPortugues.contains(palavra)){

            index = palavrasPortugues.indexOf(palavra);
            return palavrasIngles.get(index);

        }else if(palavrasIngles.contains(palavra)){

            index = palavrasIngles.indexOf(palavra);
            return palavrasPortugues.get(index);

        }else{

            return "Essa palavra não é valida";
        }

    }

}
