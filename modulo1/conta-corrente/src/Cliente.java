public class Cliente {

    String nome;
    String cpf;
    Contato [] contatos = new Contato[2];
    Endereco [] enderecos = new Endereco[2];

    void imprimirContatos () {

        for(Contato contato : contatos){

            if(contato != null){
                System.out.println(contato);
            }

        }
    }

    void imprimirEnderecos () {

        for(Endereco endereco : enderecos){

            if(endereco != null){
                System.out.println(endereco);
            }
        }
    }

    void imprimirCliente () {

        System.out.printf("O cliente é : %s\ne seu cpf é de : %s\n",nome,cpf);
    }

}
