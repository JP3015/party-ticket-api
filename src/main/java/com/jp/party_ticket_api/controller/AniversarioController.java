package com.jp.party_ticket_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;
import com.jp.party_ticket_api.service.interfaces.IAniversarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aniversarios")
public class AniversarioController {

    private final IAniversarioService aniversarioService;

    @Autowired
    public AniversarioController(IAniversarioService aniversarioService) {
        this.aniversarioService = aniversarioService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAniversario(
            @PathVariable Long id,
            @RequestBody AniversarioDTO aniversario) {
    	aniversarioService.atualizarAniversario(id, aniversario);
        return ResponseEntity.ok("Aniversário atualizado com sucesso.");
    }
    
    @PostMapping
    public ResponseEntity<String> criarAniversario(@Valid @RequestBody Aniversario aniversario) {
    	aniversarioService.criarAniversario(aniversario);
    	return ResponseEntity.ok("Aniversário registrado com sucesso!");
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
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAniversario(
            @PathVariable Long id) {
    	aniversarioService.deletarAniversario(id);
        return ResponseEntity.ok("Aniversário deletado com sucesso.");
    }

}
