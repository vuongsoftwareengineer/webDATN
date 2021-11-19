<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm sản phẩm mới</title>
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
		<h2 class="lb">Thêm sản phẩm</h2><h6 style="color: red">${message}</h6> 
		<form:form action="admin/themsp.html" method="post" modelAttribute="sanpham">
			<div class="form-group">
				<label class="lb">Mã sản phẩm</label>
				<br>
				<form:input class="frm" path="id" />
				<form:errors class="errors" path="id"/>
				</div>
				<div class="form-group">
				<label class="lb">Tên sản phẩm</label>
				<br>
				<form:input class="frm" path="ten" />
				<form:errors class="errors" path="ten"/>
					</div>
			<div class="form-group">
				<label class="lb">Giá tiền</label>
				<br>
				<form:input class="frm" type="number" min="0" path="gia" />
				<form:errors class="errors" path="gia"/>
				</div>
			
			<div class="form-group">
				<label class="lb">Thể loại</label>
				<form:select path="theLoaiId">
				<form:options items="${theloais}" itemValue="id" itemLabel="ten"/>
				</form:select>
			</div>
			<div class="form-group">
				<label class="lb">Mô tả</label>
				<br>
				<form:textarea class="frm" path="moTa" rows="7"/>
				<form:errors class="errors" path="moTa"/>
				</div>
			<div class="form-group">
			<label class="lb">Chọn hình ảnh</label><br>
			<form:input class="frm" type="file" path="anh"/>
			<form:errors class="errors" path="anh"/>
			</div>
											
			<div class="form-group">
				<label class="lb">Thương hiệu</label>
				<form:select path="thuongHieuId">
				<form:options items="${thuonghieus}" itemValue="id" itemLabel="ten"/>
				</form:select>
			</div>
			<div class="form-group">
				<label class="lb">Số lượng Tồn</label>
				<br>
			<form:input class="frm" type="number" min="0" path="soLuongTon" />
			<form:errors class="errors" path="soLuongTon"/>
			</div>
			<div class="form-group">
				<label class="lb">Khối lượng tịnh</label>
				<br>
				<form:input class="frm" path="khoiLuong" type="text"/>
				<form:errors class="errors" path="khoiLuong"/>
			</div>
			<div class="form-group">
				<label class="lb">Giá nhập</label>
				<br>
				<input name="giaNhap" class="frm" type="number" min="0" />
				</div>
			<div class="form-group">
				<button class="btn"  style="width: 50%">Thêm sản phẩm</button>
				<br>
	</div>
	</form:form>
	<br>
	</div>
	</div>
</body>
</html>