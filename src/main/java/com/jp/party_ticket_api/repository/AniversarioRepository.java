package com.jp.party_ticket_api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;

import jakarta.transaction.Transactional;

@Repository
public interface AniversarioRepository extends JpaRepository<Aniversario, Long> {
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.AniversarioDTO(\n"
			+ "a.id,\n"
			+ "a.nomeEvento,\n"
			+ "a.data,\n"
			+ "a.local,\n"
			+ "a.nomeAniversariante,\n"
			+ "a.idadeAniversariante,\n"
			+ "a.capacidade"
			+ ")\n"
			+ "FROM Aniversario a WHERE a.nomeEvento = :nome")
    List<AniversarioDTO> findByNomeAniversario(@Param("nome") String nome);

	@Query(value = "SELECT new com.jp.party_ticket_api.dto.AniversarioDTO(\n"
			+ "a.id,\n"
			+ "a.nomeEvento,\n"
			+ "a.data,\n"
			+ "a.local,\n"
			+ "a.nomeAniversariante,\n"
			+ "a.idadeAniversariante,\n"
			+ "a.capacidade"
			+ ")\n"
			+ "FROM Aniversario a WHERE DATE(a.data) = :data")
    List<AniversarioDTO> findByData(@Param("data") LocalDate data);
	
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.AniversarioDTO(\n"
			+ "a.id,\n"
			+ "a.nomeEvento,\n"
			+ "a.data,\n"
			+ "a.local,\n"
			+ "a.nomeAniversariante,\n"
			+ "a.idadeAniversariante,\n"
			+ "a.capacidade"
			+ ")\n"
			+ "FROM Aniversario a WHERE a.id = :id")
	AniversarioDTO findByIdAniversario(@Param("id") Long id);
    
	
	@Modifying
	@Transactional
    @Query(value = "UPDATE Aniversario a SET \n"
    		+ "a.nomeEvento = :nomeEvento,\n"
    		+ "a.data = :data,\n"
    		+ "a.local = :local,\n"
    		+ "a.nomeAniversariante = :nomeAniversariante,\n"
    		+ "a.idadeAniversariante = :idadeAniversariante,\n"
    		+ "a.capacidade = :capacidade\n"
    		+ "WHERE a.id = :id")
    void updateAniversario(
    		@Param("id") Long id, 
    		@Param("nomeEvento") String nomeEvento,
    		@Param("data") LocalDateTime data,
    		@Param("local") String local,
    		@Param("nomeAniversariante") String nomeAniversariante,
    		@Param("idadeAniversariante") int idadeAniversariante,
    		@Param("capacidade") int capacidade);
}