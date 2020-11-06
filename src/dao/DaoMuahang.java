package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Muahang;

public class DaoMuahang {
	String sql;
	public void insertMuahang(String username) throws SQLException {
		sql="insert into muahang(username,thoigian,trangthai) values(?,now(),0)";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, username);
		pre.executeUpdate();
	}
	public int getMamuahangByUsername(String usernam) throws SQLException {
		sql="select mamuahang from muahang where username=? and trangthai=0";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, usernam);
		ResultSet rs=pre.executeQuery();
		int mamuahang=0; 
		while(rs.next()) {
			mamuahang=rs.getInt("mamuahang");
		}
		return mamuahang;
	}
	public int updateTrangthai(int trangthai,int mamuahang) throws SQLException {
		sql="update muahang set trangthai=?,thoigian=now() where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, trangthai);
		pre.setInt(2, mamuahang);
		int x=pre.executeUpdate();
		return x; 
	}
	public List<Muahang> getAllMuahangByTrangthai(int trangthai) throws SQLException {
		Muahang muahang;
		List<Muahang>list=new ArrayList<>();
		sql="select*from muahang where trangthai=? order by thoigian desc";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1,trangthai);
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			muahang=new Muahang();
			muahang.setMamuahang(rs.getInt("mamuahang"));
			muahang.setUsername(rs.getString("username"));
			muahang.setThoigian(rs.getDate("thoigian"));
			muahang.setTrangthai(rs.getInt("trangthai"));
			list.add(muahang);
		}
		return list;
	}
	public void deleteMuahang(int mamuahang) throws SQLException {
		sql="delete from muahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		pre.executeUpdate();
		
	}
	public int deleteMua(int mamuahang) throws SQLException {
		sql="delete from muahang where mamuahang=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, mamuahang);
		int x=pre.executeUpdate();
		return x;
		
	}
}
