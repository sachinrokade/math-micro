package com.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.pojo.DataAdd;
import com.web.pojo.DataSub;

@FeignClient(name = "web-sub-client", url = "http://localhost:8093")
public interface SubFeignClient {

	@PostMapping("/sub")
	public ResponseEntity<DataSub> sub(@RequestBody DataSub data);
		
	
}
