package com.jp.party_ticket_api.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Usuario;
import com.jp.party_ticket_api.domain.enums.Role;
import com.jp.party_ticket_api.dto.LoginDTO;
import com.jp.party_ticket_api.exception.ExcedeuCapacidadeException;
import com.jp.party_ticket_api.exception.emailRepetidoException;
import com.jp.party_ticket_api.exception.nomeUsuarioRepetidoException;
import com.jp.party_ticket_api.repository.UsuarioRepository;
import com.jp.party_ticket_api.service.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService{

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public void salvarUsuario(LoginDTO dto) {
		if (usuarioRepository.findByUsername(dto.getNomeUsuario()).isPresent()) {
		    throw new nomeUsuarioRepetidoException();
		}if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
		    throw new emailRepetidoException();
		}
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setRole(dto.getRole());
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
	            Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole().name()))
	        );
	}
	
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
