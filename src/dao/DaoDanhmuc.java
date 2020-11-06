package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Danhmuc;

public class DaoDanhmuc {
	String sql;
	public List<Danhmuc>getAllDanhmuc(){
		List<Danhmuc>list=new ArrayList<>();
		sql="select*from danhmucsanpham";
		Danhmuc dm;
		try {
			Statement st=DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				dm=new Danhmuc();
				dm.setMadanhmuc(rs.getInt("madanhmuc"));
				dm.setTendanhmuc(rs.getString("tendanhmuc"));
				dm.setTrangthai(rs.getBoolean("trangthai"));
				list.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Danhmuc>getAllDanhmucLimit4(){
		List<Danhmuc>list=new ArrayList<>();
		sql="select*from danhmucsanpham where trangthai=1 limit 4";
		Danhmuc dm;
		try {
			Statement st=DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				dm=new Danhmuc();
				dm.setMadanhmuc(rs.getInt("madanhmuc"));
				dm.setTendanhmuc(rs.getString("tendanhmuc"));
				dm.setTrangthai(rs.getBoolean("trangthai"));
				list.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Danhmuc>getAllDanhmucHienthi(){
		List<Danhmuc>list=new ArrayList<>();
		sql="select*from danhmucsanpham where trangthai=1";
		Danhmuc dm;
		try {
			Statement st=DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				dm=new Danhmuc();
				dm.setMadanhmuc(rs.getInt("madanhmuc"));
				dm.setTendanhmuc(rs.getString("tendanhmuc"));
				dm.setTrangthai(rs.getBoolean("trangthai"));
				list.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Danhmuc getDanhmucByMadanhmuc(int madanhmuc) throws SQLException  {
		Danhmuc dm=new Danhmuc();
		sql="select*from danhmucsanpham where madanhmuc=?";
		PreparedStatement pre;
		
			pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, madanhmuc);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				dm.setMadanhmuc(rs.getInt("madanhmuc"));
				dm.setTendanhmuc(rs.getString("tendanhmuc"));
				dm.setTrangthai(rs.getBoolean("trangthai"));
			}
		
		return dm;
		
	}
	public int insertDanhmuc(String tendanhmuc,boolean trangthai) throws SQLException {
		sql="insert into danhmucsanpham (tendanhmuc,trangthai) values(?,?)";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tendanhmuc);
		pre.setBoolean(2, trangthai);
		int x=pre.executeUpdate();
		return x;
	}
	public int deleteDanhmuc(int madanhmuc) throws SQLException {
		sql="delete from danhmucsanpham where madanhmuc=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, madanhmuc);
		int x=pre.executeUpdate();
		return x;
		
	}
	public int updateDanhmuc(String tendanhmuc,boolean trangthai,int madanhmuc) throws SQLException {
		sql="update danhmucsanpham set trangthai=?,tendanhmuc=? where madanhmuc=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setBoolean(1, trangthai);
		pre.setString(2, tendanhmuc);
		pre.setInt(3, madanhmuc);
		int x=pre.executeUpdate();
		return x;
	}
}
