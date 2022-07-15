package entities;

public class PraiaBrava extends Praia{

    private int quantidadeDeOndasPorMinuto;


    public PraiaBrava(int extensao, String nome, int quantidadeDeOndasPorMinuto) {
        super(extensao, nome);
        this.quantidadeDeOndasPorMinuto = quantidadeDeOndasPorMinuto;
    }

    public int getQuantidadeDeOndasPorMinuto() {
        return quantidadeDeOndasPorMinuto;
    }

    public void setQuantidadeDeOndasPorMinuto(int quantidadeDeOndasPorMinuto) {
        this.quantidadeDeOndasPorMinuto = quantidadeDeOndasPorMinuto;
    }

    @Override
    public String toString() {
        return "PraiaBrava " +
                "Nome = '" + getNome() + '\'' +
                " extensao = " + getExtensao() +
                " quantidadeDeOndasPorMinuto = " + quantidadeDeOndasPorMinuto;
    }
}
