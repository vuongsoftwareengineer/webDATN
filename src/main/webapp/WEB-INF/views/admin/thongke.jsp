<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <c:url value="http://localhost:8080/img" var="url"></c:url> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thống kê doanh thu</title>
<base href="${pageContext.servletContext.contextPath}/">

<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
<link rel="shortcut icon" type="image/png" href="./images/iconweb.png">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">

.btn{
	background-color: #2e6f51;
	color: white;
}

.errors {
	color: red;
	font-style: italic;
}

.frm{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #2e6f51;
  border-radius: 4px;
}

.lb{
	font-weight: bold;
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
</head>
<body>

<div class="sidebar">
  <a href="admin/index.html"><i class="fas fa-users"></i> Xin chào ${sessionScope.admin.getHoTen()} đã đến với trang quản trị
  </a><hr><p><a href="admin/sanpham.html"><i class="far fa-list-alt"></i> Danh sách sản phẩm</a></p>
  <p>
    <a href="admin/thuonghieu.html"><i class="far fa-list-alt"></i>Thương hiệu sản phẩm</a>
    <a href="admin/theloai.html"><i class="far fa-list-alt"></i>Thể loại sản phẩm</a>
    <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
	<h2 style="margin-left: 250px; font-style: italic;"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
<div class="container">
<h2 style="font-weight: bold;color: #FF6666">THỐNG KÊ DOANH THU</h2>
<div class="dropdown" style="margin-left: 40px">
<label class="lb">Thống kê theo ngày</label>
		<form class="form-inline" action="admin/thongkengay.html">
			<input type="date" name="ngay" id="value" onchange="myFunction(value)" class="form-control mr-sm-2" type="text" style="width: 300px"
				placeholder="Lựa chọn ngày để xem thống kê theo ngày">
			<button type="submit"
				style="height: 30px"><font color="#800000">Xác nhận</font></button>
		</form>
		<br><br>
		<form action="admin/thongkequy.html">
			<div class="form-group">
				<label class="lb">Thống kê theo quý</label><br>
				<select name="quy">
				<option value="none">Thống kê theo quý</option>
				<option value="1">Thống kê theo quý 1</option>
				<option value="2">Thống kê theo quý 2</option>
				<option value="3">Thống kê theo quý 3</option>
				<option value="4">Thống kê theo quý 4</option>
				</select>
			</div>
			<button type="submit"
				style="height: 30px"><font color="#800000">Xác nhận</font></button>
		</form>
		<br>
		<br>
		<br>
		
		</div>
        <script>
            var a;

            function myFunction(val){
                a = val.split("-").reverse().join("-");
                document.getElementById("value").type = "text";
                document.getElementById("value").value = a;
            }

            function f(){
                document.getElementById("result").innerHTML = a;
                var z = a.split("-").reverse().join("-");
                document.getElementById("value").type = "date";
                document.getElementById("value").value = z;
            }

        </script>

<br/>
<h4 id="selectedDtaeVal"></h4>
<script>
$( function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });
 
    $( "#datepicker" ).datepicker();
});
</script>


</div></div>
</body>
</html>