package com.ptithcm.entity.combinekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CT_LoaiCvKey implements Serializable {

	@Column(name = "IDBV")
	private int idbv;
	
	@Column(name = "IDLCV")
	private int idlcv;

	public CT_LoaiCvKey() {
		super();
	}

	public CT_LoaiCvKey(int idbv, int idlcv) {
		super();
		this.idbv = idbv;
		this.idlcv = idlcv;
	}

	public int getIdbv() {
		return idbv;
	}

	public void setIdbv(int idbv) {
		this.idbv = idbv;
	}

	public int getIdlcv() {
		return idlcv;
	}

	public void setIdlcv(int idlcv) {
		this.idlcv = idlcv;
	}
	
	
}
