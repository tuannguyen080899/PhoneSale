package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import model.Sanpham;

@WebServlet(name = "chinhsuahinhanh", urlPatterns = { "/chinhsuahinhanh" })
public class Chinhsuahinhanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String masanpham;
    public Chinhsuahinhanh() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		masanpham=request.getParameter("masanpham");
		getServletContext().getRequestDispatcher("/capnhatanh.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoSanpham dao=new DaoSanpham();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Sanpham sp=new Sanpham();
		List<String>list=new ArrayList<>();
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		try {
			List<FileItem> iList = sfu.parseRequest(request);
			for (FileItem fi : iList) {
				if (fi.isFormField()){
				
				} else {
					String filePath = "C:\\Users\\Administrator\\eclipse-workspace\\didongthongminh\\WebContent\\images\\img";
					String imageName = (new Date()).getTime() + Math.random() + fi.getName();
					File uploadFile = new File(filePath + "\\" + imageName);
					fi.write(uploadFile);
					list.add(imageName);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.setAnhtruoc(list.get(0));
		sp.setAnhsau(list.get(1));
		sp.setAnhtuxa(list.get(2));
		try {
			int x=dao.updateAnhByMasanpham(sp,Integer.parseInt(masanpham));
			if(x!=0) {
				response.sendRedirect("quanlysanpham");
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
