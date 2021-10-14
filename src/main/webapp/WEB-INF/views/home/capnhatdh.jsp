<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <c:url value="http://localhost:8080/img" var="url"></c:url> --%>
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
	
 <div class="header"  align="center">
 
		<h2 class="lb">Xác nhận hủy đơn hàng</h2>
		<p class="errors">${message}</p>
		<form:form action="home/capnhatdh/${donhang.id}.html" method="post" modelAttribute="donhang" enctype="multipart/form-data">
			<div class="form-group">
				<label class="lb">Mã đơn hàng</label>
				
				<form:input readonly="true" class="frm" path="id" />
			</div>
			<div class="form-group">
				<label class="lb"> Mã tài khoản</label>
				
				<form:input class="frm" readonly="true" path="taiKhoanId" />
			</div>
			<div class="form-group">
				<label class="lb">Tổng giá tiền</label>
				
				<form:input class="frm" readonly="true" path="tongTien" />
			</div>
			<div class="form-group">
				<label class="lb">Trạng thái</label>
				
				<c:if test="${donhang.trangThai == 0}">
				<form:select path="trangThai">
				<option value="0">Chờ xác nhận</option>
				<option value="-1">Hủy đơn</option>
				</form:select><br>
				<br><button style="margin-left: 98px; background-color: #2e6f51; margin-top: 2px; color: white; width: 30%;" class=""><b>Xác nhận</b></button>
				</c:if>
				<c:if test="${donhang.trangThai != 0}">
				<label class="lb"><font color="red">Đơn hàng của bạn không thể hủy do đơn hàng: </font>
				<c:choose>
				<c:when test="${donhang.trangThai==1}"><b>Đã xác nhận</b></c:when>
				<c:when test="${donhang.trangThai==2}"><b>Đang giao hàng</b></c:when>
				<c:when test="${donhang.trangThai==3}"><b>Đã hoàn thành</b></c:when>
				<c:when test="${donhang.trangThai==-1}"><b>Đã hủy</b></c:when>
				</c:choose>
				</label>
				</c:if>
			</div>
					<br>
				
				<br>
		</form:form>
		</div>

				
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>