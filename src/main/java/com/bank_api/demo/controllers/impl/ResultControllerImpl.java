package com.bank_api.demo.controllers.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank_api.demo.controllers.ResultController;
import com.bank_api.demo.dto.ResultDto;
import com.bank_api.demo.dto.mapper.ResultMapper;
import com.bank_api.demo.model.Result;
import com.bank_api.demo.service.result.ResultService;

@RequestMapping("/result")
@RestController
public class ResultControllerImpl implements ResultController {

	private final ResultService rService;
	private final ResultMapper rMapper;
	
	public ResultControllerImpl(ResultService resultService, ResultMapper resultMapper){
		this.rService = resultService;
		this.rMapper = resultMapper;
	}
	
	@Override
	public ResponseEntity<List<ResultDto>> findAll() {
		List<ResultDto> resultDtoList = rService.findAll().stream()
				.map(rMapper::toGetDtoEntity)
				.collect(Collectors.toList());
		return ResponseEntity.ok(resultDtoList);
	}

	@Override
	public ResponseEntity<ResultDto> findById(Integer id) {
		Result result;
		result = rService.findById(id);
		return ResponseEntity.ok(rMapper.toGetDtoEntity(result));
	}

	@Override
	public ResponseEntity<ResultDto> save(ResultDto dtoEntity) {
		Result result, savedResult;
		
		result = rMapper.toPostEntity(dtoEntity);
		savedResult = rService.save(result);
		
		return new ResponseEntity<ResultDto>(rMapper.toGetDtoEntity(savedResult), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<ResultDto>> getPage(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResultDto> update(Integer id, ResultDto dtoEntity) {
		
		Result result, savedResult;
		dtoEntity.setId_result(id);
		result = rMapper.toPostEntity(dtoEntity);
		savedResult = rService.update(result);
				
		return ResponseEntity.ok(rMapper.toGetDtoEntity(savedResult));
	}

	@Override
	public void logicalRemove(Integer id, ResultDto dtoEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void physicalRemove(Integer id) {
		rService.remove(id);
	}

}
