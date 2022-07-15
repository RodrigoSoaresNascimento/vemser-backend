package entities;

public class PraiaCalma extends Praia{

    private boolean podeLevarAnimais;

    public PraiaCalma(int extensao, String nome, boolean podeLevarAnimais) {
        super(extensao, nome);
        this.podeLevarAnimais = podeLevarAnimais;
    }

    public boolean isPodeLevarAnimais() {
        return podeLevarAnimais;
    }

    public void setPodeLevarAnimais(boolean podeLevarAnimais) {
        this.podeLevarAnimais = podeLevarAnimais;
    }


    @Override
    public String toString() {
        return "PraiaCalma " +
                "nome = '" + getNome() + '\'' +
                " extensao = " + getExtensao() +
                " podeLevarAnimais = " + podeLevarAnimais;
    }
}
