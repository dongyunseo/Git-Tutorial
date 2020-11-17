package com.human.dto;

import java.util.Date;

public class QandAVo {
	private int qandaid;
	private String qandatitle;
	private String qandacontent;
	private Date qandadate;
	private String qandareply;
	private String id;
	private int dressid;
	
	public QandAVo() {}
	
	public QandAVo(int qandaid, String qandatitle, String qandacontent, Date qandadate, String qandareply, String id,
			int dressid) {
		super();
		this.qandaid = qandaid;
		this.qandatitle = qandatitle;
		this.qandacontent = qandacontent;
		this.qandadate = qandadate;
		this.qandareply = qandareply;
		this.id = id;
		this.dressid = dressid;
	}

	public int getQandaid() {
		return qandaid;
	}

	public void setQandaid(int qandaid) {
		this.qandaid = qandaid;
	}

	public String getQandatitle() {
		return qandatitle;
	}

	public void setQandatitle(String qandatitle) {
		this.qandatitle = qandatitle;
	}

	public String getQandacontent() {
		return qandacontent;
	}

	public void setQandacontent(String qandacontent) {
		this.qandacontent = qandacontent;
	}

	public Date getQandadate() {
		return qandadate;
	}

	public void setQandadate(Date qandadate) {
		this.qandadate = qandadate;
	}

	public String getQandareply() {
		return qandareply;
	}

	public void setQandareply(String qandareply) {
		this.qandareply = qandareply;
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
	
	
}