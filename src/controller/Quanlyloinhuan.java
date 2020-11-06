package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoMuahang;
import model.Muahang;


@WebServlet(name = "quanlyloinhuan", urlPatterns = { "/quanlyloinhuan" })
public class Quanlyloinhuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Quanlyloinhuan() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMuahang dao=new DaoMuahang();
		List<Muahang>list;
		try {
			list=dao.getAllMuahangByTrangthai(2);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/loinhuan.jsp").forward(request, response);
	}

}
