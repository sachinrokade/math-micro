package com.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.pojo.DataAdd;

@FeignClient(name = "web-add-client", url = "http://localhost:8092")
public interface AddFeignClient {

	@PostMapping("/add")
	public ResponseEntity<DataAdd> add(@RequestBody DataAdd data);
		
	
}
