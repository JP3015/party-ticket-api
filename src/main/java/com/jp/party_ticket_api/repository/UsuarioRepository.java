package com.jp.party_ticket_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.party_ticket_api.domain.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.nomeUsuario = :username")
	Optional<Usuario> findByUsername(@Param("username") String username);
	
	@Query(value = "SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Modifying
    @Transactional
	@Query(value = "UPDATE Usuario u SET\n"
			+ "u.nomeUsuario = :username,\n"
			+ "u.email = :email,\n"
			+ "u.senha = :senha\n"
			+ "WHERE u.id = :id")
	void updateUsuario(
			@Param("id") Long id,
			@Param("username") String username,
			@Param("email") String email,
			@Param("senha") String senha);
	
	
	
	@Modifying
    @Transactional
	@Query(value = "UPDATE Usuario u SET u.senha = :senha WHERE u.id = :id")
	void updateSenha(
			@Param("id") Long id,
			@Param("senha") String senha);

}



