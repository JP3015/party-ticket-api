package com.jp.party_ticket_api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Compra;
import com.jp.party_ticket_api.dto.CompraDTO;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query(value = "SELECT c FROM CompraDTO c WHERE c.nomeComprador = :nome")
    List<CompraDTO> findByNomeComprador(String nome);
    
    @Query(value = "SELECT c FROM CompraDTO c WHERE c.email = :email")
    List<CompraDTO> findByEmail(String email);
    
    @Query(value = "SELECT c FROM CompraDTO c WHERE DATE(c.dataCompra) = :data")
    List<CompraDTO> findByDataCompra(@Param("data") LocalDate data);
    
    
    @Query(value = "UPDATE Compra c SET "
    		+ "c.nomeComprador = :nomeComprador,"
    		+ "c.dataCompra = :dataCompra,"
    		+ "c.email = :email"
    		+ "c.quantidadeIngressos = :quantidadeIngressos,"
    		+ "c.ingressosDisponiveis = :ingressosDisponiveis"
    		+ "WHERE c.id = :id")
    void updateCompra(
    		@Param("id") Long id, 
    		@Param("nomeComprador") String nomeComprador,
    		@Param("dataCompra") LocalDateTime dataCompra,
    		@Param("email") String email,
    		@Param("quantidadeIngressos") int quantidadeIngressos);
}
