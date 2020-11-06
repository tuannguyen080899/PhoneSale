package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Taikhoan;

public class DaoTaikhoan {
	String sql;
	public int updateThongtinTaikhoan(String tenkhachhang,String email,String diachi,int makhuvuc,String username,String dienthoai) throws SQLException {
		sql="update taikhoan set tenkhachhang=?,email=?,diachi=?,dienthoai=?,makhuvuc=? where username=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tenkhachhang);
		pre.setString(2, email);
		pre.setString(3, diachi);
		pre.setString(4, dienthoai);
		pre.setInt(5, makhuvuc);
		pre.setString(6, username);
		int x=pre.executeUpdate();
		return x;
	}
	public int insertTaikhoan(Taikhoan tk) throws SQLException {
		sql = "insert into taikhoan (username,password) values(?,?)";
		PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, tk.getUsername());
		pre.setString(2, tk.getPassword());
		int x=pre.executeUpdate();
		return x;
	}
	public int deleteTaikhoan(String username) throws SQLException {
		sql="delete from taikhoan where username=? and phanquyen=0";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, username);
		int x=pre.executeUpdate();
		return x;
	}
	public List<Taikhoan>getAllTaikhoanPhanquyenKhachhang(){
		List<Taikhoan> list=new ArrayList<>();
		sql="select*from taikhoan where phanquyen=0";
		Statement st;
		Taikhoan tk;
		try {
			st = DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				tk=new Taikhoan();
				tk.setUsername(rs.getString("username"));
				tk.setPassword(rs.getString("password"));
				list.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Taikhoan>getAllKhachhang(){
		List<Taikhoan> list=new ArrayList<>();
		sql="select*from taikhoan where phanquyen=0";
		Statement st;
		Taikhoan tk;
		try {
			st = DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				tk=new Taikhoan();
				tk.setUsername(rs.getString("username"));
				tk.setPassword(rs.getString("password"));
				tk.setTenkhachhang(rs.getString("tenkhachhang"));
				tk.setEmail(rs.getString("email"));
				tk.setDiachi(rs.getString("diachi"));
				tk.setSodienthoai(rs.getString("dienthoai"));
				list.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Taikhoan>getAllTaikhoanPhanquyenAdmin(){
		List<Taikhoan> list=new ArrayList<>();
		sql="select*from taikhoan where phanquyen=1";
		Statement st;
		Taikhoan tk;
		try {
			st = DBConnection.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				tk=new Taikhoan();
				tk.setUsername(rs.getString("username"));
				tk.setPassword(rs.getString("password"));
				list.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public Taikhoan getTaikhoanByUsername(String username) throws SQLException {
		Taikhoan tk=new Taikhoan();
		sql="select*from taikhoan where username=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, username);
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			tk.setUsername(rs.getString("username"));
			tk.setTenkhachhang(rs.getString("tenkhachhang"));
			tk.setDiachi(rs.getString("diachi"));
			tk.setEmail(rs.getString("email"));
			tk.setSodienthoai(rs.getString("dienthoai"));
			tk.setMakhuvuc(rs.getInt("makhuvuc"));
		}
		return tk;
	}
}
