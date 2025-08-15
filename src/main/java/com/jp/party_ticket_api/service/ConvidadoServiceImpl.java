package com.jp.party_ticket_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Convidado;
import com.jp.party_ticket_api.dto.ConvidadoDTO;
import com.jp.party_ticket_api.exception.ExcedeuCapacidadeException;
import com.jp.party_ticket_api.repository.ConvidadoRepository;
import com.jp.party_ticket_api.service.interfaces.IAniversarioService;
import com.jp.party_ticket_api.service.interfaces.IConvidadoService;

@Service
public class ConvidadoServiceImpl implements IConvidadoService{
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public ConvidadoServiceImpl(ConvidadoRepository convidadoRepository) {
		this.convidadoRepository = convidadoRepository;
	}

	private void validarCapacidade(Long id) {
		if(capacidadeRestante(id) == 0) {
			throw new ExcedeuCapacidadeException("A quantidade de convidados excedeu a capacidade permitida.");
		}
	}
	
	@Override
	public Integer capacidadeRestante(Long id) {
		return convidadoRepository.capacidadeRestante(id);
	}
	
	@Override
	public List<ConvidadoDTO> buscarNome(String nome) {
		return convidadoRepository.findByNomeConvidado(nome);
	}

	@Override
	public List<ConvidadoDTO> buscarEmail(String email) {
		return convidadoRepository.findByEmail(email);
	}
	
	@Override
	public ConvidadoDTO buscarId(Long id) {
		return convidadoRepository.findByIdConvidado(id);
	}
	

	@Override
	public void criarConvidado(Convidado convidado) {
		validarCapacidade(convidado.getAniversario().getId());
		
		convidadoRepository.save(convidado);
	}

	@Override
	public void atualizarConvidado(Long id, ConvidadoDTO convidado) {
		convidadoRepository.updateConvidado(id, convidado.getNome(), convidado.getEmail());
	}

	@Override
	public void deletarConvidado(Long id) {
		convidadoRepository.deleteById(id);
	}

}
