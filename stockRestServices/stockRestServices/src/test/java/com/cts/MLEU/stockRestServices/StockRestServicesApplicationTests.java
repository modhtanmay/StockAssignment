package com.cts.MLEU.stockRestServices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.MLEU.stockRestServices.Dao.StockDao;
import com.cts.MLEU.stockRestServices.Model.Stock;
import com.cts.MLEU.stockRestServices.Service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockRestServicesApplicationTests {

	@MockBean
	StockDao stockDao;

	@Autowired
	StockService stockImpl;
	
	// Testing all Stock Details Service
	@Test
	public void getAllStockTest() {
		when(stockDao.findAll()).thenReturn(Stream.of(new Stock(101,"CTS",123.24,150,new Date(2020-01-01))).collect(Collectors.toList()));
		
		assertEquals(1, stockImpl.getAllStock().size());
	}
	
	// Testing Get Stock By Name Service
	@Test
	public void getStockByNameTest() {
		String name = "";
		when(stockDao.findByName(name))
			.thenReturn(Stream.of(new Stock(101,"CTS",123.24,150,new Date(2020-01-01))).collect(Collectors.toList()));
		
		assertEquals(1, stockImpl.findByName(name).size());
	}
	
	@Test
	public void addStockTest() {
		Stock stock = new Stock(101,"CTS",123.24,150,new Date(2020-01-01));
		when(stockDao.save(stock)).thenReturn(stock);
		assertEquals(stock, stockImpl.addStock(stock));
	}

	@Test
	public void deleteStockTest() {
		int id = 101;
		Stock stock = new Stock(101,"CTS",123.24,150,new Date(2020-01-01));
		stockImpl.deleteStock(id);
		verify(stockDao,times(1)).deleteById(id);
	}

}
