package com.yieldlab.bidder.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yieldlab.bidder.service.BidderService;

@RestController
public class BidderResource {

	private final Logger log = LoggerFactory.getLogger(BidderResource.class);

	@Autowired
	private BidderService bidderService;

	@RequestMapping(value = { "/{id}/",
			"/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String handleClientRequest(@PathVariable int id, @RequestParam Map<String, String> details) {
		log.info("Revived request with  id {}", id);
		return bidderService.handleRequest(id, details);
	}

}
