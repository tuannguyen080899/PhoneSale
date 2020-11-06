package model;

public class Tinh {
	private int makhuvuc;
	private String tenkhuvuc;
	private int cuocphy;
	public int getMakhuvuc() {
		return makhuvuc;
	}
	public void setMakhuvuc(int makhuvuc) {
		this.makhuvuc = makhuvuc;
	}
	public String getTenkhuvuc() {
		return tenkhuvuc;
	}
	public void setTenkhuvuc(String tenkhuvuc) {
		this.tenkhuvuc = tenkhuvuc;
	}
	public int getCuocphy() {
		return cuocphy;
	}
	public void setCuocphy(int cuocphy) {
		this.cuocphy = cuocphy;
	}
	public Tinh(int makhuvuc, String tenkhuvuc, int cuocphy) {
		super();
		this.makhuvuc = makhuvuc;
		this.tenkhuvuc = tenkhuvuc;
		this.cuocphy = cuocphy;
	}
	public Tinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
