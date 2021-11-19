<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <c:url value="http://localhost:8080/img" var="url"></c:url> --%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<base href="${pageContext.servletContext.contextPath}/">
<style type="text/css">

.btn{
	background-color: #2e6f51;
	color: white;
}

.frm1{
  width: 90%;
  padding: 7px 8px;
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
	<jsp:include page="firstpage.jsp"></jsp:include>
	<em style="color: red; margin-left: 120px" >${message}</em>
		<form:form action="home/dathang/${sanpham.id}.html" method="post" modelAttribute="chitietdonhang" enctype="multipart/form-data">
	<div class="container-fluid">
		<div class="row">
			<div style=" margin-left: 30px">
			<h3 style="text-align: center;">THÔNG TIN SẢN PHẨM</h3>
			
			<div class="form-group" style="margin-left: 100px">
			<i class="fa fa-user-circle" aria-hidden="true"></i>
				<label><b>Tên sản phẩm: </b> ${sanpham.ten}</label>
				<br>
				<i class="fa fa-money" aria-hidden="true"></i>
				<label><b>Giá tiền: </b> <fmt:formatNumber minFractionDigits="0" value="${sanpham.gia}" type="number"/> đ</label>
				<br>
				<i class="fa fa-shopping-bag" aria-hidden="true"></i>
				
				<label><b>Hãng: </b> <c:forEach var="b" items="${thuonghieus}">
				<c:choose>
				<c:when test="${sanpham.thuongHieuId==b.id}">${b.ten}</c:when>
				</c:choose></c:forEach></label>
				
				<br>
				
				<i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
				<label><b>Loại: </b>
				<c:forEach var="a" items="${theloais}">
				<c:choose>
				<c:when test="${sanpham.theLoaiId==a.id}">${a.ten}</c:when>
				</c:choose></c:forEach>
				</label>
				<br>
				<textarea rows="7" cols="90%"
						style="border: none; font-style: italic;" readonly="true"> ${sanpham.moTa}</textarea>
						
				<br>
				<i class="fa fa-shopping-bag" aria-hidden="true"></i>
				
				<label><b>Khối lượng tịnh </b> ${sanpham.khoiLuong}</label>
				
				<br>
				<i class="fa fa-exchange" aria-hidden="true"></i>
				<label><b>Số lượng đặt: </b></label>
				<input name="soLuong" type="number" style="margin-left: 12px" min="1" max="${sanpham.soLuongTon}"/>
				<br><button style="width: 44.5%; margin-top: 2px"><b>Mua hàng</b></button>
			</div>
			</div>
		<div style=" margin-left: 120px">
		<h3 style="text-align: center">THÔNG TIN NHẬN HÀNG</h3>
		
			<div class="form-group" style="margin-left: 30px">
			<i class="fas fa-file-signature icon" aria-hidden="true"></i>
				<label><b>Họ và tên</b></label><br>
				<input name="hoten" class="frm1" readonly="true" value="${sessionScope.taikhoan.getHoTen()}"/>
			</div>
			<div class="form-group" style="margin-left: 30px">
			<i class="fa fa-address-card icon" aria-hidden="true"></i>
				<label><b>Địa chỉ</b></label><br>
				<input name="diachi" readonly="true" class="frm1"value="${sessionScope.taikhoan.getDiaChi()}"/>
			</div>
			<div class="form-group" style="margin-left: 30px">
				<i class="fa fa-envelope" aria-hidden="true"></i>
				<label><b>Email</b></label><br>
				<input name="email" readonly="true" class="frm1" value="${sessionScope.taikhoan.getEmail()}"/>
			</div>
			<div class="form-group" style="margin-left: 30px">
			<i class="fa fa-phone" aria-hidden="true"></i>
				<label><b>Điện thoại</b></label><br>
				<input name="sdt" readonly="true" class="frm1" value="${sessionScope.taikhoan.getSdt()}"/>
			</div>
			
	</div>
	</div>
	</div>
	</form:form>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>