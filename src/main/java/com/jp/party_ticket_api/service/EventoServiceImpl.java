package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Evento;
import com.jp.party_ticket_api.dto.EventoDTO;
import com.jp.party_ticket_api.repository.EventoRepository;
import com.jp.party_ticket_api.service.interfaces.IEventoService;

@Service
public class EventoServiceImpl implements IEventoService{
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public EventoServiceImpl(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	@Override
	public List<EventoDTO> buscarNomeEvento(String nome) {
		return eventoRepository.findByNomeEvento(nome);
	}

	@Override
	public List<EventoDTO> buscarData(LocalDate data) {
		return eventoRepository.findByData(data);
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
