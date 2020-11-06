package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Slider;

public class DaoSlider {
	public List<Slider>getAllSlider() throws SQLException{
		List<Slider>list=new ArrayList<>();
		String sql="select*from slider";
		Statement st=DBConnection.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		Slider slider;
		while(rs.next()) {
			slider=new Slider();
			slider.setMaslider(rs.getInt("maslider"));
			slider.setTitle(rs.getString("title"));
			slider.setAnh(rs.getString("anh"));
			slider.setTrangthai(rs.getBoolean("trangthai"));
			list.add(slider);
		}
		return list;
	}
	public int insertSlider(String title,boolean trangthai) throws SQLException {
		String sql="insert into slider (title,trangthai) values(?,?)";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, title);
		pre.setBoolean(2,trangthai);
		int x=pre.executeUpdate();
		return x;
	}
	public int updateSlider(String title,boolean trangthai,int maslider) throws SQLException {
		String sql="update slider set title=?,trangthai=? where maslider=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, title);
		pre.setBoolean(2, trangthai);
		pre.setInt(3, maslider);
		int x=pre.executeUpdate();
		return x;
	}
	public int updateAnhSlider(String anh,int maslider) throws SQLException {
		String sql="update slider set anh=? where maslider=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setString(1, anh);
		pre.setInt(2, maslider);
		int x=pre.executeUpdate();
		return x;
	}
	public Slider getSliderByMaslider(int maslider) throws SQLException {
		Slider slider=new Slider();
		String sql="select*from slider where maslider=?";
		PreparedStatement pre=DBConnection.getConnection().prepareStatement(sql);
		pre.setInt(1,maslider);
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			slider.setMaslider(rs.getInt("maslider"));
			slider.setTitle(rs.getString("title"));
			slider.setAnh(rs.getString("anh"));
			slider.setTrangthai(rs.getBoolean("trangthai"));
		}
		return slider;
	}
	public List<Slider>getAllSliderShow() throws SQLException{
		List<Slider>list=new ArrayList<>();
		String sql="select*from slider where trangthai=1";
		Statement st=DBConnection.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		Slider slider;
		while(rs.next()) {
			slider=new Slider();
			slider.setMaslider(rs.getInt("maslider"));
			slider.setTitle(rs.getString("title"));
			slider.setAnh(rs.getString("anh"));
			slider.setTrangthai(rs.getBoolean("trangthai"));
			list.add(slider);
		}
		return list;
	}
}
