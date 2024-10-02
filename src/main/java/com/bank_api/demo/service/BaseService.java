package com.bank_api.demo.service;

import java.util.List;

import com.bank_api.demo.model.ModelEntity;

public interface BaseService<T extends ModelEntity, ID> {
	List<T> findAll();
	
	T findById(ID id);
	
	T save(T entity);
	
	T update(T entity);
	
	void remove(ID id);
}
