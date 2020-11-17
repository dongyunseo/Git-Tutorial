package com.human.dto;

import java.util.Date;

public class OrderVO {
	private int ordernum;
	private String id;
	private int dressid;
	private String dressname;
	private int price;
	private int amount;
	private int sum;
	private String ordername;
	private String address;
	private String phone;
	private String email;
	private String orderMessage;
	private String depositor;
	private String Bank;
	private String delivery;
	private Date orderDate;
	private String dressimg;
	
	public OrderVO() {}
	
	public OrderVO(int ordernum, String id, int dressid, String dressname, int price, int amount, int sum,
			String ordername, String address, String phone, String email, String orderMessage, String depositor,
			String bank, String delivery, Date orderDate, String dressimg) {
		super();
		this.ordernum = ordernum;
		this.id = id;
		this.dressid = dressid;
		this.dressname = dressname;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
		this.ordername = ordername;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.orderMessage = orderMessage;
		this.depositor = depositor;
		Bank = bank;
		this.delivery = delivery;
		this.orderDate = orderDate;
		this.dressimg = dressimg;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDressid() {
		return dressid;
	}

	public void setDressid(int dressid) {
		this.dressid = dressid;
	}

	public String getDressname() {
		return dressname;
	}

	public void setDressname(String dressname) {
		this.dressname = dressname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderMessage() {
		return orderMessage;
	}

	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public String getBank() {
		return Bank;
	}

	public void setBank(String bank) {
		Bank = bank;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDressimg() {
		return dressimg;
	}

	public void setDressimg(String dressimg) {
		this.dressimg = dressimg;
	}

	
	
}