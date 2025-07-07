package com.jp.party_ticket_api.controller;

import java.time.LocalDateTime;
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

import com.jp.party_ticket_api.domain.Evento;
import com.jp.party_ticket_api.dto.EventoDTO;
import com.jp.party_ticket_api.service.interfaces.IEventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final IEventoService eventoService;

    @Autowired
    public EventoController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEvento(
            @PathVariable Long id,
            @RequestBody EventoDTO evento) {

        eventoService.atualizarEvento(id, evento);
        return ResponseEntity.noContent().build(); 
    }
    
    @PutMapping("/{id}/ingressos")
    public ResponseEntity<Void> atualizarEventoIngressosDisponiveis(
            @PathVariable Long id,
            @RequestBody EventoDTO evento) {

        eventoService.atualizarEventoIngressosDisponiveis(id, evento.getQuantidadeIngressos());
        return ResponseEntity.noContent().build(); 
    }
    
    @PostMapping
    public ResponseEntity<Void> criarEvento(@Valid @RequestBody Evento evento) {
    	
    	eventoService.criarEvento(evento);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/nome/{nomeEvento}")
    public ResponseEntity<List<EventoDTO>> buscarNomeEvento(@PathVariable String nomeEvento) {
        
    	List<EventoDTO> dto = eventoService.buscarNomeEvento(nomeEvento);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/data/{data}")
    public ResponseEntity<List<EventoDTO>> buscarDataEvento(@PathVariable LocalDateTime data) {
        
    	List<EventoDTO> dto = eventoService.buscarData(data);
        return ResponseEntity.ok(dto);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(
            @PathVariable Long id) {

        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build(); 
    }

}
