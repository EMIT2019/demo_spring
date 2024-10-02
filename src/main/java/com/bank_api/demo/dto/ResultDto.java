package com.bank_api.demo.dto;

import lombok.Data;

@Data
public class ResultDto implements DtoEntity {
	private int id_result;
	private boolean approved;
	private double final_interest_rate;
	private double approved_amount;
}
