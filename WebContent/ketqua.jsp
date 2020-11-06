<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Sanpham" %>
<%@page import="java.util.List" %>

<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
	<%
		String thongbao=(String)request.getAttribute("thongbao");
	%>
	<div style="color: #8A4B08; font-weight: 700;margin:20px auto;">
		<%=thongbao %><strong style="color: red"></strong>
	</div>
</div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>