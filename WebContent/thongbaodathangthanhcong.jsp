<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="homeheader.jsp"%>
<div id="content" class="container" align="center" >
	<%
		String thongbao=(String)request.getAttribute("thongbao");
	%>
	<div style="height:400px;color:blue;font-weight:700;margin-top:100px">
	<%=thongbao %>
	</div>
<%@ include file="homefooter.jsp"%>