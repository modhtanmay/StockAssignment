package com.cts.MLEU.stockRestServices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.MLEU.stockRestServices.Model.Stock;
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
	
	@PostMapping("/stocks")
	public ResponseEntity<Object> addEmployee(@RequestBody Stock stock){
		return new ResponseEntity<>(stockService.addStock(stock),HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<Object> getByName(@PathVariable String name ){
		return new ResponseEntity<>(stockService.findByName(name),HttpStatus.OK); 
	}
}
