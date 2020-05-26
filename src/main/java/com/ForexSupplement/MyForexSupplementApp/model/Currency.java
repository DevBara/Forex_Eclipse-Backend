package com.ForexSupplement.MyForexSupplementApp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="currencies")

public class Currency {
	
	private long id;
	private String currencyName;
	private String currencyCode;
	private BigDecimal currencyAmt;
	private BigDecimal currencyRate;
	
	public Currency() {
		
	}
	
	
	public Currency(String currencyName, String currencyCode, BigDecimal currencyAmt, BigDecimal currencyRate) {
		this.currencyName = currencyName;
		this.currencyCode = currencyCode;
		this.currencyAmt = currencyAmt;
		this.currencyRate = currencyRate;
	}
	
	@Id
	@GeneratedValue
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id= id;
	}
	
	@Column(name = "currencyName")
		public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName= currencyName;
	}
	
	@Column(name="currencyCode")
		public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@Column(name="currencyAmt")
		public BigDecimal getCurrencyAmt() {
		return currencyAmt;
	}
	
	public void setCurrencyAmt(BigDecimal currencyAmt) {
		this.currencyAmt = currencyAmt;
	}
	
	@Column(name="currencyRate")
		public BigDecimal getCurrencyRate() {
		return currencyRate;
	}
	
	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}
	
	@Override
	public String toString() {
		return "Currency[id="+id+",currencyName="+ currencyName + ",currencyCode="+ currencyCode + ",currencyAmt="+ currencyAmt+",currencyRate="+currencyRate + "]";
	}

}

