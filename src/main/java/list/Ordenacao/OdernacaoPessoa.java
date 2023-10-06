package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OdernacaoPessoa {
	// Atributo

	private List<Pessoa> pessoaList;

	public OdernacaoPessoa() {
		this.pessoaList = new ArrayList<>();
	}

	public void adicionarPessoa(String nome, int idade, double altura) {
		pessoaList.add(new Pessoa(nome, idade, altura));
	}

	public List<Pessoa> ordenarPorIdade() {
		List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);

		// Ordenando as pessoas por idade devido ao comparable
		// declarado dentro da classe pessoa.
		Collections.sort(pessoasPorIdade);
		return pessoasPorIdade;
	}

	public List<Pessoa> ordenarPorAltura() {
		List<Pessoa> pessoarPorAltura = new ArrayList<>(pessoaList);

		/*
			Ordenando pessoas por altura utilizando o comparator
			declarado dentro da classe pessoa. Caso não fosse passado nada
			a IDE utilizaria o Comparable, por isso eh necessario
			instanciar o Comparator.
		 */

		Collections.sort(pessoarPorAltura, new ComparatorPorAltura());
		return pessoarPorAltura;
	}

	public static void main(String[] args) {
		OdernacaoPessoa ordenacaoPessoa = new OdernacaoPessoa();
		ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.56);
		ordenacaoPessoa.adicionarPessoa("Nome 2", 30, 1.80);
		ordenacaoPessoa.adicionarPessoa("Nome 3", 25, 1.70);
		ordenacaoPessoa.adicionarPessoa("Nome 4", 17, 1.56);

		System.out.println(ordenacaoPessoa.ordenarPorIdade());
		System.out.println(ordenacaoPessoa.ordenarPorAltura());
	}
}
