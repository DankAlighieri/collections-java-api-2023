package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	public static void main(String[] args) {
		CarrinhoDeCompras carrinhoCompras = new CarrinhoDeCompras();

		System.out.println("O valor total eh: " + carrinhoCompras.calcularValorTotal());

		carrinhoCompras.adicionarItem("Videogame", 199.90, 2);
		System.out.println("O valor total eh: " + carrinhoCompras.calcularValorTotal());

		carrinhoCompras.removerItem("Videogame");
		System.out.println("O valor total eh: " + carrinhoCompras.calcularValorTotal());

		carrinhoCompras.adicionarItem("Vacina", 199.90, 2);
		carrinhoCompras.exibirItens();


	}

	private List<Item> carrinhoList;

	public CarrinhoDeCompras() {
		this.carrinhoList = new ArrayList<>();
	}

	public void  adicionarItem(String nome, double preco, int quantidade) {
		carrinhoList.add(new Item(nome, preco, quantidade));
	}

	public void removerItem(String nome) {
		List<Item> itemsParaRemover = new ArrayList<>();
		for (Item i : carrinhoList) {
			String name = i.getNome();
			double price = i.getPreco();
			int quant = i.getQuantidade();
			if(name.equalsIgnoreCase(nome)) itemsParaRemover.add(i);

		}
		carrinhoList.removeAll(itemsParaRemover);
	}

	public double calcularValorTotal() {
		double valorTotalCarrinho = 0;

		for (Item i : carrinhoList) {
			double price = i.getPreco();
			int quant = i.getQuantidade();
			double valorTotalItem = price * quant;
			valorTotalCarrinho += valorTotalItem;
		}
		return valorTotalCarrinho;
	}

	public void exibirItens() {
		System.out.println(carrinhoList);
	}
}
