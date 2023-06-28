package Registro;

import Model.*;
import Repository.ClienteRepository;
import Repository.ProdutoRepository;
import Repository.VendaRepository;
import Repository.VendedorRepository;
import java.util.Scanner;

public class VendedorRegistro {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private VendaRepository vendaRepository = new VendaRepository();
    private VendedorRepository vendedorRepository = new VendedorRepository();
    private ProdutoRepository produtoRepository = new ProdutoRepository();
    private Vendedor vendedor;
    static Scanner scanner = new Scanner(System.in);
    public void cadastrarVendedor() {
        System.out.println("Qual seu nome: ");
        String nomeC = scanner.nextLine();
        VerificaInputs.verificaNome(nomeC);
        System.out.println("Qual seu email: ");
        String emailC = scanner.next();
        if (!VerificaInputs.verificarEmail(emailC)) throw new IllegalArgumentException("Email invalido");

        System.out.println("Qual seu cpf: ");
        String cpfC = scanner.next();
        if (!VerificaInputs.verificarCpf(cpfC))throw new IllegalArgumentException("CPF invalido");
        System.out.println("Digite a senha:");
        String senha = scanner.next();
        vendedor= new Vendedor(emailC, nomeC, cpfC, senha);
        if (!vendedorRepository.vendedorJaExiste(vendedor)) {
            throw new IllegalArgumentException("Vendedor já cadastrado");
        }
    }
    public void loginVendedor() {
        System.out.println("Informe seu e-mail");
        String email = scanner.next();
        if (!VerificaInputs.verificarEmail(email)) throw new IllegalArgumentException("Email invalido");
        System.out.println("Informe sua senha");
        String senha = scanner.next();
        if (vendedorRepository.procuraVendedorEmail(email, senha) == null) {
            throw new IllegalArgumentException("Vendedor não cadastrado");
        }
        vendedor = vendedorRepository.procuraVendedorEmail(email, senha);
    }
    public void vendasPorCliente(String cpf) {
        if (!VerificaInputs.verificarCpf(cpf))throw new IllegalArgumentException("CPF invalido");
        for (Venda venda : vendaRepository.getVendas()) {
            if (venda.getCliente().getCpf().equals(cpf)) {
                System.out.println(venda.mostrarVenda());
                System.out.println();
            }
        }
    }
    public void vendasPorVendedor(String email){
        if (!VerificaInputs.verificarEmail(email)) throw new IllegalArgumentException("Email invalido");
        for (Venda venda: vendaRepository.getVendas()) {
            if (venda.getVendedor().getEmail().equals(email)){
                System.out.println( venda.mostrarVenda());
                System.out.println();
            }
        }
    }
    public void listarVendedores(){
        System.out.println("------------------LISTA DE VENDEDORES------------------");
        for (Vendedor vendedor: vendedorRepository.getVendedores()){
            System.out.println(vendedor.mostrar());
            System.out.println();
        }
    }
    public void listarClientes(){
        System.out.println("------------------LISTA DE CLIENTES------------------");
        for (Cliente cliente:this.clienteRepository.getClientes()) {
            System.out.println(cliente.mostrar());
            System.out.println();
        }

    }
    public void vendas(){
        System.out.println("------------------LISTA DE VENDAS------------------");
        for (Venda venda: vendaRepository.getVendas()) {
            System.out.println(venda.mostrarVenda());
            System.out.println();
        }
    }
    public void exibirEstoque(){
        for (Produto produto: produtoRepository.getEstoqueProdutos()) {
            System.out.println(produto.mostrarProduto()+"\nQuantidade: "+produto.getQuantidade());
        }
    }

}

