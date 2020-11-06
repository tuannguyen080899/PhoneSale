package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMuahang;
import dao.DaoTaikhoan;

/**
 * Servlet implementation class Deletekhachhang
 */
@WebServlet(name = "deletekhachhang", urlPatterns = { "/deletekhachhang" })
public class Deletekhachhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletekhachhang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		DaoTaikhoan dao=new DaoTaikhoan();
		DaoMuahang daom=new DaoMuahang();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer=response.getWriter();
		try {
			int x=daom.deleteMua(daom.getMamuahangByUsername(username));
			if(x!=0) {
				int y=dao.deleteTaikhoan(username);
				response.sendRedirect("quanlyTaikhoan");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append("<html>");
		writer.append("<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể xóa tài khoản khi còn tồn tại đơn hàng</div>");
		writer.append("</html>");
	}
}
