package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoTaikhoan;
import model.CheckTaikhoan;
import model.Taikhoan;

/**
 * Servlet implementation class QuanlyDangnhap
 */
@WebServlet(name = "quanlyDangnhap", urlPatterns = { "/quanlyDangnhap" })
public class QuanlyDangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanlyDangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		CheckTaikhoan check=new CheckTaikhoan();
		HttpSession session;
		
		if(check.checkAdmin(username, password)) {
			session=request.getSession();
			session.setAttribute("admin",username);
			session.getMaxInactiveInterval();
		}
		getServletContext().getRequestDispatcher("/trangquanly.jsp").forward(request, response);
	}

}
