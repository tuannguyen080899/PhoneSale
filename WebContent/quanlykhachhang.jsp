<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Taikhoan" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px" >
					<div style="color: #8A4B08;font-weight: 700;">Danh sách khách hàng !</div>
					<div class="row"style="margin-top: 20px;background-image: linear-gradient(to right,#F2F2F2,#F2F2F2);">
						<div class="col-sm-2">
							<strong>Tài khoản</strong>
						</div>
						<div class="col-sm-2">
							<strong>Tên khách hàng</strong>
						</div>	
						<div class="col-sm-2">
							<strong>Email</strong>
						</div>
						<div class="col-sm-2">
							<strong>Số điện thoại</strong>
						</div>
						<div class="col-sm-2">
							<strong>Địa chỉ</strong>
						</div>	
					</div>
					<%
					List<Taikhoan>listtk=(List)request.getAttribute("tk");
					for(Taikhoan tk:listtk){
					%>
					<div class="row" style="margin-top: 20px">
						<div class="col-sm-2">
							<small><%=tk.getUsername() %></small>
						</div>
						<div class="col-sm-2">
							<small><%=tk.getTenkhachhang() %></small>
						</div>
						<div class="col-sm-2">
							<small><%=tk.getEmail()%></small>
						</div>
						<div class="col-sm-2">
							<small><%=tk.getSodienthoai()%></small>
						</div>
						<div class="col-sm-2">
							<small><%=tk.getDiachi()%></small>
						</div>
						<div class="col-sm-1">
							<a href="deletekhachhang?username=<%=tk.getUsername()%>"><img src="images/xoa.png" style="width: 18px;height: 18px"></a>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
<%@ include file="quanlyfooter.jsp"%>