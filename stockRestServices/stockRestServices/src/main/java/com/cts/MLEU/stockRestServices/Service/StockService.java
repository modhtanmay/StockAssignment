package com.cts.MLEU.stockRestServices.Service;

import java.util.Date;
import java.util.List;

import com.cts.MLEU.stockRestServices.Model.Stock;


public interface StockService {
	
	public List<Stock> getAllStock();
	
	public Stock getStockById(int id);
	
	public Stock addStock(Stock stock);
	
	public Stock updateStock(Stock stock);
	
	public void deleteEmployee(int id);

	
	List<Stock> findByName(String stock_name);
	
	List<Stock> findByPriceBetween(double startPrice,double endPrice);
	
	List<Stock> findByVolumeBetween(int startVolume,int endVolume);
	
	List<Stock> findByDateBetween(Date startDate,Date endDate);
	
	List<Stock> findTopFiveStockByPrice();

}
