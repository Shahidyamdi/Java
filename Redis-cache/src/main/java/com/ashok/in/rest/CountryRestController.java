package com.ashok.in.rest;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.in.binding.Country;

@RestController
public class CountryRestController {
	//create an object for OpsForHash class to perform operations with HashKey
		private HashOperations<String, Integer, Country> opsForHash=null;
		
		//dependency Injection by calling constructor
		public CountryRestController(RedisTemplate<String, Country> rt)
		{
			this.opsForHash=rt.opsForHash();
		}
		
		//add country to RedisServer Cache memory
		@PostMapping("/country")
		public String addCountry(@RequestBody Country country)
		{
			opsForHash.put("Countries", country.getSno(), country);
			return "Country Added";
		}
		
		//get countries from RedisServer Cache Memory
		@GetMapping("/countries")
		public Collection<Country> getCountries()
		{
			Map<Integer, Country> entries=opsForHash.entries("Countries");
			Collection<Country> values=entries.values();
			return values;
		}

}
