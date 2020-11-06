<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<%
		if(admin==null){
	%>
	<p style="color: #8A4B08; font-weight: 700">Đăng nhập vào hệ thống
		quản lý của di động thông minh!</p>
	<form action="quanlyDangnhap" method="post">
		<div style="margin-top: 10px">
			<strong> Tài khoản </strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="text" name="username">
		</div>
		<div style="margin-top: 10px">
			<strong>Mật khẩu</strong>
		</div>
		<div style="margin-top: 10px">
			<input style="padding: 5px; width: 100%" type="password"
				name="password">
		</div>
		<div style="margin-top: 30px">
			<button
				style="padding: 5px; width: 20%; font-weight: 700; background-color: #088A08; color: white"
				type="submit">Đăng nhập</button>
			<a href="" style="margin-left: 20px">Quên mật khẩu?</a>
		</div>
	</form>
	<%
		}else{
	%>
	<p style="color: #8A4B08; font-weight: 700">Đăng nhập vào hệ thống thành công!</p>
	<%
		}
	%>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>