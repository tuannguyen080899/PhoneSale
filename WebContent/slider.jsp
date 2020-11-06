<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Slider" %>
<%@ page import="dao.DaoSlider" %>
<div id="slider" class="container" style="padding: 15px 0">
		<div class="row">
			<div class="col-sm-7">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<%
						List<Slider>listsli;
						DaoSlider daosl=new DaoSlider();
						listsli=daosl.getAllSliderShow();
						
					%>
					<div class="carousel-inner" role="listbox">
					<div class="item active">
							<img src="images/slider/<%=listsli.get(0).getAnh()%>">
							<div class="carousel-caption"><%=listsli.get(0).getTitle()%></div>
						</div>
					<%
						for(int i=1;i<listsli.size();i++){
					%>
						<div class="item">
							<img src="images/slider/<%=listsli.get(i).getAnh()%>">
							<div class="carousel-caption"><%=listsli.get(i).getTitle() %></div>
						</div>
					<%} %>
					</div>
					<a href="#carousel-example-generic" class="left carousel-control"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a href="#carousel-example-generic" class="right carousel-control"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>

				</div>
			</div>
			<div class="col-sm-4"
				style="border-collapse: collapse; border: 0.1px solid black; padding-top: 25px; margin-left: 85px">
				<div style="margin-left: 15px">
					<p style="float: left; font-weight: 700; color: red;">Tin Công
						Nghệ</p>
					<p style="text-align: right;">
						<a style="color: blue" href="">Xem tất cả</a>
					</p>
					<a href="">
						<div class="col-sm-4">
							<img src="images/tintuc.jpg" style="width: 90px; height: 60px;">
						</div>
						<div class="col-sm-8">
							<p>Khám phá địa chỉ mua điện thoại Oppo chính hãng giá rẻ,
								uy tín số 1 tại Đà Nẵng</p>
						</div>
					</a> <a href="">
						<div class="col-sm-4">
							<img src="images/tintuc.jpg" style="width: 90px; height: 60px">
						</div>
						<div class="col-sm-8">
							<p>Khám phá địa chỉ mua điện thoại Oppo chính hãng giá rẻ, uy
								tín số 1 tại Đà Nẵng</p>
						</div>
					</a> <a href="">
						<div class="col-sm-4">
							<img src="images/tintuc.jpg" style="width: 90px; height: 60px">
						</div>
						<div class="col-sm-8">
							<p>Khám phá địa chỉ mua điện thoại Oppo chính hãng giá rẻ, uy
								tín số 1 tại Đà Nẵng</p>
						</div>
					</a>
				</div>

			</div>
		</div>
	</div>