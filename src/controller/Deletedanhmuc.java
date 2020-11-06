package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoDanhmuc;

/**
 * Servlet implementation class Deletedanhmuc
 */
@WebServlet(name = "deletedanhmuc", urlPatterns = { "/deletedanhmuc" })
public class Deletedanhmuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletedanhmuc() {
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
		String madanhmuc=request.getParameter("madanhmuc");
		DaoDanhmuc dao=new DaoDanhmuc();
		PrintWriter writer=response.getWriter();
		try {
			int x=dao.deleteDanhmuc(Integer.parseInt(madanhmuc));
			if(x!=0) {
				response.sendRedirect("quanlydanhmuc");
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append("<html>");
		writer.append("<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể xóa danh mục khi còn sản phẩm</div>");
		writer.append("</html>");
	}

	

}
