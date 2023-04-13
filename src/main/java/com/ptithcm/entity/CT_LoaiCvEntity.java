package com.ptithcm.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CT_LOAICV")
public class CT_LoaiCvEntity {

	@EmbeddedId
	private CT_LoaiCvKey key;
	
	@ManyToOne()
	@MapsId("idbv")
	@JoinColumn(name = "IDBV")
	private BaiVietEntity bvEntity;
	
	@ManyToOne()
	@MapsId("idlcv")
	@JoinColumn(name = "IDLCV")
	private LoaiCVEntity lcvEntity;

	public CT_LoaiCvEntity() {
		super();
	}

	public CT_LoaiCvEntity(CT_LoaiCvKey key, BaiVietEntity bvEntity, LoaiCVEntity lcvEntity) {
		super();
		this.key = key;
		this.bvEntity = bvEntity;
		this.lcvEntity = lcvEntity;
	}

	public CT_LoaiCvKey getKey() {
		return key;
	}

	public void setKey(CT_LoaiCvKey key) {
		this.key = key;
	}

	public BaiVietEntity getBvEntity() {
		return bvEntity;
	}

	public void setBvEntity(BaiVietEntity bvEntity) {
		this.bvEntity = bvEntity;
	}

	public LoaiCVEntity getLcvEntity() {
		return lcvEntity;
	}

	public void setLcvEntity(LoaiCVEntity lcvEntity) {
		this.lcvEntity = lcvEntity;
	}
	
	
}
