package com.ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BAOCAO")
public class BaoCaoEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOIDUNGBAOCAO")
	private String ndbc;
	
	@OneToMany(mappedBy = "bcEntity")
	private Collection<CT_BaoCaoEntity> dsbaocao;

	public BaoCaoEntity() {
		super();
	}

	public BaoCaoEntity(int id, String ndbc, Collection<CT_BaoCaoEntity> dsbaocao) {
		super();
		this.id = id;
		this.ndbc = ndbc;
		this.dsbaocao = dsbaocao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNdbc() {
		return ndbc;
	}

	public void setNdbc(String ndbc) {
		this.ndbc = ndbc;
	}

	public Collection<CT_BaoCaoEntity> getDsbaocao() {
		return dsbaocao;
	}

	public void setDsbaocao(Collection<CT_BaoCaoEntity> dsbaocao) {
		this.dsbaocao = dsbaocao;
	}
	
	
}
