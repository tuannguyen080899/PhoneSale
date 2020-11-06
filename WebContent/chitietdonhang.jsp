<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="dao.DaoKhuvuc" %>
	<%@ page import="dao.DaoGiohang" %>
	<%@ page import="dao.DaoMuahang" %>
	<%@ page import="model.Taikhoan" %>
	<%@ page import="model.Giohang" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
					<p style="color: #8A4B08;font-weight: 700">Chi tiết mã hàng !</p>
					<hr/>
				<div class="row">
					<div class="col-sm-8">
						<strong>Sản phẩm</strong>
					</div>
					<div class="col-sm-2">
						<strong>Sô lượng</strong>
					</div>
					<div class="col-sm-2">
						<strong>Tổng giá</strong>
					</div>
				</div>
				<hr/>
				<%
					List<Giohang>list=(List)request.getAttribute("list");
					Taikhoan tk=(Taikhoan)request.getAttribute("tk");
					String mamuahang=(String)request.getAttribute("mamuahang");
					DaoMuahang daomua = new DaoMuahang();
					DaoGiohang daogio=new DaoGiohang();
					DaoKhuvuc daokhuvuc=new DaoKhuvuc();
					int x=Integer.parseInt(mamuahang);
					for(Giohang gio:list){
				%>
				<div class="row">
					<div class="col-sm-8">
						<p><%=gio.getTensanpham() %></p>
					</div>
					<div class="col-sm-2">
						<strong><%=gio.getSoluong() %></strong>
					</div>
					<div class="col-sm-2">
						<p style="color:#DF7401 "><%=gio.getThanhtien() %> VND</p>
					</div>
				</div>
				<hr/>
				<%
					}
				%>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Tổng phụ:</strong></p>
					</div>
					<div class="col-sm-4">
						<p style="color:#DF7401 "><%=(tk==null)?"":daogio.totalGiohang(x)%> VND</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Khách hàng</strong></p>
					</div>
					<div class="col-sm-4">
						<p style="color:#DF7401 "><%=(tk==null)?"":tk.getTenkhachhang() %></p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Số điện thoại</strong></p>
					</div>
					<div class="col-sm-4">
						<p style="color:#DF7401 "><%=(tk==null)?"":tk.getSodienthoai() %></p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Giao hàng</strong></p>
					</div>
					<div class="col-sm-4">
						<p style="color:#DF7401 "><%=(tk == null) ? "" : daokhuvuc.getKhuvucByMakhuvuc(tk.getMakhuvuc()).getCuocphy()%> VND</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Địa chỉ giao hàng</strong></p>
					</div>
					<div class="col-sm-4">
						<p><%=(tk==null)?"":tk.getDiachi() %></p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<p><strong>Tổng giá trị:</strong></p>
					</div>
					<div class="col-sm-4">
						<p style="color:#DF7401 "><%=(tk == null) ? ""
					: (daokhuvuc.getKhuvucByMakhuvuc(tk.getMakhuvuc()).getCuocphy() + daogio.totalGiohang(x))%>
						VND</p>
					</div>
				</div>
				</div>
			</div>
		</div>
<%@ include file="quanlyfooter.jsp"%>