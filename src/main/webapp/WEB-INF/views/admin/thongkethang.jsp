<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<c:url value="http://localhost:8080/img" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DANH SÁCH SẢN PHẨM BÁN ĐƯỢC TRONG THÁNG</title>

<base href="${pageContext.servletContext.contextPath}/">
<link href="styleweb.css" rel='stylesheet' type='text/css' />
<jsp:include page="stylebanhang.css"></jsp:include>
<jsp:include page="banhang.css"></jsp:include>
 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="./js/Chart.min.js"></script>
<link rel="shortcut icon" type="image/png" href="${url}/iconweb.png">
<style type="text/css">

.bg {
	background-image: url("${url}/moi.png");
	width: 100%;
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}
body {
	font-family: "Lato", sans-serif;
}
.lb{
	font-weight: bold;
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
    <a href="admin/taikhoan.html"><i class="far fa-list-alt"></i>Tài khoản người dùng</a>
    <a href="admin/tintuc.html"><i class="far fa-list-alt"></i>Tin tức</a>
    <a href="admin/phieunhaphang.html"><i class="far fa-list-alt"></i>Phiếu nhập hàng</a>
    <a href="admin/kiemtradon.html"><i class="far fa-list-alt"></i>Kiểm tra đơn hàng</a>
    <a href="admin/dangxuat.html"><i class="fas fa-sign-out-alt"></i>Đăng xuất </a></p>
</div>
	<div class="main bg">
<h2 style="margin-left: 250px; font-style: italic; color: #8B4513"> Xin chào ${sessionScope.admin.getHoTen()}! </h2>
  <p style="margin-left: 250px; color: brown">Chào mừng bạn quay trở lại với trang quản trị của Website </p>
  	
		<div class="container">
			<br>
			<!-- <input type="date" name="thang" value="09/09/2021"> -->
			<h2 style="font-weight: bold;color: #FF6666">DANH SÁCH SẢN PHẨM ĐÃ BÁN ĐƯỢC TRONG THÁNG</h2>
			<div>
				<table class="table table-bordered table-hover table-condensed">
					<thead>
						<tr>
		<th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Tháng</th>
        <th>Tổng</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${thongkethangs}">
      <tr>
        <td>${p.id}</td>
        <td>${p.ten}</td>
        <td>${p.thang}</td>
       	<td>${p.tong}</td>
       	</tr>
      </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</div>


<div class="col-md-6 chart-blo-1" style="margin-left: 600px">
    	    <div class="line-chart">
    		<h7 style="margin-left: 160px"><b>Thống kê tổng sản phẩm bán được theo biểu đồ cột</b></h7>
    		 <canvas id="line" height="300" width="700" style="width: 700px; height: 300px;"> </canvas>
    		  <h3 class="tlt">Line Chart</h3>
                                            <canvas id="viewchart1" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
                                            <script>
                                                var lineChartData = {
                                                    labels: ["",<c:forEach var="item" items="${thongkethangs}">'${item.id}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                            fillColor: "#FC8213",
                                                            data: ["0",<c:forEach var="item" items="${thongkethangs}">${item.tong},</c:forEach>]
                                                        }
                                                    ]

                                                };
                                                new Chart(document.getElementById("viewchart1").getContext("2d")).Line(lineChartData);

                                            </script>
                                        </div> 			  		   			
                                    </div>
                                
                                <div class="col-md-6 chit-chat-layer1-rit" style="margin-left: 600px">    	
                                    <div class="glocy-chart">
                                        <div class="span-2c">  
                                            <h3 class="tlt">Bar Chart</h3>
                                            <canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
                                            <script>
                                                var barChartData = {
                                                    labels: [<c:forEach var="item" items="${thongkethangs}">'${item.id}',</c:forEach>],
                                                    datasets: [
                                                        {
                                                            fillColor: "#FC8213",
                                                            data: [<c:forEach var="item" items="${thongkethangs}">${item.tong},</c:forEach>]
                                                        }
                                                    ]

                                                };
                                                new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);

                                            </script>
                                        </div> 			  		   			
                                    </div>
                                </div>
                                <div class="clearfix">
                                
          <%--    <div class="col-md-6 chart-blo-1" style="margin-left: 600px">
    	    <div class="line-chart">
    		<h7 style="margin-left: 160px"><b>Thống kê tổng sản phẩm bán được theo biểu đồ cột</b></h7>
    		 <canvas id="line" height="300" width="700" style="width: 700px; height: 300px;"> </canvas>
    		 <c:forEach var="v" items="${thongkethangs}">
                     <script>
                        var lineChartData = {
						labels : ["",<c:forEach var="item" items="${thongkethangs}">'${item.id}',</c:forEach>],
						datasets : [
							{
								fillColor : "rgba(51, 122, 183, 0.71)",
								strokeColor : "#337AB7",
								pointColor : "#337AB7",
								pointStrokeColor : "#fff",
								data : [0,<c:forEach var="item" items="${thongkethangs}">'${item.tong}',</c:forEach>]
							}
						]
						
					};
                       new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);

			 google.load("visualization", "1", {packages:["corechart"]});
			 google.setOnLoadCallback(drawChart);
			 function drawChart() {
			 var data = google.visualization.arrayToDataTable([
			 ['Mã sản phẩm', 'Tổng giá trị'],
			 ["${v.id}', ${v.tong}]
			 ]);
			 var options = {
					 title: 'Thống kê tổng sản phẩm bán được theo biểu đồ tròn',
			 is3D: true,
			 };
			 var chart = new
			google.visualization.PieChart(document.getElementById('piechart_3d'));
			 chart.draw(data, options);
			 }
			 </script>
			<div id="piechart_3d" style="width: 900px; height: 800px;"></div>
			                    </c:forEach>
    	    </div>
    	  </div>
 --%>
 </div>
</body>
</html>