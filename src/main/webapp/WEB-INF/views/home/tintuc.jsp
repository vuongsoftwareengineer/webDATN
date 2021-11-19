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
			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>