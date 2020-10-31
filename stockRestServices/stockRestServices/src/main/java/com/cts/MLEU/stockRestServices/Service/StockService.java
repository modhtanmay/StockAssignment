package com.cts.MLEU.stockRestServices.Service;

import java.util.Date;
import java.util.List;

import com.cts.MLEU.stockRestServices.Model.Stock;


public interface StockService {
	 
	public List<Stock> getAllStock();  // test
	
	public Stock getStockById(int id);
	
	public Stock addStock(Stock stock); // test
	
	public Stock updateStock(Stock stock);
	
	public void deleteStock(int id); // test

	
	List<Stock> findByName(String stock_name); // test
	
	List<Stock> findByPriceBetween(double startPrice,double endPrice);
	
	List<Stock> findByVolumeBetween(int startVolume,int endVolume);
	
	List<Stock> findByDateBetween(Date startDate,Date endDate);
	
	List<Stock> findTopFiveStockByPrice();
	
	List<Stock> searchByCompName(String compName);
	
	List<Stock> listByCompRanking();

}
