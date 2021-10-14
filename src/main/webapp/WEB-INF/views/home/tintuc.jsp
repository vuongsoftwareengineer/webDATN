<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<br>
	<h2 style="text-align: center;">TIN TỨC NỔI BẬT</h2>
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
			<h2 style="text-align: left; margin-left: 150px;">${v.chuDe}</h2>
				<img src="./images/${v.anh}" style="width: 40%; margin-left: 200px">
				</a>
				</div>
				
			<div class="col-sm-6" style="background-color: white;">
			<h4 style="text-align: left; margin-right: 50px; margin-top: 20px; color: purple"></h4>
					<textarea rows="12" cols="90%"
						style="border: none; font-style: italic;" readonly="true"> ${v.noiDung}</textarea>
			</div>
			
			</div>
			</div>
			<br>
			</c:forEach>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>