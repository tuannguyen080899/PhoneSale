
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Slider"%>
<%@ include file="quanlyheader.jsp"%>
<div style="margin-top: 20px">
					<p style="color: #8A4B08;font-weight: 700">Danh sách slider!</p>
					<div class="row" style="background-image: linear-gradient(to right,#F2F2F2,#F2F2F2);">
					
						<div class="col-sm-4">
							Title
						</div>
						<div class="col-sm-2">
							Trạng thái
						</div>
						<div class="col-sm-6">
							Hình ảnh
						</div>
					</div>
					<%
						List<Slider>listslider=(List)request.getAttribute("slider");
						for(Slider sl:listslider){
					%>
					<hr/>
					
					<div class="row">
						<div class="col-sm-4">
							<p><%=sl.getTitle()%></p>
							<hr/>
							<p >
								<a href=""><img src="images/xoa.png"style="width: 20px;height: 20px"></a>
								<a href="chinhsuaslider?maslider=<%=sl.getMaslider()%>"><img src="images/edit.png"style="width: 20px;height: 20px;margin-left: 20px"></a>
							</p>
						</div>
						<div class="col-sm-2">
							<p><%=(sl.isTrangthai()==true)?"Hiển thị":"Không hiện thị" %></p>
						</div>
						<div class="col-sm-6">
							<a href="chinhsuanhslider?maslider=<%=sl.getMaslider()%>">
							<%
								if(sl.getAnh()==null){
							%>
							<p>Cập nhật</p>
							<%
								}else{
							%>
							<img src="images/slider/<%=sl.getAnh()%>" style="width: 100%;height: 110px">
							<%
								}
							%>
							</a>
						</div>
					</div>
					<%} %>
				</div>
				<div style="margin-top:20px">Thêm slider. <a href="chinhsuaslider">Tại đây</a></div>
</div>
</div>
<%@ include file="quanlyfooter.jsp"%>