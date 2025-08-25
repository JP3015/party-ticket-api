package com.jp.party_ticket_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;
import com.jp.party_ticket_api.response.ApiResponse;
import com.jp.party_ticket_api.service.interfaces.IAniversarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aniversarios")
public class AniversarioController {

    private final IAniversarioService aniversarioService;

    @Autowired
    public AniversarioController(IAniversarioService aniversarioService) {
        this.aniversarioService = aniversarioService;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse> criarAniversario(@Valid @RequestBody Aniversario aniversario) {
    	aniversarioService.criarAniversario(aniversario);
    	return ResponseEntity
    			.status(HttpStatus.CREATED.value())
    	        .body(
		    		new ApiResponse(HttpStatus.CREATED.value(), "Aniversário registrado com sucesso!", aniversario)
		    	);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarAniversario(
            @PathVariable Long id,
            @RequestBody AniversarioDTO aniversario) {
    	aniversarioService.atualizarAniversario(id, aniversario);
    	return ResponseEntity.ok(
    		new ApiResponse(HttpStatus.OK.value(), "Aniversário atualizado com sucesso.", aniversario)
    	);
    }
    
    @GetMapping("/nome/{nomeAniversario}")
    public ResponseEntity<List<AniversarioDTO>> buscarNomeAniversario(@PathVariable String nomeAniversario) {
    	List<AniversarioDTO> dto = aniversarioService.buscarNomeAniversario(nomeAniversario);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/data/{data}")
    public ResponseEntity<List<AniversarioDTO>> buscarDataAniversario(@PathVariable LocalDate data) {
    	List<AniversarioDTO> dto = aniversarioService.buscarData(data);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AniversarioDTO> buscarId(@PathVariable Long id) {
    	AniversarioDTO dto = aniversarioService.buscarId(id);
        return ResponseEntity.ok(dto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletarAniversario(
            @PathVariable Long id) {
    	aniversarioService.deletarAniversario(id);
    	return ResponseEntity.ok(
        	new ApiResponse(HttpStatus.OK.value(), "Aniversário deletado com sucesso.", null)
        );
    }

}
