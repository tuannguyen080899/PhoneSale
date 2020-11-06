package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoTaikhoan;
import model.Taikhoan;

/**
 * Servlet implementation class Capnhatthongtinkhachhang
 */
@WebServlet(name = "capnhatthongtinkhachhang", urlPatterns = { "/capnhatthongtinkhachhang" })
public class Capnhatthongtinkhachhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capnhatthongtinkhachhang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoTaikhoan dao=new DaoTaikhoan();
		HttpSession session=request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String username= (String) session.getAttribute("khachhang");
		String tenkhachhang=request.getParameter("tenkhachhang");
		String diachi=request.getParameter("diachi");
		String email=request.getParameter("email");
		String dienthoai=request.getParameter("dienthoai");
		String makhuvuc=request.getParameter("khuvuc");
		try {
			int x=dao.updateThongtinTaikhoan(tenkhachhang, email, diachi, (makhuvuc==null||makhuvuc.trim().length()<1)?0:Integer.parseInt(makhuvuc), username,dienthoai);
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("thanhtoan");
	}

}
