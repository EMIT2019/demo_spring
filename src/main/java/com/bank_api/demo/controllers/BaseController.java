package com.bank_api.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank_api.demo.dto.DtoEntity;

@RequestMapping("/default")
public interface BaseController<T extends DtoEntity, ID> {
	
	@GetMapping("/get-all")
	ResponseEntity<List<T>> findAll();
	
	@GetMapping("/item")
	ResponseEntity<T> findById(@RequestParam("id") ID id);
	
	@PostMapping("/save")
	ResponseEntity<T> save(@RequestBody T dtoEntity);
	
	@GetMapping("/page/{page}")
    ResponseEntity<List<T>> getPage(@PathVariable Integer page);
	
	@PutMapping("/update")
	ResponseEntity<T> update(@RequestParam("id") ID id, @RequestBody T dtoEntity);
	
	@PutMapping("/remove")	
	void logicalRemove(@RequestParam("id") ID id, @RequestBody T dtoEntity);
	
	@DeleteMapping("/delete")
	void physicalRemove(@RequestParam("id") ID id);
}
