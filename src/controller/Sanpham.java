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

/**
 * Servlet implementation class Sanpham
 */
@WebServlet(name = "sanpham", urlPatterns = { "/sanpham" })
public class Sanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sanpham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loaisanpham = request.getParameter("loaisanpham");
		String bonho = request.getParameter("bonho");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		String record=request.getParameter("record");
		DaoSanpham dao = new DaoSanpham();
		Danhmuc danhmuc = new Danhmuc();
		List<model.Sanpham> list = null;
		try {
			if (loaisanpham != null && bonho == null && minprice == null && maxprice == null) {
				danhmuc.setTendanhmuc(loaisanpham);
				list = dao.getAllSanpham(danhmuc);
				request.setAttribute("list", list);
			} else if (loaisanpham != null && bonho != null && minprice == null && maxprice == null) {
				danhmuc.setTendanhmuc(loaisanpham);
				list = dao.getAllSanpham(danhmuc, bonho);
				request.setAttribute("list", list);
			} else if (loaisanpham != null && bonho == null && minprice != null && maxprice != null) {
				danhmuc.setTendanhmuc(loaisanpham);
				list = dao.getAllSanpham(danhmuc, Integer.parseInt(minprice), Integer.parseInt(maxprice));
				request.setAttribute("list", list);
			} else if (loaisanpham != null && bonho != null && minprice != null && maxprice != null) {
				danhmuc.setTendanhmuc(loaisanpham);
				list = dao.getAllSanpham(danhmuc, bonho, Integer.parseInt(minprice), Integer.parseInt(maxprice));
				request.setAttribute("list", list);
			} else if (loaisanpham == null && bonho != null && minprice != null && maxprice != null) {
				list = dao.getAllSanpham(bonho, Integer.parseInt(minprice), Integer.parseInt(maxprice));
				request.setAttribute("list", list);
			} else if (loaisanpham == null && bonho == null && minprice != null && maxprice != null) {
				list = dao.getAllSanpham(Integer.parseInt(minprice), Integer.parseInt(maxprice));
				request.setAttribute("list", list);
			} else if (loaisanpham == null && bonho != null && minprice == null && maxprice == null) {
				list = dao.getAllSanpham(bonho);
				request.setAttribute("list", list);
			}else {
				list=dao.getAllSanphamlimit((record==null||record.trim().length()<1)?12:Integer.parseInt(record));
				request.setAttribute("list", list);
			}
			request.setAttribute("bonho", bonho);
			request.setAttribute("danhmuc", danhmuc.getTendanhmuc());
			request.setAttribute("minprice", minprice);
			request.setAttribute("maxprice", maxprice);
			request.setAttribute("record", record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
