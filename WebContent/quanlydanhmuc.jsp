
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Danhmuc"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<div style="color: #8A4B08; font-weight: 700;">Danh sách danh mục
		sản phẩm!</div>
	<div class="row" style="margin-top: 20px;background-image: linear-gradient(to right,#F2F2F2,#F2F2F2);">
		<div class="col-sm-6">
			<strong>Tên danh mục</strong>
		</div>
		<div class="col-sm-4">
			<strong>Trạng thái</strong>
		</div>
	</div>
	<%	
		List<Danhmuc>list=(List)request.getAttribute("danhmuc");
		for (Danhmuc obj :list) {
	%>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-6">
			<small><%=(obj == null) ? "empty" : obj.getTendanhmuc()%></small>
		</div>
		<div class="col-sm-4">
			<small><%=(obj == null) ? "empty" : (obj.isTrangthai() == true) ? "Hiển thị" : "Không hiển thị"%></small>
		</div>
		<div class="col-sm-1">
			<a href="chinhsuadanhmuc?id=<%=obj.getMadanhmuc()%>"><img src="images/edit.png"
				style="width: 18px; height: 18px"></a>
		</div>
		<div class="col-sm-1">
			<a href="deletedanhmuc?madanhmuc=<%=obj.getMadanhmuc()%>"><img src="images/xoa.png"
				style="width: 18px; height: 18px"></a>
		</div>
	</div>
	<%
		}	
	%>
	<div style="margin-top: 20px; color: #886A08">
		Thêm danh mục.<a href="chinhsuadanhmuc">Tại đây</a>
	</div>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>