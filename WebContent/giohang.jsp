<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Giohang"%>
<%@ page import="dao.DaoMuahang"%>
<%@ page import="dao.DaoGiohang"%>
<%@ include file="homeheader.jsp"%>
<div id="content" class="container">
	<div class="row" style="margin-top: 10px">
		<p style="color: #DF7401; padding: 20px; border: 1px solid #DF7401">
			Miễn phý vận chuyển cho khách hàng thanh toán 100% giá trị đơn hàng,
			tặng thời gian đổi trả đến 30 ngày. <a href="">Chi tiết</a>
		</p>
	</div>
	<div style="padding: 10px; font-size: 18px">
		<strong>Giỏ hàng của bạn</strong>
	</div>
	<%
		Dinhdangtien dd=new Dinhdangtien();
		List<Giohang> listgio = (List) request.getAttribute("giohang");
		String username = (String) session.getAttribute("khachhang");
		DaoMuahang daomua = new DaoMuahang();
		DaoGiohang daogio = new DaoGiohang();
		int x = daomua.getMamuahangByUsername(username);
		if (listgio.isEmpty()) {
	%>
	<div style="margin-left:10px;color:red">Empty</div>
	<%
		} else {
	%>
	<hr />
	<div class="row">
		<div class="col-sm-6">
			<p>
				<strong>Sản phẩm</strong>
			</p>
		</div>
		<div class="col-sm-1">
			<p>
				<strong>Số lượng</strong>
			</p>
		</div>
		<div class="col-sm-2">
			<p>
				<strong>Tổng</strong>
			</p>
		</div>
	</div>
	<hr />
	<%
		for (Giohang gio : listgio) {
	%>
	<div class="row" style="margin-top: 5px">
		<div class="col-sm-6">
			<img src="images/img/<%=gio.getHinhanh()%>"
				style="width: 30px; height: 30px"> <i style="padding: 10px"><%=gio.getTensanpham()%></i>
		</div>
		<div class="col-sm-1">
			<i><%=gio.getSoluong()%></i>
		</div>
		<div class="col-sm-2">
			<i><%=dd.Format(gio.getThanhtien())%></i>
		</div>
		<div class="col-sm-1">
			<i onclick="giamGiohang(<%=gio.getMasanpham()%>,<%=gio.getMamuahang()%>,<%=gio.getSoluong()%>,<%=gio.getThanhtien()%>,<%=gio.getTienvon()%>)"><img src="images/giam.jpg"
				style="width: 15px; height: 15px"></i>
		</div>
		<div class="col-sm-1">
			<i
				onclick="deleteGiohang(<%=gio.getMasanpham()%>,<%=gio.getMamuahang()%>)"><img
				src="images/xoa.png" style="width: 15px; height: 15px"></i>
		</div>
	</div>
	<%
		}
		}
	%>
	<hr />
	<div class="row" style="margin: 20px">
		<div class="col-sm-6"></div>
		<div class="col-sm-6" style="border: 1px solid #DF7401">
			<p style="font-size: 18px; font-weight: 700; padding: 10px">Tổng
				giá trị sản phẩm!</p>
			<hr />
			<div class="row">
				<div class="col-sm-4">
					<strong>Tổng tiền</strong>
				</div>
				<div class="col-sm-8">
					<p>
						<strong><%=dd.Format(daogio.totalGiohang(x))%></strong>
					</p>
				</div>
			</div>
			<%
				if(daogio.totalGiohang(x)==0){
			%>
			<div class="row" style="margin-top: 10px; padding: 10px">
				<a	href="" style="text-decoration: none">
					<div align="center"style="width: 100%; height: 60px; color: white; background-color: #DF7401;padding-top:17px;font-size:18px">Giỏ hàng của bạn rỗng</div>
				</a>
			</div>
			<%
				}else{
			%>
			<div class="row" style="margin-top: 10px; padding: 10px">
				<a	href="thanhtoan" style="text-decoration: none">
					<div align="center"style="width: 100%; height: 60px; color: white; background-color: #DF7401;padding-top:17px;font-size:18px">Tiến hành thanh toán</div>
				</a>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<script>
			function deleteGiohang(masanpham,mamuahang) {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("top").innerHTML = this.responseText;
				}
			};
				xhttp.open("GET", "deletespGiohang?masanpham="+masanpham+"&mamuahang="+mamuahang, true);
				xhttp.send();
			}
			function giamGiohang(masanpham,mamuahang,soluong,tien,tienvon) {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						document.getElementById("top").innerHTML = this.responseText;
					}
				};
					xhttp.open("GET", "giamspGiohang?masanpham="+masanpham+"&mamuahang="+mamuahang+"&soluong="+soluong+"&tien="+tien+"&tienvon="+tienvon, true);
					xhttp.send();
				}
		</script>
	<%@ include file="homefooter.jsp"%>