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
			+ "c.aniversario\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE c.nome = :nome")
    List<ConvidadoDTO> findByNomeConvidado(String nome);
    
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.ConvidadoDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.aniversario\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE c.email = :email")
    List<ConvidadoDTO> findByEmail(String email);
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.ConvidadoDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.aniversario\n"
			+ ")\n"
			+ "FROM Convidado c\n"
			+ "WHERE c.id = :id")
	ConvidadoDTO findByIdConvidado(@Param("id") Long id);
	
	@Query("SELECT a.capacidade - COUNT(c)\n"
			+ "FROM Aniversario a\n"
			+ "LEFT JOIN Convidado c ON c.aniversario.id = a.id\n"
			+ "WHERE a.id = :id\n"
			+ "GROUP BY a.capacidade\n")
	Integer capacidadeRestante(@Param("id") Long id);
    
    
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
}
