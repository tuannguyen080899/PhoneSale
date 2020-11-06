package model;

public class Taikhoan {
	private String username;
	private String password;
	private String tenkhachhang;
	private String sodienthoai;
	private String email;
	private String diachi;
	private int makhuvuc;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getMakhuvuc() {
		return makhuvuc;
	}
	public void setMakhuvuc(int makhuvuc) {
		this.makhuvuc = makhuvuc;
	}
	public Taikhoan(String username, String password, String tenkhachhang, String sodienthoai, String email,
			String diachi, int makhuvuc) {
		super();
		this.username = username;
		this.password = password;
		this.tenkhachhang = tenkhachhang;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.diachi = diachi;
		this.makhuvuc = makhuvuc;
	}
	public Taikhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
