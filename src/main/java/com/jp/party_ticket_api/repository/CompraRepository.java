package com.jp.party_ticket_api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;

import jakarta.transaction.Transactional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query(value = "SELECT new com.jp.party_ticket_api.dto.CompraDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.quantidadeIngressos,\n"
			+ "c.dataCompra,\n"
			+ "c.balada\n"
			+ ")\n"
			+ "FROM Compra c\n"
			+ "WHERE c.nome = :nome")
    List<CompraDTO> findByNomeComprador(String nome);
    
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.CompraDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.quantidadeIngressos,\n"
			+ "c.dataCompra,\n"
			+ "c.balada\n"
			+ ")\n"
			+ "FROM Compra c\n"
			+ "WHERE c.email = :email")
    List<CompraDTO> findByEmail(String email);
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.CompraDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.quantidadeIngressos,\n"
			+ "c.dataCompra,\n"
			+ "c.balada\n"
			+ ")\n"
			+ "FROM Compra c\n"
			+ "WHERE DATE(c.dataCompra) = :data")
    List<CompraDTO> findByDataCompra(@Param("data") LocalDate data);
	
	@Query(value = "SELECT new com.jp.party_ticket_api.dto.CompraDTO(\n"
			+ "c.id,\n"
			+ "c.nome,\n"
			+ "c.email,\n"
			+ "c.quantidadeIngressos,\n"
			+ "c.dataCompra,\n"
			+ "c.balada\n"
			+ ")\n"
			+ "FROM Compra c\n"
			+ "WHERE c.id = :id")
    CompraDTO findByIdCompra(@Param("id") Long id);
    
    
	@Modifying
    @Transactional
    @Query(value = "UPDATE Compra c SET\n"
    		+ "c.nome = :nomeComprador,\n"
    		+ "c.dataCompra = :dataCompra,\n"
    		+ "c.email = :email,\n"
    		+ "c.quantidadeIngressos = :quantidadeIngressos\n"
    		+ "WHERE c.id = :id")
    void updateCompra(
    		@Param("id") Long id, 
    		@Param("nomeComprador") String nomeComprador,
    		@Param("dataCompra") LocalDateTime dataCompra,
    		@Param("email") String email,
    		@Param("quantidadeIngressos") int quantidadeIngressos);
}
