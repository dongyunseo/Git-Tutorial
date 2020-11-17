package com.human.dto;

public class ProDto {
	private int dressid;    	 
    private String dressname; 
    private int categoryid;  	
    private int price;     
    private String companyid; 	
    private int amount;      	
    private String dressimg;
    
    public ProDto() {} 
    
    public ProDto(int dressid, String dressname, int categoryid, int price, String companyid, int amount,
			String dressimg) {
		super();
		this.dressid = dressid;
		this.dressname = dressname;
		this.categoryid = categoryid;
		this.price = price;
		this.companyid = companyid;
		this.amount = amount;
		this.dressimg = dressimg;
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

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDressimg() {
		return dressimg;
	}

	public void setDressimg(String dressimg) {
		this.dressimg = dressimg;
	}
    
    
    
}