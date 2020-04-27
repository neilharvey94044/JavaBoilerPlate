package org.ndhit.bp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;



/**
 * 
 * This class implements the Builder pattern.
 * @author nharvey
 *
 */
public class Transaction {

	public enum TransactionTypes {DEPOSIT, WITHDRAWAL, FEE};
	private final String tranId;
	private final BigDecimal amount;
	private final String account;
	private final TransactionTypes tranType;
	private final ZonedDateTime tranDate;
	
	public static class Builder {
		private String tranId = null;
		private BigDecimal amount = null;
		private String account = null;
		private TransactionTypes tranType;
		private ZonedDateTime tranDate = null;
		
		
		public Builder tranId(String val) {
			tranId = val; return this;
		}
		
		public Builder tranDate(ZonedDateTime val) {
			tranDate = val; return this;
		}
		
		public Builder tranDate(LocalDate date, LocalTime time, ZoneId zone) {
			tranDate = ZonedDateTime.of(date, time, zone); return this;
		}
		public Builder amount(BigDecimal val) {
			amount = new BigDecimal(val.toString(), MathContext.DECIMAL64).setScale(2);
			return this;
		}
		public Builder account(String val) {
			account = val; return this;
		}
		public Builder tranType(TransactionTypes val) {
			tranType = val; return this;
		}
		
		public Transaction build() {
			return new Transaction(this);
		}
	}
		private Transaction(Builder builder) {
			tranId = builder.tranId;
			tranDate = builder.tranDate;
			amount = builder.amount;
			account = builder.account;
			tranType = builder.tranType;
		}
	
	public String getTranId() {
		return tranId;
	}
	
	public ZonedDateTime getTranDate() {
		return tranDate;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public String getAccount() {
		return account;
	}
	public TransactionTypes getTranType() {
		return tranType;
	}

	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", amount=" + amount + ", account=" + account + ", tranType="
				+ tranType + ", tranDate=" + tranDate + "]";
	}

	
}