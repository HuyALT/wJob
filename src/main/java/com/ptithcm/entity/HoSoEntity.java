package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HO_SO_ND")
public class HoSoEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOIDUNGMOTA")
	private String noidung;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;

	public HoSoEntity() {
		super();
	}

	public HoSoEntity(int id, String noidung, NguoiDungEntity ndEntity) {
		super();
		this.id = id;
		this.noidung = noidung;
		this.ndEntity = ndEntity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public NguoiDungEntity getNdEntity() {
		return ndEntity;
	}

	public void setNdEntity(NguoiDungEntity ndEntity) {
		this.ndEntity = ndEntity;
	}
	
	
	
}
