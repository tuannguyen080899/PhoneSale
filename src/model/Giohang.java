package model;

public class Giohang {
	private int masanpham;
	private String tensanpham;
	private String hinhanh;
	private int soluong;
	private int thanhtien;
	private int tienvon;
	private int mamuahang;
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public int getTienvon() {
		return tienvon;
	}
	public void setTienvon(int tienvon) {
		this.tienvon = tienvon;
	}
	public int getMamuahang() {
		return mamuahang;
	}
	public void setMamuahang(int mamuahang) {
		this.mamuahang = mamuahang;
	}
	public Giohang(int masanpham, String tensanpham, String hinhanh, int soluong, int thanhtien, int tienvon,
			int mamuahang) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.tienvon = tienvon;
		this.mamuahang = mamuahang;
	}
	public Giohang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
