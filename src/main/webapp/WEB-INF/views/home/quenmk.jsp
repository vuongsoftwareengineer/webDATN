<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%-- 
<c:url value="http://localhost:8080/img" var="url"></c:url> --%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<base href="${pageContext.servletContext.contextPath}/">
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



.frm {
	width: 30%;
	height: 40px;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #2e6f51;
	border-radius: 4px;
}
	.bg2 {
	background-image: url("./images/ds.jpg");
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
<div class="bg2" style="text-align: center">
 <div class="container-fluid">
<h1>Quên mật khẩu</h1>
	<form:form action="home/quenmk.html" class="container" method = "post" modelAttribute="taikhoan" enctype="multipart/form-data">
    <h6 style="color: red">${message}</h6>
    <h6 style="color: red">${message1}</h6>
    <h6 style="color: red">${tb}</h6>
	<i class="fa fa-user" aria-hidden="true"></i>
    <input type="text" placeholder="Nhập Username" class="frm" name="id" required oninvalid="this.setCustomValidity('Xin vui lòng nhập tài khoản của bạn !')"
 oninput="setCustomValidity('')">
    <br>
     <h6 style="color: red">${message2}${tb}</h6>
    	<i class="fa fa-lock" aria-hidden="true"></i>
    <input type="text" placeholder="Nhập email" class="frm" name="email" required oninvalid="this.setCustomValidity('Xin vui lòng nhập email của bạn !')"
 oninput="setCustomValidity('')"><br><br>
<button type="submit" style="text-align: center;margin-left: 25px; width: 30%; background-color: #2e6f51">Xác nhận lấy lại mật khẩu</button>
<br><br>
					</form:form>
					</div>
					</div>
					
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>