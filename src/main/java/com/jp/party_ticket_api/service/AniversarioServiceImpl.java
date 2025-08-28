package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Aniversario;
import com.jp.party_ticket_api.dto.AniversarioDTO;
import com.jp.party_ticket_api.repository.AniversarioRepository;
import com.jp.party_ticket_api.repository.ConvidadoRepository;
import com.jp.party_ticket_api.service.interfaces.IAniversarioService;

@Service
public class AniversarioServiceImpl implements IAniversarioService{
	
	private AniversarioRepository aniversarioRepository;
	private ConvidadoRepository convidadoRepository;
	
	public AniversarioServiceImpl(AniversarioRepository aniversarioRepository, ConvidadoRepository convidadoRepository) {
		this.aniversarioRepository = aniversarioRepository;
		this.convidadoRepository = convidadoRepository;
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
	public List<AniversarioDTO> listarAniversarios() {
		 return aniversarioRepository.findAll().stream()
			        .map(a -> new AniversarioDTO(a, capacidadeRestante(a.getId())))
			        .toList();
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
		aniversarioRepository.save(aniversario);
	}

	@Override
	public void atualizarAniversario(Long id, AniversarioDTO aniversario) {
		aniversarioRepository.updateAniversario(id, aniversario.getNomeEvento(), aniversario.getData(), aniversario.getLocal(), aniversario.getNomeAniversariante(), 
				aniversario.getIdadeAniversariante(), aniversario.getCapacidade());
	}
	
	@Override
	public void deletarAniversario(Long id) {
		convidadoRepository.deleteByIdAniversario(id);
		aniversarioRepository.deleteById(id);
	}

}
