<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon1" type="image/png" href="./images/iconweb.png">
<base href="${pageContext.servletContext.contextPath}/">
</head>
<style type="text/css">
 
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



.frm1 {
	width: 83%;
	height: 40px;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #2e6f51;
	border-radius: 4px;
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
<body>
	<jsp:include page="firstpg.jsp"></jsp:include>
	
 <div class="header"  style=" margin-left: 5px">
 
		<form:form action="home/dangki.html" method="post" modelAttribute="taikhoan">		
			<h2 style="text-align: center; color: #2e6f51"><i class="fa fa-user"></i>Đăng ký tài khoản</h2><h6 style="color: red">${tb}</h6> <h6 style="color: red">${message}</h6> 
			<div class="container-fluid">
			<div class="row"> 
			                 
					<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><form:errors style="color:red;" path="hoTen"/><br>
					<i class="fas fa-file-signature icon1"></i>
							<form:input type="text" class="frm1" placeholder="Họ và tên" path="hoTen" />
						</div>
						</div>
						<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><br>
					<i class="fa fa-lock icon1"></i>
						<input name="mk" type="password" class="frm1" placeholder="Nhập vào mật khẩu" maxlength="20" />
						
						</div></div>
					
					<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><form:errors style="color:red;" path="username"/><br>
					<i class="fa fa-key icon1"></i>
					<input hidden="true" name="user" value="${taikhoan.username}">
						<form:input type="username" class="frm1" placeholder="Nhập vào username" path="username" maxlength="20" />
					</div></div>
					
						<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"> <br>
						<i class="fa fa-key icon1"></i>
						<input name="xacnhanmk" type="password" class="frm1" placeholder="Nhập lại mật khẩu" maxlength="20" class="errors">
						</div></div>
					
					<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><form:errors style="color:red;" path="sdt"/><br>
						<i class="fa fa-phone icon1"></i>
						<form:input type="tel" class="frm1" placeholder="Số điện thoại" path="sdt" maxlength="10"/>
						</div></div>
					<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><form:errors style="color:red;" path="diaChi"/><br>
					<i class="fa fa-address-card icon1"></i>
						<form:input type="text" class="frm1" placeholder="Địa chỉ" path="diaChi" />
						</div></div>
								<div class="col-sm-6" style="background-color: white;">
					<div class="form-group"><form:errors style="color:red;" path="email"/><br>
						<i class="fa fa-envelope icon1"></i>
						<form:input class="frm1" placeholder="Nhập vào email" path="email" type="email"/>
						</div></div>
					
					
						<form:hidden path="quyen" value="CUSTOMER"/>
						<form:hidden path="trangThai" value="1"/>
						<div>
								 <input type="checkbox" id="check-rule" checked="checked" style="text-align: center;margin-left: 500px">
								<label>Bạn đã đọc và đồng ý với các điều khoản
								<span class="checkmark"></span>
								
								</label>
								<br>
								<input type="checkbox" id="check-promo" checked="checked" style="text-align: center;margin-left: 500px">
								<label>Đăng ký nhận khuyến mãi từ chúng tôi
								  
								 <span class="checkmark"></span></label></div>
						<button style="text-align: center;margin-left: 330px; background-color: #2e6f51; margin-top: 2px; color: white; width: 50%;" class=""><b>Đăng ký</b></button>
				</div></div>
				</form:form>
				</div>
				<br>
				
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>