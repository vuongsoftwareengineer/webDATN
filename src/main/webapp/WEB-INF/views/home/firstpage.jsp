<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Khánh Vương Store: Website bán hàng tiêu dùng</title>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<link href="styleweb.css" rel='stylesheet' type='text/css' />
  
  <style type="text/css">
.bg1 {
    background-image: url('images/anhbg2.png');
}

.bg {
    background-image: url('images/metqua.png');
}

.errors {
	color: red;
	font-style: italic;
}

.icon1 {
	padding: 10px;
	background: brown;
	color: white;
	min-width: 50px;
	text-align: center;
	border-radius: 4px;
	height: 40px;
}



.frm {
	width: 30%;
	height: 40px;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #2e6f51;
	border-radius: 4px;
}
	.bg2 {
	background-image: url("./images/ds.jpg");
	width: 100%;
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}


</style>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>

<div class="bg1">
		<div class="container">

   <h8><font color="black"><marquee>CHẤT LƯỢNG CHÚNG TÔI GỬI ĐI & NIỀM TIN BẠN NHẬN ĐƯỢC</marquee></font></h8>
   
   		<c:if test="${ktdangnhap == false}">
			<H7><a href="home/dangnhap.html" ><i class="fa fa-user" aria-hidden="true" style="text-align: center; margin-right: 40px">Đăng nhập</i></a></H7>
			<H7><a href="home/dangki.html" ><i class="fa fa-arrow-right" aria-hidden="true" style="text-align: center; margin-right: 40px">Đăng kí </i></a></H7>
		</c:if>
					<H7><a href="home/thongtin.html" ><i class="fa fa-file-text-o" aria-hidden="true" style="text-align: center; margin-right: 40px"><b>Giới Thiệu Chúng Tôi</b></i></a></H7>
						<c:if test="${ktdangnhap == true}">
			<a href="#" class="dropdown-toggle hyper" data-toggle="dropdown" ><span><font color="black"><img src="./images/${sessionScope.taikhoan.getAnh()}" style="width: 40px">
				<h7><b class="caret">Chào mừng Khách Hàng - ${sessionScope.taikhoan.getHoTen()}</b></h7></font></span></a>
								<ul class="dropdown-menu multi">
									<div class="row">
									<div class="col-sm-3 w3l">
										<div class="dropdown">
											<ul class="multi-column-dropdown">	
											<li>							
				<label><b>Mã tài khoản: </b> ${sessionScope.taikhoan.getId()}</label>
				<br>
				<label><b>Họ tên Khách hàng: </b> ${sessionScope.taikhoan.getHoTen()}</label>
				<br>
				<label><b>Số điện thoại: </b> ${sessionScope.taikhoan.getSdt()}</label>
				<br>
				<label><b>Địa chỉ: </b> ${sessionScope.taikhoan.getDiaChi()}</label>
				<br>
				<label><b>Email: </b> ${sessionScope.taikhoan.getEmail()}</label>
				</li>
										
					<li><a href="home/thaydoiuser/${sessionScope.taikhoan.getId()}.html"><img src="./images/logouser.png" style="width: 50px">Thay đổi thông tin</a> </li>
					<li><a href="home/lichsu.html"><img src="./images/carttime.png" style="width: 50px">Đơn hàng đã đặt</a> </li>
					<li><a href="home/doimk/${sessionScope.taikhoan.getId()}.html" onclick="if(!(confirm('Bạn có chắc chắn vào mục đổi mật khẩu không?'))) return false;">
					<img src="./images/changepass.jpg"style="width: 50px">Đổi mật khẩu</a></li>
					<li><a href="home/dangxuat.html" onclick="if(!(confirm('Bạn có chắc chắn  muốn đăng xuất hay không?'))) return false;">
					<img src="./images/logout.png"style="width: 50px">Đăng xuất</a></li>
			</ul>
</div>
</div>


<div class="col-sm-3 w3l" >
				<a href=""><img src="./images/${sessionScope.taikhoan.getAnh()}" style="margin-left: 98px" class="img-responsive" alt=""></a>
				</div>
			
</ul>
			
					</c:if>
					<br>
					<span><b>Mạng Xã Hội:</b></span>
					<a href="https://www.facebook.com/hoangvuong.dkhanh" class="icon facebook"><i class="fa fa-facebook" aria-hidden="true"></i>&nbsp;<span></span></a>
					<a href="https://www.instagram.com/khanhvuong.diep" class="icon instagram"><i class="fa fa-instagram" aria-hidden="true"></i>&nbsp;<span></span></a>
					<a href="https://www.pinterest.com/khanhvuongptithcm" class="icon pinterest"><i class="fa fa-pinterest-p" aria-hidden="true"></i>&nbsp;</a><span></span>
			<a href="tel:0817581018" style="margin-left: 75px"><span><b>HOTLINE: 0817581018</b></span></a>
			<H7><a href="home/lienhe.html" style="margin-left: 30px"><i class="fa fa-file-text-o" aria-hidden="true" style="text-align: center"><b>Trang Liên Hệ</b></i></a></H7>
			</div>
			</div>
<div data-vide-bg="images/videoheader">
<script>window.jQuery || document.write('<script src="./js/jquery-1.11.1.min.js"><\/script>')</script>
    <script src="./js/jquery.vide.min.js"></script>
    <div class="container">
		<div class="banner-info">
		<h1>&nbsp;</h1>
		<h1>&nbsp;</h1>
		<h1 style="text-align: center"><font color="white"><marquee behavior="alternate">Website bán hàng tiêu dùng</marquee></font></h1>
		<h1>&nbsp;</h1>
		<h1>&nbsp;</h1>
				
			</div>		
		</div>	
    </div>

 <div class="header bg1">
	<nav class="navbar navbar-expand-sm bg" style="width: 100%">
			<div class="dropup" style="margin-left:  0px">
					<a href="home/index.html"><img src="./images/logos.png" style="margin-left: -12px"></a>
					</div>
	<div class="dropdown" style="margin-left: 12px">
								<a href="#" class="dropdown-toggle hyper" data-toggle="dropdown" ><span><font color="black">SẢN PHẨM</font><b class="caret"></b></span></a>
								<ul class="dropdown-menu multi">
									<div class="row">
									<div class="col-sm-3 w3l">
										<div class="dropdown">
											<ul class="multi-column-dropdown">
			
												<li><a href="home/theloai/1.html"><i class="fa fa-list" aria-hidden="true"></i>Thực phẩm chức năng</a></li>
												<li><a href="home/theloai/2.html"><i class="fa fa-list" aria-hidden="true"></i>Chăm sóc sức khỏe</a></li>
												<li><a href="home/theloai/3.html"><i class="fa fa-list" aria-hidden="true"></i>Vệ sinh nhà cửa</a></li>
												<li><a href="home/theloai/4.html"><i class="fa fa-list" aria-hidden="true"></i>Phòng dịch Covid</a></li>
												<li><a href="home/theloai/5.html"><i class="fa fa-list" aria-hidden="true"></i>Chăm sóc cơ thể</a></li>
												<li><a href="home/theloai/6.html"><i class="fa fa-list" aria-hidden="true"></i>Mẹ và bé</a></li>
</ul>
</div>
</div>


<div class="col-sm-3 w3l">
<a href="home/sanpham/3.html"><img src="./images/taovang.jpg" class="img-responsive" alt=""></a>
				</div>
			
</ul>
</div>
<div class="dropdown" style="margin-left: 0px">
								<a href="#" class="dropdown-toggle hyper" data-toggle="dropdown" ><span><font color="black">BÁN CHẠY</font><b class="caret"></b></span></a>
								<ul class="dropdown-menu multi multi1">
									<div class="row">
									<div class="col-sm-3 w3l">
										<div class="dropdown">
											<ul class="multi-column-dropdown">
			
												<li><a href="home/sanpham/HH001.html"><i class="fa fa-list" aria-hidden="true"></i>Tảo xoắn Spirulina Nhật Bản 2200 viên</a></li>
												<li><a href="home/sanpham/HH002.html"><i class="fa fa-list" aria-hidden="true"></i>Viên uống hỗ trợ điều trị tai biến Orihiro</a></li>
												<li><a href="home/sanpham/HH022.html"><i class="fa fa-list" aria-hidden="true"></i>82x Nước Uống Placenta 450.000mg Tinh Chất Nhau Thai Heo 500ml</a></li>
												<li><a href="home/sanpham/HH004.html"><i class="fa fa-list" aria-hidden="true"></i>Bột uống chiết xuất từ rau xanh hữu cơ Orihiro Aojiru 30 gói</a></li>
												<li><a href="home/sanpham/HH010.html"><i class="fa fa-list" aria-hidden="true"></i>Viên ngậm lợi khuẩn</a></li>
												
</ul>
</div>
</div>


<div class="col-sm-3 w32">
<a href="home/sanpham/HH023.html"><img src="./images/banchay.png" class="img-responsive" alt=""></a>
				</div>
				
			
</ul>
</div>
<div class="dropdown" style="margin-left: 0px">
								<a href="#" class="dropdown-toggle hyper" data-toggle="dropdown" ><span><font color="black">HÀNG MỚI VỀ</font><b class="caret"></b></span></a>
								<ul class="dropdown-menu multi">
									<div class="row">
									<div class="col-sm-3 w3l">
										<div class="dropdown">
											<ul class="multi-column-dropdown">
			
												<li><a href="home/sanpham/HH005.html"><i class="fa fa-list" aria-hidden="true"></i>Combo 3 kem đánh răng Aquafresh</a></li>
												<li><a href="home/sanpham/HH008.html"><i class="fa fa-list" aria-hidden="true"></i>Nước uống bổ sung tế bào gốc Kinohimitsu</a></li>
												<li><a href="home/sanpham/HH012.html"><i class="fa fa-list" aria-hidden="true"></i>Băng dính nhôm dán kẽ hở Nhật Bản 2m</a></li>
												<li><a href="home/sanpham/HH015.html"><i class="fa fa-list" aria-hidden="true"></i>Khẩu trang kháng khuẩn, chống UV Pitta</a></li>
												<li><a href="home/sanpham/HH017.html"><i class="fa fa-list" aria-hidden="true"></i>Thẻ đeo diệt Virus kháng khuẩn TOAMIT</a></li>
												
</ul>
</div>
</div>


<div class="col-sm-3 w33">
<a href="home/sanpham/HH017.html"><img src="./images/thedeo.png" class="img-responsive" alt=""></a>
				
			</div>
</ul>
</div>


<div class="dropdown" style="margin-left: 0px">
						<a href="home/tintuc.html"
							style="color: black; text-decoration: none">Tin Tức</a>
</div>
		
		<div class="dropdown" style="margin-left: 40px">
						<a href="home/thuonghieu.html"
							style="color: black; text-decoration: none">Thương Hiệu</a>
		</div>
		
		<div class="dropdown" style="margin-left: 40px">
		<form class="form-inline" action="home/timkiem.html">
			<input class="form-control mr-sm-2" type="text" style="width: 198px"
				placeholder="Bạn muốn mua gì?" name="timkiem">
			<button type="submit"
				style="height: 30px"><font color="#800000">Tìm kiếm</font></button>
		</form>
		</div>
		<div class="dropdown" style="margin-left: 12px">
		<a href="mycart.html"><i class="fa fa-shopping-cart icon1"></i></a></div>
	</nav>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
				<div class="carousel-item active"><a href="home/sanpham/HH004.html">
				<img src="./images/00.png" style="width: 100%; height: 498px"></a>
			</div>

			<div class="carousel-item"><a href="home/sanpham/HH001.html">
				<img src="./images/slide.jpg" style="width: 100%; height: 498px"></a>
			</div>

			<div class="carousel-item"><a href="home/sanpham/HH022.html">
				<img src="./images/slide1.jpg" style="width: 100%; height: 498px"></a>
			</div>
			<div class="carousel-item"><a href="home/sanpham/HH018.html">
				<img src="./images/slide2.jpg" style="width: 100%; height: 498px"></a>
			</div>
			<div class="carousel-item"><a href="home/sanpham/HH002.html">
				<img src="./images/slide3.jpg" style="width: 100%; height: 498px"></a>
			</div>
			
		</div>
		<ul class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
		</ul>
</div>
	</div>
	<div class="dropdown" style="margin-left: 70px">
						<a href="home/sptheogia1/1.html"
							style="color: red; text-decoration: none">Sản phẩm có giá từ 0 đến 500.000 đồng</a>
		</div>
		
		<div class="dropdown" style="margin-left: 40px">
						<a href="home/sptheogia2/2.html"
							style="color: red; text-decoration: none">Sản phẩm có giá từ 500.000 đồng đến 4 triệu đồng</a>
		</div>
	</body>
	</html>