package com.yieldlab.bidder.appInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyFileReader {

	@Value("${bidders}")
	private String bidders;

	public String getBidders() {
		return bidders;
	}

}
