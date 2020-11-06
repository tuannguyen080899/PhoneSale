package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;
import model.Sanpham;

@WebServlet(name = "detailsanpham", urlPatterns = { "/detailsanpham" })
public class Detailsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Detailsanpham() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masanpham=request.getParameter("masanpham");
		DaoSanpham dao=new DaoSanpham();
		try {
			Sanpham sp=dao.getSanphamByMasanpham(Integer.parseInt(masanpham));
			request.setAttribute("sanpham", sp);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/detailsanpham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
