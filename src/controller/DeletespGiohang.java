package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoGiohang;

/**
 * Servlet implementation class DeletespGiohang
 */
@WebServlet(name = "deletespGiohang", urlPatterns = { "/deletespGiohang" })
public class DeletespGiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletespGiohang() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoGiohang daogio=new DaoGiohang();
		String masanpham =request.getParameter("masanpham");
		String mamuahang=request.getParameter("mamuahang");
		try {
			daogio.deletespGiohang(Integer.parseInt(masanpham), Integer.parseInt(mamuahang));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("showGiohang");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
