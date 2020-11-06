package model;

public class Thongsokithuat {
	private String bangtan;
	private String gpu;
	private String cpu;
	private String ram;
	private String bonhotrong;
	private String cambien;
	private String hedieuhanh;
	private String camtruoc;
	private String camsau;
	private String pin;
	private String congnghesacpin;
	private String thenho;
	private int masanpham;
	
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getBangtan() {
		return bangtan;
	}
	public void setBangtan(String bangtan) {
		this.bangtan = bangtan;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getBonhotrong() {
		return bonhotrong;
	}
	public void setBonhotrong(String bonhotrong) {
		this.bonhotrong = bonhotrong;
	}
	public String getCambien() {
		return cambien;
	}
	public void setCambien(String cambien) {
		this.cambien = cambien;
	}
	public String getHedieuhanh() {
		return hedieuhanh;
	}
	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}
	public String getCamtruoc() {
		return camtruoc;
	}
	public void setCamtruoc(String camtruoc) {
		this.camtruoc = camtruoc;
	}
	public String getCamsau() {
		return camsau;
	}
	public void setCamsau(String camsau) {
		this.camsau = camsau;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCongnghesacpin() {
		return congnghesacpin;
	}
	public void setCongnghesacpin(String congnghesacpin) {
		this.congnghesacpin = congnghesacpin;
	}
	public String getThenho() {
		return thenho;
	}
	public void setThenho(String thenho) {
		this.thenho = thenho;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	
	public Thongsokithuat(String bangtan, String gpu, String cpu, String ram, String bonhotrong, String cambien,
			String hedieuhanh, String camtruoc, String camsau, String pin, String congnghesacpin, String thenho,
			int masanpham) {
		super();
		this.bangtan = bangtan;
		this.gpu = gpu;
		this.cpu = cpu;
		this.ram = ram;
		this.bonhotrong = bonhotrong;
		this.cambien = cambien;
		this.hedieuhanh = hedieuhanh;
		this.camtruoc = camtruoc;
		this.camsau = camsau;
		this.pin = pin;
		this.congnghesacpin = congnghesacpin;
		this.thenho = thenho;
		this.masanpham = masanpham;
	}
	public Thongsokithuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
