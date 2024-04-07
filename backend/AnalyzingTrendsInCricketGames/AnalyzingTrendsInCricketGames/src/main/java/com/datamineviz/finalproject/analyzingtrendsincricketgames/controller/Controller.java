package com.datamineviz.finalproject.analyzingtrendsincricketgames.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/test/{id}")
	public String test(@PathVariable String id){
		String x = "Working! ";
		return x + id;
	}

}
