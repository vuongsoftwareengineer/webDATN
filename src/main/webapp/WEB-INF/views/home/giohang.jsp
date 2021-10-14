<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%-- 
<c:url value="http://localhost:8080/img" var="url"></c:url> --%>
<!DOCTYPE html>
<html>
	<head>
<jsp:include page="stylebanhang.css"></jsp:include>
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
	background-image: url("images/anhbg2.png");
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
			<a href="#" class="dropdown-toggle hyper" data-toggle="dropdown" ><span><font color="black"><img src="./images/user.png" style="width: 40px">
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
										
					<li><a href="home/thaydoiuser/${sessionScope.taikhoan.getId()}.html"><img src="./images/carttime.png" style="width: 50px">Thay đổi thông tin</a> </li>
					<li><a href="home/lichsu.html"><img src="./images/carttime.png" style="width: 50px">Đơn hàng đã đặt</a> </li>
					<li><a href="home/doimk/${sessionScope.taikhoan.getId()}.html" onclick="if(!(confirm('Bạn có chắc chắn vào mục đổi mật khẩu không?'))) return false;">
					<img src="./images/changepass.jpg"style="width: 50px">Đổi mật khẩu</a></li>
					<li><a href="home/dangxuat.html" onclick="if(!(confirm('Bạn có chắc chắn  muốn đăng xuất hay không?'))) return false;">
					<img src="./images/logout.png"style="width: 50px">Đăng xuất</a></li>
			</ul>
</div>
</div>


<div class="col-sm-3 w3l">
				<a href=""><img src="./images/vuongdiep.jpg" class="img-responsive" alt=""></a>
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
			<br>
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
			
												<li><a href="home/sanpham/SP001.html"><i class="fa fa-list" aria-hidden="true"></i>Tảo xoắn Spirulina Nhật Bản 2200 viên</a></li>
												<li><a href="home/sanpham/SP002.html"><i class="fa fa-list" aria-hidden="true"></i>Viên uống hỗ trợ điều trị tai biến Orihiro</a></li>
												<li><a href="home/sanpham/SP022.html"><i class="fa fa-list" aria-hidden="true"></i>82x Nước Uống Placenta 450.000mg Tinh Chất Nhau Thai Heo 500ml</a></li>
												<li><a href="home/sanpham/SP004.html"><i class="fa fa-list" aria-hidden="true"></i>Bột uống chiết xuất từ rau xanh hữu cơ Orihiro Aojiru 30 gói</a></li>
												<li><a href="home/sanpham/SP010.html"><i class="fa fa-list" aria-hidden="true"></i>Viên ngậm lợi khuẩn</a></li>
												
</ul>
</div>
</div>


<div class="col-sm-3 w32">
<a href="home/sanpham/SP023.html"><img src="./images/banchay.png" class="img-responsive" alt=""></a>
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
			
												<li><a href="home/sanpham/SP005.html"><i class="fa fa-list" aria-hidden="true"></i>Combo 3 kem đánh răng Aquafresh</a></li>
												<li><a href="home/sanpham/SP008.html"><i class="fa fa-list" aria-hidden="true"></i>Nước uống bổ sung tế bào gốc Kinohimitsu</a></li>
												<li><a href="home/sanpham/SP012.html"><i class="fa fa-list" aria-hidden="true"></i>Băng dính nhôm dán kẽ hở Nhật Bản 2m</a></li>
												<li><a href="home/sanpham/SP015.html"><i class="fa fa-list" aria-hidden="true"></i>Khẩu trang kháng khuẩn, chống UV Pitta</a></li>
												<li><a href="home/sanpham/SP017.html"><i class="fa fa-list" aria-hidden="true"></i>Thẻ đeo diệt Virus kháng khuẩn TOAMIT</a></li>
												
</ul>
</div>
</div>


<div class="col-sm-3 w33">
<a href="home/sanpham/SP017.html"><img src="./images/thedeo.png" class="img-responsive" alt=""></a>
				
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
		<div class="dropdown">
		<a href="mycart.html"><i class="fa fa-shopping-cart"></i></a></div>
	</nav>


	</div>
<!-- 	<div class="dropdown" style="margin-left: 70px">
						<a href="home/sptheogia1/1.html"
							style="color: red; text-decoration: none">Sản phẩm có giá từ 0 đến 500.000 đồng</a>
		</div>
		
		<div class="dropdown" style="margin-left: 40px">
						<a href="home/sptheogia2/2.html"
							style="color: red; text-decoration: none">Sản phẩm có giá từ 500.000 đồng đến 4 triệu đồng</a>
		</div> -->
<div  class="bg1">
<h4 class="text-center" style="color: darkblue;margin-top: 7px;">Giỏ hàng của bạn</h4>
<div class="container" style="margin-top: 0px;margin-left: 312px; background-color: white;">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover table-bordered table-responsive" style="margin-top: 25px;">
                <thead>
                    <tr>
                    	<th class="text-center">STT</th>
                        <th class="text-center">Tên sản phẩm</th>
                          <th class="text-center">Số lượng</th>
                        <th class="text-center" >Giá</th>
                        <th class="text-center">Số tiền</th>
                        <th class="text-center"> </th>
                        <th class="text-center"> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="u" items="${mycart.cartLines}" varStatus="status">
                    <tr>
                    	<td>${status.index+1}</td>
                       <td class="col-sm-8 col-md-6">
	                        <div class="media">
	                            <a class="thumbnail pull-left" href="home/sanpham/${u.productInfo.id}.html"> <img class="media-object" src="./images/${u.productInfo.anh}" style="width: 70px; height: 70px;"> </a>
	                            <div class="media-body" style="padding-top: 20px; padding-left: 10px;">
	                                <h4 class="media-heading"><a href="home/sanpham/${u.productInfo.id}.html">${u.productInfo.ten}</a></h4>
	                            </div>
	                        </div>
                    	</td>
                        
                       <td><input id="quantity" readonly class="input-quantity"
							style="width: 54px; text-align: center;" value="${u.quantity}">

							<script type="text/javascript">
								$(document).ready(
										function() {
											loadFunction();// auto render
											// AUTO DETECT //
											function loadFunction(){
												var quantity = $('.input-quantity').val();
												
												if (quantity == 1){
													$('#sub').css("pointer-events","none");
												} else {
													$('#sub').css("pointer-events","auto");
												}
											}
											
											
										});
							</script>
							
							
								<a id="add" href="quantityChange.html?id=${u.productInfo.id}&quantity=${u.quantity + 1}"><button> + </button></a>
									
								<a id="sub" href="quantityChange.html?id=${u.productInfo.id}&quantity=${u.quantity - 1}"><button> - </button></a>
									
							</td>
 					<td class="col-sm-1 col-md-1 text-center"><strong>${u.productInfo.gia} đ</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${u.amount } đ</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <a><button type="button" class="btn btn-danger">
                           Xoá
                        </button></a></td>
                        <td><input type="submit" class="btn btn-info" value="Cập nhật"></td>
                    	
                    </tr>
                 </c:forEach>
                 
                   
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h4 class="text-center">Tổng</h4></td>
                        <td class="text-right"><h5><strong>${mycart.amountTotal} VNĐ</strong></h5></td>
                        <td>   </td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h4 class="text-center">Khuyến mại</h4></td>
                        <td class="text-right"><h5><strong>0 đ</strong></h5></td>
                        <td>   </td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td ><h3 class="text-center">Tổng số tiền</h3></td>
                        <td class="text-right"><h4><strong>${mycart.amountTotal} VNĐ</strong></h4></td>
                        <td>   </td>
                        <td>   </td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="home/index.html"><button class="text-center">Tiếp tục mua hàng</button></a></td>
                        <td>
                        
           <form:form action="myoder.html" modelAttribute="orderdetail">
			<button  class="btn btn-primary bt ">Đặt hàng</button>
		
		</form:form>
                        <td>   </td>
                        <td>   </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>