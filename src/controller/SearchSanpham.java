package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSanpham;

@WebServlet(name = "searchSanpham", urlPatterns = { "/searchSanpham" })
public class SearchSanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchSanpham() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		DaoSanpham dao=new DaoSanpham();
		List<model.Sanpham>list;
		try {
			list=dao.searchSanpham(search);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
	}

}
