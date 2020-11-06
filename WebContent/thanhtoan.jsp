<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Giohang"%>
<%@ page import="dao.DaoMuahang"%>
<%@ page import="dao.DaoGiohang"%>
<%@ page import="model.Tinh"%>
<%@ page import="dao.DaoKhuvuc"%>
<%@ page import="model.Taikhoan"%>
<%@ include file="homeheader.jsp"%>
<div id="content" class="container">
	<div class="row" style="margin-top: 20px;">
		<p style="color: #DF7401; padding: 20px; border: 1px solid #DF7401">
			Miễn phý vận chuyển cho khách hàng thanh toán 100% giá trị đơn hàng,
			tặng thời gian đổi trả đến 30 ngày. <a href="">Chi tiết</a>
		</p>
	</div>

	<hr />
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-6">
			<%
				Taikhoan tk = (Taikhoan) request.getAttribute("donhang");
			%>
			<form action="capnhatthongtinkhachhang" method="post">
				<div class="row" style="color: red; font-size: 20px; padding: 10px">
					<img src="images/chamthan.jpg"
						style="width: 20px; height: 20px; margin-right: 20px; margin-bottom: 5px">Cập
					nhật thông tin khách hàng
				</div>
				<div class="row">
					<input type="text" name="tenkhachhang"
						placeholder="Nhập đầy đủ họ và tên của bạn..."
						style="width: 90%; height: 35px; border-radius: 2px; margin-top: 20px"
						required="required" value=""> <input type="text"
						name="email" placeholder="Email.."
						style="width: 90%; height: 35px; border-radius: 2px; margin-top: 20px"
						required="required" value=""> <input type="text"
						name="dienthoai" placeholder="Điện thoại.."
						style="width: 90%; height: 35px; border-radius: 2px; margin-top: 20px"
						required="required" value="">
					<%
						Dinhdangtien dd=new Dinhdangtien();
						List<Tinh> listkhuvuc;
						DaoKhuvuc daokhuvuc = new DaoKhuvuc();
						listkhuvuc = daokhuvuc.getAllKhuvuc();
					%>
					<select name="khuvuc"
						style="width: 90%; height: 35px; border-radius: 2px; margin-top: 20px">
						<%
							for (Tinh tinh : listkhuvuc) {
						%>
						<option value="<%=tinh.getMakhuvuc()%>"><%=tinh.getTenkhuvuc()%></option>
						<%
							}
						%>
					</select> <input type="text" name="diachi"
						placeholder="Nơi nhận hàng..ví dụ Số 30/ngõ 28/Trương Định/Hai Bà Trưng/Hà Nội"
						style="width: 90%; height: 35px; border-radius: 2px; margin-top: 20px"
						required="required">
				</div>
				<div></div>
				<div class="row" style="margin-top: 60px;">

					<button
						style="width: 90%; height: 40px; color: white; background-color: #31B404;">
						Cập nhật thông tin</button>
				</div>
			</form>
			<%
				if (tk.getTenkhachhang() == null) {
			%>
			<div class="row"
				style="margin-top: 30px; margin-bottom: 20px; color: red">Bạn
				chưa cập nhật thông tin, xin vui lòng cập nhật ở phía trên</div>
			<%
				} else {
			%>
			<div class="row" style="margin-top: 10px;margin-bottom:20px">
				<a href="dathang" style="text-decoration: none">
					<div align="center"
						style="width: 90%; height: 40px; color: white; background-color: #DF7401; padding-top: 10px; font-size: 15px">Đặt hàng ngay</div>
				</a>
			</div>
			<%
				}
			%>


		</div>
		<div class="col-sm-6" style="border: 1px solid #DF7401">
			<p style="font-size: 18px; font-weight: 700; padding: 10px">Đơn
				hàng của bạn</p>
			<hr />
			<%
				String username = (String) session.getAttribute("khachhang");
				DaoMuahang daomua = new DaoMuahang();
				DaoGiohang daogio = new DaoGiohang();
				int x = daomua.getMamuahangByUsername(username);
				List<Giohang> listthanhtoan = (List) request.getAttribute("thanhtoan");
			%>
			<div class="row">
				<div class="col-sm-8">
					<strong>Sản phẩm</strong>
				</div>
				<div class="col-sm-4">
					<strong>Tổng giá</strong>
				</div>
			</div>
			<hr />
			<%
				for (Giohang gio : listthanhtoan) {
			%>
			<div class="row">
				<div class="col-sm-8">
					<p><%=gio.getTensanpham()%>
						<small style="color: red">(X<%=gio.getSoluong()%>)
						</small>
					</p>
				</div>
				<div class="col-sm-4">
					<p style="color: #DF7401"><%=dd.Format(gio.getThanhtien())%>
					</p>
				</div>
			</div>
			<hr />
			<%
				}
			%>
			<hr />
			<div class="row">
				<div class="col-sm-8">
					<p>
						<strong>Tổng phụ:</strong>
					</p>
				</div>
				<div class="col-sm-4">
					<p style="color: #DF7401"><%=dd.Format(daogio.totalGiohang(x))%>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<p>
						<strong>Giao hàng</strong>
					</p>
				</div>
				<div class="col-sm-4">
					<p style="color: #DF7401"><%=(tk == null) ? "" :dd.Format(daokhuvuc.getKhuvucByMakhuvuc(tk.getMakhuvuc()).getCuocphy())%>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<p>
						<strong>Địa chỉ giao hàng</strong>
					</p>
				</div>
				<div class="col-sm-4">
					<p><%=(tk == null) ? "" : tk.getDiachi()%></p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<p>
						<strong>Tổng giá trị:</strong>
					</p>
				</div>
				<div class="col-sm-4">
					<p style="color: #DF7401"><%=(tk == null) ? ""
					: dd.Format((daokhuvuc.getKhuvucByMakhuvuc(tk.getMakhuvuc()).getCuocphy() + daogio.totalGiohang(x)))%>
					</p>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="homefooter.jsp"%>