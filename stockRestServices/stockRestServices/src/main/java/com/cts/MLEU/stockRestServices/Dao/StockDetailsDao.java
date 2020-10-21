package com.cts.MLEU.stockRestServices.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.MLEU.stockRestServices.Model.StockDetails;

public interface StockDetailsDao extends JpaRepository<StockDetails, Integer>{
	
}
