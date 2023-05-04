package com.ptithcm.entity;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "BAIVIET")
public class BaiVietEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TIEUDE")
	private String tieude;
	
	@Column(name = "NOIDUNG")
	private String noidung;
	
	@Column(name = "NGAYBATDAU")
	private Date ngaybd;
	
	@Column(name = "NGAYKETTHUC")
	private Date ngaykt;
	
	@Column(name = "DIACHI")
	private String diachi;
	
	@Column(name = "EMAILLH")
	private String emaillh;
	
	@Column(name = "SDTLH")
	private String sdtlh;
	
	@Column(name = "LUOTXEM")
	private int luotxem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDND")
	private NguoiDungEntity ndEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTT")
	private TrangThaiEntity ttEntity;
	
	@OneToMany(mappedBy = "bvEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<CT_BaoCaoEntity> dsctBaoCao;
	
	@OneToMany(mappedBy = "bvEntity")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<CT_LoaiCvEntity> dsctLoaiCV;

	public BaiVietEntity() {
		super();
	}

	public BaiVietEntity(int id, String tieude, String noidung, Date ngaybd, Date ngaykt, String diachi, String emaillh,
			String sdtlh, int luotxem, NguoiDungEntity ndEntity, TrangThaiEntity ttEntity,
			Collection<CT_BaoCaoEntity> dsctBaoCao, Collection<CT_LoaiCvEntity> dsctLoaiCV) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.noidung = noidung;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.diachi = diachi;
		this.emaillh = emaillh;
		this.sdtlh = sdtlh;
		this.luotxem = luotxem;
		this.ndEntity = ndEntity;
		this.ttEntity = ttEntity;
		this.dsctBaoCao = dsctBaoCao;
		this.dsctLoaiCV = dsctLoaiCV;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmaillh() {
		return emaillh;
	}

	public void setEmaillh(String emaillh) {
		this.emaillh = emaillh;
	}

	public String getSdtlh() {
		return sdtlh;
	}

	public void setSdtlh(String sdtlh) {
		this.sdtlh = sdtlh;
	}

	public int getLuotxem() {
		return luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	public NguoiDungEntity getNdEntity() {
		return ndEntity;
	}

	public void setNdEntity(NguoiDungEntity ndEntity) {
		this.ndEntity = ndEntity;
	}

	public TrangThaiEntity getTtEntity() {
		return ttEntity;
	}

	public void setTtEntity(TrangThaiEntity ttEntity) {
		this.ttEntity = ttEntity;
	}

	public Collection<CT_BaoCaoEntity> getDsctBaoCao() {
		return dsctBaoCao;
	}

	public void setDsctBaoCao(Collection<CT_BaoCaoEntity> dsctBaoCao) {
		this.dsctBaoCao = dsctBaoCao;
	}

	public Collection<CT_LoaiCvEntity> getDsctLoaiCV() {
		return dsctLoaiCV;
	}

	public void setDsctLoaiCV(Collection<CT_LoaiCvEntity> dsctLoaiCV) {
		this.dsctLoaiCV = dsctLoaiCV;
	}
	
	
	
}
