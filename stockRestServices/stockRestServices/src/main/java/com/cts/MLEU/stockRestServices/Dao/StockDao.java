package com.cts.MLEU.stockRestServices.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.MLEU.stockRestServices.Model.Stock;


public interface StockDao extends JpaRepository<Stock, Integer>{
		
	public Stock findByName(String stock_name);
	
	public Stock findByPriceBetween(double startPrice,double endPrice);
	
	public Stock findByVolumeBetween(int startVolume,int endVolume);
	
	public Stock findByDateBetween(Date startDate,Date endDate);
	
}
