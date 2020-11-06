package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= {"/showGiohang","/giohang"})
public class TestTaikhoan implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rep=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("khachhang");
		RequestDispatcher dispatcher;
		if(username==null) {
			dispatcher=req.getRequestDispatcher("dangnhap.jsp");
			dispatcher.forward(req, rep);
		}else {
			chain.doFilter(request, response);
		}
		
	}


	@Override
	public void init(FilterConfig request) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}