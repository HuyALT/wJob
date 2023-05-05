package com.ptithcm.entity.combinekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuanTamBVKey implements Serializable {

	@Column(name = "IDND")
	private int idnd;
	
	@Column(name = "IDBV")
	private int idbv;

	public QuanTamBVKey() {
		super();
	}

	public QuanTamBVKey(int idnd, int idbv) {
		super();
		this.idnd = idnd;
		this.idbv = idbv;
	}

	public int getIdnd() {
		return idnd;
	}

	public void setIdnd(int idnd) {
		this.idnd = idnd;
	}

	public int getIdbv() {
		return idbv;
	}

	public void setIdbv(int idbv) {
		this.idbv = idbv;
	}
	
	
}
