package com.bank_api.demo.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.bank_api.demo.dto.EvaluationProcessDto;
import com.bank_api.demo.dto.mapper.EvaluationProcessMapper;
import com.bank_api.demo.dto.mapper.ResultMapper;
import com.bank_api.demo.model.EvaluationProcess;

@Component
public class EvaluationProcessMapperImpl implements EvaluationProcessMapper {

	private final ResultMapper rMapper;
	
	public EvaluationProcessMapperImpl(ResultMapper resultMapper) {
		this.rMapper = resultMapper;
	}
	
	@Override
	public EvaluationProcessDto toGetDtoEntity(EvaluationProcess entity) {
		EvaluationProcessDto epDto = new EvaluationProcessDto();
		epDto.setProcess_id(entity.getProcess_id());
		epDto.setStatus(entity.getStatus());
		epDto.setResultDto(
				rMapper.toGetDtoEntity(entity.getResult())
				);
		return epDto;
	}

	@Override
	public EvaluationProcess toPostEntity(EvaluationProcessDto dto) {
		EvaluationProcess evaluationProcess = new EvaluationProcess();
		evaluationProcess.setProcess_id(dto.getProcess_id());
		evaluationProcess.setStatus(dto.getStatus());
		evaluationProcess.setResult(
				rMapper.toPostEntity(dto.getResultDto())
				);
		return evaluationProcess;
	}

}
