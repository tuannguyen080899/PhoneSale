package model;

public class Danhmuc {
	private int madanhmuc;
	private String tendanhmuc;
	private boolean trangthai;
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	public Danhmuc(int madanhmuc, String tendanhmuc, boolean trangthai) {
		super();
		this.madanhmuc = madanhmuc;
		this.tendanhmuc = tendanhmuc;
		this.trangthai = trangthai;
	}
	public Danhmuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
