package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Laptop;
import com.example.demo.service.LaptopService;

@RestController
@RequestMapping("api")
public class LaptopController {
	@Autowired
	LaptopService cl;
	@PostMapping("addlaptop")
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop l)
	{
		Laptop l1=cl.addLaptop(l);
		ResponseEntity re=new ResponseEntity<Laptop> (l1,HttpStatus.OK);
		return re;
	}

}
