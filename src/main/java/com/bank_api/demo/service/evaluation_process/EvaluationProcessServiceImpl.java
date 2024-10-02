package com.bank_api.demo.service.evaluation_process;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank_api.demo.model.EvaluationProcess;
import com.bank_api.demo.repository.EvaluationProcessRepository;
@Service
public class EvaluationProcessServiceImpl implements EvaluationProcessService {

	private final EvaluationProcessRepository epRepository;
	
	public EvaluationProcessServiceImpl(EvaluationProcessRepository evaluationProcessRepository) {
		this.epRepository = evaluationProcessRepository;
	}
	
	@Override
	public List<EvaluationProcess> findAll() {
		return epRepository.findAll();
	}

	@Override
	public EvaluationProcess findById(Integer id) {
		Optional<EvaluationProcess> epOption = epRepository.findById(id);
		
		if(epOption.isPresent()) {
			return epOption.get();
		}
		
		throw new RuntimeException("The item with the id "+id+" does not exists.");
	}

	@Override
	public EvaluationProcess save(EvaluationProcess entity) {
		return epRepository.save(entity);
	}

	@Override
	public EvaluationProcess update(EvaluationProcess entity) {
		return epRepository.save(entity);
	}

	@Override
	public void remove(Integer id) {
		epRepository.deleteById(id);
	}

}
