package com.jp.party_ticket_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.party_ticket_api.dto.AniversarioDTO;
import com.jp.party_ticket_api.dto.LoginDTO;
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
    public ResponseEntity<String> registrar(@RequestBody LoginDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody LoginDTO dto) {
    	usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity.ok("Usuário atualizado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getNomeUsuario());

        if (userDetails != null && passwordEncoder.matches(dto.getSenha(), userDetails.getPassword())) {
            String token = jwtUtil.gerarToken(userDetails);
            return ResponseEntity.ok(token);
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
    	usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }
}

