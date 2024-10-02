package com.bank_api.demo.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "loan_details")
public class LoanDetails implements ModelEntity {
	@Id
	@NotNull(message = "The primary key id_loan_details must not be null.")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loan_details", nullable = false)
	private int id_loan_details;
	
	@NotNull(message = "The fiel amount must not be null.")
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@NotNull(message = "The field term_month must not be null.")
	@Column(name = "term_month", nullable = false)
	@Min(2) @Max(2)
	private int term_month;
	
	@NotNull(message = "The field interest_rate must not be null")
	@Column(name = "interest_rate", nullable = false)
	private double interest_rate;
	
	@NotEmpty(message = "The field purpose must not be empty.")
	@Column(name = "purpose", nullable = false)
	private String purpose;
}
