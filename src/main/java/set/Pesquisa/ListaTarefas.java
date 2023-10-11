package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
	private Set<Tarefa> tarefaSet;

	public ListaTarefas() {
		this.tarefaSet = new HashSet<>();
	}

	public void adicionarTarefa(String descricao) {
		tarefaSet.add(new Tarefa(descricao, false));
	}

	public void removerTarefa(String descricao) {
		Tarefa tarefaParaRemover = null;
		if(!tarefaSet.isEmpty()) {
			for (Tarefa t : tarefaSet)
				if (t.getDescricao().equalsIgnoreCase(descricao)) {
					tarefaParaRemover = t;
					break;
				}
			tarefaSet.remove(tarefaParaRemover);
		} else System.out.println("Conjunto está vazio!");
		if (tarefaParaRemover == null){
			System.out.println("Tarefa n encontrada!");
		}
	}

	public void exibirTarefas() {
		System.out.println(tarefaSet);
	}

	public int contarTarefas() {
		return tarefaSet.size();
	}

	public Set<Tarefa> obterTarefasConcluidas() {
		Set<Tarefa> tarefasConcluidas = new HashSet<>();
		for (Tarefa t: tarefaSet)
			if(t.isConcluido()) tarefasConcluidas.add(t);
		return tarefasConcluidas;
	}

	public Set<Tarefa> obterTarefasPendentes() {
		Set<Tarefa> tarefasPendentes = new HashSet<>();
		for (Tarefa t: tarefaSet)
			if(!t.isConcluido()) tarefasPendentes.add(t);
		return tarefasPendentes;
	}

	public Tarefa marcarTarefaConcluida(String descricao) {
		Tarefa tarefaConcluida = null;
		for (Tarefa t : tarefaSet) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluido(true);
				tarefaConcluida = t;
				break;
			}
		}
		return tarefaConcluida;
	}

	public Tarefa marcarTarefaPendente(String descricao) {
		Tarefa tarefaPendente = null;
		for (Tarefa t : tarefaSet) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluido(false);
				tarefaPendente = t;
				break;
			}
		}
		return tarefaPendente;
	}

	public void limparListaTarefas() {
		if(tarefaSet.isEmpty()) System.out.println("Lista vazia");
		else tarefaSet.clear();
	}

	public static void main(String[] args) {
		// Criando uma instância da classe ListaTarefas
		ListaTarefas listaTarefas = new ListaTarefas();

		// Adicionando tarefas à lista
		listaTarefas.adicionarTarefa("Estudar Java");
		listaTarefas.adicionarTarefa("Fazer exercícios físicos");
		listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
		listaTarefas.adicionarTarefa("Ler livro");
		listaTarefas.adicionarTarefa("Preparar apresentação");

		// Exibindo as tarefas na lista
		listaTarefas.exibirTarefas();

		// Removendo uma tarefa
		listaTarefas.removerTarefa("Fazer exercícios físicos");
		listaTarefas.exibirTarefas();

		// Contando o número de tarefas na lista
		System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

		// Obtendo tarefas pendentes
		System.out.println(listaTarefas.obterTarefasPendentes());

		// Marcando tarefas como concluídas
		listaTarefas.marcarTarefaConcluida("Ler livro");
		listaTarefas.marcarTarefaConcluida("Estudar Java");

		// Obtendo tarefas concluídas
		System.out.println(listaTarefas.obterTarefasConcluidas());

		// Marcando tarefas como pendentes
		listaTarefas.marcarTarefaPendente("Estudar Java");
		listaTarefas.exibirTarefas();

		// Limpando a lista de tarefas
		listaTarefas.limparListaTarefas();
		listaTarefas.exibirTarefas();
	}
}
