import models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Contato contatoDobli = new Contato("Residencial","(55) 99999 - 9999",1);
        Contato contatoGeisbor = new Contato("Celular","(55) (55) 88888 - 8888",2);
        ArrayList <Contato> contatos = new ArrayList<>();
        ArrayList <Contato> contatos1 = new ArrayList<>();
        contatos.add(contatoDobli);
        contatos1.add(contatoGeisbor);

        contatoDobli.imprimirContato();
        contatoGeisbor.imprimirContato();

        Endereco enderecoDobli = new Endereco("Proximo ao centro", "Rua", 1, 50, "58135-000","Esperança", "Paraíba","Brasil");
        Endereco enderecoGeisbor = new Endereco("Bairro Santo Antônio", "Rua", 2, 67, "90640-140","Porto Alegre", "Rio Grande do Sul","Brasil");
        ArrayList <Endereco> enderecos = new ArrayList<>();
        enderecos.add(enderecoDobli);
        ArrayList <Endereco> enderecos1 = new ArrayList<>();
        enderecos1.add(enderecoGeisbor);
        enderecoDobli.imprimirEndereco();
        enderecoGeisbor.imprimirEndereco();

        Cliente clienteTodoawi = new Cliente("Todoawi", "090.734.300-70", contatos, enderecos);
        Cliente clienteZiadar = new Cliente("Ziadar", "090.734.300-70", contatos1, enderecos1);

        clienteTodoawi.imprimirCliente();
        clienteTodoawi.imprimirContatos();
        clienteTodoawi.imprimirEnderecos();

        ContaCorrente contaCorrente = new ContaCorrente(clienteTodoawi, "3180", 4455, 1000, 500);

        System.out.println(contaCorrente.sacar(500));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.sacar(500));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.sacar(200));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.depositar(-100));
        System.out.println(contaCorrente.depositar(500));
        System.out.println(contaCorrente.retornarSaldoComChequeEspecial());

        ContaCorrente contaCorrente1 = new ContaCorrente(clienteZiadar, "9641", 8899, 500, 250);

        contaCorrente.transferir(contaCorrente1, 500);
        System.out.println("O saldo na conta corrente 1 é de : "+contaCorrente1.getSaldo());
        contaCorrente1.imprimirConta();

        ContaPoupanca poupanca = new ContaPoupanca(clienteTodoawi, "6699", 6978, 2500);
        poupanca.creditarTaxa();
        poupanca.imprimirConta();
        System.out.printf("Seu saldo com taxa é de : %.2f\n",poupanca.getSaldo());
        System.out.println("Transferido com sucesso ? "+poupanca.transferir(contaCorrente, 2525));
        System.out.println("é possivel depositar? "+poupanca.depositar(-100));
        System.out.println("é possivel depositar? "+poupanca.depositar(100));
        System.out.println("é possivel sacar ? "+poupanca.sacar(1000));
        System.out.println("é possivel sacar ? "+poupanca.sacar(100));
        ContaPagamento pagamento = new ContaPagamento(clienteZiadar, "6699", 3654, 1500);
        ContaPagamento pagamento2 = new ContaPagamento(clienteTodoawi, "6699", 1598, 3500);
        System.out.println();
        pagamento.imprimirConta();
        System.out.println();
        pagamento.sacar(1000);
        System.out.println("Saldo apos o saque de 1000 : "+pagamento.getSaldo());
        System.out.println();
        System.out.println("Saldo antes da transferencia : "+contaCorrente.getSaldo());
        pagamento.transferir(contaCorrente, 400);
        System.out.println("Saldo após transferencia de conta corrente : "+pagamento.getSaldo());
        System.out.println("Saldo da conta corrente : "+ contaCorrente.getSaldo());
        pagamento.depositar(500);
        System.out.println("Deposito na conta pagamento : "+pagamento.getSaldo());
    }
}
