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

        if(valor <= retornarSaldoComChequeEspecial() && valor > 0){
            this.saldo -= valor;
            return true;

        }else {
            System.out.println("Não é possivel sacar um valor maior que o saldo");
            return false;
        }



    }

    boolean depositar (double valor) {
        if(valor < 0){
            System.out.println("Não é possivel depositar um valor negativo");
            return false;
        }else{

            saldo += valor;
            return true;
        }

    }

    double retornarSaldoComChequeEspecial () {

        return saldo + chequeEspecial;

    }

    boolean trasferir (ContaCorrente conta, double valor){

        if(sacar(valor)){
           return conta.depositar(valor);
        }

        return false;
    }

}
