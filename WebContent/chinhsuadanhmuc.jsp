<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Danhmuc" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<p style="color: #8A4B08; font-weight: 700">Chi tiết danh mục!</p>
	<%
		Danhmuc dm=(Danhmuc)request.getAttribute("dm");
	%>
	<form action="chinhsuadanhmuc"method="post">
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="hidden" name="madanhmuc" value="<%=(dm==null)?"":dm.getMadanhmuc()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Tên danh mục</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="tendanhmuc" value="<%=(dm==null)?"":dm.getTendanhmuc()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Trạng thái</strong>
		</div>
		<div style="margin-top: 10px">
			<select name="trangthai" style="padding: 5px; width: 100%">
				<option value="false">Không hiển thị</option>
				<option value="true">Hiển thị</option>
			</select>
		</div>
		<div style="margin-top: 10px">
			Quay lại danh sách danh mục. <a href="quanlydanhmuc">Tại đây</a>
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