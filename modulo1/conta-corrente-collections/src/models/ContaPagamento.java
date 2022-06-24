package models;

import abstrac.Conta;
import interfaces.Impressao;
import models.Cliente;

public class ContaPagamento extends Conta implements Impressao {

    public final static double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroDaConta, String agencia, double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    public boolean sacar (double valor) {

        if(getSaldo() >= TAXA_SAQUE + valor && valor > 0){
            setSaldo(getSaldo() - (valor + TAXA_SAQUE));
            return true;

        }else {
            System.out.println("Não é possivel sacar um valor maior que o saldo");
            return false;
        }

    }

    @Override
    public void imprimir() {

        System.out.println("------- abstrac.Conta Pagamento -------");
        System.out.println("models.Cliente : "+getCliente().getNome());
        getCliente().getContatos().forEach(System.out::println);
        getCliente().getEnderecos().forEach(System.out::println);
        System.out.println("Agencia : "+getAgencia());
        System.out.printf("Saldo : %.2f\n",getSaldo());

    }

    @Override
    public boolean transferir(Conta conta, double valor) {

        if(sacar(valor - TAXA_SAQUE)){
            return conta.depositar(valor);
        }

        return false;
    }

}
