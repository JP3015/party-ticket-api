package com.jp.party_ticket_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Convidado;
import com.jp.party_ticket_api.dto.ConvidadoDTO;
import com.jp.party_ticket_api.repository.AniversarioRepository;
import com.jp.party_ticket_api.repository.ConvidadoRepository;
import com.jp.party_ticket_api.service.interfaces.IConvidadoService;
import com.jp.party_ticket_api.validator.CapacidadeValidator;
import com.jp.party_ticket_api.validator.EmailValidator;

@Service
public class ConvidadoServiceImpl implements IConvidadoService{
	
	private final ConvidadoRepository convidadoRepository;
	private final AniversarioRepository aniversarioRepository;
	private final EmailValidator emailValidator; 
	private final CapacidadeValidator capacidadeValidator; 
	
	public ConvidadoServiceImpl(ConvidadoRepository convidadoRepository, AniversarioRepository aniversarioRepository, EmailValidator emailValidator, CapacidadeValidator capacidadeValidator) {
		this.convidadoRepository = convidadoRepository;
		this.aniversarioRepository = aniversarioRepository;
		this.emailValidator = emailValidator;
		this.capacidadeValidator = capacidadeValidator;
	}

	@Override
	public Integer capacidadeRestante(Long id) {
		return aniversarioRepository.capacidadeRestante(id);
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
		capacidadeValidator.validarCapacidade(capacidadeRestante(convidado.getAniversario().getId()));
		emailValidator.validarEmail(convidado.getEmail());
		
		convidadoRepository.save(convidado);
	}

	@Override
	public void atualizarConvidado(Long id, ConvidadoDTO convidado) {
		emailValidator.validarEmail(convidado.getEmail());
		convidadoRepository.updateConvidado(id, convidado.getNome(), convidado.getEmail());
	}

	@Override
	public void deletarConvidado(Long id) {
		convidadoRepository.deleteById(id);
	}

	@Override
	public List<Convidado> listarConvidado(Long id) {
		return convidadoRepository.findByAniversario(id);
	}

}
