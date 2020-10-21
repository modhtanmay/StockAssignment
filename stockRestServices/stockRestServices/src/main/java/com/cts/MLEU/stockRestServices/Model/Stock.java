package com.cts.MLEU.stockRestServices.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Stock {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private int volume;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@OneToMany(mappedBy = "stock")
	private List<StockDetails> stockDetail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public Stock(int id, String name, double price, int volume, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.volume = volume;
		this.date = date;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

}
