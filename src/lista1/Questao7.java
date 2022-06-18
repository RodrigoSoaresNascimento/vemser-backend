package lista1;

public class Questao7 {
    public static void main(String[] args) {

        int variavelA = 10;
        int variavelB = 20;

        System.out.println(trocarVariaveis(10,20));

    }
    public static String trocarVariaveis (int numero1,int numero2){

        int troca = 0;
        troca = numero1;
        numero1 = numero2;
        numero2 =  troca;


        return String.format("O valor da variavel A é : %d\nO valor da variavel B é: %d", numero1, numero2);
    }
}
