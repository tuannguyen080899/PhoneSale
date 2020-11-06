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

/**
 * Servlet implementation class DeleteKhuvuc
 */
@WebServlet(name = "deleteKhuvuc", urlPatterns = { "/deleteKhuvuc" })
public class DeleteKhuvuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKhuvuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String makhuvuc=request.getParameter("id");
		DaoKhuvuc dao=new DaoKhuvuc();
		PrintWriter writer=response.getWriter();
		try {
			int x=dao.deleteKhuvuc(Integer.parseInt(makhuvuc));
			if(x!=0) {
				response.sendRedirect("quanlykhuvuc");
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append("<html>");
		writer.append("<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể xóa khu vực này khi còn thông tin khách hàng</div>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
