<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm phiếu nhập, chi tiết phiếu nhập</title>
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
    <a href="admin/taikhoan.html"><i class="far fa-list-alt"></i>Tài khoản người dùng</a>
    <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
	
<h2 style="margin-left: 250px; font-style: italic;"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
	
		<div class="container">
		<h2 class="lb">Thêm phiếu nhập, chi tiết phiếu nhập</h2><h6 style="color: red">${message}</h6> 
	<form:form action="admin/thempn.html" method="post" modelAttribute="chitietnhaphang" enctype="multipart/form-data">
	
	<div class="container-fluid">
		<div class="row">
			<div style=" margin-left: 30px">
			<h3 style="text-align: center;">THÔNG TIN NHẬP HÀNG</h3>
			
			<div class="form-group">
				<label class="lb">Chọn hàng hóa</label><br>
				<form:select path="idhh">
				<form:options items="${sanphams}" itemValue="id" itemLabel="id"/>
				
				</form:select>
				
			</div>
			<div class="form-group">
			<label class="lb">Chọn giá cho hàng hóa</label><br>
			<select name="giaHH">
          <c:forEach var="p" items="${gias}">
          <c:forEach var="v" items="${sanphams}">
				<c:if test="${v.id==p.idHH}">
            <option class="frm" value="${p.gia}">${p.idHH}-Giá tiền:<fmt:formatNumber minFractionDigits="0" value="${p.gia}"/>đ- Tên sản phẩm: ${v.ten}</option>
            </c:if></c:forEach>
          </c:forEach>
        </select>
        </div></div>
			
			</div>
			<br>
				<label style=" margin-left: 18px"><b>Số lượng nhập hàng: </b></label><i class="fa fa-exchange" aria-hidden="true"></i>
				<input name="soLuongNhap" type="number" min="1" max="200"/>
				<br>
	<br><button style="width: 44.5%; margin-left: 16px"><b>Nhập hàng</b></button>
	<br><br>
	</div></form:form></div></div>
</body>
</html>