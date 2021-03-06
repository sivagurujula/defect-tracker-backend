package com.alm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Priority {
	@Id
	@Column(name="priority_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NonNull private String priority;
}
