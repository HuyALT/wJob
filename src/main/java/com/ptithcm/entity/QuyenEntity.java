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
@Table(name = "QUYEN")
public class QuyenEntity {
	@Id
	@Column(name = "MAQUYEN")
	private String maQuyen;
	
	@Column(name = "TENQUYEN")
	private String tenQuyen;
	
	@OneToMany(mappedBy = "quEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<TaiKhoanEntity> dstk;

	public QuyenEntity() {
		super();
	}

	public QuyenEntity(String maQuyen, String tenQuyen, Collection<TaiKhoanEntity> dstk) {
		super();
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.dstk = dstk;
	}

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public Collection<TaiKhoanEntity> getDstk() {
		return dstk;
	}

	public void setDstk(Collection<TaiKhoanEntity> dstk) {
		this.dstk = dstk;
	}
	
	
}
