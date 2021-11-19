<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DANH SÁCH CHI TIẾT NHẬP HÀNG</title>

<base href="${pageContext.servletContext.contextPath}/">
<link href="styleweb.css" rel='stylesheet' type='text/css' />
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<style type="text/css">

.bg {
	background-image: url("./images/moi.png");
	width: 100%;
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}
.frm1{
  width: 80%;
  padding: 7px 8px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #2e6f51;
  border-radius: 4px;
}
body {
	font-family: "Lato", sans-serif;
}
.lb{
	font-weight: bold;
}
</style>
</head>
<body>

<div class="sidebar">
  <a href="admin/index.html"><i class="fas fa-users"></i> Xin chào ${sessionScope.admin.getHoTen()} đã đến với trang quản trị
  </a><hr><p><a href="admin/sanpham.html"><i class="far fa-list-alt"></i> Danh sách sản phẩm</a></p>
  <p>
    <a href="admin/thuonghieu.html"><i class="far fa-list-alt"></i>Thương hiệu sản phẩm</a>
    <a href="admin/theloai.html"><i class="far fa-list-alt"></i>Thể loại sản phẩm</a>
    <a href="admin/taikhoan.html"><i class="far fa-list-alt"></i>Tài khoản người dùng</a>
    <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
<h2 style="margin-left: 250px; font-style: italic; color: #8B4513"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px; color: brown">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
		<div class="container">       <br>
<h2 style="font-weight: bold;color: #FF6666">DANH SÁCH CHI TIẾT NHẬP HÀNG</h2>
			<form:form action="admin/chitietnhap/${chitiet.id}.html" method="post" modelAttribute="chitiet" enctype="multipart/form-data">
				<c:forEach var="p" items="${sanphams}">
				<c:if test="${p.id==chitiet.idhh}">
    		<div class="container-fluid">
			<div class="row"> 
    		<div class="col-sm-6" style="background-color: white;">
			<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Mã chi tiết nhập hàng</label>
				<br>
				<label class="frm1" style="color: black">${chitiet.id}</label>
			</div>
					<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb"> Tên hàng hóa</label>
				<br>
				<label class="frm1" style="color: black">${chitiet.idhh}-${p.ten}</label>
				
			</div>
			<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Số lượng Nhập</label>
				<br>
				<form:input class="frm1" readonly="true" path="soLuong" />
			</div>
			<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Thành tiền</label>
				<br>
				
			<label class="frm1" style="color: black"><f:formatNumber minFractionDigits="0" value="${gianhap.gia*chitiet.soLuong}" type="number"/>đ</label>
			</div>
			<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Mã phiếu nhập hàng</label>
				<br>
				<form:input class="frm1" readonly="true" path="idPhieuNhapHang" />
			</div>
			</div>
			<div class="col-sm-6" style="background-color: white;">
			<img style="margin-left: 0px; width: 100%" src="./images/${p.anh}"></div>
			</div></div>
			
			</c:if></c:forEach>
		
</form:form></div></div>
</body>
</html>