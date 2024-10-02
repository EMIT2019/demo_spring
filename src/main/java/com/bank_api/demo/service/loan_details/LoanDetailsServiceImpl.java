package com.bank_api.demo.service.loan_details;

import java.util.List;
import java.util.Optional;

import com.bank_api.demo.model.LoanDetails;
import com.bank_api.demo.repository.LoanDetailsRepository;

public class LoanDetailsServiceImpl implements LoanDetailsService {

	private final LoanDetailsRepository ldRepository;
	
	public LoanDetailsServiceImpl(LoanDetailsRepository loanDetailsRepository) {
		this.ldRepository = loanDetailsRepository;
	}
	
	@Override
	public List<LoanDetails> findAll() {
		return ldRepository.findAll();
	}

	@Override
	public LoanDetails findById(Integer id) {
		Optional<LoanDetails> loanDetails = ldRepository.findById(id);
		
		if(loanDetails.isPresent()) {
			
		}
		
		return null;
	}

	@Override
	public LoanDetails save(LoanDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanDetails update(LoanDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
