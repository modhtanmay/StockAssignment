package com.cts.MLEU.stockRestServices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.MLEU.stockRestServices.Service.StockService;

@Controller
public class StockController {

	@Autowired
	StockService stockService;
	
	@GetMapping("/stocks")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(stockService.getAllStock(), HttpStatus.OK);
	}
	
	@GetMapping("/stocks/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id ){
		return new ResponseEntity<>(stockService.getStockById(id),HttpStatus.OK); 
	}
}
