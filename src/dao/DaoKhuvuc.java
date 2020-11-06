package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.util.Base64Decoder;

import model.DBConnection;
import model.Danhmuc;
import model.Tinh;

public class DaoKhuvuc {
	String sql;
	public List<Tinh> getAllKhuvuc() throws SQLException{
		List<Tinh>list=new ArrayList<>();
		sql="select*from tinh";
		Statement st=DBConnection.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		Tinh tinh;
		while(rs.next()) {
			tinh=new Tinh();
			tinh.setMakhuvuc(rs.getInt("makhuvuc"));
			tinh.setTenkhuvuc(rs.getString("tenkhuvuc"));
			tinh.setCuocphy(rs.getInt("cuocphy"));
			list.add(tinh);
		}
		return list;
	}
	public int insertKhuvuc(String tenkhuvuc,int cuocphy) throws SQLException {
		sql="insert into tinh (tenkhuvuc,cuocphy) values (?,?)";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(2, cuocphy);
		pre.setString(1, tenkhuvuc);
		int  x=pre.executeUpdate();
		return x;
	}
	public int updateKhuvuc(String tenkhuvuc,int cuocphy,int makhuvuc) throws SQLException {
		sql="update tinh set tenkhuvuc=?,cuocphy=? where makhuvuc=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(2, cuocphy);
		pre.setString(1, tenkhuvuc);
		pre.setInt(3, makhuvuc);
		int  x=pre.executeUpdate();
		return x;
	}
	public int deleteKhuvuc(int makhuvuc) throws SQLException {
		sql="delete from tinh where makhuvuc=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1, makhuvuc);
		int x=pre.executeUpdate();
		return x;
	}
	public Tinh getKhuvucByMakhuvuc(int makhuvuc) throws SQLException  {
		Tinh tinh=new Tinh();
		sql="select*from tinh where makhuvuc=?";
		PreparedStatement pre;
		
			pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, makhuvuc);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				tinh.setMakhuvuc(rs.getInt("makhuvuc"));
				tinh.setTenkhuvuc(rs.getString("tenkhuvuc"));
				tinh.setCuocphy(rs.getInt("cuocphy"));
			}
		
		return tinh;
		
	}
}
