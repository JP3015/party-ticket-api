package com.jp.party_ticket_api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.party_ticket_api.domain.Balada;
import com.jp.party_ticket_api.dto.BaladaDTO;
import com.jp.party_ticket_api.exception.ExcedeuCapacidadeException;
import com.jp.party_ticket_api.repository.BaladaRepository;
import com.jp.party_ticket_api.service.interfaces.IBaladaService;

@Service
public class BaladaServiceImpl implements IBaladaService{
	
	@Autowired
	private BaladaRepository baladaRepository;
	
	public BaladaServiceImpl(BaladaRepository baladaRepository) {
		this.baladaRepository = baladaRepository;
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
	public void criarBalada(Balada balada) {
		if(balada.getCapacidade() < balada.getIngressosDisponiveis()) {
			throw new ExcedeuCapacidadeException();
		}
		
		baladaRepository.save(balada);
	}

	@Override
	public void atualizarBalada(Long id, BaladaDTO balada) {
		if(balada.getCapacidade() < balada.getIngressosDisponiveis()) {
			throw new ExcedeuCapacidadeException();
		}
		
		baladaRepository.updateBalada(id, balada.getNomeEvento(), balada.getData(), balada.getLocal(), balada.getCapacidade(), balada.getIngressosDisponiveis());
	}

	@Override
	public void atualizarBaladaIngressosDisponiveis(Long id, int ingressosDisponiveis) {
		BaladaDTO balada = buscarId(id);
		
		if(balada.getCapacidade() < ingressosDisponiveis) {
			throw new ExcedeuCapacidadeException();
		}
		
		baladaRepository.updateBaladaIngressosDisponiveis(id, ingressosDisponiveis);
		
	}
	
	@Override
	public void deletarBalada(Long id) {
		baladaRepository.deleteById(id);
	}

}
