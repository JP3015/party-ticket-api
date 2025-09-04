package com.jp.party_ticket_api.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Usuario;
import com.jp.party_ticket_api.domain.enums.Role;
import com.jp.party_ticket_api.dto.LoginDTO;
import com.jp.party_ticket_api.dto.UsuarioDTO;
import com.jp.party_ticket_api.exception.UsuarioNaoEncontradoException;
import com.jp.party_ticket_api.repository.UsuarioRepository;
import com.jp.party_ticket_api.security.JwtUtil;
import com.jp.party_ticket_api.service.interfaces.IUsuarioService;
import com.jp.party_ticket_api.validator.EmailValidator;
import com.jp.party_ticket_api.validator.UsuarioValidator;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService{

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final EmailValidator emailValidator; 
	private final UsuarioValidator usuarioValidator; 
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, 
			JwtUtil jwtUtil, EmailValidator emailValidator, UsuarioValidator usuarioValidator) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.emailValidator = emailValidator;
		this.usuarioValidator = usuarioValidator;
	}
	
	@Override
	public UsuarioDTO buscarUsuario(String token) {
		String username = jwtUtil.extrairUsername(token);
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() ->  new UsuarioNaoEncontradoException(username));
		
		return new UsuarioDTO(usuario);
	}

	@Override
	public void salvarUsuario(LoginDTO dto) {
		usuarioValidator.validarNomeUsuario(usuarioRepository.findByUsername(dto.getNomeUsuario()).isPresent(), dto.getNomeUsuario());
		emailValidator.validarEmail(usuarioRepository.findByEmail(dto.getEmail()).isPresent(), dto.getEmail());
		emailValidator.validarEmail(dto.getEmail());
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setRole(dto.getRole() == null ? Role.ROLE_USER : dto.getRole());
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void atualizarUsuario(Long id, LoginDTO dto) {
		emailValidator.validarEmail(dto.getEmail());
		usuarioRepository.updateUsuario(id, dto.getNomeUsuario(), dto.getEmail(), passwordEncoder.encode(dto.getSenha()));
	}
	
	@Override
	public void mudarSenha(String token, String novaSenha) {
		String username = jwtUtil.extrairUsername(token);
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() ->  new UsuarioNaoEncontradoException(username));

		usuarioRepository.updateSenha(usuario.getId(), passwordEncoder.encode(novaSenha));
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() ->  new UsuarioNaoEncontradoException(username));
	        
		return new User(
	            usuario.getNomeUsuario(),
	            usuario.getSenha(),
	            Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole().name()))
	        );
	}
	
	@Override
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}
