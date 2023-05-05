package com.ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "NGUOIDUNG")
public class NguoiDungEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "HO")
	private String ho;
	
	@Column(name = "TEN")
	private String ten;
	
	@Column(name = "PHAI")
	private boolean phai;
	
	@Column(name = "DIACHI")
	private String diachi;
	
	@Column(name = "NGAYSINH")
	private Date ngaysinh;
	
	@Column(name = "CMND")
	private String cmnd;
	
	@Column(name = "SDT")
	private String sdt;
	
	@OneToOne(mappedBy = "ndEntity")
	private TaiKhoanEntity tknd;
	
	@OneToOne(mappedBy = "ndEntity")
	private HoSoEntity hsnd;
	
	@OneToMany(mappedBy = "ndEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<BaiVietEntity> dsbv;
	
	@OneToMany(mappedBy = "ndEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<CT_BaoCaoEntity> dsctbc;

	public NguoiDungEntity() {
		super();
	}

	public NguoiDungEntity(int id, String ho, String ten, boolean phai, String diachi, Date ngaysinh, String cmnd,
			String sdt, TaiKhoanEntity tknd, HoSoEntity hsnd, Collection<BaiVietEntity> dsbv,
			Collection<CT_BaoCaoEntity> dsctbc) {
		super();
		this.id = id;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.diachi = diachi;
		this.ngaysinh = ngaysinh;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.tknd = tknd;
		this.hsnd = hsnd;
		this.dsbv = dsbv;
		this.dsctbc = dsctbc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiKhoanEntity getTknd() {
		return tknd;
	}

	public void setTknd(TaiKhoanEntity tknd) {
		this.tknd = tknd;
	}

	public HoSoEntity getHsnd() {
		return hsnd;
	}

	public void setHsnd(HoSoEntity hsnd) {
		this.hsnd = hsnd;
	}

	public Collection<BaiVietEntity> getDsbv() {
		return dsbv;
	}

	public void setDsbv(Collection<BaiVietEntity> dsbv) {
		this.dsbv = dsbv;
	}

	public Collection<CT_BaoCaoEntity> getDsctbc() {
		return dsctbc;
	}

	public void setDsctbc(Collection<CT_BaoCaoEntity> dsctbc) {
		this.dsctbc = dsctbc;
	}

	
	
	
	
}
