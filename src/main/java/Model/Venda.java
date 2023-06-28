package Model;

import Model.Cliente;
import Model.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double totalCompra;
    private String dataCompra;

    public Venda(Vendedor vendedor, Cliente cliente, Produto produto, int quantidade) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.totalCompra = quantidade*produto.getPreco();
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataCompra = data.format(formatarData);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }
    public String mostrarVenda(){
        return "Vendedor: "+vendedor.getNome()+"\nCliente: "+cliente.getNome()+"\nData da compra: "+dataCompra
                +"\nCódigo produto: "+produto.getCodigoProduto()+"\nNome do Produto: "+produto.getNomeProduto()+"\nPreço unitário: "+produto.getPreco()+
                "\nQuantidade: "+quantidade+"\nValor total da compra: "+ totalCompra;
    }
}
