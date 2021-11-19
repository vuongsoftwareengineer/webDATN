<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật giá nhập</title>
<base href="${pageContext.servletContext.contextPath}/">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="jquery.uploadfile.js"></script>
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>

<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<style type="text/css">

.btn{
	background-color: #2e6f51;
	color: white;
}

.frm{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #2e6f51;
  border-radius: 4px;
}

.errors {
	color: red;
	font-style: italic;
}

.lb{
	font-weight: bold;
}


.bg {
	background-image: url("./images/them.jpg");
	width: 100%;
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
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
   <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
	
<h2 style="margin-left: 250px; font-style: italic;"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
	
		<div class="container">
		<h2 class="lb">Cập nhật giá nhập</h2>
		<form:form action="admin/capnhatgianhap/${gianhap.idHH}.html" method="post" modelAttribute="gianhap">
		<c:forEach var="p" items="${sanphams}">
				<c:if test="${p.id==gianhap.idHH}">
		<div class="container-fluid">
			<div class="row"> 
    		<div class="col-sm-6" style="background-color: white;  width: 70%">
		
			<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Hàng hóa</label>
				<br>
				<form:hidden class="frm" path="idHH" />
				<input readonly="readonly" class="frm" value="${p.id} - ${p.ten}"/>
				</div>
				<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Ngày áp dụng</label>
				<br>
				<input readonly="readonly" class="frm" value="${gianhap.ngayApDung}"/>
				</div>
				<div class="form-group">
				<label style="font-weight: bold;color: #FF6666" class="lb">Nhập vào giá nhập</label>
				<br>
				<form:input class="frm" path="gia" />
				</div>	
				<form:hidden path="ngayApDung" />
				
				</div>
				<div class="col-sm-4" style="background-color: white;">
				<img style="margin-top: 70px; width: 100%" src="./images/${p.anh}">
				</div>
				
				</div>
				
				</div>
			<div class="form-group">
			<br>
				<button class="btn" style="width: 50%; margin-left: 190px">Cập nhật giá nhập</button><br><br>
	</div>
	</c:if></c:forEach>
	</form:form>
	</div>
	</div>

</body>
</html>