<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Sanpham" %>
<%@page import="model.Danhmuc" %>
<%@page import="dao.DaoDanhmuc" %>
<%@page import="java.util.List" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px; margin-bottom: 20px">
	<%
		Sanpham sp=(Sanpham)request.getAttribute("sp");
		DaoDanhmuc daodm=new DaoDanhmuc();
		List<Danhmuc>list=daodm.getAllDanhmuc();
	%>
	<p style="color: #8A4B08; font-weight: 700">Chi tiết sản phẩm!</p>
	<form action="chinhsuasanpham" method="post">
		<div style="margin-top: 10px">
			<strong>Danh mục</strong>
		</div>
		<div style="margin-top: 10px">
			<select name="danhmuc" style="padding: 5px; width: 100%">
				<% for(Danhmuc dm:list){ %>
				<option value="<%=dm.getMadanhmuc()%>"><%=dm.getTendanhmuc() %></option>
				<%} %>
			</select>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="hidden"
				name="masanpham" value="<%=(sp==null)?"":sp.getMasanpham()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Tên sản phẩm</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="tensanpham"value="<%=(sp==null)?"":sp.getTensanpham()%>" required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Giá nhập</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="number" name="gianhap" value="<%=(sp==null)?"":sp.getGianhap()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Giá bán</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="number" name="giaban" value="<%=(sp==null)?"":sp.getGiaban()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Giá giảm</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="number" name="giagiam" value="<%=(sp==null)?"":sp.getGiagiam()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Màu sắc</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="mausac" value="<%=(sp==null)?"":sp.getMausac()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Loại</strong>
		</div>
		<div style="margin-top: 10px">
			<select name="loai" style="padding: 5px; width: 100%">
				<option value="true">Mới</option>
				<option value="false">Cũ</option>
			</select>
		</div>
		<div style="margin-top: 10px">
			<strong>Bộ nhớ</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="bonho" value="<%=(sp==null)?"":sp.getBonho()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Mô tả</strong>
		</div>
		<div style="margin-top: 10px">
			<textarea style="width: 100%; height: 100px" name="mota"><%=(sp==null)?"":sp.getMota()%></textarea>
		</div>
		<div style="margin-top: 10px">
			Cập nhật ảnh sản phẩm. <a href="chinhsuahinhanh?masanpham=<%=(sp==null)?"":sp.getMasanpham()%>">Tại đây</a>
		</div>
		<div style="margin-top: 10px">
			Cập nhật thông số kĩ thuật sản phẩm. <a href="chinhsuathongsokithuat?masanpham=<%=(sp==null)?"":sp.getMasanpham()%>">Tại đây</a>
		</div>
		<div style="margin-top: 30px">
			<button
				style="padding: 5px; width: 20%; font-weight: 700; background-color: #088A08; color: white"
				type="submit">Cập nhật</button>
			<button
				style="padding: 5px; width: 20%; font-weight: 700; background-color: #088A08; color: white; margin-left: 20px"
				type="reset">Làm mới</button>
		</div>
	</form>

</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>