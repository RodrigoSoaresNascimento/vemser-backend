public class ContaCorrente {

    Cliente cliente;
    String numeroDaConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    void imprimirContaCorrente () {
        System.out.println("------- Conta Corrente -------");
        System.out.println("Cliente : "+cliente.nome);
        System.out.println("Agencia : "+agencia);
        System.out.printf("Saldo : %.2f\n",saldo);
        System.out.printf("Limite de cheque Especial : %.2f\n",chequeEspecial);

    }

    boolean sacar (double valor) {

        double saldoTotal = saldo + chequeEspecial;

        if(valor > saldoTotal){
            System.out.println("Não é posivel sacar um valor maior que o valor disponível na conta");
            return false;
        }

        if(saldo < 0){
            this.chequeEspecial = valor;
            return true;

        }
        saldo -= valor;
        return true;


    }

    boolean depositar (double valor) {
        if(valor < 0){
            return false;
        }else{

            saldo += valor;
            return true;
        }

    }

    double retornarSaldoComChequeEspecial () {

        return saldo;

    }

    boolean trasferir (ContaCorrente conta, double valor){

        return conta.depositar(valor);
    }

}
