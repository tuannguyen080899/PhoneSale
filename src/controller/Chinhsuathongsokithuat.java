package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;
import model.DBConnection;
import model.Thongsokithuat;

@WebServlet(name = "chinhsuathongsokithuat", urlPatterns = { "/chinhsuathongsokithuat" })
public class Chinhsuathongsokithuat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String masanpham;
	DaoSanpham dao;

	public Chinhsuathongsokithuat() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		masanpham = request.getParameter("masanpham");
		dao = new DaoSanpham();
		Thongsokithuat thongso = null;

		try {
			String sql = "select*from thongsokithuat where masanpham=?";
			PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(masanpham));
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				thongso = dao.getThongsoBymasanpham(Integer.parseInt(masanpham));
				request.setAttribute("thongso", thongso);
			} else {
				
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/capnhatthongsokithuat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String bangtan = request.getParameter("bangtan");
		String gpu = request.getParameter("gpu");
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String bonhotrong = request.getParameter("bonhotrong");
		String cambien = request.getParameter("cambien");
		String hedieuhanh = request.getParameter("hedieuhanh");
		String camtruoc = request.getParameter("camtruoc");
		String camsau = request.getParameter("camsau");
		String pin = request.getParameter("pin");
		String congnghesacpin = request.getParameter("congnghesacpin");
		String thenho = request.getParameter("thenho");
		Thongsokithuat thongso = new Thongsokithuat(bangtan, gpu, cpu, ram, bonhotrong, cambien, hedieuhanh, camtruoc,
				camsau, pin, congnghesacpin, thenho,
				(masanpham == null || masanpham.trim().length() < 1) ? 0 : Integer.parseInt(masanpham));
		try {
			String sql = "select*from thongsokithuat where masanpham=?";
			PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(masanpham));
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				dao.updateThongso(thongso);
			} else {
				dao.insertThongsokithuat(thongso);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("quanlysanpham");
	}

}
