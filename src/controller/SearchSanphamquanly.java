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

import dao.DaoSanpham;

/**
 * Servlet implementation class SearchSanphamquanly
 */
@WebServlet(name = "searchSanphamquanly", urlPatterns = { "/searchSanphamquanly" })
public class SearchSanphamquanly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSanphamquanly() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		DaoSanpham dao=new DaoSanpham();
		List<model.Sanpham>list;
		try {
			list=dao.searchSanpham(search);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/quanlysanpham.jsp").forward(request, response);
	}

}
