package com.ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "NGANH")
public class NganhEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOIDUNG")
	private String noidung;
	
	@OneToMany(mappedBy = "nganhEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<BaiVietEntity> dsbv;
	
	@OneToMany(mappedBy = "tdEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<HoSoEntity> dshs;

	public NganhEntity() {
		super();
	}

	public NganhEntity(int id, String noidung, Collection<BaiVietEntity> dsbv, Collection<HoSoEntity> dshs) {
		super();
		this.id = id;
		this.noidung = noidung;
		this.dsbv = dsbv;
		this.dshs = dshs;
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

	public Collection<BaiVietEntity> getDsbv() {
		return dsbv;
	}

	public void setDsbv(Collection<BaiVietEntity> dsbv) {
		this.dsbv = dsbv;
	}

	public Collection<HoSoEntity> getDshs() {
		return dshs;
	}

	public void setDshs(Collection<HoSoEntity> dshs) {
		this.dshs = dshs;
	}
	
	
}
