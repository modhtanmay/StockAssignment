package com.cts.MLEU.stockRestServices.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.MLEU.stockRestServices.Model.Stock;

public interface StockDao extends JpaRepository<Stock, Integer> {

	List<Stock> findByName(String stock_name);

	List<Stock> findByPriceBetween(double startPrice, double endPrice);

	List<Stock> findByVolumeBetween(int startVolume, int endVolume);

	List<Stock> findByDateBetween(Date startDate, Date endDate);

}
