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

import dao.DaoSanpham;
import model.DBConnection;
import model.Thongsokithuat;

@WebServlet(name = "showSanpham", urlPatterns = { "/showSanpham" })
public class ShowSanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowSanpham() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String masanpham = request.getParameter("masanpham");
		DaoSanpham dao = new DaoSanpham();
		model.Sanpham sp;
		List<model.Sanpham> list;
		Thongsokithuat thongso;
		try {
			sp = dao.getSanphamByMasanpham(Integer.parseInt(masanpham));
			list = dao.getAllSanphamByNameGroupColor(sp.getTensanpham());
			String sql = "select*from thongsokithuat where masanpham=?";
			PreparedStatement pre = DBConnection.getConnection().prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(masanpham));
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				thongso = dao.getThongsoBymasanpham(Integer.parseInt(masanpham));
				request.setAttribute("thongso", thongso);
			} else {

			}
			request.setAttribute("sanpham", sp);
			request.setAttribute("list", list);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/showSanpham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
