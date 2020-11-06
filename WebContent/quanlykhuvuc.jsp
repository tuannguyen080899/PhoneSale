<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Tinh" %>
<%@page import="java.util.List" %>

<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<div style="color: #8A4B08; font-weight: 700;">
		Danh sách khu vực !<strong style="color: red"></strong>
	</div>
	<%
		List<Tinh>list=(List)request.getAttribute("khuvuc");
		
	%>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-2">
			<strong>Mã khu vực</strong>
		</div>
		<div class="col-sm-3">
			<strong>Tên khu vực</strong>
		</div>
		<div class="col-sm-3">
			<strong>Cước phý</strong>
		</div>
	</div>
	<%
		for(Tinh tinh:list){
	%>
	<div class="row" style="margin-top: 20px">
		<div class="col-sm-2">
			<small><%=tinh.getMakhuvuc() %></small>
		</div>
		<div class="col-sm-3">
			<small><%=tinh.getTenkhuvuc()%></small>
		</div>
		<div class="col-sm-4">
			<small><%=tinh.getCuocphy()%></small>
		</div>
		<div class="col-sm-1">
			<a href="chinhsuakhuvuc?id=<%=tinh.getMakhuvuc()%>"><img src="images/edit.png"
				style="width: 18px; height: 18px"></a>
		</div>
		<div class="col-sm-1">
			<a href="deleteKhuvuc?id=<%=tinh.getMakhuvuc()%>"><img src="images/xoa.png"
				style="width: 18px; height: 18px"></a>
		</div>
	</div>
	<%
		}
	%>
	<div style="margin-top: 20px; color: #886A08">
		Thêm khu vực.<a href="chinhsuakhuvuc">Tại đây</a>
	</div>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>