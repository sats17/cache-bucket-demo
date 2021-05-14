package com.github.sats17.cachebucketdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dump")
@Data
public class Dump {
	
	@Id
	private Integer id;
	
	@Column(name = "uuid",length = 20)
	private String uuid;

}
