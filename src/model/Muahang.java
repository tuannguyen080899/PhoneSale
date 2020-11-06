package model;

import java.util.Date;

public class Muahang {
	private int mamuahang;
	private String username;
	private Date thoigian;
	private int trangthai;
	public int getMamuahang() {
		return mamuahang;
	}
	public void setMamuahang(int mamuahang) {
		this.mamuahang = mamuahang;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getThoigian() {
		return thoigian;
	}
	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public Muahang(int mamuahang, String username, Date thoigian, int trangthai) {
		super();
		this.mamuahang = mamuahang;
		this.username = username;
		this.thoigian = thoigian;
		this.trangthai = trangthai;
	}
	public Muahang() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
