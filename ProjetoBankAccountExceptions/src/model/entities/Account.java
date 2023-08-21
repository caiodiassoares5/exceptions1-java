package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public void withdraw (double withdrawAmount) {
		
		if (withdrawAmount > this.balance) {
			throw new DomainException("Withdraw amount is higher than available balance.");
		}
		else if (withdrawAmount > withdrawLimit ) {
			throw new DomainException("Withdraw amount is higher then available limit.");
		}
		
		this.balance -= withdrawAmount;
		
	}
	
	
	public void deposit (double depositAmount) {
				
		this.balance += depositAmount;
		
	}

	@Override
	public String toString() {
		return "Account [number=" 
				+ number 
				+ ", holder=" 
				+ holder 
				+ ", balance=" 
				+ String.format("%.2f", balance) 
				+ ", withdrawLimit="
				+ String.format("%.2f", withdrawLimit) 
				+ "]";
	}
	
	
	
	
	
}
