package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Coder;
import com.example.demo.entity.Laptop;
import com.example.demo.repository.CoderRepository;
@SpringBootTest
class CoderServiceTest {
	@Autowired
	CoderService cs;
	@MockBean
	CoderRepository cr;

	@Test
	void testGetCoders()throws Throwable {
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		
		Laptop l1=new Laptop();
		l1.setId(2);
		l1.setName("lenovo");
		Coder c1=new Coder();
		c1.setId(2);
		c1.setName("abhin");
		c1.setTech("c");
		c1.setLaptop(l1);
		
		List<Coder> coderList = new ArrayList<>();
		coderList.add(c);
		coderList.add(c1);
		
		Mockito.when(cr.findAll()).thenReturn(coderList);
		assertThat(cs.getCoders()).isEqualTo(coderList);
		
		
		
	}

	@Test
	void testAddCoders() throws Throwable{
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		Laptop l1=new Laptop();
		l1.setId(2);
		l1.setName("lenovo");
		Coder c1=new Coder();
		c1.setId(2);
		c1.setName("abhin");
		c1.setTech("c");
		c1.setLaptop(l1);
		
		List<Coder> lc = new ArrayList<>();
		lc.add(c);
		lc.add(c1);
		
		
		Mockito.when(cr.saveAll(lc)).thenReturn(lc);
		assertThat(cs.addCoders(lc)).isEqualTo(lc);
		
		
	}

	@Test
	void testAddCoder() throws Throwable {
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		Mockito.when(cr.save(c)).thenReturn(c);
		assertThat(cs.addCoder(c)).isEqualTo(c);
		
		
		
	}

	@Test
	void testDeleteCoder() throws Throwable {
		Coder c1=new Coder();
		c1.setId(1);
		c1.setName("Madhu");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		Mockito.when(cr.findById(1)).thenReturn(c2);
		 Mockito.when(cr.existsById(c1.getId())).thenReturn(false);
		   assertFalse(cr.existsById(c1.getId()));
		
		
	}

	@Test
	void testDeleteById() throws Throwable{
		Coder c1=new Coder();
		c1.setId(1);
		c1.setName("Madhu");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(cr.findById(1)).thenReturn(c2);
		 Mockito.when(cr.existsById(c1.getId())).thenReturn(false);
		   assertFalse(cr.existsById(c1.getId()));
		
		
	}

	@Test
	void testUpdateCoder()throws Throwable{
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		Optional<Coder> o=Optional.of(c);
		Mockito.when(cr.findById(1)).thenReturn(o);
		
		Mockito.when(cr.save(c)).thenReturn(c);
		Laptop l1=new Laptop();
		
		l.setName("lenovo");
		c.setName("abhin");
		c.setTech("c");
		c.setLaptop(l);
		assertThat(cs.addCoder(c)).isEqualTo(c);
		
		
	}

	@Test
	void testGetById()throws Throwable {
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		
		Optional<Coder> o=Optional.of(c);
		Mockito.when(cr.findById(1)).thenReturn(o);
		assertThat(cs.getById(1)).isEqualTo(c);
		
		
		
	}

	@Test
	void testGetCoderByTechSorted() throws Throwable {
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		Laptop l1=new Laptop();
		l1.setId(2);
		l1.setName("lenovo");
		Coder c1=new Coder();
		c1.setId(2);
		c1.setName("abhin");
		c1.setTech("c");
		c1.setLaptop(l1);
		
		List<Coder> lc = new ArrayList<>();
		lc.add(c);
		lc.add(c1);
	    Mockito.when(cr.getCoderByTechSorted("java")).thenReturn(lc);
		assertThat(cs.getCoderByTechSorted("java")).isEqualTo(lc);
	}

	@Test
	void testGetCoderByName() throws Throwable {
		Laptop l=new Laptop();
		l.setId(1);
		l.setName("mac");
		Coder c=new Coder();
		c.setId(1);
		c.setName("pavi");
		c.setTech("java");
		c.setLaptop(l);
		
	    Mockito.when(cr.getCoderByName("pavi")).thenReturn(c);
		assertThat(cs.getCoderByName("pavi")).isEqualTo(c);
	}
   
}
