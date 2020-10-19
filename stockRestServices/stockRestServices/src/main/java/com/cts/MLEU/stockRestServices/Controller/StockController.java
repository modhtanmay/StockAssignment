package com.cts.MLEU.stockRestServices.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.MLEU.stockRestServices.Model.Stock;
import com.cts.MLEU.stockRestServices.Service.StockService;

@RestController
@RequestMapping(value = "/stock/")
public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping("/getStocks")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(stockService.getAllStock(), HttpStatus.OK);
	}

	@GetMapping("/getStocksById/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		return new ResponseEntity<>(stockService.getStockById(id), HttpStatus.OK);
	}

	@PostMapping("/addStock")
	public ResponseEntity<Object> addEmployee(@RequestBody Stock stock) {
		return new ResponseEntity<>(stockService.addStock(stock), HttpStatus.OK);
	}

	@GetMapping("/findByName/{name}")
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		return new ResponseEntity<>(stockService.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/getByPriceBetween")
	public ResponseEntity<Object> getByPriceBetween() {
		return new ResponseEntity<>(stockService.findByPriceBetween(100.0, 200.0), HttpStatus.OK);
	}

	@GetMapping("/getByVolumeBetween")
	public ResponseEntity<Object> getByVolumeBetween() {
		return new ResponseEntity<>(stockService.findByVolumeBetween(100, 200), HttpStatus.OK);
	}

	@GetMapping("/getByDateBetween")
	public ResponseEntity<Object> getByDateBetween() {
		return new ResponseEntity<>(stockService.findByDateBetween(new Date(2020 - 01 - 01), new Date(2020 - 12 - 12)),
				HttpStatus.OK);
	}

	@GetMapping("/getTopFiveStock")
	public ResponseEntity<Object> getTopFiveStock() {
		return new ResponseEntity<>(stockService.findTopFiveStockByPrice(), HttpStatus.OK);
	}
	
	@PutMapping("/updateStock")
	public ResponseEntity<Object> updateEmployee(@RequestBody Stock stock){
		// ONE WAY TO UPDATE
		Stock s = stockService.updateStock(stock);
		if(s!= null)
			return new ResponseEntity<>(stock,HttpStatus.OK);
		else
			return new ResponseEntity<>("Not Found",HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Object> deleteStock(@PathVariable("id") int id) {
		Stock stock = stockService.getStockById(id);
		if (stock == null)
			return new ResponseEntity<>("Stock Not Found", HttpStatus.OK);
		else {
			stockService.deleteEmployee(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		}
	}
}
