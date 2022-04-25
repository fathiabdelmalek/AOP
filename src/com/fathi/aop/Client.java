package com.fathi.aop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.fathi.aop.exceptions.AccountException;
import com.fathi.aop.exceptions.EmptyAccountException;
import com.fathi.aop.exceptions.MaxWithdrawException;
import com.fathi.aop.exceptions.MinWithdrawException;
import com.fathi.aop.exceptions.NegativeValueException;

public class Client {
	private int accountsNumber;
	private ArrayList<Account> accounts;
	
	public String dispose(float amount, int accountIndex) {
		try {
            return accounts.get(accountIndex).dispose(amount);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
			try {
				FileOutputStream file = new FileOutputStream("log.txt", true);
				file.write((e.getMessage() + "\n").getBytes());
			    file.close();
			} catch (IOException ex) {
				System.out.println("An error occurred => " + ex.getMessage());
			}
            return e.getMessage();
        }
	}
	
	public String withdraw(float amount, int accountIndex) {
		try {
			return accounts.get(accountIndex).withdraw(amount);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			try {
				FileOutputStream file = new FileOutputStream("log.txt", true);
				file.write((e.getMessage() + "\n").getBytes());
			    file.close();
			} catch (IOException ex) {
				System.out.println("An error occurred => " + ex.getMessage());
			}
			return e.getMessage();
		}
	}
	
	public int getAccountsNumber() {
		return accountsNumber;
	}

	public void setAccountsNumber(int accountsNumber) {
		this.accountsNumber = accountsNumber;
	}

	public Account getAccount(int accountIndex) {
		return accounts.get(accountIndex);
	}
	
	public Client(int accountsNumber) {
		this.accountsNumber = accountsNumber;
		this.accounts = new ArrayList();
		for (int i = 0; i < accountsNumber; i++) {
			accounts.add(new Account(this));
		}
	}
}
