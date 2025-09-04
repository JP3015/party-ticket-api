package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Balada;
import com.jp.party_ticket_api.dto.BaladaDTO;
import com.jp.party_ticket_api.repository.BaladaRepository;
import com.jp.party_ticket_api.repository.CompraRepository;
import com.jp.party_ticket_api.service.interfaces.IBaladaService;
import com.jp.party_ticket_api.validator.CapacidadeValidator;

@Service
public class BaladaServiceImpl implements IBaladaService{
	
	private final BaladaRepository baladaRepository;
	private final CompraRepository compraRepository;
	private final CapacidadeValidator capacidadeValidator; 
	
	public BaladaServiceImpl(BaladaRepository baladaRepository, CompraRepository compraRepository, CapacidadeValidator capacidadeValidator) {
		this.baladaRepository = baladaRepository;
		this.compraRepository = compraRepository;
		this.capacidadeValidator = capacidadeValidator;
	}
	
	@Override
	public List<BaladaDTO> buscarNomeBalada(String nome) {
		return baladaRepository.findByNomeBalada(nome);
	}

	@Override
	public List<BaladaDTO> buscarData(LocalDate data) {
		return baladaRepository.findByData(data);
	}
	
	@Override
	public BaladaDTO buscarId(Long id) {
		return baladaRepository.findByIdBalada(id);
	}
	
	@Override
	public List<Balada> listarBaladas() {
		return baladaRepository.findAll();
	}

	@Override
	public void criarBalada(Balada balada) {
		capacidadeValidator.validarCapacidade(balada.getCapacidade(), balada.getIngressosDisponiveis());
		
		baladaRepository.save(balada);
	}

	@Override
	public void atualizarBalada(Long id, BaladaDTO balada) {
		capacidadeValidator.validarCapacidade(balada.getCapacidade(), balada.getIngressosDisponiveis());
		
		baladaRepository.updateBalada(id, balada.getNomeEvento(), balada.getData(), balada.getLocal(), balada.getCapacidade(), balada.getIngressosDisponiveis());
	}

	@Override
	public void atualizarBaladaIngressosDisponiveis(Long id, int ingressosDisponiveis) {
		BaladaDTO balada = buscarId(id);
		
		capacidadeValidator.validarCapacidade(balada.getCapacidade(), ingressosDisponiveis);
		
		baladaRepository.updateBaladaIngressosDisponiveis(id, ingressosDisponiveis);
		
	}
	
	@Override
	public void deletarBalada(Long id) {
		compraRepository.deleteByIdBalada(id);;
		baladaRepository.deleteById(id);
	}

}
