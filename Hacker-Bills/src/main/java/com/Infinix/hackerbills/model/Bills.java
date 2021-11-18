package com.Infinix.hackerbills.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Bill_id") 
	private int billId;

	@Column(name = "bill_number")
	private String billNumber;

	@Column(name = "billed_to")
	private String billedTo;

	@Column(name = "billed_date")
	private String billedDate;
	
	@Column(name = "due_date")
	private String dueDate;

	@Column(name = "billed_price")
	private String billedPrice;

	@Column(name = "tax_on_bill")
	private String taxOnBill;
	
	@Column(name = "total_price")
	private String totalPrice;
	
	public Bills() {
		super();
	}

	

	public Bills(int billsId, String billNumber, String billedTo, String billedDate, String dueDate, String billedPrice,
			String taxOnBill, String totalPrice) {
		super();
		this.billNumber = billNumber;
		this.billedTo = billedTo;
		this.billedDate = billedDate;
		this.dueDate = dueDate;
		this.billedPrice = billedPrice;
		this.taxOnBill = taxOnBill;
		this.totalPrice = totalPrice;
	}



	public int getBillsId() {
		return billId;
	}

	public void setBillsId(int billId) {
		this.billId = billId;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBilledTo() {
		return billedTo;
	}

	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}

	public String getBilledDate() {
		return billedDate;
	}

	public void setBilledDate(String billedDate) {
		this.billedDate = billedDate;
	}

	public String getDueDate() {
		return dueDate;
	}



	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}



	public String getBilledPrice() {
		return billedPrice;
	}

	public void setBilledPrice(String billedPrice) {
		this.billedPrice = billedPrice;
	}

	public String getTaxOnBill() {
		return taxOnBill;
	}

	public void setTaxOnBill(String taxOnBill) {
		this.taxOnBill = taxOnBill;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
