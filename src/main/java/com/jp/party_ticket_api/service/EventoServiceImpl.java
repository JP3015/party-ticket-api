package com.jp.party_ticket_api.service;

import java.time.LocalDateTime;
import java.util.List;

import com.jp.party_ticket_api.domain.Evento;
import com.jp.party_ticket_api.dto.EventoDTO;
import com.jp.party_ticket_api.repository.EventoRepository;
import com.jp.party_ticket_api.service.interfaces.IEventoService;

public class EventoServiceImpl implements IEventoService{
	
	private EventoRepository eventoRepository;
	
	public EventoServiceImpl(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	@Override
	public List<EventoDTO> buscarNomeEvento(String nome) {
		return eventoRepository.findByNomeEventoContainingIgnoreCase(nome);
	}

	@Override
	public List<EventoDTO> buscarData(LocalDateTime data) {
		return eventoRepository.findByData(data.toLocalDate());
	}

	@Override
	public void criarEvento(Evento evento) {
		eventoRepository.save(evento);
	}

	@Override
	public void atualizarEvento(Long id, EventoDTO evento) {
		eventoRepository.updateEvento(id, evento.getNomeEvento(), evento.getData(), evento.getLocal(), evento.getCapacidade(), evento.getQuantidadeIngressos());
	}

	@Override
	public void atualizarEventoIngressosDisponiveis(Long id, int ingressosDisponiveis) {
		eventoRepository.updateEventoIngressosDisponiveis(id, ingressosDisponiveis);
	}
	
	@Override
	public void deletarEvento(Long id) {
		eventoRepository.deleteById(id);
	}

}
