package com.jp.party_ticket_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Convidado;
import com.jp.party_ticket_api.dto.ConvidadoDTO;

import jakarta.transaction.Transactional;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

	@Query(value = "SELECT new com.jp.party_ticket_api.dto.ConvidadoDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.aniversario,\n"
			+ "(c.aniversario.capacidade - SIZE(c.aniversario.convidados))\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<ConvidadoDTO> findByNomeConvidado(String nome);
    
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.ConvidadoDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.aniversario,\n"
			+ "(c.aniversario.capacidade - SIZE(c.aniversario.convidados))\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE c.email = :email")
    List<ConvidadoDTO> findByEmail(String email);
	
	
	@Query(value = "SELECT c FROM Convidado c WHERE c.aniversario.id = :id")
    List<Convidado> findByAniversario(Long id);
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.ConvidadoDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.aniversario,\n"
			+ "(c.aniversario.capacidade - SIZE(c.aniversario.convidados))\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE c.id = :id")
	ConvidadoDTO findByIdConvidado(@Param("id") Long id);
	
    
	@Modifying
    @Transactional
    @Query(value = "UPDATE Convidado c SET\n"
    		+ "c.nome = :nomeConvidado,\n"
    		+ "c.email = :email\n"
    		+ "WHERE c.id = :id")
    void updateConvidado(
    		@Param("id") Long id, 
    		@Param("nomeConvidado") String nomeConvidado,
    		@Param("email") String email);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Convidado c WHERE c.aniversario.id = :id")
	void deleteByIdAniversario(@Param("id") Long id);
}
