package entities;

public class Praia {

    private int extensao;
    private String nome;

    public Praia(int extensao, String nome) {
        this.extensao = extensao;
        this.nome = nome;
    }

    public int getExtensao() {
        return extensao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Praia{" +
                "extensao=" + extensao +
                ", nome='" + nome + '\'' +
                '}';
    }
}
