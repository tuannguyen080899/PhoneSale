<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Muahang" %>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px" >
					<div style="color: #8A4B08;font-weight: 700;">Danh sách đơn hàng đã đặt !</div>
					<div class="row"style="margin-top: 20px;background-image: linear-gradient(to right,#F2F2F2,#F2F2F2);">
						<div class="col-sm-3">
							<strong>Mã đơn hàng</strong>
						</div>
						<div class="col-sm-3">
							<strong>Tài khoản</strong>
						</div>	
						<div class="col-sm-3">
							<strong>Thời gian</strong>
						</div>
					</div>
					<%
						List<Muahang>listmuahang=(List)request.getAttribute("list");
						for(Muahang muahang:listmuahang){
					%>
					<div class="row" style="margin-top: 20px">
						<div class="col-sm-3">
							<small><%=muahang.getMamuahang() %></small>
						</div>
						<div class="col-sm-3">
							<small><%=muahang.getUsername() %></small>
						</div>
						<div class="col-sm-3">
							<small><%=muahang.getThoigian() %></small>
						</div>
						<div class="col-sm-1">
							<a title="chi tiết" href="detaildonhang?mamuahang=<%=muahang.getMamuahang()%>&username=<%=muahang.getUsername()%>"><img src="images/detail.jpg" alt="chi tiết" style="width: 18px;height: 18px"></a>
						</div>
						<div class="col-sm-1">
							<a  title="hàng đã giao"href="vanchuyen?mamuahang=<%=muahang.getMamuahang()%>"><img src="images/vanchuyen.png" style="width: 18px;height: 18px" alt="hàng đã giao"></a>
						</div>
						<div class="col-sm-1">
							<a href=""><img src="images/xoa.png" style="width: 18px;height: 18px"></a>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
<%@ include file="quanlyfooter.jsp"%>