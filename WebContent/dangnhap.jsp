<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="homeheader.jsp"%>
<div id="content" class="container" align="center" >
		<form action="dangnhap" method="post">
			<div style="border:1px solid #FFBF00 ;width: 40%;margin:60px;padding: 30px;height: 400px">
				<div style="font-size: 18px;font-weight: 700;padding: 5px">
				Đăng nhập
				</div>
				<div style="padding: 5px">
				Tên tài khoản *
				</div>
				<div style="padding: 5px">
					<input type="text" name="username"style="border-collapse: collapse;border:1px solid 0.5px;width: 90%;height: 40px"required="required">
				</div>
				<div style="padding: 5px">
					Mật khẩu *
				</div>
				<div style="padding: 5px">
					<input type="password" name="password" style="border-collapse: collapse;border:1px solid 0.5px;width: 90%;height: 40px"required="required">
				</div>
				<div style="padding: 5px"><a href="">Quên mật khẩu ?</a></div>
				<div style="padding: 5px">
				<button type="submit" style="width: 90%;height: 40px;background-color: #FFBF00;color: white">Đăng nhập</button>
			</div>
			<div style="padding: 5px">
					<a href="dangki.jsp">Đăng kí</a>
			</div>
			<div style="padding: 5px">
					<a href="dangxuat">Đăng xuất</a>
			</div>
			</div>
			
		</form>
<%@ include file="homefooter.jsp"%>