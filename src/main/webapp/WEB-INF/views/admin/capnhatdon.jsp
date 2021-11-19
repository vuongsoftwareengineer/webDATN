<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <c:url value="http://localhost:8080/img" var="url"></c:url> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cập nhật đơn hàng</title>
<base href="${pageContext.servletContext.contextPath}/">
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<style type="text/css">

.btn{
	background-color: #2e6f51;
	color: white;
}

.errors {
	color: red;
	font-style: italic;
}

.frm{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #2e6f51;
  border-radius: 4px;
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
		<h2 class="lb">Cập nhật/Xác nhận đơn hàng</h2>
		<p class="errors">${message}</p>
		<form:form action="admin/capnhatdon/${donhang.id}.html" method="post" modelAttribute="donhang" enctype="multipart/form-data">
			<div class="form-group">
				<label class="lb">Mã đơn hàng</label>
				<br>
				<form:input readonly="true" class="frm" path="id" />
			</div>
			<div class="form-group">
				<label class="lb"> Mã tài khoản</label>
				<br>
				<form:input class="frm" readonly="true" path="taiKhoanId" />
			</div>
			<div class="form-group">
				<label class="lb">Tổng tiền</label>
				<br>
				<form:input class="frm" readonly="true" path="tongTien" />
			</div>
			<form:hidden path="diachi" />
			<div class="form-group">
			<c:if test="${donhang.trangThai <=2 && donhang.trangThai >-1}">
			<label class="lb">Trạng thái</label>
				<form:select path="trangThai">
				<option value="1">Xác nhận đơn hàng</option>
				<option value="2">Đang giao hàng</option>
				<option value="3">Đã hoàn thành</option>
				<option value="4">Giao hàng không thành công</option>
				</form:select>
							<br>
				<button class="btn" style="width: 50%">Xác nhận cập nhật đơn hàng</button>
		
				</c:if>
				<c:if test="${donhang.trangThai >2 || donhang.trangThai <0}">
				<label class="lb"><font color="red">Không thể cập nhật được trạng thái do đơn hàng: </font>
				<c:choose>
				<c:when test="${donhang.trangThai==3}"><b>Đã hoàn thành</b></c:when>
				<c:when test="${donhang.trangThai==-1}"><b>Đã hủy</b></c:when>
				<c:when test="${donhang.trangThai==4}"><b>Giao hàng không thành công</b></c:when>
				</c:choose></label></c:if>
				<br>	
			</div>
		</form:form>
		</div>
		</div>
</body>
</html>