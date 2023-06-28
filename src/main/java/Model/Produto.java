package Model;

public class Produto {
    private int codigoProduto;
    static int contCodigoProduto = 0;
    private int quantidade;
    private String nomeProduto;
    private double preco;
    private String descricao;

    public Produto(String nomeProduto,String descricao, double preco,int quantidade) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        Produto.contCodigoProduto++;
        this.codigoProduto = contCodigoProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;

    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String mostrarProduto(){
        return "Código: "+codigoProduto+"\nNome: "+nomeProduto+"\nPreço R$: "+ preco;
    }
}

