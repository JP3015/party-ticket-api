package com.jp.party_ticket_api.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.party_ticket_api.dto.LoginDTO;
import com.jp.party_ticket_api.response.ApiResponse;
import com.jp.party_ticket_api.security.JwtUtil;
import com.jp.party_ticket_api.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final IUsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UsuarioController(IUsuarioService usuarioService, JwtUtil jwtUtil, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.usuarioService = usuarioService;
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

    @PostMapping("/registrar")
    public ResponseEntity<ApiResponse> registrar(@RequestBody LoginDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity.ok(
           new ApiResponse(HttpStatus.CREATED.value(), "Usuário registrado com sucesso!", dto)
        );
    }

	
	@PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody LoginDTO dto) {
    	usuarioService.atualizarUsuario(id, dto);
    	return ResponseEntity.ok(
    		new ApiResponse(HttpStatus.OK.value(), "Usuário atualizado com sucesso.", dto)
    	);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDTO dto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getNomeUsuario());

        if (userDetails != null && passwordEncoder.matches(dto.getSenha(), userDetails.getPassword())) {
            String token = jwtUtil.gerarToken(userDetails);
            return ResponseEntity.ok(
            	new ApiResponse(HttpStatus.OK.value(), "Usuário logado.", token)
        	);
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "Credenciais inválidas.", null));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletarUsuario(@PathVariable Long id) {
    	usuarioService.deletarUsuario(id);
    	return ResponseEntity.ok(
    		new ApiResponse(HttpStatus.OK.value(), "Usuário deletado com sucesso.", null)
        );
    }
}

