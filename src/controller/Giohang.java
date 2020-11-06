package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoGiohang;
import dao.DaoMuahang;
import dao.DaoSanpham;
import model.DBConnection;

/**
 * Servlet implementation class Giohang
 */
@WebServlet(name = "giohang", urlPatterns = { "/giohang" })
public class Giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Giohang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String masanpham = request.getParameter("masanpham");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("khachhang");
		DaoMuahang daomuahang = new DaoMuahang();
		DaoGiohang daogiohang = new DaoGiohang();
		DaoSanpham daosp = new DaoSanpham();
		int tien = 0;
		int tienvon=0;
		try {
			tien = daosp.giatriBySanpham(Integer.parseInt(masanpham));
			tienvon=daosp.tienvonBySanpham(Integer.parseInt(masanpham));
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int mamuahang = 0;
		try {
			mamuahang = daomuahang.getMamuahangByUsername(username);
			String sql = "select *from chitietmuahang where mamuahang=? and masanpham=?";
			PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, mamuahang);
			pre.setInt(2, Integer.parseInt(masanpham));
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				daogiohang.updateSoluongSanpham(rs.getInt("mamuahang"), rs.getInt("masanpham"), rs.getInt("soluong"),
						rs.getInt("tien") + tien,rs.getInt("tienvon")+tienvon);
			} else {
				daogiohang.addSanphamToGiohang(mamuahang, Integer.parseInt(masanpham), tien,tienvon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("showGiohang");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
