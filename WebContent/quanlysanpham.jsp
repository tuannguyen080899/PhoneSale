<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Sanpham" %>
<%@page import="java.util.List" %>

<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<%
		List<Sanpham>list=(List)request.getAttribute("list");
	%>
	<div style="color: #8A4B08; font-weight: 700;">
		Danh sách sản phẩm !<strong style="color: red"></strong>
	</div>
	<div class="row" style="margin-top: 20px;background-image: linear-gradient(to right,#F2F2F2,#F2F2F2);">
		<div class="col-sm-4">
			<strong>Tên sản phẩm</strong>
		</div>
		<div class="col-sm-3">
			<strong>Giá bán</strong>
		</div>
		<div class="col-sm-2">
			<strong>Màu sắc</strong>
		</div>
	</div>
	<%
		for(Sanpham sp:list){
	%>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-4">
			<small><%=sp.getTensanpham() %></small>
		</div>
		<div class="col-sm-3">
			<small><%=sp.getGiagiam() %></small>
		</div>
		<div class="col-sm-2">
			<small><%=sp.getMausac() %></small>
		</div>
		<div class="col-sm-1">
			<a href="detailsanpham?masanpham=<%=sp.getMasanpham()%>"><img src="images/detail.jpg"
				style="width: 18px; height: 18px"></a>
		</div>
		<div class="col-sm-1">
			<a href="chinhsuasanpham?id=<%=sp.getMasanpham()%>"><img src="images/edit.png"
				style="width: 18px; height: 18px"></a>
		</div>
		<div class="col-sm-1">
			<a href="deletesanpham?masanpham=<%=sp.getMasanpham()%>"><img src="images/xoa.png"
				style="width: 18px; height: 18px"></a>
		</div>
	</div>
	<%
		}
	%>
	<div style="margin-top: 20px; color: #886A08">
		Thêm sản phẩm.<a href="chinhsuasanpham">Tại đây</a>
	</div>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>