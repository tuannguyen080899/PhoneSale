package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoGiohang;
import dao.DaoTaikhoan;
import model.Taikhoan;

@WebServlet(name = "detailloinhuan", urlPatterns = { "/detailloinhuan" })
public class Detailloinhuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Detailloinhuan() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuahang=request.getParameter("mamuahang");
		String username=request.getParameter("username");
		DaoGiohang daogio=new DaoGiohang();
		List<model.Giohang>list;
		Taikhoan tk;
		DaoTaikhoan daotk=new DaoTaikhoan();
		try {
			list=daogio.getAllSanphamBygiohang(Integer.parseInt(mamuahang));
			tk=daotk.getTaikhoanByUsername(username);
			request.setAttribute("list", list);
			request.setAttribute("tk", tk);
			request.setAttribute("mamuahang",mamuahang);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/loinhuanchitiet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
