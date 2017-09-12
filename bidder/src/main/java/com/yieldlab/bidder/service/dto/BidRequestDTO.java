package com.yieldlab.bidder.service.dto;

import java.io.Serializable;
import java.util.Map;

public class BidRequestDTO implements Serializable {

	private static final long serialVersionUID = 3286417933323825944L;

	private int id;

	private Map<String, String> attributes;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
