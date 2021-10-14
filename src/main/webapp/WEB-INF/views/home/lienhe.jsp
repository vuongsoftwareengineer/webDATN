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


<div class="banner-top">
	<div class="container">
	<a href="http://hcm.ptit.edu.vn/"><img src="./images/logoptithcm.png" alt=""></a><br>
		<h3 >Liên hệ</h3>
		<h4><a href="home/index.html">Trang chủ</a><label>/</label>Liên hệ</h4>
		<div class="clearfix"> </div>
	</div>
</div>
<a href="http://hcm.ptit.edu.vn/"><img src="./images/hinhnenptit.jpg" alt=""></a>	 <P>&nbsp;</P>
<div id="content" class="site-content">
            <div class="container">
        <small> </small>
        <P>&nbsp;</P>
        <h4>Thông tin liên lạc&nbsp;&nbsp;</h4>
				<p> Sinh viên tại trường Học viện Công nghệ bưu chính viễn thông cơ sở tại TPHCM</p>
				<ul class="contact-list">
					<li> <i class="fa fa-map-marker" aria-hidden="true"></i> 97 Man Thiện, phường Hiệp Phú, quận 9, TPHCM.</li>
					<li><i class="fa fa-envelope" aria-hidden="true"></i><a href="mailto:khanhvuong2015@mail.com">khanhvuong2015@gmail.com</a></li>
					<li> <i class="fa fa-phone" aria-hidden="true"></i>+84817581018</li>
				</ul>
    <div>
        <h6>&emsp;Đăng kí nhận tin qua email</h6>
        
            <form action="http://feedburner.google.com/fb/a/mailverify" method="post" target="popupwindow" onsubmit="window.open('http://feedburner.google.com/fb/a/mailverify?uri=ptithcm', 'popupwindow', 'scrollbars=yes,width=550,height=520');return true">
                <span style="display: block; float: left; padding: 3px; width: 60px; text-align: right; ">Email:</span>  
                <input type="text" style="width: 300px; border: 1px solid #ddd; color: #666; height: 20px;" name="email">
                <input type="hidden" value="ptithcm" name="uri">
                <input type="hidden" name="loc" value="en_US">
                <input type="submit" value="Đăng kí" style="border: 1px solid #72a0c5; height: 24px; line-height: 24px; display: inline-block; margin-left: 8px; padding: 0pt 8px; ">
            </form>
        </div>
								<div class="map-grid">
								<h5>Địa chỉ</h5>
									<ul>
										<li><i class="fa fa-arrow-right" aria-hidden="true"></i>97 Man Thiện, phường Hiệp Phú, quận 9</li>
										<li><i class="fa fa-arrow-right" aria-hidden="true"></i>khu phố Tân Lập, đường T2, phường Linh Trung, quận Thủ Đức</li>
									</ul>
								<div class="map-grid">
									<h5>Liên hệ khi cần</h5>
									<ul>
										<li>PTITHCM : (028) 38295092</li>
										<li>Phone me : +84817581018</li>
									
									</ul>
									<iframe src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=vi&amp;geocode=&amp;q=H%E1%BB%8Dc+vi%E1%BB%87n+C%C3%B4ng+ngh%E1%BB%87+B%C6%B0u+ch%C3%ADnh+Vi%E1%BB%85n+th%C3%B4ng+TP+H%E1%BB%93+Ch%C3%AD+Minh&amp;aq=&amp;sll=14.9121,108.941399&amp;sspn=0.426642,0.837021&amp;ie=UTF8&amp;hq=H%E1%BB%8Dc+vi%E1%BB%87n+C%C3%B4ng+ngh%E1%BB%87+B%C6%B0u+ch%C3%ADnh+Vi%E1%BB%85n+th%C3%B4ng&amp;hnear=H%E1%BB%8Dc+vi%E1%BB%87n+C%C3%B4ng+ngh%E1%BB%87+B%C6%B0u+ch%C3%ADnh+Vi%E1%BB%85n+th%C3%B4ng,+Vi%E1%BB%87t+Nam&amp;ll=10.848101,106.785947&amp;spn=0.013551,0.026157&amp;z=14&amp;iwloc=A&amp;cid=14421467237377511686&amp;output=embed" style="border:0"></iframe>
								</div>
			<div class="map-grid">
            <iframe src="//www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2Fptithcm.edu.vn&amp;width=300&amp;height=258&amp;colorscheme=light&amp;show_faces=true&amp;header=false&amp;stream=false&amp;show_border=true" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:300px; height:265px;" allowtransparency="true"></iframe>
		</div>
			
</div>
</div>
</div>

<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>