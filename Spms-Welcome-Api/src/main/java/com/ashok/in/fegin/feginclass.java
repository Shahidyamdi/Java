package com.ashok.in.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface feginclass {
	@GetMapping(value ={"/greet"})
	public String involveGreetapi ();

}
