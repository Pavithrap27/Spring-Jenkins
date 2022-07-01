package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Coder;

@Repository
public interface CoderRepository extends JpaRepository<Coder,Integer>{
	public Coder getCoderByName(String name);
	@Query("Select c from Coder c where tech=?1 order by name")
	public List<Coder> getCoderByTechSorted(String tech);

}
