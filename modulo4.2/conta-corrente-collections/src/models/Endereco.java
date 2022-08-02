package models;

public class Endereco {

       private String complemento;
       private String logradouro;
       private int tipoDeEndereco;
       private int numero;
       private String cep;
       private String cidade;
       private String estado;
       private String pais;

    public Endereco(String complemento, String logradouro, int tipoDeEndereco, int numero, String cep, String cidade, String estado, String pais) {
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.tipoDeEndereco = tipoDeEndereco;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco (){}

    public void imprimirEndereco () {

        switch (tipoDeEndereco){
            case 1 -> {
                System.out.println("Comercial");
            }
            case 2 -> {
                System.out.println("Residencial");
            }
            default -> {
                System.out.println("Tipo de endereço fora do padrão escolha residencial ou comercial");
            }
        }

        System.out.printf("------- informações -------\n" +
                "Pais :  %s\n" +
                "Cidade : %s\n" +
                "Estado : %s\n" +
                "Cep : %s\n" +
                "Logradouro : %s\n" +
                "Complemento : %s\n" +
                "numero : %d\n",getPais(),getCidade(),getEstado(),getCep(),getLogradouro(),getComplemento(),getNumero());
    }

    @Override
    public String toString() {
        return "------- informações de endereço -------\n" +
                "complemento = " + getComplemento() + '\n' +
                "logradouro = " + getLogradouro() + '\n' +
                "tipoDeEndereco = " + getTipoDeEndereco() + '\n' +
                "numero = " + getNumero() + '\n' +
                "cep = " + getCep() + '\n' +
                "cidade = " + getCidade() + '\n' +
                "estado = " + getEstado() + '\n' +
                "pais = " + getPais() + '\n';
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getTipoDeEndereco() {
        return tipoDeEndereco;
    }

    public void setTipoDeEndereco(int tipoDeEndereco) {
        this.tipoDeEndereco = tipoDeEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
