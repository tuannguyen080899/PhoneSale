<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Sanpham"%>
<%@page import="dao.DaoSanpham"%>
<%@ include file="homeheader.jsp"%>
<%@ include file="slider.jsp"%>
<div id="content" class="container">

	<div class="row"
		style="background-image: linear-gradient(to right, #FAAC58, #FAAC58)">
		<div class="col-sm-1">
			<div class="btn-group">
				<button style="width: 98px; padding-left: 0px;" type="button"
					class=" dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Giá Tiền</button>
				<div class="dropdown-menu">
					<a style="margin-left: 15px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%><%=(bonho == null) ? "" : "&bonho="%><%=(bonho == null) ? "" : bonho%>&minprice=0&maxprice=3000000">Dưới
						3M</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 15px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%><%=(bonho == null) ? "" : "&bonho="%><%=(bonho == null) ? "" : bonho%>&minprice=3000000&maxprice=7000000">3-7M</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 15px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%><%=(bonho == null) ? "" : "&bonho="%><%=(bonho == null) ? "" : bonho%>&minprice=7000000&maxprice=15000000">7-15M</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 15px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%><%=(bonho == null) ? "" : "&bonho="%><%=(bonho == null) ? "" : bonho%>&minprice=15000000&maxprice=50000000">Trên
						15M</a>
				</div>
			</div>
		</div>
		<div class="col-sm-1">
			<div class="btn-group">
				<button style="width: 98px; padding-left: 0px;" type="button"
					class=" dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Bộ Nhớ</button>
				<div class="dropdown-menu">
					<a style="margin-left: 17px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%>&bonho=16G
				<%=(minprice == null) ? "" : "&minprice="%><%=(minprice == null) ? "" : minprice%>
				<%=(maxprice == null) ? "" : "&maxprice="%><%=(maxprice == null) ? "" : maxprice%>">16G</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 17px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%>&bonho=32G
				<%=(minprice == null) ? "" : "&minprice="%><%=(minprice == null) ? "" : minprice%>
				<%=(maxprice == null) ? "" : "&maxprice="%><%=(maxprice == null) ? "" : maxprice%>">32G</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 17px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%>&bonho=64G
				<%=(minprice == null) ? "" : "&minprice="%><%=(minprice == null) ? "" : minprice%>
				<%=(maxprice == null) ? "" : "&maxprice="%><%=(maxprice == null) ? "" : maxprice%>">64G</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 17px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%>&bonho=128G
				<%=(minprice == null) ? "" : "&minprice="%><%=(minprice == null) ? "" : minprice%>
				<%=(maxprice == null) ? "" : "&maxprice="%><%=(maxprice == null) ? "" : maxprice%>">128G</a>
					<div class="dropdown-divider"></div>
					<a style="margin-left: 17px" class="dropdown-item"
						href="sanpham?<%=(danhmuc == null) ? "" : "loaisanpham="%><%=(danhmuc == null) ? "" : danhmuc%>&bonho=256G
				<%=(minprice == null) ? "" : "&minprice="%><%=(minprice == null) ? "" : minprice%>
				<%=(maxprice == null) ? "" : "&maxprice="%><%=(maxprice == null) ? "" : maxprice%>">256G</a>
				</div>
			</div>
		</div>
		<div class="col-sm-1">
			<div class="btn-group">
				<button style="width: 98px; padding-left: 0px;" type="button"
					class=" dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">Hãng Khác</button>
				<div class="dropdown-menu">
					<%
						for (Danhmuc dm : listDanhmuc) {
					%>
					<a style="margin-left: 10px" class="dropdown-item"
						href="sanpham?loaisanpham=<%=dm.getTendanhmuc()%>&
				<%=(bonho == null) ? "" : "bonho="%><%=(bonho == null) ? "" : bonho%>&
				<%=(minprice == null) ? "" : "minprice="%><%=(minprice == null) ? "" : minprice%>&
				<%=(maxprice == null) ? "" : "maxprice="%><%=(maxprice == null) ? "" : maxprice%>"><%=dm.getTendanhmuc()%></a>
					<div class="dropdown-divider"></div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<%
			Dinhdangtien dd=new Dinhdangtien();
			List<Sanpham> listsp;
			listsp = (List) request.getAttribute("list");
			int size = listsp.size();
			DaoSanpham daosanpham=new DaoSanpham();
		%>
		<div class="col-sm-2">
			<p
				style="font-family: initial; font-size: 20px; font-weight: 700; padding-top: 10px"><%=(danhmuc == null) ? "Toàn bộ sản phẩm" : danhmuc%></p>
		</div>
	</div>
	<style type="text/css">
			#sanpham:hover{
				background-color:#E3F6CE;
				padding-left:1px;
				padding-right:1px;
		</style>
	<div class="row" style="padding: 10px">
		<%
			if (listsp.isEmpty()) {
		%>
		<div style="margin: 5px; color: red">Không tìm thấy sản phẩm chỉ
			định!</div>
		<%
			} else {
				for (Sanpham sp : listsp) {
		%>
		
		<div class="col-sm-2" id="sanpham">
			<a href="showSanpham?masanpham=<%=sp.getMasanpham()%>"
				style="text-decoration: none;"> <img
				src="images/img/<%=sp.getAnhtruoc()%>"
				style="width: 90%; height: 230px; padding-top: 5px">
				<p align="center" style="color: red">
					<strike><%=dd.Format(sp.getGiaban())%></strike>
				</p>
				<p align="center" style="color: blue">
					<strong><%=dd.Format(sp.getGiagiam())%></strong>
				</p>
				<div align="center" style="height: 50px; color: black"><%=sp.getTensanpham()%></div>
			</a>
		</div>
		<%
			}
			}
		%>
	</div>
	<div align="center" style="padding: 50px">
		<%
			String record=(String)request.getAttribute("record");
			int reco=18;
			if(record!=null){
				reco=Integer.parseInt(record)+6;
			}
			if (size >11&&size<daosanpham.soluongSanpham()&&danhmuc==null&&bonho==null&&minprice==null&&maxprice==null) {
		%>
		<button onclick="xemThem(<%=reco%>)"
			style="border: 1px solid #FF8000; font-weight: 700; width: 300px; height: 40px; color: #FF8000;">Xem
			Thêm</button>
		<%
			}
		%>
	</div>
	<script>
			function xemThem(record) {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("top").innerHTML = this.responseText;
				}
			};
				xhttp.open("GET", "sanpham?record="+record, true);
				xhttp.send();
			}
		</script>
	<%@ include file="homefooter.jsp"%>