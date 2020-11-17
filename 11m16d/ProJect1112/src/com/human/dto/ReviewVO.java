package com.human.dto;

import java.util.Date;

public class ReviewVO {
	private int reviewnumber;
	private int dressId;
	private String dressname;
	private String id;
	private String reviewtitle;
	private String reviewcontent;
	private String reviewimg;
	private String reviewscore;
	private Date reviewDate;

	public ReviewVO() {
	}

	
	public ReviewVO(int reviewnumber, int dressId, String dressname, String id, String reviewtitle, String reviewcontent,
			String reviewimg, String reviewscore, Date reviewDate) {
		super();
		this.reviewnumber = reviewnumber;
		this.dressId = dressId;
		this.dressname = dressname;
		this.id = id;
		this.reviewtitle = reviewtitle;
		this.reviewcontent = reviewcontent;
		this.reviewimg = reviewimg;
		this.reviewscore = reviewscore;
		this.reviewDate = reviewDate;
	}

	public int getReviewnumber() {
		return reviewnumber;
	}

	public void setReviewnumber(int reviewnumber) {
		this.reviewnumber = reviewnumber;
	}

	public int getDressId() {
		return dressId;
	}

	public void setDressId(int dressId) {
		this.dressId = dressId;
	}

	public String getDressname() {
		return dressname;
	}

	public void setDressname(String dressname) {
		this.dressname = dressname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReviewtitle() {
		return reviewtitle;
	}

	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}

	public String getReviewcontent() {
		return reviewcontent;
	}

	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}

	public String getReviewimg() {
		return reviewimg;
	}

	public void setReviewimg(String reviewimg) {
		this.reviewimg = reviewimg;
	}

	public String getReviewscore() {
		return reviewscore;
	}

	public void setReviewscore(String reviewscore) {
		this.reviewscore = reviewscore;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

}