package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMuahang;
import dao.DaoTaikhoan;
import model.Taikhoan;

/**
 * Servlet implementation class Dangki
 */
@WebServlet(name = "dangki", urlPatterns = { "/dangki" })
public class Dangki extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dangki() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nhaplai = request.getParameter("nhaplai");
		DaoTaikhoan dao = new DaoTaikhoan();
		Taikhoan tk = new Taikhoan();
		tk.setPassword(password);
		tk.setUsername(username);
		DaoMuahang daomuahang=new DaoMuahang();
		try {
			if (password.equals(nhaplai) == true){
				int x = dao.insertTaikhoan(tk);
				if (x != 0) {
					daomuahang.insertMuahang(username);
					request.setAttribute("error", "0");
					getServletContext().getRequestDispatcher("/showError.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "2");
				getServletContext().getRequestDispatcher("/showError.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("error", "1");
		getServletContext().getRequestDispatcher("/showError.jsp").forward(request, response);
	}

}
