package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

	private Set<Produto> produtoSet;

	public CadastroProdutos() {
		this.produtoSet = new HashSet<>();
	}

	public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
		produtoSet.add(new Produto(nome, cod, preco, quantidade));
	}

	public Set<Produto> exibirProdutosPorNome() {
		// organiza o conjunto pela ordem natural determinada na classe (comparable)
		// utilizando o TreeSet<>();
		Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
		return produtosPorNome;
	}

	public Set<Produto> exibirProdutosPorPreco(){
		Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
		produtosPorPreco.addAll(produtoSet);
		return produtosPorPreco;
	}

	public static void main(String[] args) {
		// Criando uma instância do CadastroProdutos
		CadastroProdutos cadastroProdutos = new CadastroProdutos();

		// Adicionando produtos ao cadastro
		cadastroProdutos.adicionarProduto(1L, "Produto 5", 1000d, 10);
		cadastroProdutos.adicionarProduto(2L, "Produto 0", 1500d, 5);
		cadastroProdutos.adicionarProduto(1L, "Produto 3", 30d, 20);
		cadastroProdutos.adicionarProduto(4L, "Produto 9", 50d, 15);

		// Exibindo todos os produtos no cadastro
		System.out.println(cadastroProdutos.produtoSet);

		// Exibindo produtos ordenados por nome
		System.out.println(cadastroProdutos.exibirProdutosPorNome());

		// Exibindo produtos ordenados por preço
		System.out.println(cadastroProdutos.exibirProdutosPorPreco());
	}
}
