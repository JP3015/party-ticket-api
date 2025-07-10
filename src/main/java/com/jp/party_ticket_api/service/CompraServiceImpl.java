package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.repository.CompraRepository;
import com.jp.party_ticket_api.service.interfaces.ICompraService;
import com.jp.party_ticket_api.service.interfaces.IEventoService;

@Service
public class CompraServiceImpl implements ICompraService{
	
	@Autowired
	private CompraRepository compraRepository;

	public CompraServiceImpl(CompraRepository compraRepository) {
		this.compraRepository = compraRepository;
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
		compraRepository.save(compra);
	}

	@Override
	public void atualizarCompra(Long id, CompraDTO compra) {
		compraRepository.updateCompra(id, compra.getNomeComprador(), compra.getDataCompra(), compra.getEmail(), compra.getQuantidadeIngressos());
	}

	@Override
	public void deletarCompra(Long id) {
		compraRepository.deleteById(id);
	}

}
