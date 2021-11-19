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
	<jsp:include page="firstpage.jsp"></jsp:include>

	<h2 style="text-align: center; color: brown; margin-top: 30px">Sản phẩm bán chạy
	</h2>
		<br>
		<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
	
	<hr width="60%">
	<div class="container-fluid" style="margin-bottom: 20px">
		<div class="row">
			<c:forEach var="p" items="${sanphams}">
			<c:forEach var="b" items="${banchays}">
			<c:if test="${p.id==b.idhh}">
						<div class="col-sm-4" style="background-color: white;">
							<p>
								<a href="home/sanpham/${p.id}.html" style="color: black;"><img
									src="./images/${p.anh}" style="width: 60%; margin-left: 98px">
								</a>
							</p>
							<p
								style="text-align: center; margin-left: 60px; margin-right: 50px">
								<a href="home/sanpham/${p.id}.html" style="color: black;">${p.ten}
								</a>
							</p>

							<h5
								style="color: red; text-align: center;  margin-left: 60px; margin-right: 60px">
								<fmt:formatNumber minFractionDigits="0" value="${p.gia}"
									type="number" />
								₫
							</h5>
							<c:if test="${p.soLuongTon==0}">
								<a href="mycart.html?id=${p.id}.html" class="btn disabled"
									role="button"
									style="width: 30%; background-color: orange; color: white; margin-left: 165px;">Hết hàng</a>
							</c:if>
							 <c:if test="${p.soLuongTon>0}">
								<c:choose>
							<c:when test="${ktdangnhap==false}">
								<a href="home/dangnhap.html" class="btn" onclick="if(!(confirm('Vui lòng đăng nhập để mua sản phẩm'))) return false;"
									role="button"
									style="width: 30%; background-color: red; color: white; margin-left: 165px;">Thêm giỏ hàng</a>
									<br><br>
							</c:when>
							<c:when test="${ktdangnhap==true}">
								<a href="mycart.html?id=${p.id}" class="btn" role="button"
									style="width: 30%; background-color: red; color: white; margin-left: 165px;">Thêm giỏ hàng</a>
									<br><br>
								
							</c:when>
</c:choose>
</c:if>
</div>
</c:if>
</c:forEach>
</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>