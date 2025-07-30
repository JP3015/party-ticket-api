package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.BaladaDTO;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.exception.IngressosIndisponiveisException;
import com.jp.party_ticket_api.repository.CompraRepository;
import com.jp.party_ticket_api.service.interfaces.IBaladaService;
import com.jp.party_ticket_api.service.interfaces.ICompraService;

@Service
public class CompraServiceImpl implements ICompraService{
	
	@Autowired
	private CompraRepository compraRepository;
	
	private IBaladaService baladaService;

	public CompraServiceImpl(CompraRepository compraRepository, IBaladaService baladaService) {
		this.compraRepository = compraRepository;
		this.baladaService = baladaService;
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
		BaladaDTO balada = baladaService.buscarId(compra.getBalada().getId());
		
		if(balada.getIngressosDisponiveis() < compra.getQuantidadeIngressos()) {
			throw new IngressosIndisponiveisException(balada.getNomeEvento());
		}
		
		baladaService.atualizarBaladaIngressosDisponiveis(balada.getId(), balada.getIngressosDisponiveis() - compra.getQuantidadeIngressos());
		compraRepository.save(compra);
	}

	@Override
	public void atualizarCompra(Long id, CompraDTO compra) {
	    CompraDTO dto = buscarId(id);
	    
	    int ingressosAntigos = dto.getQuantidadeIngressos();
	    int ingressosNovos = compra.getQuantidadeIngressos();
	    int delta = ingressosNovos - ingressosAntigos;

	    if (delta > 0 && dto.getBalada().getIngressosDisponiveis() < delta) {
	        throw new IngressosIndisponiveisException(dto.getBalada().getNomeEvento());
	    }

	    baladaService.atualizarBaladaIngressosDisponiveis(dto.getBalada().getId(), dto.getBalada().getIngressosDisponiveis() - delta );
	    compraRepository.updateCompra(id, compra.getNome(), compra.getDataCompra(), compra.getEmail(), compra.getQuantidadeIngressos());
	}


	@Override
	public void deletarCompra(Long id) {
		CompraDTO dto = buscarId(id);
		
		baladaService.atualizarBaladaIngressosDisponiveis(dto.getBalada().getId(), dto.getBalada().getIngressosDisponiveis() + dto.getQuantidadeIngressos());
		compraRepository.deleteById(id);
	}

}
