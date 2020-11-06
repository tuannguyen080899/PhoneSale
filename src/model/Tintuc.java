package model;

import java.util.Date;

public class Tintuc {
	private int matintuc;
	private String hinhanh;
	private String mota;
	private Date thoigian;
	private boolean trangthai;
	public int getMatintuc() {
		return matintuc;
	}
	public void setMatintuc(int matintuc) {
		this.matintuc = matintuc;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Date getThoigian() {
		return thoigian;
	}
	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	public Tintuc(int matintuc, String hinhanh, String mota, Date thoigian, boolean trangthai) {
		super();
		this.matintuc = matintuc;
		this.hinhanh = hinhanh;
		this.mota = mota;
		this.thoigian = thoigian;
		this.trangthai = trangthai;
	}
	public Tintuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
