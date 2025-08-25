package com.jp.party_ticket_api.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jp.party_ticket_api.dto.LoginDTO;
import com.jp.party_ticket_api.dto.UsuarioDTO;

public interface IUsuarioService extends UserDetailsService{
	
	void salvarUsuario(LoginDTO dto);
	
	void mudarSenha(String token, String novaSenha);
	
	void atualizarUsuario(Long id, LoginDTO dto);
	
	void deletarUsuario(Long id);

	UsuarioDTO buscarUsuario(String token);

}
