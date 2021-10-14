<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%-- 
<c:url value="http://localhost:8080/img" var="url"></c:url> --%>
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
	.bg2 {
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
	
 <div class="bg2" style="text-align: center">
 <div class="container-fluid">

		<form:form action="home/doimk/${taikhoan.id}.html" method="post" modelAttribute="taikhoan" enctype="multipart/form-data">
			<h2 style="text-align: center; color: #2e6f51"><i class="fa fa-user"></i>Thay đổi thông tin tài khoản</h2> <h6 style="color: red">${message}</h6> 
			<div class="container-fluid">
			<div class="row"> 
				<form:hidden class="frm" path="id" />
				<form:hidden class="frm" path="hoTen" />
				<form:hidden class="frm" path="diaChi" />
				<form:hidden class="frm" path="sdt"/>
				<form:hidden class="frm" path="email"/>
				<form:hidden class="frm" path="username"/>
				<form:hidden class="frm"  path="quyen" />
				<form:hidden class="frm"  path="anh" />
			
			<div class="col-sm-6" style="background-color: white;margin-left: 370px">
						<div class="form-group">
							<i class="fa fa-lock" aria-hidden="true" style="margin-left: 12px"></i>
							<label for="id"><b>Nhập mật khẩu cũ</b></label>
							<input name="mkcu" type="password" class="frm" maxlength="20" name="password" required oninvalid="this.setCustomValidity('Xin vui lòng nhập mật khẩu của bạn !')"
 							oninput="setCustomValidity('')"><p class="errors" style="color: red">${message1}</p>
							
							<br><i class="fa fa-lock" aria-hidden="true"></i>
							<label for="id"><b>Nhập mật khẩu mới</b></label>
							<form:input class="frm" path="password" />
							<p class="errors" style="color: red">${tb1}</p>
							
							<br><i class="fa fa-lock" aria-hidden="true" style="margin-left: -28px"></i>
							<label for="id"><b>Xác nhận mật khẩu mới</b></label>
							<input name="xacnhanmk" type="password" class="frm" maxlength="14" name="xacnhanmk" required oninvalid="this.setCustomValidity('Xin vui lòng nhập xác nhận mật khẩu mới của bạn !')"
 oninput="setCustomValidity('')"><p class="errors" style="color: red">${tb}</p>
 
						</div></div>
						
				<button style="text-align: center;margin-left: 518px; background-color: #2e6f51; margin-top: 12px; color: white; width: 30%;" class=""><b>Thay đổi mật khẩu</b></button>
				</div></div>
				</form:form>
				</div>
				<br>
				</div>
				
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>