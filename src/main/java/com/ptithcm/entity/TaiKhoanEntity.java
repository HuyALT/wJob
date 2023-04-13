package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoanEntity {
	
	@Id
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MAQUYEN")
	private QuyenEntity quEntity;

	public TaiKhoanEntity() {
		super();
	}

	public TaiKhoanEntity(String username, String password, NguoiDungEntity ndEntity, QuyenEntity quEntity) {
		super();
		this.username = username;
		this.password = password;
		this.ndEntity = ndEntity;
		this.quEntity = quEntity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public NguoiDungEntity getNdEntity() {
		return ndEntity;
	}

	public void setNdEntity(NguoiDungEntity ndEntity) {
		this.ndEntity = ndEntity;
	}

	public QuyenEntity getQuEntity() {
		return quEntity;
	}

	public void setQuEntity(QuyenEntity quEntity) {
		this.quEntity = quEntity;
	}
	
	
}
