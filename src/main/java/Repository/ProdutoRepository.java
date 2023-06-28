package Repository;

import Model.Produto;

import java.util.ArrayList;
import java.util.List;


public class ProdutoRepository {
        private List<Produto> estoqueProdutos = new ArrayList<>();

        public ProdutoRepository() {
            iniciarEstoque();
        }

    public Produto produtoExiste(int codigo) {
        for (Produto produto : estoqueProdutos) {
            if (produto.getCodigoProduto() == codigo) {
                return produto;
            }
        }
        return null;
    }

        public List<Produto> getEstoqueProdutos() {
            return estoqueProdutos;
        }

        public void retirarUnidadeDoProduto(int codigo, int quantidade) {
            Produto produto = produtoExiste(codigo);
            if (produto != null) {
                int quantidadeAtual = produto.getQuantidade();
                if (quantidadeAtual > quantidade) {
                    int novaQuantidade = quantidadeAtual - quantidade;
                    produto.setQuantidade(novaQuantidade);
                    estoqueProdutos.remove(produto);
                    estoqueProdutos.add(produto);
                } else if (quantidadeAtual == quantidade) {
                    estoqueProdutos.remove(produto);
                } else throw new IllegalArgumentException("Essa quantidade está indisponível");
            } else {
                throw new NullPointerException("Esse código não está relacionado com nenhum produto");
            }
        }

        public void listarProdutos() {
            for (Produto produto : estoqueProdutos) {
                System.out.println(produto.mostrarProduto());
            }
        }

        private void iniciarEstoque() {
            estoqueProdutos.add(new Produto("Bolo de Chocolate", "Delicioso bolo de chocolate", 15.99, 10));
            estoqueProdutos.add(new Produto("Bolo de Morango", "Bolo com camadas de morango fresco", 12.99, 7));
            estoqueProdutos.add(new Produto("Bolo de Cenoura", "Bolo de cenoura com cobertura de chocolate", 10.99, 20));
            estoqueProdutos.add(new Produto("Bolo Red Velvet", "Bolo vermelho com cream cheese", 18.99, 4));
            estoqueProdutos.add(new Produto("Bolo de Limão", "Bolo com recheio e cobertura de limão", 14.99, 5));
            estoqueProdutos.add(new Produto("Bolo de Coco", "Bolo com coco ralado e leite de coco", 11.99, 7));
            estoqueProdutos.add(new Produto("Bolo de Nozes", "Bolo com nozes e cobertura de caramelo", 16.99, 12));
            estoqueProdutos.add(new Produto("Bolo de Abacaxi", "Bolo com pedaços de abacaxi e calda", 13.9, 13));
            estoqueProdutos.add(new Produto("Bolo de Amendoim", "Bolo com cobertura de amendoim", 12.99, 20));
            estoqueProdutos.add(new Produto("Bolo de Maçã", "Bolo com pedaços de maçã e canela", 15.99, 14));
        }
    }
