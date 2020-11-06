package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDanhmuc;
import model.Danhmuc;

@WebServlet(name = "quanlydanhmuc", urlPatterns = { "/quanlydanhmuc" })
public class Quanlydanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Quanlydanhmuc() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoDanhmuc dao = new DaoDanhmuc();
		List<Danhmuc> list;
		list = dao.getAllDanhmuc();
		request.setAttribute("danhmuc", list);
		getServletContext().getRequestDispatcher("/quanlydanhmuc.jsp").forward(request, response);
	}

}
