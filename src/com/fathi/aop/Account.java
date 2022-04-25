package com.fathi.aop;

import com.fathi.aop.exceptions.NegativeValueException;
import com.fathi.aop.exceptions.AccountException;
import com.fathi.aop.exceptions.EmptyAccountException;
import com.fathi.aop.exceptions.MaxWithdrawException;
import com.fathi.aop.exceptions.MinWithdrawException;

public class Account {
	
	private float amount;
	private Client owner;
	
	public String dispose(float amount) throws AccountException {
		if (amount < 1000)
            throw new MinWithdrawException("You can't dispose less than 1000 DA");
        this.amount += amount;
        return "Dispose " + amount + " DA";
	}

	public String withdraw(float amount) throws AccountException {
		if (this.amount <= 0)
			throw new EmptyAccountException("You can't withdraw from an empty account");
		if (this.amount < amount)
			throw new NegativeValueException("You can't withdraw more than your credit");
		if (amount < 1000)
			throw new MinWithdrawException("You can't withdraw less than 1000 DA");
        if (amount > 50000)
            throw new MaxWithdrawException("You can't withdraw more than 50000 DA");
		this.amount -= amount;
		return "Withdraw " + amount + " DA";
	}
	
	public float getAmount() {
		return amount;
	}

	public Client getOwner() {
		return owner;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public Account(Client owner) {
		this.amount = 0;
		this.owner = owner;
	}
	
	public Account(float amount, Client owner) {
		this.amount = amount;
		this.owner = owner;
	}
}
