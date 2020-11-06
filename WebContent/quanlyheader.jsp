<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.DaoDanhmuc" %>
<%@ page import="model.Danhmuc" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Quản lý thông tin sản phẩm</title>
	<link rel="icon"
	href="https://image.shutterstock.com/image-vector/phone-red-vector-icon-circle-260nw-457492240.jpg"
	type="image/png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<style type="text/css">
		i{
			color:#190707;
		}
		i:hover{
			color:red;
		}
		.menu p{
			padding: 7px;
			font-size: 15px;
			font-weight: 900;
			font-family: initial;
		}
		.menu p a:hover{
			color: red;
		}
		.menu p a{
			text-decoration: none;
			color: white;
		}
	</style>
</head>
<body >
	<div class="container">
		<div class="row" style="padding-top:5px;background-image: linear-gradient(to right,#848484,#F2F2F2);">
			<div class="col-sm-7">
				<p><a href="sanpham"><i class="fa fa-android">Hệ thống quản lý di động thông minh</i></a></p>
			</div>
			<div class="col-sm-5">
				<div style="float: right;">
				<%
					String admin=(String)session.getAttribute("admin");
				%>
					<div class="btn-group">
					 	<button style="width:161px;margin-bottom:10px;float: right;background-color: #DBA901"type="button" class="btn  dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					   <%=(admin==null)?"Đăng nhập":admin %>
					 	</button>
				  		<div class="dropdown-menu" >
				   		 	<a style="margin-left: 42px"class="dropdown-item" href="quanlyDangxuat">Đăng xuất</a>
				    		<div class="dropdown-divider"></div>
				   			 <a style="margin-left: 42px"class="dropdown-item" href="#">Đổi mật khẩu</a>
				 		</div>
					</div>
				</div>
			</div>
		</div>
		<hr/>
		<div class="row" style="padding-top:20px">
			<div class="col-sm-3 menu" style="padding-top:5px;background-image: linear-gradient(to right,#848484,#848484);min-height: 600px">
				<p style="margin-left: 1px;"> <a href=""><img src="images/logo.png"style="width: 100%;height: 100%"></a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlydanhmuc">DANH MỤC</a></p>
				<%
					List<Danhmuc>listdm;
					DaoDanhmuc dao=new DaoDanhmuc();
					listdm=dao.getAllDanhmuc();
					for(Danhmuc dm:listdm){
					
				%>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlysanpham?loaisanpham=<%=dm.getTendanhmuc()%>"><%=dm.getTendanhmuc() %></a></p>
				<%
					}
				%>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlyquangcao">Quảng cáo</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlyslider">Slider</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlyGiaohang">Giao hàng</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlyTaikhoan">Khách hàng</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlyloinhuan">Lợi nhuận</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="">Phụ kiện</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="">Sửa chữa</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="">Khuyến mại</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="">Tin tức</a></p>
				<p style="margin-left: 1px;font-size:20px"><a href="quanlykhuvuc">Khu vực</a></p>
			</div>
			<div class="col-sm-9">
				<div>
					<form action="searchSanphamquanly" method="post" >
						<input type="text" name="search" placeholder="Bạn cần tìm..." style="width: 70%;height: 30px" >
						<input type="submit" value="Tìm kiếm" style="width: 29%;height: 30px;float: right;" >
					</form>
				</div>