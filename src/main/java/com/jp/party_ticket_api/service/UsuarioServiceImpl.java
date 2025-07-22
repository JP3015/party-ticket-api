package com.jp.party_ticket_api.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jp.party_ticket_api.domain.Usuario;
import com.jp.party_ticket_api.domain.enums.Role;
import com.jp.party_ticket_api.dto.LoginDTO;
import com.jp.party_ticket_api.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public void salvarUsuario(LoginDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setRole(Role.ROLE_USER);
		usuarioRepository.save(usuario);
	}
	

	public void atualizarUsuario(Long id, LoginDTO dto) {
		usuarioRepository.updateUsuario(id, dto.getNomeUsuario(), dto.getEmail(), passwordEncoder.encode(dto.getSenha()));
	}
	

	@Override
	public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(Username)
				.orElseThrow(() ->  new UsernameNotFoundException("Usuário não encontrado com nome: " + Username));
	        
		return new User(
	            usuario.getNomeUsuario(),
	            usuario.getSenha(),
	            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRole().name()))
	        );
	}
	
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
