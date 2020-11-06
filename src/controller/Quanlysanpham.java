package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;
import model.Danhmuc;

@WebServlet(name = "quanlysanpham", urlPatterns = { "/quanlysanpham" })
public class Quanlysanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quanlysanpham() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loaisanpham=request.getParameter("loaisanpham");
		List<model.Sanpham>list;
		DaoSanpham dao=new DaoSanpham();
		Danhmuc dm=new Danhmuc();
		dm.setTendanhmuc(loaisanpham);
		try {
			list=dao.getAllSanpham(dm);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/quanlysanpham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
