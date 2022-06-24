public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroDaConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroDaConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimir () {

        System.out.println("------- Conta Corrente -------");
        System.out.println("Cliente : "+getCliente().getNome());
        System.out.println("Agencia : "+getAgencia());
        System.out.printf("Saldo : %.2f\n",getSaldo());
        System.out.printf("Limite de cheque Especial : %.2f\n",this.chequeEspecial);

    }
    public boolean sacar (double valor) {

        if(valor <= this.retornarSaldoComChequeEspecial() && valor > 0){
            setSaldo(getSaldo() - valor);
            return true;

        }else {
            System.out.println("Não é possivel sacar um valor maior que o saldo");
            return false;
        }

    }

    public double retornarSaldoComChequeEspecial () {

        return getSaldo() + chequeEspecial;

    }

}
