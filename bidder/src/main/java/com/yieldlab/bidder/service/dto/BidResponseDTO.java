package com.yieldlab.bidder.service.dto;

import java.io.Serializable;

public class BidResponseDTO implements Serializable {

	private static final long serialVersionUID = -7963491158080911328L;

	@Override
	public String toString() {
		return "BidResponseDTO [id=" + id + ", bid=" + bid + ", content=" + content + "]";
	}

	private int id;

	private int bid;

	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
