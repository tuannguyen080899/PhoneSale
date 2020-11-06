<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Slider" %>

<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<p style="color: #8A4B08; font-weight: 700">Cập nhật trạng thái!</p>
	<form action="chinhsuaslider"method="post">
	<%
		Slider slider=(Slider)request.getAttribute("sl");
	%>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="hidden" name="maslider" value="<%=(slider==null)?"":slider.getMaslider()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Title</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="title" value="<%=(slider==null)?"":slider.getTitle()%>"required="required">
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