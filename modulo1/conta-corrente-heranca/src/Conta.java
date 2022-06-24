public abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroDaConta;
    private String agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroDaConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean depositar(double valor) {
        if(valor < 0){
            System.out.println("Não é possivel depositar um valor negativo");
            return false;
        }else{

            setSaldo(getSaldo() + valor);
            return true;
        }
    }

    @Override
    public boolean sacar(double valor) {

        if(valor <= getSaldo()){
            setSaldo(getSaldo() - valor);
            return true;

        }else {
            System.out.println("Não é possivel sacar um valor maior que o saldo");
            return false;
        }

    }

    @Override
    public boolean transferir(Conta conta, double valor) {

        if(sacar(valor)){
            return conta.depositar(valor);
        }

        return false;
    }
}
