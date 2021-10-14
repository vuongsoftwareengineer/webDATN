<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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

	<h4 style="text-align: center; margin-bottom: 10px">ĐƠN HÀNG ĐÃ ĐẶT</h4>
<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
			<br>
			<h5 style="text-align: center; margin-bottom: 10px">Xem chi tiết đơn hàng</h5>
			<div class="ser-t">
				<b></b>
				<span><i></i></span>
			</div>
	<br>
	<table class="table table-bordered table-hover">
		<tr>
		<th>Mã đơn hàng</th>
		<th><div align="center">Tên Người Nhận</div></th>
		<th><div align="center">Địa chỉ</div></th>
		<th><div align="center">Email</div></th>
		<th><div align="center">Số điện thoại</div></th>
		<th>Ngày đặt</th>
		<th>Tổng tiền</th>
		<th>Trạng thái</th>
		</tr>
		<c:forEach var="o" items="${donhangs}">
			<tr>
				<td>${o.id}</td>
				<td><div align="center">${sessionScope.taikhoan.getHoTen()}</div></td>
				<td><div align="center">${sessionScope.taikhoan.getDiaChi()}</div></td>
				<td><div align="center">${sessionScope.taikhoan.getEmail()}</div></td>
				<td><div align="center">${sessionScope.taikhoan.getSdt()}</div></td>
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${o.ngayLap}"/></td>
				<td><fmt:formatNumber minFractionDigits="0" value="${o.tongTien}"
						type="number" />
					₫</td>
				<td><c:choose>
				<c:when test="${o.trangThai==0}">Chờ xác nhận</c:when>
				<c:when test="${o.trangThai==1}">Đã xác nhận</c:when>
				<c:when test="${o.trangThai==2}">Đang giao hàng</c:when>
				<c:when test="${o.trangThai==3}">Đã hoàn thành</c:when>
				<c:when test="${o.trangThai==-1}">Đã hủy</c:when>
				</c:choose></td>	
		<td><div align="center"><a href="home/capnhatdh/${o.id}.html" onclick="if(!(confirm('Bạn có chắc chắn muốn hủy đơn hàng này không?'))) return false;">Tùy chọn hủy đơn</a></div></td>
	<H7><a href="home/xemchitietdon/${o.id}.html" ><i class="fa fa-file-text-o" aria-hidden="true" style="text-align: center; margin-left: 200px"><b>Chi tiết đơn hàng: ${o.id}</b></i></a></H7>
	</c:forEach>
	
	</table>
	
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>