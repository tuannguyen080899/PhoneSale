<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Web điện thoại</title>
</head>
<body>
	<%
		String error=(String)request.getAttribute("error");
		if(error!=null){
		int err=Integer.parseInt(error);
	%>
	<h4 style='color:<%=(err==0)?"blue":"red"%>' align="center">
		<%=(err==0)?"Đăng kí tài khoản thành công!":(err==1)?"Tài khoản đã tồn tại hoặc lỗi kí tự!":"Nhập sai password,vui lòng nhập lại!"%>
	</h4>
	<h5 align="center"><a href='<%=(err==0)?"dangnhap.jsp":"dangki.jsp"%>'><%=(err==0)?"Quay lại trang đăng nhập":(err==1)?"Quay lại trang đăng kí":"Quay lại trang khách hàng"%></a></h5>
	<%
		}
	%>
</body>
</html>