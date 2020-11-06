package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDanhmuc;
import model.Danhmuc;

/**
 * Servlet implementation class Chinhsuadanhmuc
 */
@WebServlet(name = "chinhsuadanhmuc", urlPatterns = { "/chinhsuadanhmuc" })
public class Chinhsuadanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	DaoDanhmuc dao;

	public Chinhsuadanhmuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = request.getParameter("id");
		dao = new DaoDanhmuc();
		if (id != null) {
			try {
				Danhmuc dm = dao.getDanhmucByMadanhmuc(Integer.parseInt(id));
				request.setAttribute("dm", dm);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/chinhsuadanhmuc.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String madanhmuc = request.getParameter("madanhmuc");
		String tendanhmuc = request.getParameter("tendanhmuc");
		String trangthai = request.getParameter("trangthai");
		boolean tt = Boolean.parseBoolean(trangthai);
		PrintWriter writer = response.getWriter();

		if (request.getAttribute("dm") == null && id == null) {
			try {
				int x = dao.insertDanhmuc(tendanhmuc,tt);
				if (x != 0) {
					response.sendRedirect("quanlydanhmuc");
				} else {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Danh mục đã tồn tại</div>");
			writer.append("</html>");
		} else {
			try {
				if (madanhmuc != null) {
					int madm = Integer.parseInt(madanhmuc);
					int x1 = dao.updateDanhmuc(tendanhmuc, tt, madm);
					if (x1 != 0) {
						response.sendRedirect("quanlydanhmuc");
					} else {

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể update tên danh mục</div>");
			writer.append("</html>");
		}
	}
}
