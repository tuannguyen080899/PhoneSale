package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoGiohang;
import dao.DaoSanpham;

/**
 * Servlet implementation class GiamspGiohang
 */
@WebServlet(name = "giamspGiohang", urlPatterns = { "/giamspGiohang" })
public class GiamspGiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiamspGiohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masanpham=request.getParameter("masanpham");
		String mamuahang=request.getParameter("mamuahang");
		String soluong=request.getParameter("soluong");
		String tien=request.getParameter("tien");
		String tienv=request.getParameter("tienvon");
		int sluong=Integer.parseInt(soluong);
		DaoSanpham daosp=new DaoSanpham();
		int giatien = 0;
		int tienvon=0;
		try {
			tienvon=daosp.tienvonBySanpham(Integer.parseInt(masanpham));
			giatien = daosp.giatriBySanpham(Integer.parseInt(masanpham));
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DaoGiohang dao=new DaoGiohang();
		try {
			dao.giamspGiohang(Integer.parseInt(masanpham), Integer.parseInt(mamuahang),sluong, Integer.parseInt(tien)-giatien,Integer.parseInt(tienv)-tienvon);
			if(sluong==1) {
				dao.deletespGiohang(Integer.parseInt(masanpham), Integer.parseInt(mamuahang));
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("showGiohang");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
