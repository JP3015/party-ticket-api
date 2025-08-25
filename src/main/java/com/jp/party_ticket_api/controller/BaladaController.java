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

import com.jp.party_ticket_api.domain.Balada;
import com.jp.party_ticket_api.dto.BaladaDTO;
import com.jp.party_ticket_api.response.ApiResponse;
import com.jp.party_ticket_api.service.interfaces.IBaladaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/baladas")
public class BaladaController {

    private final IBaladaService baladaService;

    @Autowired
    public BaladaController(IBaladaService baladaService) {
        this.baladaService = baladaService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse> criarBalada(@Valid @RequestBody Balada balada) {
    	
    	baladaService.criarBalada(balada);
    	return ResponseEntity
    			.status(HttpStatus.CREATED.value())
    	        .body(
		    		new ApiResponse(HttpStatus.CREATED.value(), "Balada registrada com sucesso!", balada)
		    	);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarBalada(
            @PathVariable Long id,
            @RequestBody BaladaDTO balada) {

    	baladaService.atualizarBalada(id, balada);
    	return ResponseEntity.ok(
    		new ApiResponse(HttpStatus.OK.value(), "Balada atualizada com sucesso.", balada)
        );
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/ingressos/{quantidadeIngressos}")
    public ResponseEntity<ApiResponse> atualizarBaladaIngressosDisponiveis(
            @PathVariable Long id,
            @PathVariable int quantidadeIngressos) {

    	baladaService.atualizarBaladaIngressosDisponiveis(id, quantidadeIngressos);
    	return ResponseEntity.ok(
        	new ApiResponse(HttpStatus.OK.value(), "Ingressos atualizados com sucesso.", null)
        );
    }
    
    @GetMapping("/nome/{nomeBalada}")
    public ResponseEntity<List<BaladaDTO>> buscarNomeBalada(@PathVariable String nomeBalada) {
        
    	List<BaladaDTO> dto = baladaService.buscarNomeBalada(nomeBalada);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/data/{data}")
    public ResponseEntity<List<BaladaDTO>> buscarDataBalada(@PathVariable LocalDate data) {
        
    	List<BaladaDTO> dto = baladaService.buscarData(data);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BaladaDTO> buscarId(@PathVariable Long id) {
        
    	BaladaDTO dto = baladaService.buscarId(id);
        return ResponseEntity.ok(dto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletarBalada(
            @PathVariable Long id) {

    	baladaService.deletarBalada(id);
    	return ResponseEntity.ok(
            new ApiResponse(HttpStatus.OK.value(), "Balada deletada com sucesso.", null)
        );
    }

}
