package com.example.demo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Coder;
import com.example.demo.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	Log logger=LogFactory.getLog(CoderController.class);
	
	@Autowired
	CoderService cs;
	@GetMapping(path="getcoders")
	public List<Coder> getCoders()throws Throwable
	{
		List<Coder> lc=cs.getCoders();
		logger.info("Get Coders successfully");
		return lc;
	}
    @PostMapping("addcoders")
	public List<Coder> addCoders(@RequestBody List<Coder> c)throws Throwable
	{
		List<Coder> lc=cs.addCoders(c);
		return lc;
	}
    @PostMapping("addcoder")
	public Coder addCoder(@RequestBody Coder c)throws Throwable
	{
		Coder lc=cs.addCoder(c);
		return lc;
	}
    @DeleteMapping("deleteCoder")
    public ResponseEntity<String> deleteCoder(@RequestBody Coder c)throws Throwable
	{
    	cs.deleteCoder(c);
    	ResponseEntity<String> re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
    @DeleteMapping("deleteById/{cid}")
	public String deleteById(@PathVariable int cid)throws Throwable
	{
    	
		cs.deleteById(cid);
		return "Deleted";
    
	}
    @PutMapping("updateCoder")
	public Coder updateCoder(@RequestBody Coder c)throws Throwable
	{
		Coder c1=cs.updateCoder(c);
		return c1;
		
	}
	@GetMapping("getById/{id}")
	public Coder getById(@PathVariable int id)throws Throwable
	{
		Coder c=cs.getById(id);
		return c;
	}
	@GetMapping("getsorted/{tech}")
	public List<Coder> getCoderByTechSorted(@PathVariable String tech)throws Throwable
	{   
		List<Coder> lc = cs.getCoderByTechSorted(tech);
		return lc;
		
	}
	@GetMapping("getcoderbyname/{name}")
	public Coder getCoderByName(@PathVariable String name)throws Throwable
	{
		Coder c=cs.getCoderByName(name);
		return c;
		
	}
	@DeleteMapping("deleteCoders")
	public String deleteCoders(@RequestBody List<Coder> c)throws Throwable
	{
		cs.deleteCoders(c);
		
		return "Deleted";
	}

}
