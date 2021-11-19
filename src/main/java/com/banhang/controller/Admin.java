package com.banhang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.banhang.model.*;
import com.sun.glass.ui.Application;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;


@Transactional
@Controller
@RequestMapping("/admin/")
public class Admin {
	private static final String URL ="http://localhost:8080/staff";
//	private static final String URL ="https://khanhvuong.herokuapp.com";
	@Autowired
	SessionFactory factory;
	RestTemplate restTemplate=new RestTemplate();
	@Autowired
	Mailer mailer;
	
	@Autowired
	ServletContext context;
	@RequestMapping("dangxuat")
	public String dangxuat(HttpServletRequest request){
		HttpSession dangxuat = request.getSession();
		dangxuat.removeAttribute("admin");
		return "redirect:/home/index.html";
	}
	@RequestMapping("index")
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		return "admin/index";	
	}
	
	
	public List<HangHoa> getSanpham() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<HangHoa[]> requestEntity = new HttpEntity<HangHoa[]>(headers);
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.exchange(URL+"/hanghoa", HttpMethod.GET, requestEntity, HangHoa[].class);
          HangHoa[] responseBody = responseEntity.getBody();
	      List<HangHoa> list = Arrays.asList(responseBody);
		return list;
	}
	
	@RequestMapping("thongkethang")
	public String thongkethangsa(ModelMap model,HttpServletRequest request, HttpServletResponse response){
		String thang = request.getParameter("thang");
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<ThongKeThang[]> requestEntity = new HttpEntity<ThongKeThang[]>(headers);
		ResponseEntity<ThongKeThang[]> responseEntity = restTemplate.exchange(URL+"/thongkethang/"+thang, HttpMethod.GET, requestEntity, ThongKeThang[].class);
        ThongKeThang[] responseBody = responseEntity.getBody();
	    List<ThongKeThang> list3 = Arrays.asList(responseBody);
	   model.addAttribute("thongkethangs", list3);
		return "admin/ThongKeLoiNhuan";
	}
	
	@RequestMapping("thongkengay")
	public String thongketngay(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String ngay = request.getParameter("ngay");
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<ThongKeNgay[]> requestEntity = new HttpEntity<ThongKeNgay[]>(headers);
		ResponseEntity<ThongKeNgay[]> responseEntity = restTemplate.exchange(URL+"/thongkengay/"+ngay, HttpMethod.GET, requestEntity, ThongKeNgay[].class);
        ThongKeNgay[] responseBody = responseEntity.getBody();
	    List<ThongKeNgay> list3 = Arrays.asList(responseBody);
	   model.addAttribute("thongkengays", list3);
		return "admin/thongkengay";
	}
	
	@RequestMapping("thongkequy")
	public String thongkethang(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String quy = request.getParameter("quy");
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<ThongKeQuy[]> requestEntity = new HttpEntity<ThongKeQuy[]>(headers);
		ResponseEntity<ThongKeQuy[]> responseEntity = restTemplate.exchange(URL+"/thongkequy/"+quy, HttpMethod.GET, requestEntity, ThongKeQuy[].class);
        ThongKeQuy[] responseBody = responseEntity.getBody();
	    List<ThongKeQuy> list3 = Arrays.asList(responseBody);
	   model.addAttribute("thongkequys", list3);
		return "admin/thongkequy";
	}
	
	
	@RequestMapping("thongke")
	public String thongke(ModelMap model,HttpServletRequest request, HttpServletResponse response){ 
		return "admin/thongke";
	}
	
	public List<PhieuDatHang> getDonHang() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<PhieuDatHang[]> requestEntity = new HttpEntity<PhieuDatHang[]>(headers);
		ResponseEntity<PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"/phieudathang", HttpMethod.GET, requestEntity, PhieuDatHang[].class);
          PhieuDatHang[] responseBody = responseEntity.getBody();
	      List<PhieuDatHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<PhieuNhapHang> getNhapHang() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<PhieuNhapHang[]> requestEntity = new HttpEntity<PhieuNhapHang[]>(headers);
		ResponseEntity<PhieuNhapHang[]> responseEntity = restTemplate.exchange(URL+"/phieunhaphang", HttpMethod.GET, requestEntity, PhieuNhapHang[].class);
	      PhieuNhapHang[] responseBody = responseEntity.getBody();
	      List<PhieuNhapHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<TheLoai> getTheLoai() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<TheLoai[]> requestEntity = new HttpEntity<TheLoai[]>(headers);
		ResponseEntity<TheLoai[]> responseEntity = restTemplate.exchange(URL+"/theloai", HttpMethod.GET, requestEntity, TheLoai[].class);
          TheLoai[] responseBody = responseEntity.getBody();
	      List<TheLoai> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<GiaNhap> getGiaNhap() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<GiaNhap[]> requestEntity = new HttpEntity<GiaNhap[]>(headers);
		ResponseEntity<GiaNhap[]> responseEntity = restTemplate.exchange(URL+"/chitietgianhap", HttpMethod.GET, requestEntity, GiaNhap[].class);
          GiaNhap[] responseBody = responseEntity.getBody();
	      List<GiaNhap> list = Arrays.asList(responseBody);
		return list;
	}

	
	public List<TinTuc> getTinTuc() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<TinTuc[]> requestEntity = new HttpEntity<TinTuc[]>(headers);
		ResponseEntity<TinTuc[]> responseEntity = restTemplate.exchange(URL+"/tintuc", HttpMethod.GET, requestEntity, TinTuc[].class);
          TinTuc[] responseBody = responseEntity.getBody();
	      List<TinTuc> list = Arrays.asList(responseBody);
		return list;
	}
	
	
	public List<ThuongHieu> getThuongHieu() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<ThuongHieu[]> requestEntity = new HttpEntity<ThuongHieu[]>(headers);
		ResponseEntity<ThuongHieu[]> responseEntity = restTemplate.exchange(URL+"/thuonghieu", HttpMethod.GET, requestEntity, ThuongHieu[].class);
          ThuongHieu[] responseBody = responseEntity.getBody();
	      List<ThuongHieu> list = Arrays.asList(responseBody);
		return list;
		
	}
	
	public List<TaiKhoan> getTaiKhoan() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<TaiKhoan[]> requestEntity = new HttpEntity<TaiKhoan[]>(headers);
		ResponseEntity<TaiKhoan[]> responseEntity = restTemplate.exchange(URL+"/taikhoan", HttpMethod.GET, requestEntity, TaiKhoan[].class);
          TaiKhoan[] responseBody = responseEntity.getBody();
	      List<TaiKhoan> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<CT_PhieuDatHang> getChiTietDonHang() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<CT_PhieuDatHang[]> requestEntity = new HttpEntity<CT_PhieuDatHang[]>(headers);
		ResponseEntity<CT_PhieuDatHang[]> responseEntity = restTemplate.exchange(URL+"/chitietdathang", HttpMethod.GET, requestEntity, CT_PhieuDatHang[].class);
          CT_PhieuDatHang[] responseBody = responseEntity.getBody();
	      List<CT_PhieuDatHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<CT_PhieuNhapHang> getChiTietNhapHang() {
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<CT_PhieuNhapHang[]> requestEntity = new HttpEntity<CT_PhieuNhapHang[]>(headers);
		ResponseEntity<CT_PhieuNhapHang[]> responseEntity = restTemplate.exchange(URL+"/chitietnhaphang", HttpMethod.GET, requestEntity, CT_PhieuNhapHang[].class);
          CT_PhieuNhapHang[] responseBody = responseEntity.getBody();
	      List<CT_PhieuNhapHang> list = Arrays.asList(responseBody);
		return list;
	}
	//=================================PNH============================//
	@RequestMapping("phieunhaphang")
	public String phieunhaphang(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("chitietnhaps", getChiTietNhapHang());
		model.addAttribute("nhaphangs", getNhapHang());
		return "admin/phieunhaphang";
	}
	
	@RequestMapping("chitietnhaphang")
	public String chitietnhap(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("sanphams", getSanpham());
		model.addAttribute("nhaphangs", getNhapHang());
		model.addAttribute("chitietnhaps", getChiTietNhapHang());
		return "admin/chitietnhaphang";
		
	}
	
	@RequestMapping("chitietnhap/{id}")
	public String ctnhap(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<CT_PhieuNhapHang> requestEntity = new HttpEntity<CT_PhieuNhapHang>(Home.getHeaders());
        ResponseEntity<CT_PhieuNhapHang> responseEntity = restTemplate.exchange(URL+"/chitietnhaphang/"+id, HttpMethod.GET, requestEntity, CT_PhieuNhapHang.class, 1);
	    CT_PhieuNhapHang chitiet=responseEntity.getBody();
	    HttpEntity<GiaNhap> requestGN = new HttpEntity<GiaNhap>(Home.getHeaders());
        ResponseEntity<GiaNhap> responseGN = restTemplate.exchange(URL+"/hanghoa/gianhaphang/"+chitiet.getidhh(), HttpMethod.GET, requestGN, GiaNhap.class, 1);
	    GiaNhap gianhap=responseGN.getBody();
	    model.addAttribute("gianhap",gianhap);
		model.addAttribute("chitiet",chitiet);
		model.addAttribute("sanphams", getSanpham());
		return "admin/chitietnhap";
	}	
	
	@RequestMapping("chitiet_dat/{id}")
	public String ctdat(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		RestTemplate rt = new RestTemplate();
		HttpEntity<CT_PhieuDatHang> requestEntity = new HttpEntity<CT_PhieuDatHang>(Home.getHeaders());
        ResponseEntity<CT_PhieuDatHang> responseEntity = rt.exchange(URL+"/chitietdathang/"+id, HttpMethod.GET, requestEntity, CT_PhieuDatHang.class, 1);
	    CT_PhieuDatHang chitiet=responseEntity.getBody();
	   model.addAttribute("chitiet",chitiet);
		model.addAttribute("sanphams", getSanpham());
		return "admin/chitiet_dat";
	}	
	
	//===============================================TIN TUC============================================//
	@RequestMapping("tintuc")
	public String tintuc(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("tintucs", getTinTuc());
		model.addAttribute("taikhoans",getTaiKhoan());
		return "admin/tintuc";
	}
	@RequestMapping("capnhattin/{id}")
	public String capnhattin(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<TinTuc> requestEntity = new HttpEntity<TinTuc>(Home.getHeaders());
        ResponseEntity<TinTuc> responseEntity = restTemplate.exchange(URL+"/tintuc/"+id, HttpMethod.GET, requestEntity, TinTuc.class, 1);
	    TinTuc tintuc=responseEntity.getBody();
	   model.addAttribute("tintuc",tintuc);
		return "admin/capnhattin";
	}

	@RequestMapping(value="capnhattin/{id}", method=RequestMethod.POST)
	public String capnhattin(ModelMap model,@Validated @ModelAttribute("tintuc")TinTuc tintuc, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		String anh = request.getParameter("photo");
		try {
			
			if(anh.isEmpty())
			{
				tintuc.setAnh(tintuc.getAnh());
			}
			else{tintuc.setAnh(anh);}
			RestTemplate rt = new RestTemplate();
			tintuc.setNgayDang(new Date());
			HttpEntity<TinTuc> requestEntity = new HttpEntity<TinTuc>(tintuc, Home.getHeaders());
			rt.put(URL+"/tintuc/"+tintuc.getId(), requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/tintuc.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		}
		return "admin/capnhattin";		
	}
	
	@RequestMapping(value="themtin")
	public String themtintuc(@Validated @ModelAttribute("tintuc")TinTuc tintuc,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			tintuc.setNgayDang(new Date());
			HttpEntity<TinTuc> tk = new HttpEntity<TinTuc>(tintuc, Home.getHeaders());
	        rt.postForLocation(URL+"/tintuc", tk);
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/admin/tintuc.html";
			}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "admin/themtin";
	}
	
		
	@RequestMapping(value="xoatin/{id}")
	public String xoatin(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<TinTuc> requestEntity = new HttpEntity<TinTuc>(Home.getHeaders());
			rt.exchange(URL+"/tintuc/"+id, HttpMethod.DELETE, requestEntity, Void.class, 2);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/tintuc.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		}
		
		model.addAttribute("tintucs", getTinTuc());
		
		return "admin/tintuc";
	}
	
	//=====================================================SAN PHAM=============================================//
	@RequestMapping("sanpham")
	public String sanpham(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("sanphams", getSanpham());
		return "admin/sanpham";
	}
	
	@RequestMapping(value="xoasp/{id}")
	public String xoasp(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			RestTemplate rt2 = new RestTemplate();
			HttpEntity<GiaNhap> requestEntity = new HttpEntity<GiaNhap>(Home.getHeaders());
			rt.exchange(URL+"/gianhap/"+id, HttpMethod.DELETE, requestEntity, Void.class, 2);
			HttpEntity<HangHoa> requestEntity2 = new HttpEntity<HangHoa>(Home.getHeaders());
	        rt2.exchange(URL+"/hanghoa/"+id, HttpMethod.DELETE, requestEntity2, Void.class,2);      
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception e) {
			model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		}
		
		model.addAttribute("sanphams", getSanpham());
		model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		return "admin/sanpham";
	}
	
	@RequestMapping("capnhatsp/{id}")
	public String capnhatsp(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<HangHoa> requestEntity = new HttpEntity<HangHoa>(Home.getHeaders());
		ResponseEntity<HangHoa> responseEntityHH = restTemplate.exchange(URL+"/hanghoa/"+id, HttpMethod.GET, requestEntity, HangHoa.class, 1);
	    HangHoa sanpham=responseEntityHH.getBody();
	    HttpEntity<GiaNhap> requestEntity2 = new HttpEntity<GiaNhap>(Home.getHeaders());
        ResponseEntity<GiaNhap> responseEntity = restTemplate.exchange(URL+"/hanghoa/gianhaphang/"+id, HttpMethod.GET, requestEntity2, GiaNhap.class, 1);
	    GiaNhap gianhap=responseEntity.getBody();
	    model.addAttribute("gianhap",gianhap);
		model.addAttribute("theloais", getTheLoai());
		model.addAttribute("thuonghieus", getThuongHieu());
		model.addAttribute("sanpham",sanpham);
		model.addAttribute("sanphams", getSanpham());
		return "admin/capnhatsp";
	}

	@RequestMapping(value="capnhatsp/{id}", method=RequestMethod.POST)
	public String capnhatsp1(ModelMap model,@Validated @ModelAttribute("sanpham")HangHoa sanpham, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		HttpEntity<GiaNhap> requestEntity = new HttpEntity<GiaNhap>(Home.getHeaders());
		ResponseEntity<GiaNhap> responseEntity = restTemplate.exchange(URL+"/hanghoa/gianhaphang/"+sanpham.getId(), HttpMethod.GET, requestEntity, GiaNhap.class, 1);
	    GiaNhap gianhapmoi=responseEntity.getBody();
	    model.addAttribute("gianhap",gianhapmoi);
		model.addAttribute("theloais", getTheLoai());
		model.addAttribute("thuonghieus", getThuongHieu());
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		
		else {
		String giaNhap = request.getParameter("giaNhap");
		String anh = request.getParameter("photo");
		try {
			
			if(anh.isEmpty())
			{
				sanpham.setAnh(sanpham.getAnh());
			}
			else{sanpham.setAnh(anh);
			}
				
			RestTemplate rt = new RestTemplate();
			HttpEntity<HangHoa> requestEntity1 = new HttpEntity<HangHoa>(sanpham, Home.getHeaders());
			rt.put(URL+"/hanghoa", requestEntity1);
			if(!String.valueOf(giaNhap).equals("")) {
				gianhapmoi.setGia(new BigDecimal(String.valueOf(giaNhap)));
			
			}
			else  {gianhapmoi.setGia(gianhapmoi.getGia());
			}
			gianhapmoi.setIdHH(sanpham.getId());
			if(gianhapmoi.getNgayApDung()!=LocalDate.now().toString()) {
			gianhapmoi.setNgayApDung(LocalDate.now().toString());
			HttpEntity<GiaNhap> gn = new HttpEntity<GiaNhap>(gianhapmoi, Home.getHeaders());
	        restTemplate.postForLocation(URL+"/chitietgianhap", gn);
			}
			model.addAttribute("message", "Cập nhật sản phẩm thành công, thêm giá nhập mới !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception ex) {
			gianhapmoi.setNgayApDung(gianhapmoi.getNgayApDung());
			gianhapmoi.setIdHH(sanpham.getId());
			if(!String.valueOf(giaNhap).equals("")) {
				gianhapmoi.setGia(new BigDecimal(String.valueOf(giaNhap)));
			
			}
			else  {gianhapmoi.setGia(gianhapmoi.getGia());
			}
			RestTemplate rt1 = new RestTemplate();
			RestTemplate rt = new RestTemplate();
			HttpEntity<HangHoa> requestEntity1 = new HttpEntity<HangHoa>(sanpham, Home.getHeaders());
			rt.put(URL+"/hanghoa", requestEntity1);
			HttpEntity<GiaNhap> gn = new HttpEntity<GiaNhap>(gianhapmoi, Home.getHeaders());
			rt1.put(URL+"/chitietgianhap", gn);
			model.addAttribute("message", "Cập nhật giá nhập hôm nay");
			return "redirect:/admin/sanpham.html";
		}
		}
		return "admin/capnhatsp";		
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
	
	@RequestMapping(value="themnv")
	public String themnv(@Validated @ModelAttribute("taikhoan")TaiKhoan taikhoan,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){	
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
			String user = request.getParameter("user");
			String matkhaumoi = randomNumber();
			List<TaiKhoan> check = getTaiKhoan();
			for(TaiKhoan u : check) {
				if(user.trim().equals(u.getUsername().trim()) == true) {
					model.addAttribute("tb", "Tài khoản đã tồn tài ! Vui lòng nhập lại username mới!");
					return "admin/themnv";
				}
			}
		try {
			RestTemplate rt = new RestTemplate();
			taikhoan.setAnh("khanhvuong.jpg");
			taikhoan.setPassword(matkhaumoi);
			taikhoan.setId("NV"+randomNumber());
			HttpEntity<TaiKhoan> tk = new HttpEntity<TaiKhoan>(taikhoan, Home.getHeaders());
	        rt.postForLocation(URL+"/taikhoan", tk);
			mailer.send("diepkvuong3012@gmail.com", taikhoan.getEmail(), "XÁC NHẬN", "Đăng kí thành công với Mã tài khoản là: " + taikhoan.getId() + "\nQuay lại trang đăng nhập để mua hàng ngay!" +"Mật khẩu của bạn là: " + matkhaumoi + " . Vui lòng đăng nhập lại để thay đổi mật khẩu mới. ");
			model.addAttribute("message", "Thêm nhân viên thành công !");
			return "redirect:/admin/taikhoan.html";
			
			}catch(Exception ex) {
			model.addAttribute("message", "");
			}
		}
		return "admin/themnv";
	}
	
	
	@RequestMapping("capnhatth/{id}")
	public String capnhatth(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<ThuongHieu> requestEntity = new HttpEntity<ThuongHieu>(Home.getHeaders());
        ResponseEntity<ThuongHieu> responseEntity = restTemplate.exchange(URL+"/thuonghieu/"+id, HttpMethod.GET, requestEntity, ThuongHieu.class, 1);
	    ThuongHieu thuonghieu=responseEntity.getBody();
	    model.addAttribute("thuonghieu",thuonghieu);
		return "admin/capnhatth";
	}

	@RequestMapping(value="capnhatth/{id}", method=RequestMethod.POST)
	public String capnhatth1(ModelMap model,@Validated @ModelAttribute("thuonghieu")ThuongHieu thuonghieu, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		String anh = request.getParameter("photo");
		try {
			
			if(anh.isEmpty())
			{
				thuonghieu.setAnh(thuonghieu.getAnh());
			}
			else{thuonghieu.setAnh(anh);}
				
			RestTemplate rt = new RestTemplate();
			HttpEntity<ThuongHieu> requestEntity = new HttpEntity<ThuongHieu>(thuonghieu, Home.getHeaders());
			rt.put(URL+"/thuonghieu/"+thuonghieu.getId(), requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/thuonghieu.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		}
		return "admin/capnhatth";		
	}
	
	
	@RequestMapping("capnhattl/{id}")
	public String capnhattl(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<TheLoai> requestEntity = new HttpEntity<TheLoai>(Home.getHeaders());
        ResponseEntity<TheLoai> responseEntity = restTemplate.exchange(URL+"/theloai/"+id, HttpMethod.GET, requestEntity, TheLoai.class, 1);
	    TheLoai theloai=responseEntity.getBody();
	    model.addAttribute("theloai",theloai);
		return "admin/capnhattl";
	}

	@RequestMapping(value="capnhattl/{id}", method=RequestMethod.POST)
	public String capnhattl1(ModelMap model,@Validated @ModelAttribute("theloai")TheLoai theloai,BindingResult errors, 
			 HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<TheLoai> requestEntity = new HttpEntity<TheLoai>(theloai, Home.getHeaders());
			rt.put(URL+"/theloai/"+theloai.getId(), requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/theloai.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		}
		return "admin/capnhattl";		
	}
	
	@RequestMapping(value="capnhatgianhap/{idHH}", method=RequestMethod.GET)
	public String capnhatgianhap(ModelMap model, @PathVariable("idHH") String idHH, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<GiaNhap> requestEntity = new HttpEntity<GiaNhap>(Home.getHeaders());
        ResponseEntity<GiaNhap> responseEntity = restTemplate.exchange(URL+"/hanghoa/gianhaphang/"+idHH, HttpMethod.GET, requestEntity, GiaNhap.class, 1);
	    GiaNhap gianhap=responseEntity.getBody();
	   model.addAttribute("gianhap",gianhap);
		model.addAttribute("sanphams",getSanpham());
		return "admin/capnhatgianhap";
	}

	@RequestMapping(value="capnhatgianhap/{idHH}", method=RequestMethod.POST)
	public String capnhatgn(ModelMap model,@ModelAttribute("gianhap")GiaNhap gianhap, 
			 HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<GiaNhap> requestEntity = new HttpEntity<GiaNhap>(gianhap, Home.getHeaders());
	        rt.put(URL+"/chitietgianhap", requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/gianhap.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/capnhatgianhap";		
	}



	
	@RequestMapping(value="themsp")
	public String themsanpham(@Validated @ModelAttribute("sanpham")HangHoa sanpham,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		GiaNhap gianhap=new GiaNhap();
		String giahh = request.getParameter("giaNhap");
		model.addAttribute("theloais", getTheLoai());
		model.addAttribute("thuonghieus", getThuongHieu());
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
	
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<HangHoa> tk = new HttpEntity<HangHoa>(sanpham, Home.getHeaders());
	        rt.postForLocation(URL+"/hanghoa", tk);
			gianhap.setNgayApDung(LocalDate.now().toString().trim());
			gianhap.setIdHH(sanpham.getId());
			gianhap.setGia(new BigDecimal(giahh));
			HttpEntity<GiaNhap> tk1 = new HttpEntity<GiaNhap>(gianhap, Home.getHeaders());
	        rt.postForLocation(URL+"/chitietgianhap", tk1);
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "admin/themsp";
	}
	
	@RequestMapping(value="thempn")
	public String thempn(@ModelAttribute("chitietnhaphang")CT_PhieuNhapHang chitietnhaphang, @ModelAttribute("nhaphang")PhieuNhapHang nhaphang, BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		model.addAttribute("gias", getGiaNhap());
		model.addAttribute("sanphams", getSanpham());
		model.addAttribute("chitiets", getChiTietNhapHang());
		TaiKhoan taikhoan = (TaiKhoan) adsession.getAttribute("admin");
		String total = request.getParameter("soLuongNhap");
		String giaHH = request.getParameter("giaHH");
		try {
			RestTemplate rt1 = new RestTemplate();
			String idNH = "PNH"+randomNumber();
			nhaphang.setId(idNH); 
			nhaphang.setNgayLap(new Date());
			nhaphang.setTrangThai(0);
			nhaphang.setTaiKhoanId(taikhoan.getId());
			nhaphang.setTongTien(Integer.valueOf(giaHH)*Integer.valueOf(total));
			HttpEntity<PhieuNhapHang> tk = new HttpEntity<PhieuNhapHang>(nhaphang, Home.getHeaders());
	        rt1.postForLocation(URL+"/phieunhaphang", tk);
			RestTemplate rt2 = new RestTemplate();
			String idCTNH="CTNH"+randomNumber();
			chitietnhaphang.setId(idCTNH);
			chitietnhaphang.setidPhieuNhapHang(idNH);
			chitietnhaphang.setSoLuong(Integer.valueOf(total));
			HttpEntity<CT_PhieuNhapHang> tk2 = new HttpEntity<CT_PhieuNhapHang>(chitietnhaphang, Home.getHeaders());
	        rt2.postForLocation(URL+"/chitietnhaphang", tk2);
			model.addAttribute("message", "Thêm thành công !");
			}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return "admin/thempn";
	}
	//=====================================================THE LOAI=============================================//
	
	@RequestMapping("theloai")
	public String theloai(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("theloais", getTheLoai());
		return "admin/theloai";
		
	}
	
	@RequestMapping("gianhap")
	public String gianhap(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("gianhaps", getGiaNhap());
		return "admin/gianhap";
		
	}
	
	@RequestMapping(value="themtl")
	public String themtl(@Validated @ModelAttribute("theloai")TheLoai theloai,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt1 = new RestTemplate();
			HttpEntity<TheLoai> tk1 = new HttpEntity<TheLoai>(theloai, Home.getHeaders());
	        rt1.postForLocation(URL+"/theloai", tk1);
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/admin/theloai.html";
		}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "admin/themtl";
	}
	
	@RequestMapping(value="xoatl/{id}")
	public String xoatl(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<String> requestEntity = new HttpEntity<String>(Home.getHeaders());
			rt.exchange(URL+"/theloai/"+id, HttpMethod.DELETE, requestEntity, Void.class, 2);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/theloai.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		}
		
		model.addAttribute("theloais", getTheLoai());
		
		return "admin/theloai";
	}
	
	//=====================================================CHI TIET DON HANG=============================================//
	@RequestMapping("chitietdon")
	public String chitietdon(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("donhangs", getDonHang());
		model.addAttribute("sanphams", getSanpham());
			model.addAttribute("chitietdons", getChiTietDonHang());
		return "admin/chitietdon";
		
	}
	
	@RequestMapping("thuonghieu")
	public String thuonghieu(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("thuonghieus", getThuongHieu());
		return "admin/thuonghieu";
	}
	@RequestMapping(value="xoath/{id}")
	public String xoath(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<ThuongHieu> requestEntity = new HttpEntity<ThuongHieu>(Home.getHeaders());
			rt.exchange(URL+"/thuonghieu/"+id, HttpMethod.DELETE, requestEntity, Void.class, 2);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/thuonghieu.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		}
		
		model.addAttribute("thuonghieus", getThuongHieu());
		
		return "admin/thuonghieu";
	}
	
	@RequestMapping(value="xoatk/{id}")
	public String xoatk(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(Home.getHeaders());
			rt.exchange(URL+"/taikhoan/"+id, HttpMethod.DELETE, requestEntity, Void.class, 2);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/taikhoan.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do tài khoản đã có đơn đặt hàng!");
		}
		
		model.addAttribute("taikhoans", getTaiKhoan());
		
		return "admin/taikhoan";
	}
	
	@RequestMapping(value="themth")
	public String themth(@Validated @ModelAttribute("thuonghieu")ThuongHieu thuonghieu,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<ThuongHieu> tk = new HttpEntity<ThuongHieu>(thuonghieu, Home.getHeaders());
	        rt.postForLocation(URL+"/thuonghieu", tk);
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/admin/thuonghieu.html";
		}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "admin/themth";
	}	
	@RequestMapping("taikhoan")
	public String taikhoan(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("taikhoans", getTaiKhoan());
		return "admin/taikhoan";
		
	}
	
	@RequestMapping("taikhoankh")
	public String taikhoankh(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("taikhoans", getTaiKhoan());
		return "admin/taikhoankh";
		
	}
	
	@RequestMapping("capnhatphieunhap/{id}")
	public String capnhatpn1(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<PhieuNhapHang> requestEntity = new HttpEntity<PhieuNhapHang>(Home.getHeaders());
        ResponseEntity<PhieuNhapHang> responseEntity = restTemplate.exchange(URL+"/phieunhaphang/"+id, HttpMethod.GET, requestEntity, PhieuNhapHang.class, 1);
	    PhieuNhapHang nhaphang=responseEntity.getBody();
	    model.addAttribute("nhaphang",nhaphang);
		return "admin/capnhatphieunhap";
	}

	@RequestMapping(value="capnhatphieunhap/{id}", method=RequestMethod.POST)
	public String capnhatpn(ModelMap model, @ModelAttribute("nhaphang")PhieuNhapHang nhaphang, 
		HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<PhieuNhapHang> requestEntity = new HttpEntity<PhieuNhapHang>(nhaphang, Home.getHeaders());
			if(nhaphang.getTrangThai()==1) {
				rt.put(URL+"/phieunhaphang/"+nhaphang.getId()+"/1", requestEntity);
			}
			else if(nhaphang.getTrangThai()==-1) {
				rt.put(URL+"/phieunhaphang/"+nhaphang.getId()+"/-1", requestEntity);
				}
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/phieunhaphang.html";
		}
		return "admin/phieunhaphang";		
	}

	
	@RequestMapping("kiemtradon")
	public String kiemtradon(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("chitietdats", getChiTietDonHang());
		model.addAttribute("donhangs", getDonHang());
		return "admin/kiemtradon";
		
	}	
	
	@RequestMapping("capnhatdon/{id}")
	public String capnhatdon(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<PhieuDatHang> requestEntity = new HttpEntity<PhieuDatHang>(Home.getHeaders());
        ResponseEntity<PhieuDatHang> responseEntity = restTemplate.exchange(URL+"/phieudathang/"+id, HttpMethod.GET, requestEntity, PhieuDatHang.class, 1);
	    PhieuDatHang donhang=responseEntity.getBody();
	    model.addAttribute("donhang",donhang);
		return "admin/capnhatdon";
	}

	@RequestMapping(value="capnhatdon/{id}", method=RequestMethod.POST)
	public String capnhatdon1(ModelMap model, @ModelAttribute("donhang")PhieuDatHang donhang, 
		HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			donhang.setNgayLap(new Date());
			HttpEntity<PhieuDatHang> requestEntity = new HttpEntity<PhieuDatHang>(donhang, Home.getHeaders());
			rt.put(URL+"/phieudathang",requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/kiemtradon.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/capnhatdon";		
	}
	
	@RequestMapping("capnhattk/{id}")
	public String capnhattk(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(Home.getHeaders());
        ResponseEntity<TaiKhoan> responseEntity = restTemplate.exchange(URL+"/taikhoan/"+id, HttpMethod.GET, requestEntity, TaiKhoan.class, 1);
	    TaiKhoan taikhoan=responseEntity.getBody();
	    model.addAttribute("taikhoan",taikhoan);
		return "admin/capnhattk";
	}

	@RequestMapping(value="capnhattk/{id}", method=RequestMethod.POST)
	public String capnhattk1(ModelMap model, @ModelAttribute("taikhoan")TaiKhoan taikhoan, 
		HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			HttpEntity<TaiKhoan> requestEntity = new HttpEntity<TaiKhoan>(taikhoan, Home.getHeaders());
			rt.put(URL+"/taikhoan",requestEntity);
			model.addAttribute("message", "Cập nhật thành công !");
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/capnhattk";		
	}
	
	
	@RequestMapping("thongkeloinhuanthang")
	public String thongkelnthang(ModelMap model,HttpServletRequest request, HttpServletResponse response){
		String thang = request.getParameter("thang");
		HttpHeaders headers = Home.getHeaders();
		HttpEntity<ThongKeLoiNhuan[]> requestEntity = new HttpEntity<ThongKeLoiNhuan[]>(headers);
		ResponseEntity<ThongKeLoiNhuan[]> responseEntity = restTemplate.exchange(URL+"/thongkeloinhuanthang/"+thang, HttpMethod.GET, requestEntity, ThongKeLoiNhuan[].class);
        ThongKeLoiNhuan[] responseBody = responseEntity.getBody();
	    List<ThongKeLoiNhuan> list3 = Arrays.asList(responseBody);
	   model.addAttribute("thongkeloinhuanthangs", list3);
		return "admin/thongkeloinhuanthang";
	}
	
	@RequestMapping("thongkeloinhuanngay")
	public String thongkelnngay(ModelMap model,   HttpServletRequest request, HttpServletResponse response){
		HttpHeaders headers = Home.getHeaders();
		String ngaydau = request.getParameter("ngaydau");
		String ngaycuoi = request.getParameter("ngaycuoi");
		HttpEntity<ThongKeLoiNhuan[]> requestEntity = new HttpEntity<ThongKeLoiNhuan[]>(headers);
		ResponseEntity<ThongKeLoiNhuan[]> responseEntity = restTemplate.exchange(URL+"/thongkeloinhuanngay/"+ngaydau+"/"+ngaycuoi, HttpMethod.GET, requestEntity, ThongKeLoiNhuan[].class);
        ThongKeLoiNhuan[] responseBody = responseEntity.getBody();
	    List<ThongKeLoiNhuan> list3 = Arrays.asList(responseBody);
	    model.addAttribute("thongkeloinhuanngays", list3);
		return "admin/thongkeloinhuanngay";
	}
	
	@RequestMapping("thongkeloinhuanquy")
	public String thongkelnquy(ModelMap model,   HttpServletRequest request, HttpServletResponse response){
		HttpHeaders headers = Home.getHeaders();
		String quy = request.getParameter("quy");
		HttpEntity<ThongKeLoiNhuan[]> requestEntity = new HttpEntity<ThongKeLoiNhuan[]>(headers);
		ResponseEntity<ThongKeLoiNhuan[]> responseEntity = restTemplate.exchange(URL+"/thongkeloinhuanquy/"+quy, HttpMethod.GET, requestEntity, ThongKeLoiNhuan[].class);
        ThongKeLoiNhuan[] responseBody = responseEntity.getBody();
	    List<ThongKeLoiNhuan> list3 = Arrays.asList(responseBody);
	    model.addAttribute("thongkeloinhuanquys", list3);
		return "admin/thongkeloinhuanquy";
	}
	
	@RequestMapping("thongkeloinhuannam")
	public String thongkelnnam(ModelMap model,   HttpServletRequest request, HttpServletResponse response){
		HttpHeaders headers = Home.getHeaders();
		String nam = request.getParameter("nam");
		HttpEntity<ThongKeLoiNhuan[]> requestEntity = new HttpEntity<ThongKeLoiNhuan[]>(headers);
		ResponseEntity<ThongKeLoiNhuan[]> responseEntity = restTemplate.exchange(URL+"/thongkeloinhuannam/"+nam, HttpMethod.GET, requestEntity, ThongKeLoiNhuan[].class);
        ThongKeLoiNhuan[] responseBody = responseEntity.getBody();
	    List<ThongKeLoiNhuan> list3 = Arrays.asList(responseBody);
	    model.addAttribute("thongkeloinhuannams", list3);
		return "admin/thongkeloinhuannam";
	}
	
	
	@RequestMapping("thongkeloinhuan")
	public String thongkeloinhuan(ModelMap model,HttpServletRequest request, HttpServletResponse response){
		return "admin/thongkeloinhuan";
	}
	


}