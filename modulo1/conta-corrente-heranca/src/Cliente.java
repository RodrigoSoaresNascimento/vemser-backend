public class Cliente {

    private String nome;
    private String cpf;
    private Contato [] contatos = new Contato[2];
    private Endereco [] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    void imprimirContatos () {

        for(Contato contato : this.contatos){
            if(contato != null){
                System.out.println(contato);
            }
        }
    }

    void imprimirEnderecos () {

        for(Endereco endereco : this.enderecos){

            if(endereco != null){
                System.out.println(endereco);
            }
        }
    }

    void imprimirCliente () {

        System.out.printf("O cliente é : %s\ne seu cpf é de : %s\n",getNome(),getCpf());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
