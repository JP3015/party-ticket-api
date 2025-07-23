package com.jp.party_ticket_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.party_ticket_api.domain.Convidado;
import com.jp.party_ticket_api.dto.ConvidadoDTO;
import com.jp.party_ticket_api.service.interfaces.IConvidadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadoController {

	private IConvidadoService convidadoService;

	public ConvidadoController(IConvidadoService convidadoService) {
		this.convidadoService = convidadoService;
	}
	
	
	@PutMapping("/{id}")
    public ResponseEntity<String> atualizarConvidado(
            @PathVariable Long id,
            @RequestBody ConvidadoDTO convidado) {

		convidadoService.atualizarConvidado(id, convidado);
		return ResponseEntity.ok("Convidado atualizado com sucesso.");
    }
	
	@PostMapping
    public ResponseEntity<String> criarConvidado(@Valid @RequestBody Convidado convidado) {
    	
		convidadoService.criarConvidado(convidado);
		return ResponseEntity.ok("Convidado registrado com sucesso!");
    }
	
	@GetMapping("/nome/{nomeConvidado}")
    public ResponseEntity<List<ConvidadoDTO>> buscarNomeConvidado(@PathVariable String nomeConvidado) {
        
    	List<ConvidadoDTO> dto = convidadoService.buscarNome(nomeConvidado);
        return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/email/{email}")
    public ResponseEntity<List<ConvidadoDTO>> buscarEmail(@PathVariable String email) {
        
    	List<ConvidadoDTO> dto = convidadoService.buscarEmail(email);
        return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ConvidadoDTO> buscarId(@PathVariable Long id) {
        
		ConvidadoDTO dto = convidadoService.buscarId(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarConvidado(
            @PathVariable Long id) {

    	convidadoService.deletarConvidado(id);
    	return ResponseEntity.ok("Convidado deletado com sucesso.");
    }
}
