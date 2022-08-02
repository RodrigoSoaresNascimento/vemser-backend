package models;

import abstrac.Conta;
import interfaces.Impressao;
import models.Cliente;

public class ContaPoupanca extends Conta implements Impressao {

    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroDaConta, String agencia, double saldo) {
        super(cliente, numeroDaConta, agencia, saldo);
    }

    public ContaPoupanca() {
    }

    @Override
    public void imprimir() {

        System.out.println("------- abstrac.Conta Poupança -------");
        System.out.println("models.Cliente : "+getCliente().getNome());
        System.out.println("Agencia : "+getAgencia());
        System.out.printf("Saldo : %.2f\n",getSaldo());

    }
    public void creditarTaxa () {

        setSaldo(getSaldo() * JUROS_MENSAL);
    }
}
