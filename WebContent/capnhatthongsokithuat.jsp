<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List" %>
<%@ page import="model.Thongsokithuat" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px; margin-bottom: 20px">
	<%
		Thongsokithuat thongso=(Thongsokithuat)request.getAttribute("thongso");
	%>
	<p style="color: #8A4B08; font-weight: 700">Chi tiết sản phẩm!</p>
	<form action="chinhsuathongsokithuat" method="post">
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="hidden"
				name="masanpham" value="<%=(thongso==null)?"":thongso.getMasanpham()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Băng tần</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="bangtan" value="<%=(thongso==null)?"":thongso.getBangtan()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>GPU</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="gpu" value="<%=(thongso==null)?"":thongso.getGpu()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>CPU</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="cpu" value="<%=(thongso==null)?"":thongso.getCpu()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>RAM</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="ram" value="<%=(thongso==null)?"":thongso.getRam() %>">
		</div>
		<div style="margin-top: 10px">
			<strong>Bộ nhớ trong</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="bonhotrong" value="<%=(thongso==null)?"":thongso.getBonhotrong()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Cảm biến</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="cambien" value="<%=(thongso==null)?"":thongso.getCambien()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Hệ điều hành</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="hedieuhanh" value="<%=(thongso==null)?"":thongso.getHedieuhanh()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Cam trước</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="camtruoc" value="<%=(thongso==null)?"":thongso.getCamtruoc()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Cam sau</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="camsau" value="<%=(thongso==null)?"":thongso.getCamsau()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>PIN</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="pin" value="<%=(thongso==null)?"":thongso.getPin()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Công nghệ sạc pin</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="congnghesacpin" value="<%=(thongso==null)?"":thongso.getCongnghesacpin()%>">
		</div>
		<div style="margin-top: 10px">
			<strong>Thẻ nhớ</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text"
				name="thenho" value="<%=(thongso==null)?"":thongso.getThenho()%>">
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