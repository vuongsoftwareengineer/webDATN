<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DANH SÁCH TÀI KHOẢN KHÁCH HÀNG</title>

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
    <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
 <h2 style="margin-left: 250px; font-style: italic; color: #8B4513"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px; color: brown">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
		<div class="container">       <br>
<h2 style="font-weight: bold;color: #FF6666">DANH SÁCH TÀI KHOẢN KHÁCH HÀNG</h2><h6 style="color: red">${message}</h6>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
		<th>Mã Tài Khoản</th>
        <th>Họ Tên</th>
        <th>Số điện thoại</th>
        <th>Địa Chỉ</th>
        <th>Email</th>
        <th>Username</th>
        <th>Quyền</th>
        <th>Trạng thái</th>
        <th>Khóa/Mở khóa</th>
       	<th>Xóa</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${taikhoans}">
    <c:if test="${p.quyen != 'ADMIN' &&p.quyen!='STAFF'}">
      <tr>
        <td>${p.id}</td>
        <td>${p.hoTen}</td>
        <td>${p.sdt}</td>
        <td>${p.diaChi}</td> 
        <td>${p.email}</td>
        <td>${p.username}</td>
        <td>${p.quyen}</td>
        <td><c:choose>
				<c:when test="${p.trangThai==0}">Đã khóa</c:when>
				<c:when test="${p.trangThai==1}">Hoạt động</c:when>
				</c:choose>
				</td>
		<c:if test="${p.trangThai == 1}">
        <td><div align="center"><a href="admin/capnhattk/${p.id}.html" onclick="if(!(confirm('Bạn có chắc chắn muốn cập nhật khóa tài khoản này không?'))) return false;">Khóa</a></div></td> 
     	</c:if>
       <c:if test="${p.trangThai == 0}">
        <td><div align="center"><a href="admin/capnhattk/${p.id}.html" onclick="if(!(confirm('Bạn có chắc chắn muốn cập nhật mở khóa tài khoản này không?'))) return false;">Mở khóa</a></div></td> 
     	<td><div align="center"><a href="admin/xoatk/${p.id}.html" onclick="if(!(confirm('Bạn có chắc chắn muốn xóa tài khoản này không?'))) return false;">Xóa</a></div></td>
     	</c:if>
       
        
			</tr>
		</c:if>
      </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>