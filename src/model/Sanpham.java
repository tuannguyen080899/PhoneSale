package model;

public class Sanpham {
	private Danhmuc danhmuc;
	private int masanpham;
	private String tensanpham;
	private int gianhap;
	private int giaban;
	private int giagiam;
	private String mausac;
	private String mota;
	private String bonho;
	private boolean loai;
	private String anhtruoc;
	private String anhsau;
	private String anhtuxa;
	private String anhquangcao;
	private boolean quangcao;
	
	public String getAnhquangcao() {
		return anhquangcao;
	}
	public void setAnhquangcao(String anhquangcao) {
		this.anhquangcao = anhquangcao;
	}
	public boolean isQuangcao() {
		return quangcao;
	}
	public void setQuangcao(boolean quangcao) {
		this.quangcao = quangcao;
	}
	public Danhmuc getDanhmuc() {
		return danhmuc;
	}
	public void setDanhmuc(Danhmuc danhmuc) {
		this.danhmuc = danhmuc;
	}
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
	public int getGianhap() {
		return gianhap;
	}
	public void setGianhap(int gianhap) {
		this.gianhap = gianhap;
	}
	public int getGiaban() {
		return giaban;
	}
	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}
	public int getGiagiam() {
		return giagiam;
	}
	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}
	public String getMausac() {
		return mausac;
	}
	public void setMausac(String mausac) {
		this.mausac = mausac;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getBonho() {
		return bonho;
	}
	public void setBonho(String bonho) {
		this.bonho = bonho;
	}
	public boolean isLoai() {
		return loai;
	}
	public void setLoai(boolean loai) {
		this.loai = loai;
	}
	public String getAnhtruoc() {
		return anhtruoc;
	}
	public void setAnhtruoc(String anhtruoc) {
		this.anhtruoc = anhtruoc;
	}
	public String getAnhsau() {
		return anhsau;
	}
	public void setAnhsau(String anhsau) {
		this.anhsau = anhsau;
	}
	public String getAnhtuxa() {
		return anhtuxa;
	}
	public void setAnhtuxa(String anhtuxa) {
		this.anhtuxa = anhtuxa;
	}
	
	public Sanpham(Danhmuc danhmuc, int masanpham, String tensanpham, int gianhap, int giaban, int giagiam,
			String mausac, String mota, String bonho, boolean loai, String anhtruoc, String anhsau, String anhtuxa,
			String anhquangcao, boolean quangcao) {
		super();
		this.danhmuc = danhmuc;
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.gianhap = gianhap;
		this.giaban = giaban;
		this.giagiam = giagiam;
		this.mausac = mausac;
		this.mota = mota;
		this.bonho = bonho;
		this.loai = loai;
		this.anhtruoc = anhtruoc;
		this.anhsau = anhsau;
		this.anhtuxa = anhtuxa;
		this.anhquangcao = anhquangcao;
		this.quangcao = quangcao;
	}
	public Sanpham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
