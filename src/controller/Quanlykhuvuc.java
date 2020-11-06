package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoKhuvuc;
import model.Tinh;

@WebServlet(name = "quanlykhuvuc", urlPatterns = { "/quanlykhuvuc" })
public class Quanlykhuvuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quanlykhuvuc() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoKhuvuc dao = new DaoKhuvuc();
		List<Tinh> list;
		try {
			list = dao.getAllKhuvuc();
			request.setAttribute("khuvuc", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/quanlykhuvuc.jsp").forward(request, response);
	}
	
}
