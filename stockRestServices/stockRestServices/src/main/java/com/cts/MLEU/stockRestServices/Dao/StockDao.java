package com.cts.MLEU.stockRestServices.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.MLEU.stockRestServices.Model.Stock;

public interface StockDao extends JpaRepository<Stock, Integer> {

	List<Stock> findByName(String stock_name);

	List<Stock> findByPriceBetween(double startPrice, double endPrice);

	List<Stock> findByVolumeBetween(int startVolume, int endVolume);

	List<Stock> findByDateBetween(Date startDate, Date endDate);
	
	@Query(value="select s.* from stock s order by price limit 5",nativeQuery = true)
	List<Stock> findTopFiveStockByPrice();
	
	@Query(value="select s.* from stock s inner join stock_details sd on s.id = sd.stock where sd.comp_name = ?1 ",nativeQuery = true)
	List<Stock> searchByCompName(String compName);
	
	@Query(value="select s.*,sd.* from stock s inner join stock_details sd on s.id = sd.stock order by comp_rank desc",nativeQuery = true)
	List<Stock> listByCompRanking();
}
