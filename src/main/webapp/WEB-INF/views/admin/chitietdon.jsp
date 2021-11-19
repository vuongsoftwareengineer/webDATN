<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DANH SÁCH CHI TIẾT ĐƠN HÀNG</title>

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
<h2 style="font-weight: bold;color: #FF6666">DANH SÁCH CHI TIẾT ĐƠN HÀNG</h2>
			<div>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
		<th>Mã Chi Tiết Đơn Hàng</th>
         <th align="center">Sản phẩm</th>
        <th>Ảnh Sản phẩm</th>
        <th>Số Lượng Đặt</th>
        <th>Mã Đơn Hàng</th>
        <th>Mã Tài Khoản</th>
        <th>Thành tiền</th>
        <th>Ngày đặt</th>
       </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${chitietdons}">
     <c:forEach var="v" items="${sanphams}">
		<c:if test="${v.id==p.idHH}">
      <tr>
        <td width="60px">${p.id}</td>
        <td width="200px"><b>${p.idHH}</b>-${v.ten}</td>
		<td width="180px"><img src="./images/${v.anh}" style="width: 50%">
        <td width="120px">${p.soLuong}</td>
        <td width="140px">${p.idPhieuDatHang}</td>
         <c:forEach var="t" items="${donhangs}">
        <c:if test="${p.idPhieuDatHang == t.id}">
        <td width="160px">${t.taiKhoanId}</td>
        <td><f:formatNumber minFractionDigits="0" value="${v.gia*p.soLuong}" type="number"/>đ</td>
        <td width="190px"><f:formatDate pattern="dd-MM-yyyy" value="${t.ngayLap}"/></td></c:if>
         </c:forEach>
      	</tr>
      	</c:if>
      </c:forEach>
      </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</div>
</body>
</html>