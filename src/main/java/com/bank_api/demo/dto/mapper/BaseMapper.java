package com.bank_api.demo.dto.mapper;

import com.bank_api.demo.dto.DtoEntity;
import com.bank_api.demo.model.ModelEntity;

public interface BaseMapper<T extends ModelEntity, E extends DtoEntity> {
	E toGetDtoEntity(T entity);
	T toPostEntity(E dto);
}
