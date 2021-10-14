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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


@Transactional
@Controller
@RequestMapping("/admin/")
public class Admin {
	private static final String URL ="http://localhost:8080";
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		return "admin/index";	
	}
	
	
	public List<HangHoa> getSanpham() {
		ResponseEntity<HangHoa[]> responseEntity = restTemplate.getForEntity(URL+"/hanghoa", HangHoa[].class);
	      HangHoa[] responseBody = responseEntity.getBody();
	      List<HangHoa> list = Arrays.asList(responseBody);
		return list;
	}
	
	@RequestMapping("thongkethang/{thang}")
	public String thongkethang(ModelMap model,@ModelAttribute("thongkethang")ThongKeThang thongkethang, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		String thang = request.getParameter("thang");
		thongkethang.setThang(thang);
		ResponseEntity<ThongKeThang[]> responseEntity = restTemplate.getForEntity(URL+"/thongkethang/"+thang, ThongKeThang[].class);
	    ThongKeThang[] responseBody = responseEntity.getBody();
	    List<ThongKeThang> list3 = Arrays.asList(responseBody);
	   model.addAttribute("thongkethangs", list3);
		return "admin/thongkethang";
	}
	
	public List<PhieuDatHang> getDonHang() {
		ResponseEntity<PhieuDatHang[]> responseEntity = restTemplate.getForEntity(URL+"/phieudathang", PhieuDatHang[].class);
	      PhieuDatHang[] responseBody = responseEntity.getBody();
	      List<PhieuDatHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<PhieuNhapHang> getNhapHang() {
		ResponseEntity<PhieuNhapHang[]> responseEntity = restTemplate.getForEntity(URL+"/phieunhaphang", PhieuNhapHang[].class);
	      PhieuNhapHang[] responseBody = responseEntity.getBody();
	      List<PhieuNhapHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<TheLoai> getTheLoai() {
		ResponseEntity<TheLoai[]> responseEntity = restTemplate.getForEntity(URL+"/theloai", TheLoai[].class);
	      TheLoai[] responseBody = responseEntity.getBody();
	      List<TheLoai> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<GiaNhap> getGiaNhap() {
		ResponseEntity<GiaNhap[]> responseEntity = restTemplate.getForEntity(URL+"/chitietgianhap", GiaNhap[].class);
	      GiaNhap[] responseBody = responseEntity.getBody();
	      List<GiaNhap> list = Arrays.asList(responseBody);
		return list;
	}

	
	public List<TinTuc> getTinTuc() {
		ResponseEntity<TinTuc[]> responseEntity = restTemplate.getForEntity(URL+"/tintuc", TinTuc[].class);
	      TinTuc[] responseBody = responseEntity.getBody();
	      List<TinTuc> list = Arrays.asList(responseBody);
		return list;
	}
	
	
	public List<ThuongHieu> getThuongHieu() {
		ResponseEntity<ThuongHieu[]> responseEntity = restTemplate.getForEntity(URL+"/thuonghieu", ThuongHieu[].class);
	      ThuongHieu[] responseBody = responseEntity.getBody();
	      List<ThuongHieu> list = Arrays.asList(responseBody);
		return list;
		
	}
	
	public List<TaiKhoan> getTaiKhoan() {
		ResponseEntity<TaiKhoan[]> responseEntity = restTemplate.getForEntity(URL+"/taikhoan", TaiKhoan[].class);
	      TaiKhoan[] responseBody = responseEntity.getBody();
	      List<TaiKhoan> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<CT_PhieuDatHang> getChiTietDonHang() {
		ResponseEntity<CT_PhieuDatHang[]> responseEntity = restTemplate.getForEntity(URL+"/chitietdathang", CT_PhieuDatHang[].class);
	      CT_PhieuDatHang[] responseBody = responseEntity.getBody();
	      List<CT_PhieuDatHang> list = Arrays.asList(responseBody);
		return list;
	}
	
	public List<CT_PhieuNhapHang> getChiTietNhapHang() {
		ResponseEntity<CT_PhieuNhapHang[]> responseEntity = restTemplate.getForEntity(URL+"/chitietnhaphang", CT_PhieuNhapHang[].class);
	      CT_PhieuNhapHang[] responseBody = responseEntity.getBody();
	      List<CT_PhieuNhapHang> list = Arrays.asList(responseBody);
		return list;
	}
	//=================================PNH============================//
	@RequestMapping("phieunhaphang")
	public String phieunhaphang(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("nhaphangs", getNhapHang());
		return "admin/phieunhaphang";
	}
	
	@RequestMapping("chitietnhaphang")
	public String chitietnhap(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("nhaphangs", getNhapHang());
			model.addAttribute("chitietnhaps", getChiTietNhapHang());
		return "admin/chitietnhaphang";
		
	}
	
	
	//===============================================TIN TUC============================================//
	@RequestMapping("tintuc")
	public String tintuc(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("tintucs", getTinTuc());
		return "admin/tintuc";
	}
	@RequestMapping("capnhattin/{id}")
	public String capnhattin(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		TinTuc tintuc = rt.getForObject(URL+"/tintuc/{id}", TinTuc.class, params);
		model.addAttribute("tintuc",tintuc);
		return "admin/capnhattin";
	}

	@RequestMapping(value="capnhattin/{id}", method=RequestMethod.POST)
	public String capnhattin(ModelMap model,@Validated @ModelAttribute("tintuc")TinTuc tintuc, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
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
			rt.put(URL+"/tintuc/"+tintuc.getId(), tintuc, String.class);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			tintuc.setNgayDang(new Date());
			rt.postForObject(URL+"/tintuc", tintuc, String.class);
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
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			rt.delete(URL+"/tintuc/{id}", params);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("sanphams", getSanpham());
		return "admin/sanpham";
	}
	
	@RequestMapping(value="xoasp/{id}")
	public String xoasp(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			RestTemplate rt = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			rt.delete(URL+"/hanghoa/{id}", params);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do dữ liệu còn sử dụng ở mục khác !");
		}
		
		model.addAttribute("sanphams", getSanpham());
		
		return "admin/sanpham";
	}
	
	@RequestMapping("capnhatsp/{id}")
	public String capnhatsp(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		HangHoa sanpham = rt.getForObject(URL+"/hanghoa/{id}", HangHoa.class, params);
		model.addAttribute("sanpham",sanpham);
		model.addAttribute("sanphams", getSanpham());
		return "admin/capnhatsp";
	}

	@RequestMapping(value="capnhatsp/{id}", method=RequestMethod.POST)
	public String capnhatsp1(ModelMap model,@Validated @ModelAttribute("sanpham")HangHoa sanpham, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		
		String anh = request.getParameter("photo");
		try {
			
			if(anh.isEmpty())
			{
				sanpham.setAnh(sanpham.getAnh());
			}
			else{sanpham.setAnh(anh);}
				
			RestTemplate rt = new RestTemplate();
			rt.put(URL+"/hanghoa", sanpham, String.class);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
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
			String matkhaumoi = randomNumber();
		try {
			RestTemplate rt = new RestTemplate();
			taikhoan.setAnh("khanhvuong.jpg");
			taikhoan.setPassword(matkhaumoi);
			rt.postForObject(URL+"/taikhoan", taikhoan, String.class);
			
			mailer.send("diepkvuong3012@gmail.com", taikhoan.getEmail(), "XÁC NHẬN", "Đăng kí thành công với Mã tài khoản là: " + taikhoan.getId() + "\nQuay lại trang đăng nhập để mua hàng ngay!" +"Mật khẩu của bạn là: " + matkhaumoi + " . Vui lòng đăng nhập lại để thay đổi mật khẩu mới. ");
			model.addAttribute("message", "Thêm nhân viên thành công !");
			return "redirect:/admin/taikhoan.html";
			
			}catch(Exception ex) {
			model.addAttribute("message", "");
			}
		return "admin/themnv";
	}
	
	
	@RequestMapping("capnhatth/{id}")
	public String capnhatth(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		ThuongHieu thuonghieu = rt.getForObject(URL+"/thuonghieu/{id}", ThuongHieu.class, params);
		model.addAttribute("thuonghieu",thuonghieu);
		return "admin/capnhatth";
	}

	@RequestMapping(value="capnhatth/{id}", method=RequestMethod.POST)
	public String capnhatth1(ModelMap model,@Validated @ModelAttribute("thuonghieu")ThuongHieu thuonghieu, BindingResult errors,
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
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
			rt.put(URL+"/thuonghieu/"+thuonghieu.getId(), thuonghieu, String.class);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		TheLoai theloai = rt.getForObject(URL+"/theloai/{id}", TheLoai.class, params);
		model.addAttribute("theloai",theloai);
		return "admin/capnhattl";
	}

	@RequestMapping(value="capnhattl/{id}", method=RequestMethod.POST)
	public String capnhattl1(ModelMap model,@Validated @ModelAttribute("theloai")TheLoai theloai,BindingResult errors, 
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			rt.put(URL+"/theloai/"+theloai.getId(), theloai, String.class);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/theloai.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		}
		return "admin/capnhattl";		
	}
	
	@RequestMapping("capnhatgianhap/{idHH}")
	public String capnhatgianhap(ModelMap model, @PathVariable("idHH") String idHH, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("idHH", idHH);
		GiaNhap gianhap = rt.getForObject(URL+"/hanghoa/gianhaphang/{idHH}", GiaNhap.class, params);
		model.addAttribute("gianhap",gianhap);
		return "admin/capnhatgianhap";
	}

	@RequestMapping(value="capnhatgianhap/{idHH}", method=RequestMethod.POST)
	public String capnhatgn(ModelMap model,@ModelAttribute("gianhap")GiaNhap gianhap, 
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			rt.put(URL+"/chitietgianhap", gianhap, String.class);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/gianhap.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		}
		return "admin/capnhatgianhap";		
	}



	
	@RequestMapping(value="themsp")
	public String themsanpham(@Validated @ModelAttribute("sanpham")HangHoa sanpham,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		GiaNhap gianhap=new GiaNhap();
		String giahh = request.getParameter("giaNhap");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			rt.postForObject(URL+"/hanghoa", sanpham, String.class);
			gianhap.setNgayApDung(LocalDate.now().toString().trim());
			gianhap.setIdHH(sanpham.getId());
			gianhap.setGia(new BigDecimal(giahh));
			rt.postForObject(URL+"/chitietgianhap", gianhap, String.class);
			model.addAttribute("message", "Thêm thành công !");
			return "redirect:/admin/sanpham.html";
		}catch(Exception ex) {
			model.addAttribute("message", "");
		}
		}
		return "admin/themsp";
	}
	//=====================================================THE LOAI=============================================//
	
	@RequestMapping("theloai")
	public String theloai(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("theloais", getTheLoai());
		return "admin/theloai";
		
	}
	
	@RequestMapping("gianhap")
	public String gianhap(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("gianhaps", getGiaNhap());
		return "admin/gianhap";
		
	}
	
	@RequestMapping(value="themtl")
	public String themtl(@Validated @ModelAttribute("theloai")TheLoai theloai,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			rt.postForObject(URL+"/theloai", theloai, String.class);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		try {
			RestTemplate rt = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			rt.delete(URL+"/theloai/{id}", params);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("donhangs", getDonHang());
			model.addAttribute("chitietdons", getChiTietDonHang());
		return "admin/chitietdon";
		
	}
	
	@RequestMapping("thuonghieu")
	public String thuonghieu(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("thuonghieus", getThuongHieu());
		return "admin/thuonghieu";
	}
	@RequestMapping(value="xoath/{id}")
	public String xoath(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		try {
			RestTemplate rt = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			rt.delete(URL+"/thuonghieu/{id}", params);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		try {
			RestTemplate rt = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			rt.delete(URL+"/taikhoan/{id}", params);
			model.addAttribute("message", "Xóa thành công !");
			return "redirect:/admin/taikhoan.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Xóa thất bại ! Do tài khoản có đơn hàng hoặc không thể xóa chính mình!");
		}
		
		model.addAttribute("taikhoans", getTaiKhoan());
		
		return "admin/taikhoan";
	}
	
	@RequestMapping(value="themth")
	public String themth(@Validated @ModelAttribute("thuonghieu")ThuongHieu thuonghieu,BindingResult errors, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		if(errors.hasErrors()){
			model.addAttribute("message","Vui lòng kiểm tra lỗi!");
		}
		else {
		try {
			RestTemplate rt = new RestTemplate();
			rt.postForObject(URL+"/thuonghieu", thuonghieu, String.class);
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
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("taikhoans", getTaiKhoan());
		return "admin/taikhoan";
		
	}
	
	@RequestMapping("capnhatphieunhap/{id}")
	public String capnhatpn1(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		PhieuNhapHang nhaphang = rt.getForObject(URL+"/phieunhaphang/{id}", PhieuNhapHang.class, params);
		model.addAttribute("nhaphang",nhaphang);
		return "admin/capnhatphieunhap";
	}

	@RequestMapping(value="capnhatphieunhap/{id}", method=RequestMethod.POST)
	public String capnhatpn(ModelMap model, @ModelAttribute("nhaphang")PhieuNhapHang nhaphang, 
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		try {
			RestTemplate rt = new RestTemplate();
			nhaphang.setNgayLap(new Date());
			rt.put(URL+"/phieunhaphang", nhaphang, String.class);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/phieunhaphang.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/capnhatphieunhap";		
	}

	
	@RequestMapping("kiemtradon")
	public String kiemtradon(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		model.addAttribute("donhangs", getDonHang());
		return "admin/kiemtradon";
		
	}	
	
	@RequestMapping("capnhatdon/{id}")
	public String capnhatdon(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){ 
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		RestTemplate rt = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		PhieuDatHang donhang = rt.getForObject(URL+"/phieudathang/{id}", PhieuDatHang.class, params);
		model.addAttribute("donhang",donhang);
		return "admin/capnhatdon";
	}

	@RequestMapping(value="capnhatdon/{id}", method=RequestMethod.POST)
	public String capnhatdon1(ModelMap model, @ModelAttribute("donhang")PhieuDatHang donhang, 
			 HttpServletRequest request, HttpServletResponse response){
		HttpSession adsession = request.getSession();
		adsession.getAttribute("admin");
		if(adsession.getAttribute("admin")==null){
			return "redirect:/home/dangnhap.html";
		}
		try {
			RestTemplate rt = new RestTemplate();
			donhang.setNgayLap(new Date());
			rt.put(URL+"/phieudathang", donhang, String.class);
			model.addAttribute("message", "Cập nhật thành công !");
			return "redirect:/admin/kiemtradon.html";
		}catch(Exception ex) {
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "admin/capnhatdon";		
	}

}