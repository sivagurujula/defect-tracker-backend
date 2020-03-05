package com.alm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alm.entities.Status;

public interface StatusDAO extends CrudRepository<Status, Integer> {
	List<Status> findByStatus(String status);
}
