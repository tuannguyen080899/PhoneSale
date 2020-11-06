package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class ShowGiohang
 */
@WebServlet(name = "showGiohang", urlPatterns = { "/showGiohang" })
public class ShowGiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGiohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<model.Giohang> list = null;
		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("khachhang");
		DaoMuahang daomuahang = new DaoMuahang();
		DaoGiohang daogiohang = new DaoGiohang();
		int mamuahang=0;
		try {
			mamuahang = daomuahang.getMamuahangByUsername(username);
			list = daogiohang.getAllSanphamBygiohang(mamuahang);
			request.setAttribute("giohang", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/giohang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
