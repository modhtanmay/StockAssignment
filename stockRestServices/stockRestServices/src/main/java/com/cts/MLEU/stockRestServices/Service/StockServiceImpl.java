package com.cts.MLEU.stockRestServices.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.MLEU.stockRestServices.Dao.StockDao;
import com.cts.MLEU.stockRestServices.Model.Stock;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockDao stockDao;
	
	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockDao.findAll();
	}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		return stockDao.findById(id).get();
	}

	@Override
	public Stock addStock(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.save(stock);
	}

	@Override
	public List<Stock> findByName(String name) {
		// TODO Auto-generated method stub
		return stockDao.findByName(name);
	}

	@Override
	public List<Stock> findByPriceBetween(double startPrice, double endPrice) {
		// TODO Auto-generated method stub
		return stockDao.findByPriceBetween(startPrice,endPrice);
	}

	@Override
	public List<Stock> findByVolumeBetween(int startVolume, int endVolume) {
		// TODO Auto-generated method stub
		return stockDao.findByVolumeBetween(startVolume, endVolume);
	}

	@Override
	public List<Stock> findByDateBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return stockDao.findByDateBetween(startDate, endDate);
	}

	

	

}
