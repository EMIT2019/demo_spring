package com.bank_api.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "result")
public class Result implements ModelEntity {
	@Id
	@NotNull(message = "The primery key must not be null.")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_result", nullable = false)
	private int id_result;
	
	@NotNull(message = "The field approved must not be null.")
	@Column(name = "approved", nullable = false)
	private boolean approved;
	
	@NotNull(message = "The field final_interest_rate must not be null.")
	@Column(name = "final_interest_rate", nullable = false)
	private double final_interest_rate;
	
	@NotNull(message = "The field approved_amount must not be null.")
	@Column(name = "approved_amount", nullable = false)
	private double approved_amount;
}
