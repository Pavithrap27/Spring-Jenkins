package com.example.demo.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.advices.ResourceNotFoundException;
import com.example.demo.entity.Coder;
import com.example.demo.repository.CoderRepository;

@Service
public class CoderService {
	@Autowired
	CoderRepository cs;
	public List<Coder> getCoders()throws Throwable
	{ 
		List<Coder> lc=cs.findAll();
		if(lc.isEmpty())
		{
			throw new ResourceNotFoundException("the field not found");
		}
		return lc;
	    
	}
	
	public List<Coder> addCoders(List<Coder> c)throws Throwable
	{
		if(!c.contains(null))
		{
		List<Coder> lc=cs.saveAll(c);
		return lc;
		}
		   else
		  {
			throw new ResourceNotFoundException("the input does not exist");
			
		  }
		
	}
	public Coder addCoder(Coder c)throws Throwable
	{
		if(c!=null)
		{
		Coder lc=cs.save(c);
		return lc;
		}
		
	
	   else
	  {
		throw new ResourceNotFoundException("the input does not exist");
		
	  }
		
	}
	public String deleteCoder(Coder c)throws Throwable
	{
		if(getCoders().contains(c))
		{
		cs.delete(c);
		
		return "Deleted";
		}
		else
		{
			throw new ResourceNotFoundException("the input does not exist");
			
		}
	}
	public String deleteById(int cid)throws Throwable
	{
		Supplier s1=()->new ResourceNotFoundException("The id not found");
		Coder c=cs.findById(cid).orElseThrow(s1);
		cs.deleteById(cid);	
			return "deleted";

	}
	public Coder updateCoder(Coder c)throws Throwable
	{
		int id=c.getId();
		Supplier s1=()->new ResourceNotFoundException("Coder does not exist in the database");
		
		Coder c1=cs.findById(id).orElseThrow(s1);
		c1.setId(c.getId());
		c1.setName(c.getName());
		c1.setTech(c.getTech());
		c1.setLaptop(c.getLaptop());
		cs.save(c1);
		return c1;
		
	}
	public Coder getById(int id)throws Throwable
	{ 
		Supplier s1=()->new ResourceNotFoundException("The id not found");
		Coder c=cs.findById(id).orElseThrow(s1);
		return c;
	}
	public List<Coder> getCoderByTechSorted(String tech)throws Throwable
	{ 
		List<Coder> lc = cs.getCoderByTechSorted(tech);
		if(lc.isEmpty())
		{
			throw new ResourceNotFoundException("the input does not exist");
		
	    }
	else
	{
		return lc;
		
	}
		
	}
	public Coder getCoderByName(String name)throws Throwable
	{	
		Coder c=cs.getCoderByName(name);
		if(c!=null)
		{
		return c;
		}
		
		else
		{
			throw new ResourceNotFoundException("the input does not exist");
			
		}
		
	}
	public String deleteCoders(List<Coder> c)throws Throwable
	{
		if(c.isEmpty())
		{
			throw new ResourceNotFoundException("the input is empty");
		}
		cs.deleteAll(c);
		return "Deleted";
	}


}
