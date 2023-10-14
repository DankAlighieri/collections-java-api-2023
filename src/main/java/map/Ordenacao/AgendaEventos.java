package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

	private Map<LocalDate, Evento> eventosMap;

	public AgendaEventos() {
		this.eventosMap = new HashMap<>();
	}

	public void adicionarEvento(LocalDate data, String nome, String atracao) {
		eventosMap.put(data, new Evento(nome, atracao));
	}

	public void exibirAgenda() {
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
		System.out.println(eventosTreeMap);
	}

	public void obterProximoEvento() {
		/*Set<LocalDate> dateSet = eventosMap.keySet();
		Collection<Evento> values = eventosMap.values();*/
//		eventosMap.get();

		LocalDate dataAtual = LocalDate.now();
		LocalDate proximaData = null;
		Evento proximoEvento = null;
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
		for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
			proximaData = entry.getKey();
			proximoEvento = entry.getValue();
			if(proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)) {
				System.out.println("O próximo evento: "
									+ proximoEvento
									+ " acontecerá na data "
									+ proximaData);
				break;
			}
		}
	}

	public static void main(String[] args) {
		AgendaEventos agendaEventos = new AgendaEventos();
		agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 15), "Evento 01", "Atracao 1");
		agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 9), "Evento 02", "Atracao 2");
		agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Evento 03", "Atracao 3");
		agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 13), "Evento 04", "Atracao 4");
		agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 14), "Evento 05", "Atracao 5");
		agendaEventos.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 20), "Evento 06", "Atracao 6");

		agendaEventos.exibirAgenda();

		agendaEventos.obterProximoEvento();
	}
}
