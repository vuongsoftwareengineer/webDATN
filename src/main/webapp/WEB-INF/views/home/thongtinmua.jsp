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
	<jsp:include page="firstpg.jsp"></jsp:include>
	<em style="color: red; margin-left: 120px" >${message}</em>
	<div class="header"  style=" margin-left: 5px">
			<h2 style="text-align: center; color: #2e6f51"><i class="fa fa-user"></i>Thông tin đặt hàng</h2> <h6 style="color: red">${message}</h6> 
			<div class="container-fluid">
			<div class="row"> 
			               
			<div class="col-sm-6" style="background-color: white;">
					<div class="form-group" style="margin-left: 80px">
			<i class="fas fa-file-signature icon" aria-hidden="true"></i>
				<label><b>Họ và tên</b></label><br>
				<input name="hoten" class="frm1" readonly="true" value="${sessionScope.taikhoan.getHoTen()}"/>
			</div>
			</div>
			<div class="col-sm-6" style="background-color: white;">
			<div class="form-group" style="margin-left: 80px">
			<i class="fa fa-address-card icon" aria-hidden="true"></i>
				<label><b>Địa chỉ</b></label><br>
				<input name="diachi" readonly="true" class="frm1" value="${sessionScope.taikhoan.getDiaChi()}"/>
			</div></div>
			<div class="col-sm-6" style="background-color: white;">
			<div class="form-group" style="margin-left: 80px">
				<i class="fa fa-envelope" aria-hidden="true"></i>
				<label><b>Email người nhận</b></label><br>
				<input name="email" readonly="true" class="frm1" value="${sessionScope.taikhoan.getEmail()}"/>
			</div></div>
			<div class="col-sm-6" style="background-color: white;">
			<div class="form-group" style="margin-left: 80px">
			<i class="fa fa-phone" aria-hidden="true"></i>
				<label><b>Số điện thoại người nhận</b></label><br>
				<input name="sdt" readonly="true" class="frm1" value="${sessionScope.taikhoan.getSdt()}"/>
			</div></div>
			</div>
			</div></div>
			<br>
		<form:form action="myoder.html" modelAttribute="orderdetail"><button style="text-align: center;margin-left: 500px; background-color: #2e6f51; margin-top: 2px; color: white; width: 30%;" class=""><b>Đặt hàng</b></button></form:form>
	<br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>