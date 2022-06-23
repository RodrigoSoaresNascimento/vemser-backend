public class Main {
    public static void main(String[] args) {

        Contato contatoDobli = new Contato("Residencial","(55) 99999 - 9999",1);
        Contato contatoGeisbor = new Contato("Celular","(55) (55) 88888 - 8888",2);
        Contato[] contatos = new Contato[1];
        Contato[] contatos1 = new Contato[1];
        contatos[0] = contatoDobli;
        contatos1[0] = contatoGeisbor;

        contatoDobli.imprimirContato();
        contatoGeisbor.imprimirContato();

        Endereco enderecoDobli = new Endereco("Proximo ao centro", "Rua", 1, 50, "58135-000","Esperança", "Paraíba","Brasil");
        Endereco enderecoGeisbor = new Endereco("Bairro Santo Antônio", "Rua", 2, 67, "90640-140","Porto Alegre", "Rio Grande do Sul","Brasil");
        Endereco[] enderecos = new Endereco[1];
        enderecos[0] = enderecoDobli;
        Endereco [] enderecos1 = new Endereco[1];
        enderecos1[0] = enderecoGeisbor;
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

    }
}
