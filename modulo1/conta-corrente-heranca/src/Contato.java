public class Contato {

   private String descricao;
   private String telefone;
   private int tipoDeTelefone;

    public Contato() {

    }

    public Contato(String descricao, String telefone, int tipoDeTelefone) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipoDeTelefone = tipoDeTelefone;
    }

    @Override
    public String toString() {
        return "----- informações de Contato -----\n" +
                "descricao = " + getDescricao() + '\n' +
                "telefone = " + getTelefone() + '\n' +
                "tipoDeTelefone = " + getTipoDeTelefone() + '\n';
    }

    void imprimirContato (){
        System.out.printf("O numero de telefone é : %s\ne o tipo é : %s \n",getTelefone(),getDescricao());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoDeTelefone() {
        return tipoDeTelefone;
    }

    public void setTipoDeTelefone(int tipoDeTelefone) {
        this.tipoDeTelefone = tipoDeTelefone;
    }
}
