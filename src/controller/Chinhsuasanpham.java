package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;
import model.Danhmuc;
import model.Sanpham;

/**
 * Servlet implementation class Chinhsuasanpham
 */
@WebServlet(name = "chinhsuasanpham", urlPatterns = { "/chinhsuasanpham" })
public class Chinhsuasanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoSanpham dao;
	String sid;

	public Chinhsuasanpham() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sid = request.getParameter("id");
		dao = new DaoSanpham();
		if (sid != null) {
			try {
				Sanpham sp = dao.getSanphamByMasanpham(Integer.parseInt(sid));
				request.setAttribute("sp", sp);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/chinhsuasanpham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String madanhmuc=request.getParameter("danhmuc");
		String masanpham = request.getParameter("masanpham");
		String tensanpham = request.getParameter("tensanpham");
		String gianhap = request.getParameter("gianhap");
		String giaban = request.getParameter("giaban");
		String giagiam = request.getParameter("giagiam");
		String mausac = request.getParameter("mausac");
		String loai = request.getParameter("loai");
		boolean loaisp = Boolean.parseBoolean(loai);
		String bonho = request.getParameter("bonho");
		String mota = request.getParameter("mota");
		PrintWriter writer = response.getWriter();
		Danhmuc danhmuc=new Danhmuc();
		danhmuc.setMadanhmuc((madanhmuc==null||madanhmuc.trim().length()<1)?0:Integer.parseInt(madanhmuc));
		Sanpham sanpham = new Sanpham();
		sanpham.setDanhmuc(danhmuc);
		sanpham.setMasanpham((masanpham==null||masanpham.trim().length()<1)?0:Integer.parseInt(masanpham));
		sanpham.setGiaban((giaban==null||giaban.trim().length()<1)?0:Integer.parseInt(giaban));
		sanpham.setGianhap((gianhap==null||gianhap.trim().length()<1)?0:Integer.parseInt(gianhap));
		sanpham.setGiagiam((giagiam==null||giagiam.trim().length()<1)?0:Integer.parseInt(giagiam));
		sanpham.setTensanpham(tensanpham);
		sanpham.setMausac(mausac);
		sanpham.setBonho(bonho);
		sanpham.setLoai(loaisp);
		sanpham.setMota(mota);
		if (request.getAttribute("sp") == null && sid == null) {
			try {
				int x = dao.insertSanpham(sanpham);
				if (x != 0) {
					request.setAttribute("thongbao","Thêm mới sản phẩm thành công!");
					getServletContext().getRequestDispatcher("/ketqua.jsp").forward(request, response);
				} else {

				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append("<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi!chắc k có</div>");
			writer.append("</html>");
		} else {
			try {
				int x1 = dao.updateSanpham(sanpham, Integer.parseInt(sid));
				if (x1 != 0) {
					request.setAttribute("thongbao","Chỉnh sửa sản phẩm thành công!");
					getServletContext().getRequestDispatcher("/ketqua.jsp").forward(request, response);
				} else {

				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append("<html>");
			writer.append(
					"<div style=\"color: #8A4B08;text-align:center; font-weight: 700;\">Lỗi! Không thể update danh mục không tồn tại</div>");
			writer.append("</html>");
		}
	}

}
