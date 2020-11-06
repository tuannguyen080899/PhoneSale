package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;

/**
 * Servlet implementation class Themvaophanquangcao
 */
@WebServlet(name = "themvaophanquangcao", urlPatterns = { "/themvaophanquangcao" })
public class Themvaophanquangcao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themvaophanquangcao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoSanpham dao=new DaoSanpham();
		String masanpham=request.getParameter("id");
		try {
			dao.updateQuangcao(Integer.parseInt(masanpham));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("quanlyquangcao");
	}


}
