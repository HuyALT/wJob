package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTRINHDO")
	private TrinhDoEntity tdEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDNGANH")
	private NganhEntity nganhEntity;

	public HoSoEntity() {
		super();
	}

	public HoSoEntity(int id, String noidung, NguoiDungEntity ndEntity, TrinhDoEntity tdEntity,
			NganhEntity nganhEntity) {
		super();
		this.id = id;
		this.noidung = noidung;
		this.ndEntity = ndEntity;
		this.tdEntity = tdEntity;
		this.nganhEntity = nganhEntity;
	}

	public TrinhDoEntity getTdEntity() {
		return tdEntity;
	}

	public void setTdEntity(TrinhDoEntity tdEntity) {
		this.tdEntity = tdEntity;
	}

	public NganhEntity getNganhEntity() {
		return nganhEntity;
	}

	public void setNganhEntity(NganhEntity nganhEntity) {
		this.nganhEntity = nganhEntity;
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
