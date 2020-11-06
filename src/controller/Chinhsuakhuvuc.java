package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoKhuvuc;
import model.Tinh;

/**
 * Servlet implementation class Chinhsuakhuvuc
 */
@WebServlet(name = "chinhsuakhuvuc", urlPatterns = { "/chinhsuakhuvuc" })
public class Chinhsuakhuvuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	DaoKhuvuc dao;

	public Chinhsuakhuvuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = request.getParameter("id");
		dao = new DaoKhuvuc();
		if (id != null) {
			try {
				Tinh khuvuc = dao.getKhuvucByMakhuvuc(Integer.parseInt(id));
				request.setAttribute("khuvuc", khuvuc);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/chinhsuakhuvuc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String makhuvuc = request.getParameter("makhuvuc");
		String tenkhuvuc = request.getParameter("tenkhuvuc");
		String cuocphy = request.getParameter("cuocphy");

		PrintWriter writer = response.getWriter();
		if (request.getAttribute("khuvuc") == null && id == null) {
			try {
				int x = dao.insertKhuvuc(tenkhuvuc, (cuocphy==null||cuocphy.trim().length()<1)?0:Integer.parseInt(cuocphy));
				if (x != 0) {
					response.sendRedirect("quanlykhuvuc");
				} else {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Khu vực đã tồn tại</div>");
			writer.append("</html>");
		} else {
			try {
				int x1 = dao.updateKhuvuc(tenkhuvuc,(cuocphy==null||cuocphy.trim().length()<1)?0:Integer.parseInt(cuocphy),(makhuvuc==null||makhuvuc.trim().length()<1)?0:Integer.parseInt(makhuvuc));
				if (x1 != 0) {
					response.sendRedirect("quanlykhuvuc");
				} else {

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
