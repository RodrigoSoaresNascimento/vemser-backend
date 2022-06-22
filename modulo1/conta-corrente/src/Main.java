public class Main {
    public static void main(String[] args) {

        Contato contato1 = new Contato();
        Contato contato2 = new Contato();
        Contato contato3 = null;
        contato1.tipoDeTelefone = 1;
        contato2.tipoDeTelefone = 2;
        contato1.descricao = "residencial";
        contato2.descricao = "comercial";
        contato1.telefone = "(55) 99999 - 9999";
        contato2.telefone = "(55) 88888 - 8888";

        contato1.imprimirContato();



        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        Endereco endereco3 = null;
        endereco1.estado = "Paraíba";
        endereco2.estado = "Rio Grande do Sul";
        endereco1.cidade = "Esperança";
        endereco2.cidade = "Porto Alegre";
        endereco1.cep = "58135-000";
        endereco2.cep = "90640-140";
        endereco1.tipoDeEndereco = 1;
        endereco2.tipoDeEndereco = 2;
        endereco1.complemento = "Centro";
        endereco2.complemento = "Bairro Santo Antônio";
        endereco1.pais = "Brasil";
        endereco2.pais = "Brasil";
        endereco1.numero = 50;
        endereco2.numero = 67;
        endereco1.logradouro = "Rua";
        endereco2.logradouro = "Rua";

        endereco1.imprimirEndereco();
        endereco2.imprimirEndereco();

        Cliente cliente = new Cliente();
        cliente.enderecos[0] = endereco1;
        cliente.enderecos[1] = endereco2;
        cliente.contatos[0] = contato1;
        cliente.contatos[1] = contato2;
        cliente.enderecos[1] = endereco3;
        cliente.contatos[1] = contato3;
        cliente.nome = "Todoawi";
        cliente.cpf = "090.734.300-70";
        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEnderecos();

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.cliente = cliente;
        contaCorrente.saldo = 1000;
        contaCorrente.chequeEspecial = 500;
        contaCorrente.agencia = 3180;
        contaCorrente.imprimirContaCorrente();
        System.out.println(contaCorrente.sacar(500));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.sacar(500));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.sacar(200));
        System.out.println("Seu saldo é de : "+contaCorrente.retornarSaldoComChequeEspecial());
        System.out.println(contaCorrente.depositar(-100));
        System.out.println(contaCorrente.depositar(500));
        System.out.println(contaCorrente.retornarSaldoComChequeEspecial());

        ContaCorrente contaCorrente1 = new ContaCorrente();

        contaCorrente.trasferir(contaCorrente1, 500);
        System.out.println("O saldo na conta corrente 1 é de : "+contaCorrente1.saldo);



    }
}
