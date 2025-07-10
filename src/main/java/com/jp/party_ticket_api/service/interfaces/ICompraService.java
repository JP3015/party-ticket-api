package com.jp.party_ticket_api.service.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;

public interface ICompraService {
	
	List<CompraDTO> buscarNome(String nome);
	    
	List<CompraDTO> buscarEmail(String email);
	    
	List<CompraDTO> buscarDataCompra(LocalDate data);
	
	CompraDTO buscarId(Long id);
	
	void criarCompra(Compra compra);

	void atualizarCompra(Long id, CompraDTO compra);

	void deletarCompra(Long id);
}
