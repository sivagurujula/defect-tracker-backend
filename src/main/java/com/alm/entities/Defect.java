package com.alm.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="defects")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Defect {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="defect_id")
	private Integer defectId;
	
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="estfix_date")
	private Date esitimatedFixData;
	@NonNull private String description;
	
	@ManyToOne 
	@JoinColumn(foreignKey=@ForeignKey(name="fk_status_id"))
	@NonNull
	private Status status;
	@ManyToOne 
	@JoinColumn(foreignKey=@ForeignKey(name="fk_priority_id"))
	@NonNull
	private Priority priority;
	
	@PrePersist
	void persistCreatedDt() {
		this.createdDate = new Date();
	}
	
}
