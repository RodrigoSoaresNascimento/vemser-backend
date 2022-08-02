package test;

import models.ContaCorrente;
import models.ContaPagamento;
import models.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    // Conta Corrente

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 1500;

        // act
        boolean conseguiuSacar = contaCorrente.sacar(saque);

        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int valorSaque = 3000;

        // act
        boolean conseguiuSacar = contaCorrente.sacar(valorSaque);

        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaCorrenteEVerificarSaldoComSucesso(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(1000);
        // act
        // assert
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(-1000);
        // act
        // assert
        Assertions.assertEquals(0, contaCorrente.getSaldo());
    }

    // Conta Poupança

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSaldo(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa();

        int valorSaque = 500;
        // act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);
        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(510 , contaPoupanca.getSaldo());
    }

    @Test
    public void deveSaqueContaPoupancaSemSaldo(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        int valorSaque = 500;
        // act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);
        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(0 , contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativoContaPoupanca(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(-1000);
        // act
        // assert
        Assertions.assertEquals(0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPoupancaEVerificarSaldoComSucesso(){
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(1000);
        // act
        // assert
        Assertions.assertEquals(1000, contaPoupanca.getSaldo());
    }

    //Conta Pagamento

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);

        int valorSaque = 500;
        // act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);
        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(495.75 , contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);

        int valorSaque = 1500;
        // act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);
        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000 , contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarDepositoContaPagamentoEVerificarSaldoComSucesso(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.depositar(1000);
        // act
        // assert
        Assertions.assertEquals(1000, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativoContaPagamentoEVerificarSaldoComSucesso(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.depositar(-1000);
        // act
        // assert
        Assertions.assertEquals(0, contaPagamento.getSaldo());
    }

    //Transferencias

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);

        int valorTransferencia = 1500;
        // act
        boolean conseguiuTransferir = contaPagamento.transferir(contaPoupanca, valorTransferencia);
        // assert
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(1000 , contaPagamento.getSaldo());
        Assertions.assertEquals(1000 , contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);

        int valorTransferencia = 500;
        // act
        boolean conseguiuTransferir = contaPagamento.transferir(contaPoupanca, valorTransferencia);
        // assert
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(500 , contaPagamento.getSaldo());
        Assertions.assertEquals(1500 , contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldoContaPoupancaSemSaldo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);

        int valorTransferencia = 1500;
        // act
        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, valorTransferencia);
        // assert
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(1000 , contaCorrente.getSaldo());
        Assertions.assertEquals(1000 , contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaContaPoupancaSemSaldo(){
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1500);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);

        int valorTransferencia = 1500;
        // act
        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, valorTransferencia);
        // assert
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(0 , contaCorrente.getSaldo());
        Assertions.assertEquals(2500 , contaPoupanca.getSaldo());
    }

}
