package com.jp.party_ticket_api.service;

import java.util.Collections;
import java.util.regex.Pattern;

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
import com.jp.party_ticket_api.exception.EmailInvalidoException;
import com.jp.party_ticket_api.exception.EmailRepetidoException;
import com.jp.party_ticket_api.exception.NomeUsuarioRepetidoException;
import com.jp.party_ticket_api.repository.UsuarioRepository;
import com.jp.party_ticket_api.service.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements UserDetailsService, IUsuarioService{

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	private void validarNomeUsuario(String nomeUsuario) {
	    if (usuarioRepository.findByUsername(nomeUsuario).isPresent()) {
	        throw new NomeUsuarioRepetidoException(nomeUsuario);
	    }
	}
	
	private void validarEmailExistente(String email) {
	    if (usuarioRepository.findByEmail(email).isPresent()) {
	        throw new EmailRepetidoException(email);
	    }
	}
	
	private void validarEmailInvalido(String email) {
	    if (!Pattern.matches(EMAIL_REGEX, email)) {
	        throw new EmailInvalidoException(email);
	    }
	}

	@Override
	public void salvarUsuario(LoginDTO dto) {
		validarNomeUsuario(dto.getNomeUsuario());
		validarEmailExistente(dto.getEmail());
		validarEmailInvalido(dto.getEmail());
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setRole(dto.getRole() == null ? Role.ROLE_USER : dto.getRole());
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void atualizarUsuario(Long id, LoginDTO dto) {
		validarEmailInvalido(dto.getEmail());
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
	
	@Override
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
