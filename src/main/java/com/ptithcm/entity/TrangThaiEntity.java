package com.ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "TRANGTHAIBV")
public class TrangThaiEntity {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TENTRANGTHAI")
	private String tentt;
	
	@OneToMany(mappedBy = "ttEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<BaiVietEntity> dsbv;

	public TrangThaiEntity() {
		super();
	}

	public TrangThaiEntity(int id, String tentt, Collection<BaiVietEntity> dsbv) {
		super();
		this.id = id;
		this.tentt = tentt;
		this.dsbv = dsbv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTentt() {
		return tentt;
	}

	public void setTentt(String tentt) {
		this.tentt = tentt;
	}

	public Collection<BaiVietEntity> getDsbv() {
		return dsbv;
	}

	public void setDsbv(Collection<BaiVietEntity> dsbv) {
		this.dsbv = dsbv;
	}
	
	
}
