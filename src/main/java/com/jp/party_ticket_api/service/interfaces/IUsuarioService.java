package com.jp.party_ticket_api.service.interfaces;

import com.jp.party_ticket_api.dto.LoginDTO;

public interface IUsuarioService {
	
	void salvarUsuario(LoginDTO dto);
	
	void atualizarUsuario(Long id, LoginDTO dto);
	
	void deletarUsuario(Long id);

}
