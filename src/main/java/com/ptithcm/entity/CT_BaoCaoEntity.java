package com.ptithcm.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CT_BAOCAO")
public class CT_BaoCaoEntity {

	@EmbeddedId
	private CT_BaoCaoKey key;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idbc")
	@JoinColumn(name = "IDBC")
	private BaoCaoEntity bcEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idbv")
	@JoinColumn(name = "IDBV")
	private BaiVietEntity bvEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idnd")
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;

	public CT_BaoCaoEntity() {
		super();
	}

	public CT_BaoCaoEntity(CT_BaoCaoKey key, BaoCaoEntity bcEntity, BaiVietEntity bvEntity, NguoiDungEntity ndEntity) {
		super();
		this.key = key;
		this.bcEntity = bcEntity;
		this.bvEntity = bvEntity;
		this.ndEntity = ndEntity;
	}

	public CT_BaoCaoKey getKey() {
		return key;
	}

	public void setKey(CT_BaoCaoKey key) {
		this.key = key;
	}

	public BaoCaoEntity getBcEntity() {
		return bcEntity;
	}

	public void setBcEntity(BaoCaoEntity bcEntity) {
		this.bcEntity = bcEntity;
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
