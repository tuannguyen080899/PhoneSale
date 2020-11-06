package model;

public class Slider {
	private int maslider;
	private String title;
	private String anh;
	private boolean trangthai;
	
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	public int getMaslider() {
		return maslider;
	}
	public void setMaslider(int maslider) {
		this.maslider = maslider;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	public Slider(int maslider, String title, String anh, boolean trangthai) {
		super();
		this.maslider = maslider;
		this.title = title;
		this.anh = anh;
		this.trangthai = trangthai;
	}
	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
