<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Tinh" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<p style="color: #8A4B08; font-weight: 700">Chi tiết khu vực!</p>
	<%
		Tinh tinh=(Tinh)request.getAttribute("khuvuc");
	%>
	<form action="chinhsuakhuvuc"method="post">
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="hidden" name="makhuvuc" value="<%=(tinh==null)?"":tinh.getMakhuvuc()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Tên khu vực</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="tenkhuvuc" value="<%=(tinh==null)?"":tinh.getTenkhuvuc()%>" required="required">
		</div>
		<div style="margin-top: 10px">
			<strong>Cước phý</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="cuocphy" value="<%=(tinh==null)?"":tinh.getCuocphy()%>"required="required">
		</div>
		<div style="margin-top: 10px">
			Quay lại danh sách khu vực. <a href="quanlykhuvuc">Tại đây</a>
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