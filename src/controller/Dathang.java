package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoGiohang;
import dao.DaoMuahang;

@WebServlet(name = "dathang", urlPatterns = { "/dathang" })
public class Dathang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Dathang() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String username=(String)session.getAttribute("khachhang");
		DaoGiohang daogio=new DaoGiohang();
		DaoMuahang daomua=new DaoMuahang();
		int mamuahang=0;
		try {
			mamuahang = daomua.getMamuahangByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int x=daomua.updateTrangthai(1, mamuahang);
			if(x!=0) {
				daomua.insertMuahang(username);
				request.setAttribute("thongbao","Bạn đã đặ hàng thành công, chúng  tôi sẽ giao hàng nhanh nhất trong vòng 3h đồng hồ.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/thongbaodathangthanhcong.jsp").forward(request, response);
	}
	

}
