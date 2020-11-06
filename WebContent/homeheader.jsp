<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="dao.DaoDanhmuc"%>
<%@page import="model.Danhmuc"%>
<%@page import="model.Muahang"%>
<%@page import="dao.DaoMuahang"%>
<%@page import="dao.DaoGiohang"%>
<%@ page import="dinhdang.Dinhdangtien" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Di động thông minh</title>
<link rel="icon"
	href="https://image.shutterstock.com/image-vector/phone-red-vector-icon-circle-260nw-457492240.jpg"
	type="image/png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
i {
	color: #190707;
}

i:hover {
	color: red;
}

.menu p {
	float: left;
	margin-left: 60px;
	padding: 7px;
	font-size: 20px;
	font-weight: 900;
	font-family: initial;
}

.menu p a {
	text-decoration: none;
	color: white;
}

#content button:hover {
	background-color: #848484;
}
</style>
</head>
<body id="top">
	<div id="header" class="container">
		<div class="row"
			style="padding-top: 5px; background-image: linear-gradient(to right, #848484, #F2F2F2);">
			<div class="col-sm-7">
				<p>
					<a href="trangquanly.jsp"><i class="fa fa-android">Hệ thống bán lẻ Di Động
							Thông Minh</i></a>
				</p>
			</div>
			<div class="col-sm-2">
				<p>
					<a href=""><i class="fa fa-american-sign-language-interpreting">Chăm
							sóc khách hàng</i></a>
				</p>
			</div>
			<div class="col-sm-1">
				<p>
					<a href=""><i class="fa fa-youtube">dReviews</i></a>
				</p>
			</div>
			<div class="col-sm-1">
				<p>
					<a href=""><i class="fa fa-facebook"> Fanpages</i></a>
				</p>
			</div>
			<div class="col-sm-1">
				<select>
					<option>Hà Nội</option>
					<option>Đà Nẵng</option>
					<option>TP.HCM</option>
					<option>Cà Mau</option>
				</select>
			</div>
		</div>
		<div class="row" style="padding-top: 20px">
			<div class="col-sm-3">
				<a href="welcome.jsp"><img src="images/logo.png"
					style="width: 100%; height: 100%"></a>
			</div>
			<div class="col-sm-4">
				<form action="searchSanpham"method="post">
					<input type="text" name="search" placeholder="Bạn cần tìm...">
					<input type="submit" value="Tìm kiếm">
				</form>
			</div>
			<div class="col-sm-2">
				<p>
					<a href=""><img style="width: 50px; height: 50px"
						src="images/new.jpg">Tin Công Nghệ</a>
				</p>
			</div>
			<%
				
				String khachhang = (String) session.getAttribute("khachhang");
				DaoDanhmuc dao = new DaoDanhmuc();
				DaoGiohang daogio1=new DaoGiohang();
				List<Danhmuc> list = dao.getAllDanhmucLimit4();
				List<Danhmuc> listDanhmuc=dao.getAllDanhmucHienthi();
				String danhmuc = (String) request.getAttribute("danhmuc");
				String bonho = (String) request.getAttribute("bonho");
				String minprice = (String) request.getAttribute("minprice");
				String maxprice = (String) request.getAttribute("maxprice");
				DaoMuahang daomua1=new DaoMuahang();
				int soluong=daogio1.soluongSanphamGiohang(daomua1.getMamuahangByUsername(khachhang));
			%>
			<div class="col-sm-2">
				<p>
					<a href="dangnhap"><img style="width: 40px; height: 40px"
						src="images/login.png"> <%=(khachhang == null) ? " Đăng nhập" : khachhang%></a>
				</p>
			</div>
			<div class="col-sm-1">
				<p>
					<a  title="giỏ hàng"href="showGiohang"><img style="width: 40px; height: 40px"
						src="images/giohang.png"></a>
				</p>
				<p style="position: absolute;top:-2px;right:40px;border-radius: 50px;width: 15px; height: 15px;background-color:red;text-align:center;font-weight:700;color:white"><%=soluong %></p>
			</div>
		</div>
		<div class="row menu"
			style="background-image: linear-gradient(to right, #DF3A01, #FAAC58); text-align: center;">
			<p style="margin-left: 7px; margin-top: 1px">
				<a href="sanpham"title="trang chủ">Điện thoại</a>
			</p>
			<%
				for (Danhmuc dm : list) {
			%>
			<p>
				<a
					href="sanpham?loaisanpham=<%=dm.getTendanhmuc()%>&
				<%=(bonho == null) ? "" : "bonho="%><%=(bonho == null) ? "" : bonho%>&
				<%=(minprice == null) ? "" : "minprice="%><%=(minprice == null) ? "" : minprice%>&
				<%=(maxprice == null) ? "" : "maxprice="%><%=(maxprice == null) ? "" : maxprice%>">
					<%=dm.getTendanhmuc()%>
				</a>
			</p>
			<%
				}
			%>
			<p>
				<a href="">Phụ kiện</a>
			</p>
			<p>
				<a href="">Sửa chữa</a>
			</p>
			<p>
				<a href="">Khuyến mại</a>
			</p>
		</div>
	</div>
	
	