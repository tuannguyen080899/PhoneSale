package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSlider;
import model.Slider;

/**
 * Servlet implementation class Quanlyslider
 */
@WebServlet(name = "quanlyslider", urlPatterns = { "/quanlyslider" })
public class Quanlyslider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quanlyslider() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoSlider dao=new DaoSlider();
		List<Slider>list;
		try {
			list=dao.getAllSlider();
			request.setAttribute("slider", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/quanlyslider.jsp").forward(request, response);
	}


}
