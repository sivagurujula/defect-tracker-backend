package com.alm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alm.entities.Priority;

public interface PriorityDAO extends CrudRepository<Priority, Integer> {
	
	List<Priority> findByPriority(String priority);

}
