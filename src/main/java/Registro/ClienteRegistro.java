package Registro;

import Model.*;
import Repository.ClienteRepository;
import Repository.ProdutoRepository;
import Repository.VendaRepository;
import Repository.VendedorRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ClienteRegistro {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private VendaRepository vendaRepository = new VendaRepository();
    private VendedorRepository vendedorRepository = new VendedorRepository();
    private ProdutoRepository produtoRepository = new ProdutoRepository();
    private Cliente cliente;
    static Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente() {

        System.out.println("Qual seu nome: ");
        String nomeC = VerificaInputs.verificaBufferScaner(scanner.nextLine());
        VerificaInputs.verificaNome(nomeC);
        System.out.println("Qual seu email: ");
        String emailC =  VerificaInputs.verificaBufferScaner(scanner.nextLine());
        if (!VerificaInputs.verificarEmail(emailC)) throw new IllegalArgumentException("Email invalido");

        System.out.println("Qual seu cpf: ");
        String cpfC = scanner.next();
        if (!VerificaInputs.verificarCpf(cpfC))throw new IllegalArgumentException("CPF invalido");

        System.out.println("Digite a senha:");
        String senha = scanner.next();
        cliente = new Cliente(nomeC, cpfC,emailC, senha);
        if (clienteRepository.clienteJaExiste(cliente)) {
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
    }

    public void loginCliente() {
        System.out.println("Informe seu e-mail");
        String email = scanner.next();
        if (!VerificaInputs.verificarEmail(email)) throw new IllegalArgumentException("Email invalido");
        System.out.println("Informe sua senha");
        String senha = scanner.next();
        if (clienteRepository.procuraClienteEmail(email, senha) == null) throw new IllegalArgumentException("Cliente não cadastrado");
        cliente = clienteRepository.procuraClienteEmail(email, senha);
    }

    public void comprarProduto() {
        produtoRepository.listarProdutos();
        System.out.println("Qual o codigo do produto que deseja: ");
        int codigo = scanner.nextInt();
        Produto produto = produtoRepository.produtoExiste(codigo);
        if (produto==null) throw new IllegalArgumentException("Código do produto inválido");

        System.out.println("Quantas unidades deseja desse produto: ");
        int quantidade = scanner.nextInt();
        produtoRepository.retirarUnidadeDoProduto(codigo,quantidade);
        Vendedor vendedor = vendedorRepository.turnoDaVez();
        Venda venda = new Venda(vendedor, cliente,produto,quantidade);
        System.out.println("----------VENDA REALIZADA----------");
        venda.mostrarVenda();
        System.out.println("_----------------------------------");
        vendaRepository.adicionarVenda(venda);
    }
}


