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

	<div class="dropdown" style="margin-left: 100px">
						<a href="home/thuonghieu.html"
							style="color: white; text-decoration: none">Thương hiệu</a>
					</div>
	<br>
	<div class="container-fluid">
	<br>
	<h2 style="text-align: center;color: brown">THƯƠNG HIỆU NỔI BẬT</h2>
	<div class="ser-t">
				<b></b>
				<span><i></i></span>
				<b class="line"></b>
			</div>
		<c:forEach var="b" items="${thuonghieus}">
			<a href="home/thuonghieu/${b.id}.html" style="text-align: center; margin-left: 100px"><img src="./images/${b.anh}" style="width: 12%; margin-bottom: 40px; margin-top: 20px"></a>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>