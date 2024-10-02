package com.bank_api.demo.controllers.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank_api.demo.controllers.EvaluationProcessController;
import com.bank_api.demo.dto.EvaluationProcessDto;
import com.bank_api.demo.dto.mapper.EvaluationProcessMapper;
import com.bank_api.demo.model.EvaluationProcess;
import com.bank_api.demo.service.evaluation_process.EvaluationProcessService;

@RequestMapping("/evaluation")
@RestController
public class EvaluationProcessControllerImpl implements EvaluationProcessController {

	private final EvaluationProcessService epService;
	private final EvaluationProcessMapper epMapper;
	
	public EvaluationProcessControllerImpl(EvaluationProcessService evaluationService, EvaluationProcessMapper evaluationMapper) {
		this.epService = evaluationService;
		this.epMapper = evaluationMapper;
	}
	
	@Override
	public ResponseEntity<List<EvaluationProcessDto>> findAll() {
		List<EvaluationProcessDto> evaluationDto = epService.findAll().stream()
				.map(epMapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(evaluationDto);
	}

	@Override
	public ResponseEntity<EvaluationProcessDto> findById(Integer id) {
		EvaluationProcess evaluation;
		evaluation = epService.findById(id);
		return ResponseEntity.ok(epMapper.toGetDtoEntity(evaluation));
	}

	@Override
	public ResponseEntity<EvaluationProcessDto> save(EvaluationProcessDto dtoEntity) {
		EvaluationProcess evaluation, savedEvaluation;
		
		evaluation = epMapper.toPostEntity(dtoEntity);
		savedEvaluation = epService.save(evaluation);
		
		return new ResponseEntity<EvaluationProcessDto>(epMapper.toGetDtoEntity(savedEvaluation), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<EvaluationProcessDto>> getPage(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EvaluationProcessDto> update(Integer id, EvaluationProcessDto dtoEntity) {
		
		EvaluationProcess evaluation, savedEvaluation;
		dtoEntity.setProcess_id(id);
		evaluation = epMapper.toPostEntity(dtoEntity);
		savedEvaluation = epService.save(evaluation);
		
		return ResponseEntity.ok(epMapper.toGetDtoEntity(savedEvaluation));
	}

	@Override
	public void logicalRemove(Integer id, EvaluationProcessDto dtoEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void physicalRemove(Integer id) {
		epService.remove(id);
	}

}
