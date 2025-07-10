package com.jp.party_ticket_api.controller;

import java.time.LocalDate;
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

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;
import com.jp.party_ticket_api.service.interfaces.ICompraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

	private ICompraService compraService;

	public CompraController(ICompraService compraService) {
		this.compraService = compraService;
	}
	
	
	@PutMapping("/{id}")
    public ResponseEntity<String> atualizarCompra(
            @PathVariable Long id,
            @RequestBody CompraDTO compra) {

		compraService.atualizarCompra(id, compra);
		return ResponseEntity.ok("Compra atualizada com sucesso.");
    }
	
	@PostMapping
    public ResponseEntity<Void> criarCompra(@Valid @RequestBody Compra compra) {
    	
		compraService.criarCompra(compra);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@GetMapping("/nome/{nomeComprador}")
    public ResponseEntity<List<CompraDTO>> buscarNomeComprador(@PathVariable String nomeComprador) {
        
    	List<CompraDTO> dto = compraService.buscarNome(nomeComprador);
        return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/email/{email}")
    public ResponseEntity<List<CompraDTO>> buscarEmail(@PathVariable String email) {
        
    	List<CompraDTO> dto = compraService.buscarEmail(email);
        return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/data/{data}")
    public ResponseEntity<List<CompraDTO>> buscarDataCompra(@PathVariable LocalDate data) {
        
    	List<CompraDTO> dto = compraService.buscarDataCompra(data);
        return ResponseEntity.ok(dto);
    }
	
	@GetMapping("/id/{id}")
    public ResponseEntity<CompraDTO> buscarId(@PathVariable Long id) {
        
    	CompraDTO dto = compraService.buscarId(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCompra(
            @PathVariable Long id) {

    	compraService.deletarCompra(id);
    	return ResponseEntity.ok("Compra deletada com sucesso.");
    }
	
}
