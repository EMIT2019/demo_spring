package com.bank_api.demo.service.result;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank_api.demo.model.Result;
import com.bank_api.demo.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {

	private final ResultRepository rRepository;
	
	public ResultServiceImpl(ResultRepository resultRepository) {
		this.rRepository = resultRepository;
	}
	
	@Override
	public List<Result> findAll() {
		return rRepository.findAll();
	}

	@Override
	public Result findById(Integer id) {
		Optional<Result> result = rRepository.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		
		throw new RuntimeException("The item with the id "+id+" does not exists.");
	}

	@Override
	public Result save(Result entity) {
		return rRepository.save(entity);
	}

	@Override
	public Result update(Result entity) {
		return rRepository.save(entity);
	}

	@Override
	public void remove(Integer id) {
		rRepository.deleteById(id);
	}

}
