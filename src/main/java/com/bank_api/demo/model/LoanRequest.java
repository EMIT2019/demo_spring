package com.bank_api.demo.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "loan_request")
public class LoanRequest implements ModelEntity {
	@Id
	@NotNull(message = "The primary key id_loan_request must not be null.")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loan_request")
	private int id_loan_request;
	
	@NotEmpty(message = "The field application_type must not be empty")
	@Column(name = "application_type", nullable = false)
	@Size(max = 50)
	private String application_type;
	
	@NotEmpty(message = "The field full_name must not be empty.")
	@Column(name = "full_name", nullable = false)
	@Size(max = 30)
	private String full_name;
	
	@NotEmpty(message = "The field id_number must not be empty.")
	@Column(name = "id_number", nullable = false)
	@Size(max = 14)
	private String id_number;
	
	@NotNull(message = "The field age must not be null")
	@Column(name = "age", nullable = false)
	private int age;
	
	@NotNull(message = "The field salary must not be null")
	@Column(name = "salary", nullable = false)
	private double salary;
	
	@NotNull(message = "The field credit_score must not be null.")
	@Column(name = "credit_score", nullable = false)
	private double credit_score;
	
	@NotNull(message = "The field debts must not be null")
	@Column(name = "debts", nullable = false)
	private boolean debts;
	
	@NotEmpty(message = "The field collateral must not be empty.")
	@Column(name = "collateral", nullable = false)
	@Size(max = 50)
	private String collateral;
	
	@NotNull(message = "The field savings must not be null.")
	@Column(name = "savings", nullable = false)
	private double savings;
	
	@NotNull(message = "The field id_loan_details must not be null.")
	@JoinColumn(name = "id_loan_details")
	@OneToOne
	private LoanDetails loan_details;
}
