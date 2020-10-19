package com.cts.MLEU.stockRestServices.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	private int stock_id;
	private String stock_name;
	private double price;
	private int volume;
	private Date date;
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int stock_id, String stock_name, double price, int volume, Date date) {
		super();
		this.stock_id = stock_id;
		this.stock_name = stock_name;
		this.price = price;
		this.volume = volume;
		this.date = date;
	}
	
	

}
