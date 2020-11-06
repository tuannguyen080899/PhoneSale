<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Danhmuc" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<p style="color: #8A4B08; font-weight: 700">Cập nhật ảnh slider!</p>
	<form action="chinhsuanhslider"method="post"enctype="multipart/form-data">
		<div style="margin-top: 10px">
			<strong>Chọn hình ảnh</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="file" name="anh" value="">
		</div>
		<div style="margin-top: 10px">
			Quay lại danh sách slider. <a href="quanlyslider">Tại đây</a>
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