package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Danhmuc;
import model.Sanpham;
import model.Thongsokithuat;

public class DaoSanpham {
	String sql;

	public int giatriBySanpham(int masanpham) throws SQLException {
		sql = "select giagiam,gianhap,giaban from sanpham where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet rs = pre.executeQuery();
		int x = 0;
		while (rs.next()) {
			x = rs.getInt("giagiam");
		}
		return x;
	}

	public int tienvonBySanpham(int masanpham) throws SQLException {
		sql = "select giagiam,gianhap,giaban from sanpham where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet rs = pre.executeQuery();
		int x = 0;
		while (rs.next()) {
			x = rs.getInt("gianhap");
		}
		return x;
	}

	public int soluongSanpham() throws SQLException {
		sql = "select count(masanpham) as soluongsp from sanpham";
		Statement st = DBConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		int x = 0;
		while (rs.next()) {
			x = rs.getInt("soluongsp");
		}
		return x;
	}

	public List<Sanpham> getAllSanpham(Danhmuc dm) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and dm.tendanhmuc=? order by thoigian desc ";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, dm.getTendanhmuc());
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc danhmuc;
		while (rs.next()){
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanphamlimit(Danhmuc dm, int start, int record) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and dm.tendanhmuc=? order by thoigian desc limit(?,?)";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, dm.getTendanhmuc());
		pre.setInt(2, start);
		pre.setInt(3, record);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc danhmuc;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanphamByName(String tensanpham) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.tensanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tensanpham);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc danhmuc;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham>getAllSanphamByNameGroupColor(String tensanpham) throws SQLException{
		List<Sanpham> list = new ArrayList<>();
		sql="select masanpham,mausac from sanpham where tensanpham=? group by mausac";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tensanpham);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		while(rs.next()) {
			sp=new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setMausac(rs.getString("mausac"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham>getAllSanphamByNameGroupBonho(String tensanpham) throws SQLException{
		List<Sanpham> list = new ArrayList<>();
		sql="select masanpham,bonho,giagiam from sanpham where tensanpham=? group by bonho";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tensanpham);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		while(rs.next()) {
			sp=new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setBonho(rs.getString("bonho"));
			sp.setGiagiam(rs.getInt("giagiam"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham> getAllSanphamlimit(int record) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc limit ?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, record);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc dm;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham> getAllSanphamQuangcao(int record) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and quangcao=1  limit ?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, record);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc dm;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			sp.setAnhquangcao(rs.getString("anhquangcao"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham> getAllSanphamQuangcao() throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and quangcao=1";
		Statement st=DBConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		Sanpham sp;
		Danhmuc dm;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			sp.setAnhquangcao(rs.getString("anhquangcao"));
			list.add(sp);
		}
		return list;
	}
	public List<Sanpham> getAllSanpham(Danhmuc dm, String bonho) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.bonho=? and dm.tendanhmuc=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, bonho);
		pre.setString(2, dm.getTendanhmuc());
		ResultSet rs = pre.executeQuery();
		Danhmuc danhmuc;
		Sanpham sp;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanpham(Danhmuc dm, String bonho, int minprice, int maxprice) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.bonho=? and dm.tendanhmuc=? and sp.giagiam < ? and sp.giagiam > ?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, bonho);
		pre.setString(2, dm.getTendanhmuc());
		pre.setInt(3, maxprice);
		pre.setInt(4, minprice);
		ResultSet rs = pre.executeQuery();
		Danhmuc danhmuc;
		Sanpham sp;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanpham(String bonho, int minprice, int maxprice) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.bonho=? and sp.giagiam < ? and sp.giagiam > ?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, bonho);
		pre.setInt(2, maxprice);
		pre.setInt(3, minprice);
		ResultSet rs = pre.executeQuery();
		Danhmuc danhmuc;
		Sanpham sp;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanpham(int minprice, int maxprice) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.giagiam < ? and sp.giagiam > ?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, maxprice);
		pre.setInt(2, minprice);
		ResultSet rs = pre.executeQuery();
		Danhmuc danhmuc;
		Sanpham sp;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanpham(Danhmuc dm, int minprice, int maxprice) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and dm.tendanhmuc=? and sp.giagiam <? and sp.giagiam >?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, dm.getTendanhmuc());
		pre.setInt(2, maxprice);
		pre.setInt(3, minprice);
		ResultSet rs = pre.executeQuery();
		Danhmuc danhmuc;
		Sanpham sp;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			danhmuc = new Danhmuc();
			danhmuc.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(danhmuc);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public List<Sanpham> getAllSanpham(String bonho) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.bonho=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, bonho);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc dm;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public Sanpham getSanphamByMasanpham(int masanpham) throws SQLException {
		Sanpham sp = new Sanpham();
		sql = "select *from sanpham as sp,danhmucsanpham as dm where sp.madanhmuc=dm.madanhmuc and sp.masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet rs = pre.executeQuery();
		Danhmuc dm;
		while (rs.next()) {
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			sp.setAnhquangcao(rs.getString("anhquangcao"));
		}
		return sp;
	}

	public int insertSanpham(Sanpham sanpham) throws SQLException {
		sql = "insert into sanpham (tensanpham,gianhap,giaban,giagiam,mausac,loai,bonho,mota,madanhmuc,thoigian) values(?,?,?,?,?,?,?,?,?,now())";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, sanpham.getTensanpham());
		pre.setInt(2, sanpham.getGianhap());
		pre.setInt(3, sanpham.getGiaban());
		pre.setInt(4, sanpham.getGiagiam());
		pre.setString(5, sanpham.getMausac());
		pre.setBoolean(6, sanpham.isLoai());
		pre.setString(7, sanpham.getBonho());
		pre.setString(8, sanpham.getMota());
		pre.setInt(9, sanpham.getDanhmuc().getMadanhmuc());
		int x = pre.executeUpdate();
		return x;
	}

	public int updateSanpham(Sanpham sanpham, int masanpham) throws SQLException {
		sql = "update sanpham set tensanpham=?,gianhap=?,"
				+ "giaban=?,giagiam=?,mausac=?,loai=?,bonho=?,mota=?,thoigian=now() where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, sanpham.getTensanpham());
		pre.setInt(2, sanpham.getGianhap());
		pre.setInt(3, sanpham.getGiaban());
		pre.setInt(4, sanpham.getGiagiam());
		pre.setString(5, sanpham.getMausac());
		pre.setBoolean(6, sanpham.isLoai());
		pre.setString(7, sanpham.getBonho());
		pre.setString(8, sanpham.getMota());
		pre.setInt(9, masanpham);
		int x = pre.executeUpdate();
		return x;
	}

	public int deleteSanpham(int masanpham) throws SQLException {
		sql = "delete from sanpham where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		int x = pre.executeUpdate();
		return x;
	}

	public int updateAnhByMasanpham(Sanpham sanpham, int masanpham) throws SQLException {
		sql = "update sanpham set anhtruoc=?,anhsau=?,anhtuxa=? where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, sanpham.getAnhtruoc());
		pre.setString(2, sanpham.getAnhsau());
		pre.setString(3, sanpham.getAnhtuxa());
		pre.setInt(4, masanpham);
		int x = pre.executeUpdate();
		return x;
	}
	public int updateAnhquangcao(String anhquangcao,int masanpham) throws SQLException {
		sql="update sanpham set anhquangcao=? where masanpham=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, anhquangcao);
		pre.setInt(2, masanpham);
		int x=pre.executeUpdate();
		return x;
	}
	public void updateQuangcao(int masanpham) throws SQLException {
		sql="update sanpham set quangcao=1 where masanpham=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		pre.executeUpdate();
	}
	public List<Sanpham> searchSanpham(String search) throws SQLException {
		List<Sanpham> list = new ArrayList<>();
		sql = "select*from sanpham as sp,danhmucsanpham as dm where (sp.madanhmuc=dm.madanhmuc and sp.tensanpham like ?) or (sp.madanhmuc=dm.madanhmuc and sp.tensanpham=?)";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, "%" + search + "%");
		pre.setString(2, search);
		ResultSet rs = pre.executeQuery();
		Sanpham sp;
		Danhmuc dm;
		while (rs.next()) {
			sp = new Sanpham();
			sp.setMasanpham(rs.getInt("masanpham"));
			sp.setTensanpham(rs.getString("tensanpham"));
			sp.setGianhap(rs.getInt("gianhap"));
			sp.setGiaban(rs.getInt("giaban"));
			sp.setGiagiam(rs.getInt("giagiam"));
			sp.setMausac(rs.getString("mausac"));
			sp.setLoai(rs.getBoolean("loai"));
			sp.setBonho(rs.getString("bonho"));
			sp.setMota(rs.getString("mota"));
			dm = new Danhmuc();
			dm.setTendanhmuc(rs.getString("tendanhmuc"));
			sp.setDanhmuc(dm);
			sp.setAnhsau(rs.getString("anhsau"));
			sp.setAnhtruoc(rs.getString("anhtruoc"));
			sp.setAnhtuxa(rs.getString("anhtuxa"));
			list.add(sp);
		}
		return list;
	}

	public void insertThongsokithuat(Thongsokithuat thongso) throws SQLException {
		sql = "insert into thongsokithuat values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, thongso.getBangtan());
		pre.setString(2, thongso.getGpu());
		pre.setString(3, thongso.getCpu());
		pre.setString(4, thongso.getRam());
		pre.setString(5, thongso.getBonhotrong());
		pre.setString(6, thongso.getCambien());
		pre.setString(7, thongso.getHedieuhanh());
		pre.setString(8, thongso.getCamtruoc());
		pre.setString(9, thongso.getCamsau());
		pre.setString(10, thongso.getPin());
		pre.setString(11, thongso.getCongnghesacpin());
		pre.setString(12, thongso.getThenho());
		pre.setInt(13, thongso.getMasanpham());
		pre.executeUpdate();
	}

	public void updateThongso(Thongsokithuat thongso) throws SQLException {
		sql = "update thongsokithuat set bangtan=?,gpu=?,cpu=?,ram=?,bonhotrong=?,cambien=?,hedieuhanh=?"
				+ ",camtruoc=?,camsau=?,pin=?,congnghesacpin=?,thenho=? where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, thongso.getBangtan());
		pre.setString(2, thongso.getGpu());
		pre.setString(3, thongso.getCpu());
		pre.setString(4, thongso.getRam());
		pre.setString(5, thongso.getBonhotrong());
		pre.setString(6, thongso.getCambien());
		pre.setString(7, thongso.getHedieuhanh());
		pre.setString(8, thongso.getCamtruoc());
		pre.setString(9, thongso.getCamsau());
		pre.setString(10, thongso.getPin());
		pre.setString(11, thongso.getCongnghesacpin());
		pre.setString(12, thongso.getThenho());
		pre.setInt(13, thongso.getMasanpham());
		pre.executeUpdate();
		
	}

	public Thongsokithuat getThongsoBymasanpham(int masanpham) throws SQLException {
		Thongsokithuat thongso = new Thongsokithuat();
		sql = "select*from thongsokithuat where masanpham=?";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			thongso.setBangtan(rs.getString("bangtan"));
			thongso.setGpu(rs.getString("gpu"));
			thongso.setCpu(rs.getString("cpu"));
			thongso.setRam(rs.getString("ram"));
			thongso.setBonhotrong(rs.getString("bonhotrong"));
			thongso.setCambien(rs.getString("cambien"));
			thongso.setHedieuhanh(rs.getString("hedieuhanh"));
			thongso.setCamtruoc(rs.getString("camtruoc"));
			thongso.setCamsau(rs.getString("camsau"));
			thongso.setPin(rs.getString("pin"));
			thongso.setCongnghesacpin(rs.getString("congnghesacpin"));
			thongso.setThenho(rs.getString("thenho"));
			thongso.setMasanpham(rs.getInt("masanpham"));

		}
		return thongso;
	}
}
