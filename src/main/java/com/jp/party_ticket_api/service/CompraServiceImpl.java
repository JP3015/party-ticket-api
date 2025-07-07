package com.jp.party_ticket_api.service;

import java.time.LocalDateTime;
import java.util.List;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.repository.CompraRepository;
import com.jp.party_ticket_api.service.interfaces.ICompraService;

public class CompraServiceImpl implements ICompraService{
	
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
	public List<CompraDTO> buscarDataCompra(LocalDateTime data) {
		return compraRepository.findByDataCompra(data.toLocalDate());
	}

	@Override
	public void criarCompra(Compra compra) {
		compraRepository.save(compra);
	}

	@Override
	public void atualizarCompra(Long id, CompraDTO compra) {
		compraRepository.updateCompra(id, compra.getNomeComprador(), compra.getDataCompra(), compra.getEmail(), compra.getQuantidadeIngresso());
	}

	@Override
	public void deletarCompra(Long id) {
		compraRepository.deleteById(id);
	}

}
