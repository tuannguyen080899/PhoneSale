<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<form action="chinhsuahinhanh" method="post"enctype="multipart/form-data">
		<p style="color: red; font-weight: 700; font-size: 18px">Lựa chọn
			hình ảnh!</p>
		<div style="margin-top: 10px" >
			<strong>Ảnh trước</strong>
		</div>
		<input style="margin-top: 10px" type="file" name="anhtruoc">
		<div style="margin-top: 10px">
			<strong>Ảnh sau</strong>
		</div>
		<input style="margin-top: 10px" type="file" name="anhsau">
		<div style="margin-top: 10px">
			<strong>Ảnh từ xa</strong>
		</div>
		<input style="margin-top: 10px" type="file" name="anhtuxa"> <input
			style="margin-top: 20px; color: white; background-color: #B18904"
			type="submit" name="" value="Cập nhật">
	</form>

</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>