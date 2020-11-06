<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Muahang"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<div style="color: #8A4B08; font-weight: 700;">Thống kê doanh thu
		của cửa hàng :</div>
	<div style="color: #8A4B08; font-weight: 700; margin-top: 40px">
		Các đơn hàng đã được giao dich!</div>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-3">
			<strong>Mã đơn hàng</strong>
		</div>
		<div class="col-sm-3">
			<strong>Thời gian</strong>
		</div>
		<div class="col-sm-3">
			<strong>Tài khoản</strong>
		</div>
	</div>
	<%
		List<Muahang> list = (List) request.getAttribute("list");
		for (Muahang muahang : list) {
	%>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-3">
			<small><%=muahang.getMamuahang()%></small>
		</div>
		<div class="col-sm-3">
			<small><%=muahang.getThoigian()%></small>
		</div>
		<div class="col-sm-3">
			<small><%=muahang.getUsername()%></small>
		</div>
		<div class="col-sm-1">
			<a
				href="detailloinhuan?mamuahang=<%=muahang.getMamuahang()%>&username=<%=muahang.getUsername()%>"><img
				src="images/detail.jpg" style="width: 18px; height: 18px"></a>
		</div>
		<div class="col-sm-1">
			<a href="deleteDonhang?mamuahang=<%=muahang.getMamuahang()%>"><img
				src="images/xoa.png" style="width: 18px; height: 18px"></a>
		</div>

	</div>
	<%
		}
	%>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>