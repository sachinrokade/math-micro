package com.clinet.sub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinet.sub.pojo.DataSub;

@RestController
public class SubController {

	private static final Logger log = LoggerFactory.getLogger(SubController.class);

	@GetMapping("/")
	public String home() {
		return "Sub Client";
	}

	@PostMapping("/sub")
	public ResponseEntity<DataSub> add(@RequestBody DataSub data) {

		log.info("SubController Calling *************************");

		data.setResult(data.getSubNum1() - data.getSubNum2());

		log.info(data + " *************************");
		log.info("SubController End *************************");

		return new ResponseEntity<DataSub>(data, HttpStatus.OK);
	}
}
