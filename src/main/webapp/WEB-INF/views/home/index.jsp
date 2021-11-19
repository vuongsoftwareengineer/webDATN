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
	
	<h1 style="text-align: center ; margin-top: 12px">TẤT CẢ SẢN PHẨM</h1>
	<br>
	<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
	<c:forEach var="t" items="${theloais}">
	<br>
		<h3 style="text-align: center;  color: brown">${t.ten}</h3>
		<br>
		<div class="ser-t">
				<span><i></i></span>
				<b class="line"></b>
			</div>
		<hr  width="100%" size="7px" align="center" color="red" />
		<div class="container-fluid" style="margin-bottom: 20px">
			<div class="row">
				<c:forEach var="p" items="${sanphams}">
					<c:if test="${p.theLoaiId == t.id}">
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
								<a href="home/dathang/${p.id}.html" class="btn disabled"
									role="button"
									style="width: 30%; background-color: orange; color: white; margin-left: 165px;">Hết hàng</a>
							</c:if>
							 <c:if test="${p.soLuongTon>0}">
								<c:choose>
							<c:when test="${ktdangnhap==false}">
								<a href="home/dangnhap.html" class="btn" onclick="if(!(confirm('Vui lòng đăng nhập để mua sản phẩm'))) return false;"
									role="button"
									style="width: 30%; background-color: red; color: white; margin-left: 165px;">Mua ngay</a>
									<br><br>
							</c:when>
							<c:when test="${ktdangnhap==true}">
								<a href="home/dathang/${p.id}.html" class="btn" role="button"
									style="width: 30%; background-color: red; color: white; margin-left: 165px;">Mua ngay</a>
									<br><br>
								
							</c:when>
</c:choose>
</c:if>
</div>
</c:if>
</c:forEach>
</div>
</div>
</c:forEach>
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
	<div class="container-fluid">
	<h2 style="text-align: center;">THƯƠNG HIỆU</h2>
	<br>
	<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
		<c:forEach var="b" items="${thuonghieus}">
			<a href="home/thuonghieu/${b.id}.html" style="text-align: center; margin-left: 150px"><img src="./images/${b.anh}" style="width: 12%; margin-bottom: 40px; margin-top: 20px"></a>
		</c:forEach>
	</div>
	
	<div class="container-fluid">
	<h2 style="text-align: center;">TIN TỨC NỔI BẬT</h2>
	<br>
	<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
			<br>
			
	<c:forEach var="v" items="${tintucs}">
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6" style="background-color: white;">
			<a style="color: blue;">
			<h2 style="text-align: left; margin-left: 120px">${v.chuDe}</h2>
				<img src="./images/${v.anh}" style="width: 40%; margin-left: 120px">
				</a>
				</div>
				
			<div class="col-sm-6" style="background-color: white;">
			<h4 style="text-align: left; margin-top: 70px; color: purple"></h4>
					<textarea rows="12" cols="60%"
						style="border: none; font-style: italic;  margin-left: 100px;" readonly="true"> ${v.noiDung}</textarea>
						<div align="center"><b>Ngày đăng bài:</b> <fmt:formatDate pattern="dd-MM-yyyy" value="${v.ngayDang}"/></div>
						<c:forEach var="t" items="${taikhoans}">
        				<c:if test="${v.taiKhoanId == t.id}">
		     			<h6 style="text-align: center;"><b><u>Tác giả:</u> </b> ${t.hoTen}</h6></c:if></c:forEach>
			</div>
			</div>
			</div>
			</c:forEach>
			</div>
			<br>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>