package com.yieldlab.bidder.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yieldlab.bidder.appInfo.PropertyFileReader;
import com.yieldlab.bidder.service.dto.BidRequestDTO;
import com.yieldlab.bidder.service.dto.BidResponseDTO;

@Service
public class BidderService {

	private final Logger log = LoggerFactory.getLogger(BidderService.class);

	@Autowired
	private PropertyFileReader propertyFileReader;

	// I would not put URLS in application.properties. I would like to put it in
	// the Database(Any). I have not done so here because it would be an
	// additional requirement to run this application.
	private String[] bidderUrls;

	@PostConstruct
	public void instalizeURLs() {
		bidderUrls = propertyFileReader.getBidders().split(",");
	}

	public String handleRequest(int id, Map<String, String> details) {
		BidRequestDTO bidRequestDTO = convertToBidRequestDTO(id, details);

		int max = Integer.MIN_VALUE;
		RestTemplate restTemplate = new RestTemplate();
		BidResponseDTO winningBid = null;
		for (String url : bidderUrls) {
			log.debug("Hitting server with url {}", url);
			try {
				BidResponseDTO bidResponseDTO = restTemplate.postForObject(url.trim(), bidRequestDTO,
						BidResponseDTO.class);
				log.debug("The response is {} from url {}", bidResponseDTO, url.trim());
				if (bidResponseDTO != null && bidResponseDTO.getBid() > max) {
					max = bidResponseDTO.getBid();
					winningBid = bidResponseDTO;
				}
			} catch (Exception e) {
				log.error("The error in connection is ", e);
			}
		}

		if (winningBid != null) {
			String result = winningBid.getContent().replaceAll("price", Integer.toString(max));
			result = result.replace('$', '\0');
			log.debug("The final response generated is {}", result);
			return result;
		} else
			return "Could Not Connect to server.";
	}

	private BidRequestDTO convertToBidRequestDTO(int id, Map<String, String> details) {
		BidRequestDTO bidRequestDTO = new BidRequestDTO();
		bidRequestDTO.setId(id);
		bidRequestDTO.setAttributes(details);
		return bidRequestDTO;
	}

}
