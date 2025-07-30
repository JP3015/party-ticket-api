package com.jp.party_ticket_api.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.jp.party_ticket_api.domain.Balada;
import com.jp.party_ticket_api.dto.BaladaDTO;

public interface IBaladaService {

	 List<BaladaDTO> buscarNomeBalada(String nome);

	 List<BaladaDTO> buscarData(LocalDate data);
	 
	 BaladaDTO buscarId(Long id);
	 
	 void criarBalada(Balada balada);

	 void atualizarBalada(Long id, BaladaDTO balada);
	 
	 void atualizarBaladaIngressosDisponiveis(Long id, int ingressosDisponiveis);

	 void deletarBalada(Long id);
}	
