package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOAICV")
public class LoaiCVEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "LOAICV")
	private String loaiCV;
}
