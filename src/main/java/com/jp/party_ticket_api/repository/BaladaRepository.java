package com.jp.party_ticket_api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Balada;
import com.jp.party_ticket_api.dto.BaladaDTO;

import jakarta.transaction.Transactional;

@Repository
public interface BaladaRepository extends JpaRepository<Balada, Long> {
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.BaladaDTO(\n"
			+ "b.id,\n"
			+ "b.nomeEvento,\n"
			+ "b.data,\n"
			+ "b.local,\n"
			+ "b.ingressosDisponiveis,\n"
			+ "b.capacidade\n"
			+ ")\n"
			+ "FROM Balada b WHERE b.nomeEvento = :nome")
    List<BaladaDTO> findByNomeBalada(@Param("nome") String nome);

	@Query(value = "SELECT new com.jp.party_ticket_api.dto.BaladaDTO(\n"
			+ "b.id,\n"
			+ "b.nomeEvento,\n"
			+ "b.data,\n"
			+ "b.local,\n"
			+ "b.ingressosDisponiveis,\n"
			+ "b.capacidade\n"
			+ ")\n"
			+ "FROM Balada b WHERE DATE(b.data) = :data")
    List<BaladaDTO> findByData(@Param("data") LocalDate data);
	
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.BaladaDTO(\n"
			+ "b.id,\n"
			+ "b.nomeEvento,\n"
			+ "b.data,\n"
			+ "b.local,\n"
			+ "b.ingressosDisponiveis,\n"
			+ "b.capacidade\n"
			+ ")\n"
			+ "FROM Balada b WHERE b.id = :id")
	BaladaDTO findByIdBalada(@Param("id") Long id);
    
	
	@Modifying
	@Transactional
    @Query(value = "UPDATE Balada b SET b.ingressosDisponiveis = :ingressosDisponiveis WHERE b.id = :id")
    void updateBaladaIngressosDisponiveis(
    		@Param("id") Long id,
    		@Param("ingressosDisponiveis") int ingressosDisponiveis);
    
	@Modifying
	@Transactional
    @Query(value = "UPDATE Balada b SET \n"
    		+ "b.nomeEvento = :nomeEvento,\n"
    		+ "b.data = :data,\n"
    		+ "b.local = :local,\n"
    		+ "b.capacidade = :capacidade,\n"
    		+ "b.ingressosDisponiveis = :ingressosDisponiveis\n"
    		+ "WHERE b.id = :id")
    void updateBalada(
    		@Param("id") Long id, 
    		@Param("nomeEvento") String nomeEvento,
    		@Param("data") LocalDateTime data,
    		@Param("local") String local,
    		@Param("capacidade") int capacidade,
    		@Param("ingressosDisponiveis") int ingressosDisponiveis);
}