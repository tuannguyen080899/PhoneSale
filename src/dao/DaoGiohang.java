package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Giohang;
import model.DBConnection;

public class DaoGiohang {
	String sql;
	public int addSanphamToGiohang(int mamuahang,int masanpham,int tien,int tienvon) throws SQLException {
		sql="insert into chitietmuahang(mamuahang,masanpham,soluong,tien,tienvon) values(?,?,1,?,?)";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		pre.setInt(2, masanpham);
		pre.setInt(3, tien);
		pre.setInt(4, tienvon);
		int x=pre.executeUpdate();
		return x;
	}
	public int updateSoluongSanpham(int mamuahang,int masanpham,int soluong, int tien,int tienvon) throws SQLException {
		sql="update chitietmuahang set soluong=?,tien=?,tienvon=? where mamuahang=? and masanpham=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, ++soluong);
		pre.setInt(2,tien);
		pre.setInt(3, tienvon);
		pre.setInt(4, mamuahang);
		pre.setInt(5, masanpham);
		int x=pre.executeUpdate();
		return x;
	}
	public List<Giohang>getAllSanphamBygiohang(int mamuahang) throws SQLException{
		List<Giohang> list=new ArrayList<>();
		sql="select*from chitietmuahang as chitiet,sanpham as sp where chitiet.masanpham=sp.masanpham and chitiet.mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1,mamuahang);
		ResultSet rs=pre.executeQuery();
		Giohang giohang;
		while(rs.next()) {
			giohang=new Giohang();
			giohang.setMasanpham(rs.getInt("masanpham"));
			giohang.setTensanpham(rs.getString("tensanpham"));
			giohang.setHinhanh(rs.getString("anhtruoc"));
			giohang.setSoluong(rs.getInt("soluong"));
			giohang.setThanhtien(rs.getInt("tien"));
			giohang.setTienvon(rs.getInt("tienvon"));
			giohang.setMamuahang(rs.getInt("mamuahang"));
			list.add(giohang);
		}
		return list;
	}
	public int totalGiohang(int mamuahang) throws SQLException {
		sql="select sum(tien) as tongtien from chitietmuahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		ResultSet rs=pre.executeQuery();
		int x=0;
		while(rs.next()) {
			x=rs.getInt("tongtien");
		}
		return x;
	}
	public int totaltienvonGiohang(int mamuahang) throws SQLException {
		sql="select sum(tienvon) as tongtienvon from chitietmuahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		ResultSet rs=pre.executeQuery();
		int x=0;
		while(rs.next()) {
			x=rs.getInt("tongtienvon");
		}
		return x;
	}
	public void deletespGiohang(int masanpham,int mamuahang) throws SQLException {
		sql="delete from chitietmuahang where masanpham=? and mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, masanpham);
		pre.setInt(2, mamuahang);
		pre.executeUpdate();
	}
	public void giamspGiohang(int masanpham,int mamuahang,int soluong,int tien,int tienvon) throws SQLException {
		sql="update chitietmuahang set soluong=?,tien=?,tienvon=? where masanpham=? and mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1,--soluong);
		pre.setInt(2,tien);
		pre.setInt(3, tienvon);
		pre.setInt(4, masanpham);
		pre.setInt(5, mamuahang);
		pre.executeUpdate();
	}
	public int deleteGiohang(int mamuahang) throws SQLException {
		sql="delete from chitietmuahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		int x=pre.executeUpdate();
		return x;
		
	}
	public int soluongSanphamGiohang(int mamuahang) throws SQLException {
		sql="select sum(soluong) as tong from chitietmuahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		ResultSet rs=pre.executeQuery();
		int x=0;
		while(rs.next()) {
			x=rs.getInt("tong");
		}
		return x;
	}
}
