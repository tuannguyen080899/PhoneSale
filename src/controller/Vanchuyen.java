package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMuahang;

/**
 * Servlet implementation class Vanchuyen
 */
@WebServlet(name = "vanchuyen", urlPatterns = { "/vanchuyen" })
public class Vanchuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Vanchuyen() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuahang=request.getParameter("mamuahang");
		DaoMuahang dao=new DaoMuahang();
		try {
			int x=dao.updateTrangthai(2, Integer.parseInt(mamuahang));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("quanlyGiaohang");
	}

}
