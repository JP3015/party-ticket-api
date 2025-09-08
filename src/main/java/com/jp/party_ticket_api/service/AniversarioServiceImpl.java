package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;
import com.jp.party_ticket_api.repository.AniversarioRepository;
import com.jp.party_ticket_api.repository.ConvidadoRepository;
import com.jp.party_ticket_api.service.interfaces.IAniversarioService;
import com.jp.party_ticket_api.validator.DataValidator;

@Service
public class AniversarioServiceImpl implements IAniversarioService{
	
	private final AniversarioRepository aniversarioRepository;
	private final ConvidadoRepository convidadoRepository;
	private final DataValidator dataValidator;
	
	public AniversarioServiceImpl(AniversarioRepository aniversarioRepository, ConvidadoRepository convidadoRepository, DataValidator dataValidator) {
		this.aniversarioRepository = aniversarioRepository;
		this.convidadoRepository = convidadoRepository;
		this.dataValidator = dataValidator;
	}
	
	@Override
	public Integer capacidadeRestante(Long id) {
		return aniversarioRepository.capacidadeRestante(id);
	}

	@Override
	public List<AniversarioDTO> buscarNomeAniversario(String nome) {
		return aniversarioRepository.findByNomeAniversario(nome);
	}
	
	@Override
	public List<Aniversario> listarAniversarios() {
		 return aniversarioRepository.findAll();
	}

	@Override
	public List<AniversarioDTO> buscarData(LocalDate data) {
		return aniversarioRepository.findByData(data);
	}
	
	@Override
	public AniversarioDTO buscarId(Long id) {
		return aniversarioRepository.findByIdAniversario(id);
	}

	@Override
	public void criarAniversario(Aniversario aniversario) {
		dataValidator.validarData(aniversario.getData());
		
		aniversarioRepository.save(aniversario);
	}

	@Override
	public void atualizarAniversario(Long id, AniversarioDTO aniversario) {
		dataValidator.validarData(aniversario.getData());
		
		aniversarioRepository.updateAniversario(id, aniversario.getNomeEvento(), aniversario.getData(), aniversario.getLocal(), aniversario.getNomeAniversariante(), 
				aniversario.getIdadeAniversariante(), aniversario.getCapacidade());
	}
	
	@Override
	public void deletarAniversario(Long id) {
		convidadoRepository.deleteByIdAniversario(id);
		aniversarioRepository.deleteById(id);
	}

}
