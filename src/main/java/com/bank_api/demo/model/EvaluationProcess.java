package com.bank_api.demo.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "evaluation_process")
public class EvaluationProcess implements ModelEntity {
	@Id
	@NotNull(message = "The primary key process_id must not be null.")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_id", nullable = false)
	private int process_id;
	
	@NotEmpty(message = "The field status must not be empty.")
	@Size(max = 50)
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull(message = "The field id_result must not be null.")
	@JoinColumn(name = "id_result")
	@OneToOne
	private Result result;
}
