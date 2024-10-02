package com.bank_api.demo.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.bank_api.demo.dto.ResultDto;
import com.bank_api.demo.dto.mapper.ResultMapper;
import com.bank_api.demo.model.Result;

@Component
public class ResultMapperImpl implements ResultMapper {

	@Override
	public ResultDto toGetDtoEntity(Result entity) {
		ResultDto dto = new ResultDto();
		dto.setId_result(entity.getId_result());
		dto.setApproved(entity.isApproved());
		dto.setFinal_interest_rate(entity.getFinal_interest_rate());
		dto.setApproved_amount(entity.getApproved_amount());
		return dto;
	}

	@Override
	public Result toPostEntity(ResultDto dto) {
		Result result = new Result();
		result.setId_result(dto.getId_result());
		result.setApproved(dto.isApproved());
		result.setFinal_interest_rate(dto.getFinal_interest_rate());
		result.setApproved_amount(dto.getApproved_amount());
		return result;
	}

}
