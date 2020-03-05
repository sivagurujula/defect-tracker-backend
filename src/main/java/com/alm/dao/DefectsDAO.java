package com.alm.dao;

import org.springframework.data.repository.CrudRepository;

import com.alm.entities.Defect;

public interface DefectsDAO extends CrudRepository<Defect, Integer> {

}
