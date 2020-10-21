package com.cts.MLEU.stockRestServices.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockDetails {

	@Id
	private int sdId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Stock stock;

	private String compName;
	private String compAddr;
	private int compRank;



	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public int getCompRank() {
		return compRank;
	}

	public void setCompRank(int compRank) {
		this.compRank = compRank;
	}

	public StockDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockDetails(String compName, String compAddr, int compRank, Stock stock) {
		super();
		this.compName = compName;
		this.compAddr = compAddr;
		this.compRank = compRank;
//		this.stock = stock;
	}
}
