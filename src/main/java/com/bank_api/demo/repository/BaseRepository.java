package com.bank_api.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.bank_api.demo.model.ModelEntity;

@NoRepositoryBean 
public interface BaseRepository<T extends ModelEntity, ID> extends JpaRepository<T, ID> {

}
