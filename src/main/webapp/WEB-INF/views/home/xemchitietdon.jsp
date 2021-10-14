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
</head>
<body>
	<jsp:include page="firstpg.jsp"></jsp:include>

	<h4 style="text-align: center; margin-bottom: 10px">CHI TIẾT ĐƠN HÀNG ĐÃ ĐẶT</h4>
<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
	<br>
	<table class="table table-bordered table-hover">
		<tr>
		<th>Mã chi tiết đơn</th>
		<th>Mã sản phẩm</th>
		<th>Số lượng đặt</th>
		<th>Mã đơn hàng</th>
		</tr>
		<c:forEach var="o" items="${ctdonhangs}">
			<tr>
				<td>${o.id}</td>
				<td>${o.idHH}</td>
				<td>${o.soLuong}</td>
				<td>${o.idPhieuDatHang}</td>
		</c:forEach>
	</table>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>