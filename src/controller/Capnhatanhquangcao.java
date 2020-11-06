package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.DaoSanpham;

/**
 * Servlet implementation class Capnhatanhquangcao
 */
@WebServlet(name = "capnhatanhquangcao", urlPatterns = { "/capnhatanhquangcao" })
public class Capnhatanhquangcao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String masanpham;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Capnhatanhquangcao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		masanpham=request.getParameter("masanpham");
		getServletContext().getRequestDispatcher("/capnhatanhquangcao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoSanpham dao=new DaoSanpham();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String anh="";
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		try {
			List<FileItem> iList = sfu.parseRequest(request);
			for (FileItem fi : iList) {
				if (fi.isFormField()){
				
				} else {
					String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\didongthongminh\\WebContent\\images\\anhquangcao";
					String imageName = (new Date()).getTime() + Math.random() + fi.getName();
					File uploadFile = new File(filePath + "\\" + imageName);
					fi.write(uploadFile);
					anh=imageName;
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int x=dao.updateAnhquangcao(anh,Integer.parseInt(masanpham));
			if(x!=0) {
				response.sendRedirect("quanlyquangcao");
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
