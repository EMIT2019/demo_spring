package com.bank_api.demo.dto;

import lombok.Data;

@Data
public class EvaluationProcessDto implements DtoEntity {
	private int process_id;
	private String status;
	private ResultDto resultDto;
}
