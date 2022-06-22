public class Endereco {

    String complemento;
    String logradouro;
    int tipoDeEndereco;
    int numero;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco () {

        System.out.printf("------- informações -------\n" +
                "Pais :  %s\n" +
                "Cidade : %s\n" +
                "Estado : %s\n" +
                "Cep : %s\n" +
                "Logradouro : %s\n" +
                "Complemento : %s\n" +
                "Tipo de endereço : %d\n"+
                "numero : %d\n",pais,cidade,estado,cep,logradouro,complemento,tipoDeEndereco,numero);
    }

    @Override
    public String toString() {
        return "------- informações de endereço -------\n" +
                "complemento = " + complemento + '\n' +
                "logradouro = " + logradouro + '\n' +
                "tipoDeEndereco = " + tipoDeEndereco + '\n' +
                "numero = " + numero + '\n' +
                "cep = " + cep + '\n' +
                "cidade = " + cidade + '\n' +
                "estado = " + estado + '\n' +
                "pais = " + pais + '\n';
    }
}
