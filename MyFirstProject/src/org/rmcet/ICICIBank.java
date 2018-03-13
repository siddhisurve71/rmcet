package org.rmcet;

import java.util.LinkedList;


public class ICICIBank {
	
	LinkedList<Account>  accounts = new LinkedList<>();
	
	
	public String createAccount(int accountNumber,int amount)
	{
		Account account = new Account(accountNumber,amount);
		accounts.add(account);
		return "account created successfully";
	}
	
	
	
	
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		
		return account.getAmount();
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		
		throw new InvalidAccountNumberException();
	}
	private Account searchAmount(int accountNo,int ammount)throws InsufficientBalance
	{
		for(Account account : accounts)
		{
			if(accountNo==account.getAccountNumber())
			{
			   if(account.getAmount()>=ammount)
			     {
				return account;
			    }
			}
		}
		 throw new InsufficientBalance();
	}




	public int withdrawAccount(int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientBalance
	{
	{
		Account account = searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>0)
			throw new InsufficientBalance();
		
		
				account.setAmount(account.getAmount()-amount);
	    return account.getAmount();	
       
		
	}
	

	}

