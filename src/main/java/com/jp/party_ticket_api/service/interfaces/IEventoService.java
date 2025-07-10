package com.jp.party_ticket_api.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.jp.party_ticket_api.domain.Evento;
import com.jp.party_ticket_api.dto.EventoDTO;

public interface IEventoService {

	 List<EventoDTO> buscarNomeEvento(String nome);

	 List<EventoDTO> buscarData(LocalDate data);
	 
	 EventoDTO buscarId(Long id);
	 
	 void criarEvento(Evento evento);

	 void atualizarEvento(Long id, EventoDTO evento);
	 
	 void atualizarEventoIngressosDisponiveis(Long id, int ingressosDisponiveis);

	 void deletarEvento(Long id);
}	
