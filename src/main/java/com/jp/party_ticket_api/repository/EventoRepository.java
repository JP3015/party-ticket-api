package com.jp.party_ticket_api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Evento;
import com.jp.party_ticket_api.dto.EventoDTO;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.EventoDTO(\n"
			+ "e.nomeEvento,\n"
			+ "e.data,\n"
			+ "e.local,\n"
			+ "e.capacidade,\n"
			+ "e.ingressosDisponiveis\n"
			+ ")\n"
			+ "FROM Evento e WHERE e.nomeEvento = :nome")
    List<EventoDTO> findByNomeEvento(@Param("nome") String nome);

	@Query(value = "SELECT new com.jp.party_ticket_api.dto.EventoDTO(\n"
			+ "e.nomeEvento,\n"
			+ "e.data,\n"
			+ "e.local,\n"
			+ "e.capacidade,\n"
			+ "e.ingressosDisponiveis\n"
			+ ")\n"
			+ "FROM Evento e WHERE DATE(e.data) = :data")
    List<EventoDTO> findByData(@Param("data") LocalDate data);
    
    
    @Query(value = "UPDATE Evento e SET e.ingressosDisponiveis = :ingressosDisponiveis WHERE DATE(e.data) = :data")
    void updateEventoIngressosDisponiveis(
    		@Param("id") Long id,
    		@Param("ingressosDisponiveis") int ingressosDisponiveis);
    
    
    @Query(value = "UPDATE Evento e SET \n"
    		+ "e.nomeEvento = :nomeEvento,\n"
    		+ "e.data = :data,\n"
    		+ "e.local = :local,\n"
    		+ "e.capacidade = :capacidade,\n"
    		+ "e.ingressosDisponiveis = :ingressosDisponiveis\n"
    		+ "WHERE e.id = :id")
    void updateEvento(
    		@Param("id") Long id, 
    		@Param("nomeEvento") String nomeEvento,
    		@Param("data") LocalDateTime data,
    		@Param("local") String local,
    		@Param("capacidade") int capacidade,
    		@Param("ingressosDisponiveis") int ingressosDisponiveis);
}