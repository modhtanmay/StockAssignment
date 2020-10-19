package com.cts.MLEU.stockRestServices.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/getByPriceBetween/{startPrice}/{endPrice}")
	public ResponseEntity<Object> getByPriceBetween(@PathVariable double startPrice,@PathVariable double endPrice) {
		return new ResponseEntity<>(stockService.findByPriceBetween(startPrice, endPrice), HttpStatus.OK);
	}

	@GetMapping("/getByVolumeBetween/{startVolume}/{endVolume}")
	public ResponseEntity<Object> getByVolumeBetween(@PathVariable int startVolume,@PathVariable int endVolume) {
		return new ResponseEntity<>(stockService.findByVolumeBetween(startVolume, endVolume), HttpStatus.OK);
	}

	@GetMapping("/getByDateBetween/{startDate}/{endDate}")
	public ResponseEntity<Object> getByDateBetween(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
		return new ResponseEntity<>(stockService.findByDateBetween(startDate,endDate),HttpStatus.OK);
	}

	@GetMapping("/getTopFiveStock")
	public ResponseEntity<Object> getTopFiveStock() {
		return new ResponseEntity<>(stockService.findTopFiveStockByPrice(), HttpStatus.OK);
	}
	
	@PutMapping("/updateStock")
	public ResponseEntity<Object> updateStock(@RequestBody Stock stock){
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
