package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoGiohang;
import dao.DaoMuahang;

@WebServlet(name = "deleteDonhang", urlPatterns = { "/deleteDonhang" })
public class DeleteDonhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteDonhang() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuahang=request.getParameter("mamuahang");
		DaoMuahang daomuahang=new DaoMuahang();
		DaoGiohang daogiohang=new DaoGiohang();
		try {
			int x=daogiohang.deleteGiohang(Integer.parseInt(mamuahang));
			if(x!=0) {
				daomuahang.deleteMuahang(Integer.parseInt(mamuahang));
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("quanlyloinhuan");
	}

}
