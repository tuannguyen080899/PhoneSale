<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Sanpham"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<style type="text/css">
td {
	width: 200px;
	padding-top: 20px;
}

th {
	width: 200px;
	padding-top: 0px;
	text-align: center;
}
</style>
	<%
		Sanpham sanpham=(Sanpham)request.getAttribute("sanpham");
	%>
	<p style="color: #8A4B08; font-weight: 700">Chi tiết sản phẩm!</p>
	<div class="row">
		<div class="col-sm-6">
			<table style="padding: 20px">
				<tr>
					<td><strong>Sản phẩm</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getTensanpham() %></small></td>
				</tr>
				<tr>
					<td><strong>Danh mục</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getDanhmuc().getTendanhmuc() %></small></td>
				</tr>
				<tr>
					<td><strong>Giá nhập</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getGianhap() %></small></td>
				</tr>
				<tr>
					<td><strong>Giá bán</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getGiaban() %></small></td>
				</tr>
				<tr>
					<td><strong>Giá giảm</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getGiagiam() %></small></td>
				</tr>
				<tr>
					<td><strong>Màu sắc</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getMausac() %></small></td>
				</tr>
				<tr>
					<td><strong>Bộ nhớ</strong></td>
					<td><small><%=(sanpham==null)?"":sanpham.getBonho() %></small></td>
				</tr>
			</table>
		</div>
		<div class="col-sm-6">
			<table>
				<tr>
					<th><strong>Mặt trước</strong></th>
					<th><strong>Mặt sau</strong></th>
					<th><strong>Từ xa</strong></th>
				</tr>
				<tr>
					<td><img src="images/img/<%=(sanpham==null)?"":sanpham.getAnhtruoc() %>"
						style="width: 100%; height: 140px;border:1px solid black"></td>
					<td><img src="images/img/<%=(sanpham==null)?"":sanpham.getAnhsau() %>"
						style="width: 100%; height: 140px;border:1px solid black"></td>
					<td><img src="images/img/<%=(sanpham==null)?"":sanpham.getAnhtuxa() %>"
						style="width: 100%; height: 140px;border:1px solid black"></td>
				</tr>
				<tr>
					<td colspan="3">
					<a href="capnhatanhquangcao?masanpham=<%=(sanpham==null)?"":sanpham.getMasanpham() %>">
					<%
						if(sanpham.getAnhquangcao()!=null){
					%>
					<img alt="" src="images/anhquangcao/<%=(sanpham==null)?"":sanpham.getAnhquangcao()%>"style="width: 100%; height: 140px;border:1px solid black">
					<%
						}else{
					%>
					<p>Cập nhật ảnh quảng cáo</p>
					<%} %>
					</a></td>
				</tr>
			</table>

		</div>
	</div>
	<div style="margin-top: 20px">
		<div class="row">
			<div class="col-sm-6">Mô tả sản phẩm</div>
			<div class="col-sm-6" align="center"><a href="themvaophanquangcao?id=<%=(sanpham==null)?"":sanpham.getMasanpham()%>">Thêm vào danh sách điện thoại hot</a></div>
		</div>
	</div>
	<hr />
	<div style="width: 100%">
	<%=(sanpham==null)?"":sanpham.getMota() %>
	</div>
</div>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>