public class Contato {

    String descricao;
    String telefone;
    int tipoDeTelefone;

    @Override
    public String toString() {
        return "----- informações de Contato -----\n" +
                "descricao = " + descricao + '\n' +
                "telefone = " + telefone + '\n' +
                "tipoDeTelefone = " + tipoDeTelefone + '\n';
    }

    void imprimirContato (){
        System.out.printf("O numero de telefone é : %s\ne o tipo é : %s \n",telefone,descricao);
    }



}
