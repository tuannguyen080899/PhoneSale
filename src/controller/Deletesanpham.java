package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;

@WebServlet(name = "deletesanpham", urlPatterns = { "/deletesanpham" })
public class Deletesanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Deletesanpham() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masanpham=request.getParameter("masanpham");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		DaoSanpham dao=new DaoSanpham();
		PrintWriter writer=response.getWriter();
		try {
			int x=dao.deleteSanpham(Integer.parseInt(masanpham));
			if(x!=0) {
				request.setAttribute("thongbao","Sản phẩm đã được xóa !");
				getServletContext().getRequestDispatcher("/ketqua.jsp").forward(request, response);
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.append("<html>");
		writer.append("<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể xóa sản phẩm khi còn tồn tại đơn hàng</div>");
		writer.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
