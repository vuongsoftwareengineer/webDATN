<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%><%-- 
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
<form action="home/dangnhap.html" class="container" method = "post">
    <h1>Đăng nhập</h1>
   		<div class="col-sm-6" style=" margin-left: 278px;text-align: center">
					<div class="form-group">
	<h6 style="color: red">${message1}</h6>
   <i class="fa fa-user icon1" aria-hidden="true"></i>
    <input class="frm1" type="text" placeholder="Nhập tài khoản" name="username" required oninvalid="this.setCustomValidity('Xin vui lòng nhập tài khoản của bạn !')" oninput="setCustomValidity('')">
  	
  	<h6 style="color: red">${message2}</h6>
    <i class="fa fa-lock icon1" aria-hidden="true"></i>
   <input class="frm1" type="password" placeholder="Nhập mật khẩu" name="password" required oninvalid="this.setCustomValidity('Xin vui lòng nhập mật khẩu vào ô trống !')"
 oninput="setCustomValidity('')">
 </div></div>
    
	<span></span>
    <button  style="text-align: center;margin-left: 330px; width: 40%; background-color: #2e6f51">Đăng nhập</button>
<a href="home/quenmk.html" style="text-decoration: none; margin-left: 12px;"> Quên mật khẩu</a>
    <a href="home/dangki.html" style="text-decoration: none; margin-left: 12px"> Tạo tài khoản ngay</a>
  </form>
  <br>
</div></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>