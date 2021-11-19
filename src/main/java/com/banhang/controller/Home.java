package com.banhang.controller;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.banhang.model.*;
@Transactional
@Controller
@RequestMapping("/home/")

public class Home {
	public static String accessToken;
	private static final String URL = "http://localhost:8080";
//	private static final String URL ="https://khanhvuong.herokuapp.com";
	@Autowired
	SessionFactory factory;
	
	@Autowired
	Mailer mailer;
	

	public static String getRandomID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	
	
	//=====lay danh sach ham=====//
	  RestTemplate restTemplate=new RestTemplate();
	
	 
	  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
		@RequestMapping(value="dangnhap", method=RequestMethod.GET)
		public String TaiKhoan(){
			return "home/dangnhap";
		}
		@RequestMapping(value="dangnhap", method=RequestMethod.POST)
		public String dangnhap( @ModelAttribute("taikhoan")TaiKhoan taikhoan,@ModelAttribute("login")Login login,HttpServletRequest request, ModelMap model){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			username.trim();
			password.trim();
			login.setUsername(username);
			login.setPassword(password);
			for(TaiKhoan u : getTaiKhoan()){
				if(username.equals(u.getUsername().trim()) == true){
					if(passwordEncoder.matches(password, u.getPassword())== false){
						model.addAttribute("message2", "Sai mật khẩu!");
						return "home/dangnhap";
					}
					else if(u.getTrangThai()==1) {
						accessToken=restTemplate.postForObject(URL+"/auth/login",login, String.class);
							if(u.getQuyen().equals("CUSTOMER")) {
							HttpSession adsession = request.getSession();
							adsession.setAttribute("taikhoan", u);
							return "redirect:/home/index.html";
						}
						else {
							HttpSession usersession = request.getSession();
							usersession.setAttribute("admin", u);
							return "redirect:/admin/index.html";
						}
					}
					model.addAttribute("message1", "Tài khoản đã bị khóa!");
					return "home/dangnhap";
				}
			}
			model.addAttribute("message1", "Tên đăng nhập không đúng!");
			return "home/dangnhap";
		}
		public static HttpHeaders getHeaders() {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    	headers.add("Authorization", "Bearer " + accessToken);
	    	return headers;
	    }
		
		public List<HangHoa> getSanpham() {
			ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/hanghoa", HangHoa[].class);
		      HangHoa[] responseBody = responseEntity.getBody();
		      List<HangHoa> list = Arrays.asList(responseBody);
			return list;
		}
		
		public List<BanChay> getBanChay() {
			ResponseEntity<BanChay[]> responseEntity = restTemplate.getForEntity(URL+"guest/banchay", BanChay[].class);
		      BanChay[] responseBody = responseEntity.getBody();
		      List<BanChay> list = Arrays.asList(responseBody);
			return list;
		}
	  
	  
	  public List<PhieuDatHang> getDonHang() {
		  	HttpHeaders headers = getHeaders();  
	        RestTemplate restTemplate = new RestTemplate();
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"customer/phieudathang", HttpMethod.GET, requestEntity, PhieuDatHang[].class);
	          PhieuDatHang[] responseBody = responseEntity.getBody();
		      List<PhieuDatHang> list = Arrays.asList(responseBody);
			return list;
		}
	  
	  public List<CT_PhieuDatHang> getChiTietDonHang() {
		  HttpHeaders headers = getHeaders();  
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<CT_PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"customer/chitietdathang", HttpMethod.GET, requestEntity, CT_PhieuDatHang[].class);
	        CT_PhieuDatHang[] responseBody = responseEntity.getBody();
		      List<CT_PhieuDatHang> list = Arrays.asList(responseBody);
			return list;
		}
	  
	  public List<TaiKhoan> getTaiKhoan() {
			ResponseEntity<TaiKhoan[]> responseEntity = restTemplate.getForEntity(URL+"guest/taikhoan", TaiKhoan[].class);
		      TaiKhoan[] responseBody = responseEntity.getBody();
		      List<TaiKhoan> list = Arrays.asList(responseBody);
			return list;
		}
	  
		public List<TheLoai> getTheLoai() {
			ResponseEntity<TheLoai[]> responseEntity = restTemplate.getForEntity(URL+"guest/theloai", TheLoai[].class);
		      TheLoai[] responseBody = responseEntity.getBody();
		      List<TheLoai> list = Arrays.asList(responseBody);
			return list;
		}
		
		public List<TinTuc> getTinTuc() {
			ResponseEntity<TinTuc[]> responseEntity = restTemplate.getForEntity(URL+"guest/tintuc", TinTuc[].class);
		      TinTuc[] responseBody = responseEntity.getBody();
		      List<TinTuc> list = Arrays.asList(responseBody);
			return list;
		}
		
		
		public List<ThuongHieu> getThuongHieu() {
			ResponseEntity<ThuongHieu[]> responseEntity = restTemplate.getForEntity(URL+"guest/thuonghieu", ThuongHieu[].class);
		      ThuongHieu[] responseBody = responseEntity.getBody();
		      List<ThuongHieu> list = Arrays.asList(responseBody);
			return list;
		}
		
		@RequestMapping("tintuc")
		public String tintuc(ModelMap model){
			model.addAttribute("tintucs", getTinTuc());
			model.addAttribute("taikhoans",getTaiKhoan());
			return "home/tintuc";
		}
	
	//=====hien thi=====//
	@RequestMapping("index")
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		model.addAttribute("sanphams", getSanpham());
		model.addAttribute("theloais", getTheLoai());
		model.addAttribute("thuonghieus", getThuongHieu());
		model.addAttribute("tintucs", getTinTuc());
		model.addAttribute("taikhoans", getTaiKhoan());
		model.addAttribute("banchays", getBanChay());
		return "home/index";
		
	}	
	
	
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		String tukhoa = request.getParameter("timkiem");
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/timkiemhh/"+tukhoa, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> list3 = Arrays.asList(responseBody);
		model.addAttribute("sanphams", list3);
		model.addAttribute("tukhoa", tukhoa);
		return "home/timkiem";
	}
		
	@RequestMapping("sanpham/{id}")
	public String spchitiet(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/hanghoaid/"+id, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> listSP = Arrays.asList(responseBody);
	    model.addAttribute("theloais", getTheLoai());
	    model.addAttribute("thuonghieus", getThuongHieu());
		model.addAttribute("sanphams", listSP);
		return "home/chitiet";
	}

	@RequestMapping("dangxuat")
	public String dangxuat(ModelMap model, HttpServletRequest request){
		HttpSession dangxuat = request.getSession();
		dangxuat.removeAttribute("taikhoan");	
		return "redirect:/home/index.html";
	}
	
	@RequestMapping("lichsu")
	public String lichsu(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
			return "redirect:/home/dangnhap.html";
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		TaiKhoan taikhoan = (TaiKhoan) usersession.getAttribute("taikhoan");
		HttpHeaders headers = getHeaders();
		HttpEntity<PhieuDatHang[]> requestEntity = new HttpEntity<PhieuDatHang[]>(headers);
        ResponseEntity<PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"customer/donhangcuakh/"+taikhoan.getId(), HttpMethod.GET, requestEntity, PhieuDatHang[].class, 1);
        PhieuDatHang[] responseBody = responseEntity.getBody();
	    List<PhieuDatHang> list2 = Arrays.asList(responseBody);
		model.addAttribute("donhangs", list2);
		return "home/lichsu";
	}
	
	@RequestMapping("xemchitietdon/{id}")
	public String xemchitietdon(ModelMap model,@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
			return "redirect:/home/dangnhap.html";
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		HttpHeaders headers = getHeaders();
		HttpEntity<CT_PhieuDatHang[]> requestEntity = new HttpEntity<CT_PhieuDatHang[]>(headers);
        ResponseEntity<CT_PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"customer/ctdonhangcuadh/"+id, HttpMethod.GET, requestEntity, CT_PhieuDatHang[].class, 1);
        CT_PhieuDatHang[] responseBody = responseEntity.getBody();
	    List<CT_PhieuDatHang> list2 = Arrays.asList(responseBody);
		model.addAttribute("sanphams", getSanpham());
		model.addAttribute("ctdonhangs", list2);
		return "home/xemchitietdon";
	}
	
	@RequestMapping("thuonghieu")
	public String thuonghieu(ModelMap model){
		model.addAttribute("thuonghieus", getThuongHieu());
		return "home/thuonghieu";
	}

	@RequestMapping("thuonghieu/{id}")
	public String spthuonghieu(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/sptheothuonghieu/"+id, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> list3 = Arrays.asList(responseBody);
	    model.addAttribute("thuonghieus", getThuongHieu());
		model.addAttribute("sanphams", list3);
		return "home/spthuonghieu";
	}
	
	@RequestMapping("banchay")
	public String spbanchay(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		model.addAttribute("banchays", getBanChay());
		model.addAttribute("sanphams", getSanpham());
		return "home/banchay";
	}
	
	
	@RequestMapping("sptheogia1/1")
	public String sptheogia1(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/sptheogia1/"+1, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> list3 = Arrays.asList(responseBody);
		model.addAttribute("sanphams", list3);
		return "home/sptheogia";
	}
	
	@RequestMapping("sptheogia2/2")
	public String sptheogia2(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/sptheogia2/"+2, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> list3 = Arrays.asList(responseBody);
		model.addAttribute("sanphams", list3);
		return "home/sptheogia";
	}
	
	@RequestMapping("theloai/{id}")
	public String sptheloai(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession usersession = request.getSession();
		usersession.getAttribute("taikhoan");
		if(usersession.getAttribute("taikhoan")==null){
			model.addAttribute("ktdangnhap", false);
		}
		else{
			model.addAttribute("ktdangnhap", true);
		}
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"guest/sptheotheloai/"+id, HangHoa[].class);
	    HangHoa[] responseBody = responseEntity.getBody();
	    List<HangHoa> list3 = Arrays.asList(responseBody);
	    model.addAttribute("theloais", getTheLoai());
		model.addAttribute("sanphams", list3);
		return "home/sptheloai";
	}

	@RequestMapping("lienhe")
	public String lienhe(){
	return "home/lienhe";
	}
	
	@RequestMapping("thongtin")
	public String thongtin(){
	return "home/thongtin";
	}
	
	@RequestMapping("thongtinmua")
	public String thongtinmua(){
	return "home/thongtinmua";
	}
	
	@RequestMapping(value="dangki")
	public String themdangki(@Validated @ModelAttribute("taikhoan")TaiKhoan taikhoan,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){	
		String xacnhanmk = request.getParameter("xacnhanmk");
		String mk = request.getParameter("mk");
		String user = request.getParameter("user");
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else{
			List<TaiKhoan> check = getTaiKhoan();
			for(TaiKhoan u : check) {
				if(checkKitu(taikhoan.getHoTen()) == false) {
					model.addAttribute("tb", "Họ tên bạn nhập chưa đúng định dạng !");
					return "home/dangki";
				}
				else if(checkId(taikhoan.getUsername()) == false) {
					model.addAttribute("tb", "Username bạn nhập chưa đúng định dạng !");
					return "home/dangki";
				}
				else if(user.trim().equals(u.getUsername().trim()) == true) {
					model.addAttribute("tb", "Tài khoản đã tồn tài ! Vui lòng nhập lại username mới!");
					return "home/dangki";
				}
				else if(checkSdt(taikhoan.getSdt()) == false) {
					model.addAttribute("tb", "Sdt bạn nhập chưa đúng định dạng !");
					return "home/dangki";
				}
				
				else if(checkEmail(taikhoan.getEmail()) == false) {
					model.addAttribute("tb", "Email bạn nhập chưa đúng định dạng !");
					return "home/dangki";
				}
				else if(mk.trim().isEmpty()) {
					model.addAttribute("tb", "Xin vui lòng nhập vào mật khẩu !");
					return "home/dangki";
				}
				else if(xacnhanmk.trim().isEmpty()) {
					model.addAttribute("tb", "Xin vui lòng xác nhận lại mật khẩu !");
					return "home/dangki";
				}
		
				else if(xacnhanmk.trim().equals(mk.trim()) == false) {
					model.addAttribute("tb", "Xác nhận Mật khẩu không đúng, vui lòng nhập lại !");
					return "home/dangki";
				}
				
			}
			
			
		try {
			RestTemplate rt = new RestTemplate();
			taikhoan.setAnh("khanhvuong.jpg");
			taikhoan.setId("KH"+randomNumber());
			taikhoan.setPassword(passwordEncoder.encode(mk));
			  
	        HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(taikhoan);
	       rt.postForLocation(URL+"guest/taikhoan", requestEntity);
			mailer.send("diepkvuong3012@gmail.com", taikhoan.getEmail(), "XÁC NHẬN", "Đăng kí thành công với Mã tài khoản là: " + taikhoan.getId() + "\nQuay lại trang đăng nhập để mua hàng ngay!");
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/home/dangnhap.html";
		}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "home/dangki";
	}
	
	public Boolean checkEmail(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
}
		public static String randomNumber() {
			String randNumber = "";
			Random rd = new Random();
			for(int i = 0; i<5; i++) {
				Integer number = rd.nextInt(5);
				randNumber += number.toString();
			}
			return randNumber;
		}
		
		@RequestMapping("doimk/{id}")
		public String doimk(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
			HttpSession adsession = request.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			HttpHeaders headers = getHeaders();
			HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(headers);
	        ResponseEntity<TaiKhoan> responseEntity = restTemplate.exchange(URL+"customer/taikhoan/"+id, HttpMethod.GET, requestEntity, TaiKhoan.class, 1);
	        TaiKhoan list2 = responseEntity.getBody();
		   model.addAttribute("taikhoan",list2);
			return "home/doimk";
		}
		
		@RequestMapping(value="doimk/{id}", method=RequestMethod.POST)
		public String thaydoimk(ModelMap model, @ModelAttribute("taikhoan")TaiKhoan taikhoan, 
				 HttpServletRequest req, HttpServletResponse response){
			HttpSession adsession = req.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			String temp = req.getParameter("temp");
			String mkcu = req.getParameter("mkcu");
			String mkmoi = req.getParameter("mkmoi");
			String xacnhanmk = req.getParameter("xacnhanmk");
			mkcu.trim();
			mkmoi.trim();
			xacnhanmk.trim();
			if(mkcu.length() == 0) {
				model.addAttribute("message1", "Vui lòng nhập mật khẩu cũ !");
				return "home/doimk";
			}
			if(passwordEncoder.matches(mkcu,temp) == false) {
				model.addAttribute("tb", "Mật khẩu cũ không đúng! Xin vui lòng nhập lại!");
				return "home/doimk";
			}
			if(mkmoi.length() == 0) {
				model.addAttribute("tb1", "Vui lòng nhập mật khẩu mới !");
				return "home/doimk";
			}
			if(xacnhanmk.length() == 0) {
				model.addAttribute("tb", "Vui lòng xác nhận mật khẩu mới !");
				return "home/doimk";
			}
			else {
				if(mkmoi.trim().equals(xacnhanmk) == false) {
					model.addAttribute("tb", "Xác nhận mật khẩu mới không đúng !");
					return "home/doimk";
				}
					try {
				RestTemplate rt = new RestTemplate();
				HttpHeaders headers = getHeaders();
				taikhoan.setPassword(passwordEncoder.encode(mkmoi));
				HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(taikhoan, headers);
				rt.put(URL+"customer/taikhoan", requestEntity);
				model.addAttribute("message", "Mật khẩu của bạn đã được thay đổi. Vui lòng kiểm tra Email của bạn !");
				mailer.send("diepkhanhvuong3012@gmail.com", taikhoan.getEmail(), 
						"Tin nhắn thông báo xác nhận thay đổi mật khẩu", 
						". Vui lòng đăng nhập lại để kiểm tra thông tin. "
						+ "Xin cảm ơn !");
				
				model.addAttribute("message", "Cập nhật thành công !");
				return "redirect:/home/index.html";
			}catch(Exception ex) {
				model.addAttribute("message", "Cập nhật thất bại");
				}
			}
			return "home/doimk";		
		}
		
		@RequestMapping("capnhatdh/{id}")
		public String capnhatdon(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
			HttpSession adsession = request.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			HttpHeaders headers = getHeaders();
			HttpEntity<PhieuDatHang> requestEntity = new HttpEntity<PhieuDatHang>(headers);
	        ResponseEntity<PhieuDatHang> responseEntity = restTemplate.exchange(URL+"customer/phieudathang/"+id, HttpMethod.GET, requestEntity, PhieuDatHang.class, 1);
		    PhieuDatHang donhang=responseEntity.getBody();
		    model.addAttribute("donhang", donhang);
			return "home/capnhatdh";
		}

		@RequestMapping(value="capnhatdh/{id}", method=RequestMethod.POST)
		public String capnhatdon1(ModelMap model, @ModelAttribute("donhang")PhieuDatHang donhang, 
				 HttpServletRequest request, HttpServletResponse response){
			HttpSession adsession = request.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			try {
				HttpHeaders headers = getHeaders();
				HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
				restTemplate.exchange(URL+"customer/huydon/"+donhang.getId(), HttpMethod.GET, requestEntity, String.class);
				model.addAttribute("message", "Cập nhật thành công !");
				return "redirect:/home/lichsu.html";
			}catch(Exception ex) {
				model.addAttribute("tb", "Cập nhật thất bại");
			}
			return "redirect:/home/lichsu.html";		
		}

		@RequestMapping("thaydoiuser/{id}")
		public String thaydoiuser(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
			HttpSession adsession = request.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			RestTemplate rt = new RestTemplate();
			HttpHeaders headers = getHeaders();
			HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(headers);
	        ResponseEntity<TaiKhoan> responseEntity = rt.exchange(URL+"customer/taikhoan/"+id, HttpMethod.GET, requestEntity, TaiKhoan.class, 1);
		    TaiKhoan taikhoan=responseEntity.getBody();
		    model.addAttribute("taikhoan",taikhoan);
		   	return "home/thaydoiuser";
		}

		@RequestMapping(value="thaydoiuser/{id}", method=RequestMethod.POST)
		public String capnhatuser(ModelMap model,@Validated @ModelAttribute("taikhoan")TaiKhoan taikhoan, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response){
			HttpSession adsession = request.getSession();
			adsession.getAttribute("taikhoan");
			if(adsession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			if(errors.hasErrors()){
				model.addAttribute("message","Vui lòng kiểm tra lỗi!");
			}
			else if(checkKitu(taikhoan.getHoTen()) == false) {
				model.addAttribute("tb", "Họ tên bạn nhập chưa đúng định dạng !");
				return "home/thaydoiuser";
			}
			else if(checkSdt(taikhoan.getSdt()) == false) {
				model.addAttribute("tb", "Sdt bạn nhập chưa đúng định dạng !");
				return "home/thaydoiuser";
			}
			else{
				String anh = request.getParameter("photo");
				try {
					
					if(anh.isEmpty())
					{
						taikhoan.setAnh(taikhoan.getAnh());
					}
					else{taikhoan.setAnh(anh);}
				RestTemplate rt = new RestTemplate();
				HttpHeaders headers = getHeaders();
				HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(taikhoan, headers);
		        rt.put(URL+"customer/taikhoan", requestEntity);
				model.addAttribute("message", "Cập nhật thành công !");
				model.addAttribute("message", "Thông tin tài khoản của bạn đã được thay đổi. Vui lòng kiểm tra Email của bạn !");
				mailer.send("Thaydoithongtin", taikhoan.getEmail(), 
						"Tin nhắn thông báo xác nhận thay đổi thông tin tài khoản", 
						". Vui lòng đăng nhập lại trang web để kiểm tra lại thông tin. "
						+ "Xin cảm ơn !");
				return "redirect:/home/index.html";
			}catch(Exception ex) {
				model.addAttribute("message", "Cập nhật thất bại");
			}
			}
			return "home/thaydoiuser";		
		}
		
		@RequestMapping(value="quenmk", method=RequestMethod.GET)
		public String quenmk(ModelMap model, HttpServletRequest req, HttpServletResponse response) {
			HttpSession v = req.getSession();
			if(v.getAttribute("taikhoan") != null) {
				return "redirect:/home/index.html";
			}
			else {
				return "home/quenmk";
			}
		}
		
		@RequestMapping(value="quenmk", method=RequestMethod.POST)
		public String quenmk1(ModelMap model, HttpServletRequest req) {
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			id.trim();
			email.trim();
			String matkhaumoi = randomNumber();
			if(id.length() == 0) {
				model.addAttribute("message1", "Vui lòng nhập Username !");
				return "home/quenmk";
			}
			
			
			if(email.length() == 0) {
				model.addAttribute("message2", "Vui lòng nhập email tài khoản !");
				return "home/quenmk";
			}
			else {
				if(checkEmail(email) == false) {
					model.addAttribute("tb", "Email bạn nhập chưa đúng định dạng !");
					return "home/quenmk";
				}
				
				if(checkId(id) == false) {
					model.addAttribute("tb", "Username của bạn nhập chưa đúng định dạng !");
					return "home/quenmk";
				}
				
				List<TaiKhoan> check = getTaiKhoan();
				for(TaiKhoan u : check) {
					if(id.trim().equals(u.getUsername())== true && email.trim().equals(u.getEmail()) == true) {
						Session session = factory.openSession();
						Transaction t = session.beginTransaction();
						try {
							
							model.addAttribute("message", "Mật khẩu của bạn đã được thay đổi. Vui lòng kiểm tra Email của bạn !");
							mailer.send("diepkhanhvuong3012@gmail.com", email, 
									"Tin nhắn thông báo lấy lại mật khẩu", 
									"Mật khẩu mới của bạn là: " + matkhaumoi + " . Vui lòng đăng nhập lại để thay đổi mật khẩu mới. "
									+ "Xin cảm ơn !");
							u.setPassword(passwordEncoder.encode(matkhaumoi));
							RestTemplate rt = new RestTemplate();
							rt.put(URL+"guest/taikhoan", u, String.class);
							model.addAttribute("message", "Mật khẩu của bạn đã được thay đổi. Vui lòng kiểm tra Email của bạn !");
							t.commit();
							return "home/quenmk";
						}
						catch(Exception ex) {
							t.rollback();
							return "home/quenmk";
						}
						finally {
							session.close();
						}
					}
				}
				model.addAttribute("message", "Id hoặc Email chưa đúng. Vui lòng kiểm tra lại !");
			}
			return "home/quenmk";
		}
		
		public Boolean checkKitu(String email) {
	        String emailPattern = "^[\\p{L} .'-]+$";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(email);
	        if (matcher.find()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public Boolean checkDiachi(String email) {
	        String emailPattern = "\\w+";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(email);
	        if (matcher.find()) {
	            return true;
	        } else {
	            return false;
	        }
	    }


	    public Boolean checkSdt(String sdt) {
	        String emailPattern = "0[0-9]{9,10}";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(sdt);
	        if (matcher.find()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public Boolean checkId(String id) {
	        String emailPattern = "[a-zA-Z0-9_-]{1,8}$";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(id);
	        if (matcher.find()) {
	            return true;
	        } else {
	            return false;
	        }
	    }




		
		@RequestMapping(value="dathang/{id}", method=RequestMethod.GET)
		public String donhang1(ModelMap model, @PathVariable("id") String id, HttpServletResponse response, HttpServletRequest request){
			HttpSession usersession = request.getSession();
			usersession.getAttribute("taikhoan");
			if(usersession.getAttribute("taikhoan")==null){
				return "redirect:/home/index.html";
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			HttpHeaders headers = getHeaders();
			HttpEntity<HangHoa> requestEntity = new HttpEntity<HangHoa>(headers);
	        ResponseEntity<HangHoa> responseEntity = restTemplate.exchange(URL+"guest/hanghoa/"+id, HttpMethod.GET, requestEntity, HangHoa.class, 1);
	        HangHoa sanpham = responseEntity.getBody();
			model.addAttribute("sanpham",sanpham);
			model.addAttribute("theloais", getTheLoai());
			model.addAttribute("thuonghieus", getThuongHieu());
			model.addAttribute("sanphams", getSanpham());
			return "home/dathang";
		}
		
		@RequestMapping(value="dathang/{id}", method=RequestMethod.POST)
		public String themth(@ModelAttribute("chitietdonhang")CT_PhieuDatHang chitietdonhang,@PathVariable("id") String id,@ModelAttribute("donhang")PhieuDatHang donhang, ModelMap model, HttpServletRequest request, HttpServletResponse response){
			HttpSession usersession = request.getSession();
			TaiKhoan taikhoan = (TaiKhoan) usersession.getAttribute("taikhoan");
			if(usersession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			String total = request.getParameter("soLuong");
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			HttpHeaders headers = getHeaders();
			HttpEntity<HangHoa> requestEntity = new HttpEntity<HangHoa>(headers);
	        ResponseEntity<HangHoa> responseEntity = restTemplate.exchange(URL+"guest/hanghoa/"+id, HttpMethod.GET, requestEntity, HangHoa.class, 1);
	        HangHoa sanpham = responseEntity.getBody();
			model.addAttribute("sanpham",sanpham);
			model.addAttribute("theloais",getTheLoai());
			model.addAttribute("thuonghieus",getThuongHieu());
			try {
				RestTemplate rt1 = new RestTemplate();
				String idDH = "PDH"+randomNumber();
				donhang.setId(idDH); 
				donhang.setNgayLap(new Date());
				donhang.setTrangThai(0);
				donhang.setTaiKhoanId(taikhoan.getDiaChi());
				donhang.setTaiKhoanId(taikhoan.getId());
				donhang.setTongTien(sanpham.getGia()*Integer.valueOf(total));
				HttpEntity<PhieuDatHang> dh = new HttpEntity<PhieuDatHang>(donhang, headers);
		        rt1.postForLocation(URL+"customer/phieudathang", dh);
				RestTemplate rt2 = new RestTemplate();
				String idCTDH="CTDH"+randomNumber();
				chitietdonhang.setIdHH(sanpham.getId());
				chitietdonhang.setId(idCTDH);
				chitietdonhang.setIdPhieuDatHang(idDH);
				chitietdonhang.setSoLuong(Integer.valueOf(total));
				HttpEntity<CT_PhieuDatHang> ctdh = new HttpEntity<CT_PhieuDatHang>(chitietdonhang, headers);
				rt2.postForLocation(URL+"customer/chitietdathang", ctdh);
				model.addAttribute("message", "Đặt hàng thành công! Vui lòng kiểm tra Email để biết thêm chi tiết");
				mailer.send("diepkvuong3012@gmail.com", taikhoan.getEmail(), "ĐẶT HÀNG THÀNH CÔNG", "Cám ơn quý khách đã tin tưởng sản phẩm của chúng tôi"
				+"\nChúng tôi sẽ cố gắng giao hàng sớm nhất cho bạn"	
						);
				model.addAttribute("message", "Đặt hàng thành công !");
				return "redirect:/home/lichsu.html";
			}catch(Exception ex) {
				model.addAttribute("message", "");
			}
			return "home/dathang";
		}
		
	}

