package com.ptithcm.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.ptithcm.entity.combinekey.QuanTamBVKey;

@Entity
@Table(name = "UNGTUYEN")
public class UngTuyenEntity {
	
	@EmbeddedId
	private QuanTamBVKey key;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idbv")
	@JoinColumn(name = "IDBV")
	private BaiVietEntity bvEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idnd")
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;

	public UngTuyenEntity() {
		super();
	}

	public UngTuyenEntity(QuanTamBVKey key, BaiVietEntity bvEntity, NguoiDungEntity ndEntity) {
		super();
		this.key = key;
		this.bvEntity = bvEntity;
		this.ndEntity = ndEntity;
	}

	public QuanTamBVKey getKey() {
		return key;
	}

	public void setKey(QuanTamBVKey key) {
		this.key = key;
	}

	public BaiVietEntity getBvEntity() {
		return bvEntity;
	}

	public void setBvEntity(BaiVietEntity bvEntity) {
		this.bvEntity = bvEntity;
	}

	public NguoiDungEntity getNdEntity() {
		return ndEntity;
	}

	public void setNdEntity(NguoiDungEntity ndEntity) {
		this.ndEntity = ndEntity;
	}
	
	
}
