public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroDaConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroDaConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirConta () {

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

     public boolean depositar (double valor) {
        if(valor < 0){
            System.out.println("Não é possivel depositar um valor negativo");
            return false;
        }else{

            setSaldo(getSaldo() + valor);
            return true;
        }

    }

    public double retornarSaldoComChequeEspecial () {

        return getSaldo() + chequeEspecial;

    }

    public boolean trasferir (ContaCorrente conta, double valor){

        if(sacar(valor)){
           return conta.depositar(valor);
        }

        return false;
    }

}
