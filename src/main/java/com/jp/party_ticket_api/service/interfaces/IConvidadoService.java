package com.jp.party_ticket_api.service.interfaces;

import java.util.List;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.domain.Convidado;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.dto.ConvidadoDTO;

public interface IConvidadoService {
	
	List<ConvidadoDTO> buscarNome(String nome);
	    
	List<ConvidadoDTO> buscarEmail(String email);
	
	ConvidadoDTO buscarId(Long id);
	
	Integer capacidadeRestante(Long id);
	
	void criarConvidado(Convidado convidado);

	void atualizarConvidado(Long id, ConvidadoDTO convidado);

	void deletarConvidado(Long id);
}
