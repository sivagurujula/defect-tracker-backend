package com.alm.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alm.dao.DefectsDAO;
import com.alm.dao.PriorityDAO;
import com.alm.dao.StatusDAO;
import com.alm.entities.Defect;
import com.alm.entities.Priority;
import com.alm.entities.Status;

@Service
public class DataFill {
	
	private DefectsDAO defectsDao;
	private PriorityDAO priorityDao;
	private StatusDAO statusDao;
	@Autowired
	public  DataFill(DefectsDAO defectsDao,PriorityDAO priorityDao,StatusDAO statusDao) {
		this.defectsDao = defectsDao;
		this.priorityDao = priorityDao;
		this.statusDao = statusDao;
	}
	
	@PostConstruct
	@Transactional
	public void fillData() {
		List<Priority> priorites = new ArrayList<>();
		priorites.add(new Priority("Critical"));
		priorites.add(new Priority("High"));
		priorites.add(new Priority("Medium"));
		priorites.add(new Priority("Low"));
		this.priorityDao.saveAll(priorites);
		
		List<Status> satuses = new ArrayList<>();
		satuses.add(new Status("Open"));
		satuses.add(new Status("Closed"));
		satuses.add(new Status("Rejected"));
		satuses.add(new Status("Validation"));
		this.statusDao.saveAll(satuses);
		
		Priority priority = this.priorityDao.findByPriority("High").get(0);
		Status status = this.statusDao.findByStatus("Open").get(0);
		
		Defect defect = new Defect( "Validation missing ", status, priority);
		
		this.defectsDao.save(defect);
	}
}
