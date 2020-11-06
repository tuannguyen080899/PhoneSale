package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSlider;
import model.Slider;

/**
 * Servlet implementation class Chinhsuaslider
 */
@WebServlet(name = "chinhsuaslider", urlPatterns = { "/chinhsuaslider" })
public class Chinhsuaslider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	DaoSlider dao;
    public Chinhsuaslider() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("maslider");
		dao = new DaoSlider();
		if (id != null) {
			try {
				Slider slider = dao.getSliderByMaslider(Integer.parseInt(id));
				request.setAttribute("sl", slider);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/chinhsuaslider.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String maslider = request.getParameter("maslider");
		String title = request.getParameter("title");
		String trangthai = request.getParameter("trangthai");
		boolean tt = Boolean.parseBoolean(trangthai);
		PrintWriter writer = response.getWriter();

		if (request.getAttribute("sl") == null && id == null) {
			try {
				int x = dao.insertSlider(title,tt);
				if (x != 0) {
					response.sendRedirect("quanlyslider");
				} else {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Bạn hãy kiểm tra lại</div>");
			writer.append("</html>");
		} else {
			try {
				if (maslider != null) {
					int masl = Integer.parseInt(maslider);
					int x1 = dao.updateSlider(title, tt, masl);
					if (x1 != 0) {
						response.sendRedirect("quanlyslider");
					} else {

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể update tên danh mục</div>");
			writer.append("</html>");
	}
	}
}
