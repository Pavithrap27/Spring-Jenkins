package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Laptop;
import com.example.demo.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepository cl;
	public Laptop addLaptop(Laptop l)
	{
		cl.save(l);
		return l;
	}
	

}
