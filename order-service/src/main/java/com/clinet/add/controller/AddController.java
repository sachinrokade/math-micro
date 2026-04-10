package com.clinet.add.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinet.add.pojo.DataAdd;

@RestController
public class AddController {

	private static final Logger log = LoggerFactory.getLogger(AddController.class);

	@GetMapping("/")
	public String home() {
		return "Add Client";
	}

	@PostMapping("/add")
	public ResponseEntity<DataAdd> add(@RequestBody DataAdd data) {

		log.info("AddController Calling *************************");
		data.setResult(data.getNum1() + data.getNum2());
		log.info(data + " *************************");
		log.info("AddController End *************************");
		return new ResponseEntity<DataAdd>(data, HttpStatus.OK);
	}
}
