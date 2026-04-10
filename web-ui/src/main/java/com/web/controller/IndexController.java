package com.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.web.client.AddFeignClient;
import com.web.client.SubFeignClient;
import com.web.pojo.DataAdd;
import com.web.pojo.DataSub;


@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	
	@Autowired
	AddFeignClient addClient;
	

	@Autowired
	SubFeignClient subClient;
	
    @GetMapping("/")
    public String homePage() 
    {
    	return "index";
    }
    @PostMapping("/add")
	
    @HystrixCommand(fallbackMethod="serviceNotStarted")
    public String addMath(@ModelAttribute("mathAdd") DataAdd data,Model model) 
    {

    	log.info("IndexController ====Add==============================");
    	
//    	model.addAttribute("num1",data.getNum1());
//    	model.addAttribute("num2",data.getNum2());
//    	model.addAttribute("message",data.getNum1()+data.getNum2());
    	
    	
    	ResponseEntity<DataAdd> result=addClient.add(data);   	

    	model.addAttribute("num1",result.getBody().getNum1());
    	model.addAttribute("num2",result.getBody().getNum2());
    	model.addAttribute("message",result.getBody().getResult());
    	
    	System.out.println(result.getBody());
    

    	log.info("IndexController ====Addd==== End==========================");
    	return "index";
    }
    @PostMapping("/sub")
	@HystrixCommand(fallbackMethod="serviceNotStarted")
    public String sub(@ModelAttribute("mathSub") DataSub data,Model model) 
    {


    	log.info("IndexController ====Sub==============================");
    
    	log.info(""+data);
    	
//    	model.addAttribute("subNum1",data.getSubNum1());
//    	model.addAttribute("subNum2",data.getSubNum2());
//    	model.addAttribute("subMsg",data.getSubNum1()-data.getSubNum2());
//    
    	
    	ResponseEntity<DataSub> result=subClient.sub(data);
    	model.addAttribute("subNum1",result.getBody().getSubNum1());
    	model.addAttribute("subNum2",result.getBody().getSubNum2());
    	model.addAttribute("subMsg",result.getBody().getResult());
    	
    	
    	System.out.println(data);
    	

    	log.info("IndexController ====Subb==== End==========================");
    	return "index";
    }
    public String serviceNotStarted(DataSub data,Model model)
	{

    	model.addAttribute("message","SUB-CLIENT service down");
		return "notfound";
	}
    public String serviceNotStarted(DataAdd data,Model model)
   	{

    	model.addAttribute("message","ADD-CLIENT service down");
   		return "notfound";
   	}
}