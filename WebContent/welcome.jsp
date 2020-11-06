<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Sanpham"%>
<%@page import="dao.DaoSanpham"%>
<%@ include file="homeheader.jsp"%>
<%@ include file="slider.jsp"%>
<div id="content" class="container">
		<style type="text/css">
			#sanpham:hover{
				background-color:#E3F6CE;
				padding-left:1px;
				padding-right:1px;
		</style>
		<div class="row">
			<div style="font-size: 16px;margin-top: 20px;padding: 10px;background-color: #F7D358"><strong>Điện thoại hot nhất</strong></div>
		</div>
		<div class="row" style="padding: 10px">
		<%
			Dinhdangtien dd=new Dinhdangtien();
			List<Sanpham> listw;
			DaoSanpham daow=new DaoSanpham();
			listw=daow.getAllSanphamQuangcao(12);
			for(Sanpham sp:listw){
		%>
			<div class="col-sm-3" id="sanpham">
				<a href="showSanpham?masanpham=<%=sp.getMasanpham() %>"
				style="text-decoration: none;"> <img
				src="images/anhquangcao/<%=sp.getAnhquangcao() %>"
				style="width:100%; height: 200px; padding-top: 5px">
				<p align="center" style="color: red">
					<strike> <%=dd.Format(sp.getGiaban()) %></strike>
				</p>
				<p align="center" style="color: blue">
					<strong><%=dd.Format(sp.getGiagiam())%></strong>
				</p>
				<div align="center" style="height: 50px; color: black"><%=sp.getTensanpham() %></div>
				</a>
			</div>
			<% } %>
		</div>
<%@ include file="homefooter.jsp"%>