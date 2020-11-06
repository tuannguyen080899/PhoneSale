package controller;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class Dangnhap
 */
@WebServlet(name = "dangnhap", urlPatterns = { "/dangnhap" })
public class Dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/dangnhap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		CheckTaikhoan check=new CheckTaikhoan();
		HttpSession session;
		if(check.checkCustomer(username, password)) {
			session=request.getSession();
			session.setAttribute("khachhang", username);
			session.getMaxInactiveInterval();
			getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/dangnhap.jsp").forward(request, response);
		}
	}

}
