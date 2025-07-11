package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.dto.EventoDTO;
import com.jp.party_ticket_api.exception.IngressosIndisponiveisException;
import com.jp.party_ticket_api.repository.CompraRepository;
import com.jp.party_ticket_api.service.interfaces.ICompraService;
import com.jp.party_ticket_api.service.interfaces.IEventoService;

@Service
public class CompraServiceImpl implements ICompraService{
	
	@Autowired
	private CompraRepository compraRepository;
	
	private IEventoService eventoService;

	public CompraServiceImpl(CompraRepository compraRepository, IEventoService eventoService) {
		this.compraRepository = compraRepository;
		this.eventoService = eventoService;
	}

	@Override
	public List<CompraDTO> buscarNome(String nome) {
		return compraRepository.findByNomeComprador(nome);
	}

	@Override
	public List<CompraDTO> buscarEmail(String email) {
		return compraRepository.findByEmail(email);
	}

	@Override
	public List<CompraDTO> buscarDataCompra(LocalDate data) {
		return compraRepository.findByDataCompra(data);
	}
	
	@Override
	public CompraDTO buscarId(Long id) {
		return compraRepository.findByIdCompra(id);
	}

	@Override
	public void criarCompra(Compra compra) {
		EventoDTO evento = eventoService.buscarId(compra.getEvento().getId());
		
		if(evento.getQuantidadeIngressos() < compra.getQuantidadeIngressos()) {
			throw new IngressosIndisponiveisException(evento.getNomeEvento());
		}
		
		eventoService.atualizarEventoIngressosDisponiveis(evento.getId(), evento.getQuantidadeIngressos() - compra.getQuantidadeIngressos());
		compraRepository.save(compra);
	}

	@Override
	public void atualizarCompra(Long id, CompraDTO compra) {
	    CompraDTO dto = buscarId(id);
	    
	    int ingressosAntigos = dto.getQuantidadeIngressos();
	    int ingressosNovos = compra.getQuantidadeIngressos();
	    int delta = ingressosNovos - ingressosAntigos;

	    if (delta > 0 && dto.getEvento().getQuantidadeIngressos() < delta) {
	        throw new IngressosIndisponiveisException(dto.getEvento().getNomeEvento());
	    }

	    eventoService.atualizarEventoIngressosDisponiveis(dto.getEvento().getId(), dto.getEvento().getQuantidadeIngressos() - delta );
	    compraRepository.updateCompra(id, compra.getNomeComprador(), compra.getDataCompra(), compra.getEmail(), compra.getQuantidadeIngressos());
	}


	@Override
	public void deletarCompra(Long id) {
		CompraDTO dto = buscarId(id);
		
		eventoService.atualizarEventoIngressosDisponiveis(dto.getEvento().getId(), dto.getEvento().getQuantidadeIngressos() + dto.getQuantidadeIngressos());
		compraRepository.deleteById(id);
	}

}
