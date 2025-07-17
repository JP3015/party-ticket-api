package com.jp.party_ticket_api.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;

public interface IAniversarioService {

	 List<AniversarioDTO> buscarNomeAniversario(String nome);

	 List<AniversarioDTO> buscarData(LocalDate data);
	 
	 AniversarioDTO buscarId(Long id);
	 
	 void criarAniversario(Aniversario aniversario);

	 void atualizarAniversario(Long id, AniversarioDTO aniversario);

	 void deletarAniversario(Long id);
}	
