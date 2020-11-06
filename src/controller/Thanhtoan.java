package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoGiohang;
import dao.DaoMuahang;
import dao.DaoTaikhoan;
import model.Taikhoan;

/**
 * Servlet implementation class Thanhtoan
 */
@WebServlet(name = "thanhtoan", urlPatterns = { "/thanhtoan" })
public class Thanhtoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Thanhtoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<model.Giohang> list = null;
		HttpSession session=request.getSession();
		String username= (String) session.getAttribute("khachhang");
		DaoMuahang daomuahang = new DaoMuahang();
		DaoGiohang daogiohang = new DaoGiohang();
		DaoTaikhoan daotaikhoan=new DaoTaikhoan();
		int mamuahang=0;
		Taikhoan tk;
		try {
			mamuahang = daomuahang.getMamuahangByUsername(username);
			list = daogiohang.getAllSanphamBygiohang(mamuahang);
			tk=daotaikhoan.getTaikhoanByUsername(username);
			request.setAttribute("thanhtoan", list);
			request.setAttribute("donhang", tk);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/thanhtoan.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
