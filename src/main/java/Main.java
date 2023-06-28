import Model.Cliente;
import Model.Vendedor;
import Registro.ClienteRegistro;
import Registro.VendedorRegistro;
import Repository.ClienteRepository;
import Repository.ProdutoRepository;
import Repository.VendaRepository;
import Repository.VendedorRepository;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {


    private static ClienteRepository clienteRepository = new ClienteRepository();
    private static VendaRepository vendaRepository = new VendaRepository();
    private static VendedorRepository vendedorRepository = new VendedorRepository();
    private static ProdutoRepository produtoRepository = new ProdutoRepository();
    private static VendedorRegistro vendedorRegistro = new VendedorRegistro(clienteRepository,vendaRepository,vendedorRepository,produtoRepository);
    private static ClienteRegistro clienteRegistro = new ClienteRegistro(clienteRepository,vendaRepository,vendedorRepository,produtoRepository);

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

         while (true){
             System.out.println("1-Cadastrar Cliente\n2-Cadastrar Vendedor\n3-Logar como cliente\n4-Logar como vendedor\n5-Sair");
             try {
                 switch (scanner.next()){
                     case "1":
                         clienteRegistro.cadastrarCliente();
                         menuCliente();
                         break;
                     case "2":
                         vendedorRegistro.cadastrarVendedor();
                         menuVendedor();
                         break;
                     case "3":
                         clienteRegistro.loginCliente();
                         menuCliente();
                         break;
                     case "4":
                         vendedorRegistro.loginVendedor();
                         menuVendedor();
                         break;
                     case "5":
                         exit(0);
                     default:
                         System.out.println("Opção inválida");
                 }
             }catch (IllegalArgumentException erro){
                 System.out.println(erro.getMessage());
             }

    }
    }

    public static void menuVendedor(){
        while (true){
            try {
                System.out.println("1-Listar Vendedores\n2-Listar Clientes\n3-Listar Vendas\n4-Listar Estoque\n5-Buscar Cliente por CPF\n6-Buscar Vendedor por Email\n7-Voltar para o menu principal");
                switch (scanner.next()){
                    case "1":
                        vendedorRegistro.listarVendedores();
                        break;
                    case "2":
                        vendedorRegistro.listarClientes();
                        break;
                    case "3":
                        vendedorRegistro.vendas();
                        break;
                    case "4":
                        vendedorRegistro.exibirEstoque();
                        break;
                    case "5":
                        System.out.println("Qual é o CPF que o vendedor deseja procurar?");
                        vendedorRegistro.vendasPorCliente(scanner.next());
                        break;
                    case "6":
                        System.out.println("Qual é o Email do vendedor deseja procurar?");
                        vendedorRegistro.vendasPorVendedor(scanner.next());
                        break;
                    case "7":
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }catch (IllegalArgumentException|NullPointerException erro){
                System.out.println(erro.getMessage());
            }

        }
    }

    public static void menuCliente(){
        while(true){
            try {
                System.out.println("1-Realizar Compra\n2-Voltar para o menu principal");
                switch (scanner.next()){
                    case "1":
                        clienteRegistro.comprarProduto();
                        break;
                    case "2":
                        return;
                    default:
                        System.out.println("Opção invalida");
                }
            }catch (IllegalArgumentException erro){
                System.out.println(erro.getMessage());
            }

        }
    }
    }