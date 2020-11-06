<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Sanpham"%>
<%@ page import="dao.DaoSanpham"%>
<%@page import="java.util.List"%>
<%@ page import="model.Thongsokithuat"%>
<%@ include file="homeheader.jsp"%>
<div class="container">
	<div class="row">
		<%
			Dinhdangtien dd=new Dinhdangtien();
			Sanpham sp = (Sanpham) request.getAttribute("sanpham");
			List<Sanpham> listbyname = (List) request.getAttribute("list");
			DaoSanpham daos = new DaoSanpham();
			List<Sanpham> listbonho = daos.getAllSanphamByNameGroupBonho(sp.getTensanpham());
		%>
		<div class="col-sm-12" style="padding: 5px">
			<small><a href="welcome.jsp">Trang chủ</a>/<%=(sp == null) ? "" : sp.getTensanpham()%></small>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12" style="padding: 5px">
			<h3><%=(sp == null) ? "" : sp.getTensanpham()%></h3>
			<p style="color: red"><%=(sp == null) ? ""
					: (sp.isLoai() != true) ? "Đã kích hoat" : "Chưa kích hoạt, bản Vn/a, nguyên hộp"%></p>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-sm-5">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel" style="width: 100%; height: 300px">
				<div class="carousel-inner" role="listbox">
					<div class="item active" align="center">
						<a href=""><img style="width: 70%; height: 300px"
							src="images/img/<%=(sp == null) ? "" : sp.getAnhtruoc()%>"></a>
						<div class="carousel-caption"></div>
					</div>
					<div class="item" align="center">
						<a href=""><img style="width: 70%; height: 300px"
							src="images/img/<%=(sp == null) ? "" : sp.getAnhsau()%>"></a>
						<div class="carousel-caption"></div>
					</div>
					<div class="item" align="center">
						<a href=""><img style="width: 70%; height: 300px"
							src="images/img/<%=(sp == null) ? "" : sp.getAnhtuxa()%>"></a>
						<div class="carousel-caption"></div>
					</div>
				</div>
				<a href="#carousel-example-generic" class="left carousel-control"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a href="#carousel-example-generic" class="right carousel-control"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>

			</div>
			<div style="margin-top: 10px">
				<strong>Thông tin sản phẩm:</strong> <small><%=(sp == null) ? "" : sp.getMota()%></small>
			</div>
		</div>
		<div class="col-sm-4">
			<div>
				<p style="color: #8A4B08; font-weight: 700; font-size: 25px"><%=(sp == null) ? "" : dd.Format(sp.getGiagiam())%>
					 <i style="font-size: 20px">(<%=(sp == null) ? "" : sp.getMausac()%>)
					</i>
				</p>
				<strike style="color: red; font-size: 17px;"><i><%=(sp == null) ? "" : dd.Format(sp.getGiaban())%>
						</i></strike>
				<div style="margin:7px"><strong>Màu sắc:</strong></div>
				<%
					for (int i = 0; i < listbyname.size(); i++) {
				%>
				<a
					href="showSanpham?masanpham=<%=listbyname.get(i).getMasanpham()%>"><p
						style="width: 30px;height: 30px;background-color:<%=listbyname.get(i).getMausac()%>;border-radius: 50px;float:left;margin-left:10px"></p></a>
				<%
					}
				%>
				<div style="clear:both;margin:7px">
					<strong>Bộ nhớ:</strong>Bạn đang xem điện thoại bản
					<%=(sp == null) ? "" : sp.getBonho()%>
					<br/>
					<small>Xem bản khác:</small>
				</div>
				<%
					for (Sanpham ssp:listbonho) {
				%>
				<a href="showSanpham?masanpham=<%=ssp.getMasanpham()%>">
					<div
						style="width: 100px; height: 70px; border: 1px solid red; border-radius: 5px; float: left; margin: 10px; padding: 8px">
						<strong><%=ssp.getBonho()%></strong> <br/><i
							style="color: red"> <%=dd.Format(ssp.getGiagiam())%>
						</i>
					</div>
				</a>
				<%
					}
				%>
				<div style="clear:both"></div>
				<hr/>
				<a href="giohang?masanpham=<%=(sp == null) ? "" : sp.getMasanpham()%>"
					style="color: white; border-radius: 5px; text-decoration: none">
					<div
						style="width:100%; padding: 8px; background-color: #5F4C0B; margin-top: 10px; height: 50px;text-align:center;border-radius: 5px;">
						<p style="font-size: 18px; font-weight: 600">MUA NGAY</p>
					</div>
				</a>

				<div style="margin-top: 17px">
					<button
						style="width:100%;height: 50px; padding: 5px; color: white; border-radius: 5px; border: 1px solid #FFBF00; background-color: #2E64FE">
						<p style="font-size: 18px; font-weight: 600">TRẢ GÓP LÃI SUẤT
							THẤP</p>
					</button>
				</div>
			</div>
		</div>
		<div class="col-sm-3" align="center">
			<div style="border: 1px solid #FFBF00">
				<div
					style="width: 100%; height: 30px; background-color: #FFBF00; color: white; font-weight: 700; padding: 5px">Chế
					độ bảo hành</div>
				<div style="padding: 10px">
					<strong>Bảo hành chính hãng</strong>
				</div>
				<div
					style="width: 80%; height: 100px; border: 0.1px solid black; color: #61380B; padding: 5px">
					<p>
						<small>Đổi sản phẩm trước 15 ngày</small>
					</p>
					<p>
						<small>Bảo hành 12 tháng kể từ ngày mua</small>
					</p>
					<p>
						<small>Xử lý trong 30 ngày</small>
					</p>
				</div>
				<div style="color: #FFBF00; margin-top: 30px">Sửa chữa bảo
					hành theo chính sách của nhà sản xuất kể cả lỗi người dùng</div>
				<div>
					<button
						style="width: 60%; margin-top: 25px; color: white; border-radius: 5px; border: 1px solid #FFBF00; background-color: #2E64FE">Xem
						chi tiết</button>
				</div>
			</div>
			<div style="border: 1px solid #04B404; margin-top: 20px">
				<div
					style="width: 100%; height: 30px; background-color: #04B404; color: white; font-weight: 700; padding: 5px">Danh
					sách cửa hàng</div>
				<div style="padding: 20px">
					<i class="fa fa-home">Hotline toàn quốc</i>-<i
						class="fa fa-phone-square" style="color: #FFBF00"> 0969456215</i>
				</div>
				<div style="padding: 20px">
					<iclass ="fafa-home">119 - 121 Thái Thịnh, Q.Đống Đa, Hà
					Nội</i>-<i class="fa fa-phone-square" style="color: #FFBF00">
						0969456215</i>
				</div>
				<div style="padding: 20px">
					<i class="fa fa-home">(Liên kết - Nhượng Quyền) 208 Xã Đàn ,
						Q.Đống Đa, Hà Nội</i>-<i class="fa fa-phone-square"
						style="color: #FFBF00"> 0969456215</i>
				</div>
				<div style="padding: 20px">
					<i class="fa fa-home">(Liên kết - Nhượng Quyền) 95 Xuân Thủy
						(135 Xuân Thủy cũ), Q.Cầu Giấy, Hà Nội</i>-<i
						class="fa fa-phone-square" style="color: #FFBF00"> 0969456215</i>
				</div>
			</div>
		</div>

	</div>
	<hr />
	<div class="row" style="margin-bottom: 30px">
		<div class="col-sm-7">
			<div style="margin-top: 50px">
				<div
					style="border-left: 5px solid #FFBF00; text-align: center; padding: 10px">
					ĐÁNH GIÁ SẢN PHẨM</div>
				<div style="margin-top: 20px">
					<form>
						<input style="width: 80%; height: 40px" type="text" name=""
							placeholder="Mời bạn để lại đánh giá bình luận cho sản phẩm của chúng tôi.....">
						<button
							style="width: 15%; height: 40px; color: white; border-radius: 5px; border: 1px solid #FFBF00; background-color: #2E64FE"
							type="submit">Nhận xét</button>
					</form>
				</div>
			</div>
			<div style="margin-top: 20px">
				<strong>Phạm Văn Quyền:</strong><small>Tôi đã dùng thử sản
					phẩm của cửa hàng cảm thấy nó rất tốt.</small>
			</div>
		</div>
		<div class="col-sm-5">
			<div style="margin-top: 50px">
				<div
					style="border-left: 5px solid #FFBF00; text-align: center; padding: 10px">
					THÔNG SỐ KỸ THUẬT</div>
				<%
					Thongsokithuat thongso = (Thongsokithuat) request.getAttribute("thongso");
					if (thongso != null) {
				%>
				<hr />
				<table style="padding: 10px;">

					<tr>
						<td>Băng tần-Sim</td>
						<td><%=(thongso == null) ? "" : thongso.getBangtan()%></td>
					</tr>
					<tr>
						<td>Chíp đồ họa (GPU)</td>
						<td><%=(thongso == null) ? "" : thongso.getGpu()%></td>
					</tr>
					<tr>
						<td>CPU</td>
						<td><%=(thongso == null) ? "" : thongso.getCpu()%></td>
					</tr>
					<tr>
						<td>RAM</td>
						<td><%=(thongso == null) ? "" : thongso.getRam()%></td>
					</tr>
					<tr>
						<td>Bộ nhớ trong</td>
						<td><%=(thongso == null) ? "" : thongso.getBonhotrong()%></td>
					</tr>
					<tr>
						<td>Cảm biến</td>
						<td><%=(thongso == null) ? "" : thongso.getCambien()%></td>
					</tr>
					<tr>
						<td>Hệ điều hành</td>
						<td><%=(thongso == null) ? "" : thongso.getHedieuhanh()%></td>
					</tr>
					<tr>
						<td>Camera trước</td>
						<td><%=(thongso == null) ? "" : thongso.getCamtruoc()%></td>
					</tr>
					<tr>
						<td>Camera sau</td>
						<td><%=(thongso == null) ? "" : thongso.getCamsau()%></td>
					</tr>
					<tr>
						<td>Pin</td>
						<td><%=(thongso == null) ? "" : thongso.getPin()%></td>
					</tr>
					<tr>
						<td>Công nghệ sạc pin</td>
						<td><%=(thongso == null) ? "" : thongso.getCongnghesacpin()%></td>
					</tr>
					<tr>
						<td>Thẻ nhớ</td>
						<td><%=(thongso == null) ? "" : thongso.getThenho()%></td>
					</tr>
				</table>
				<hr />
				<%
					} else {
				%>
				<div style="color: red; text-align: center">Chưa cập nhật</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<%@ include file="homefooter.jsp"%>