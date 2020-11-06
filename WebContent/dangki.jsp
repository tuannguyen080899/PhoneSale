<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="homeheader.jsp"%>
<div class="container" align="center" >
	<div class="row">
		<form action="dangki" method="post">
			<div style="border:1px solid #FFBF00 ;width: 40%;margin:60px;padding: 30px;height: 400px">
				<div style="font-size: 18px;font-weight: 700;padding: 5px">
				Đăng kí
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
				<div style="padding: 5px">
					Nhập lại mật khẩu *
				</div>
				<div style="padding: 5px">
					<input type="password" name="nhaplai" style="border-collapse: collapse;border:1px solid 0.5px;width: 90%;height: 40px"required="required">
				</div>
				<div style="padding: 5px">
				<button type="submit" style="width: 90%;height: 40px;background-color: #FFBF00;color: white">Đăng kí</button>
				</div>
			</div>
			
		</form>
	</div>	
<%@ include file="homefooter.jsp"%>