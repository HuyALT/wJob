package com.ptithcm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CT_BaoCaoKey implements Serializable {

	@Column(name = "IDBC")
	private int idbc;
	
	@Column(name = "IDBV")
	private int idbv;
	
	@Column(name = "IDND")
	private int idnd;

	public CT_BaoCaoKey() {
		super();
	}

	public CT_BaoCaoKey(int idbc, int idbv, int idnd) {
		super();
		this.idbc = idbc;
		this.idbv = idbv;
		this.idnd = idnd;
	}

	public int getIdbc() {
		return idbc;
	}

	public void setIdbc(int idbc) {
		this.idbc = idbc;
	}

	public int getIdbv() {
		return idbv;
	}

	public void setIdbv(int idbv) {
		this.idbv = idbv;
	}

	public int getIdnd() {
		return idnd;
	}

	public void setIdnd(int idnd) {
		this.idnd = idnd;
	}
	
	
}
