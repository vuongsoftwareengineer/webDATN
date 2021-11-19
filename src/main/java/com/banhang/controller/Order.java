package com.banhang.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.banhang.model.SetGioHang;
import com.banhang.model.GioHang;
import com.banhang.model.CT_PhieuDatHang;
import com.banhang.model.PhieuDatHang;
import com.banhang.model.Mailer;
import com.banhang.model.TaiKhoan;
@Controller
@Transactional
public class Order {
	@Autowired
	SessionFactory factory;
	private static final String URL = "http://localhost:8080";
//	private static final String URL ="https://khanhvuong.herokuapp.com";

	
	@Autowired
	Mailer mailer;

	@RequestMapping("/home/lichsu")
	public String showConfirm(ModelMap model) {
		model.addAttribute("orderdetail", new CT_PhieuDatHang());
		return "redirect:/home/lichsu.html";
	}
	
	 RestTemplate restTemplate=new RestTemplate();
	@RequestMapping(value = "/myoder", method = RequestMethod.POST)
	public String insertDonHang(HttpServletRequest request, ModelMap model) {
		SetGioHang myCart = Utils.getCartInSession(request);
		
		for (GioHang line : myCart.getCartLines()) {
			HttpSession usersession = request.getSession();
			TaiKhoan taikhoan = (TaiKhoan) usersession.getAttribute("taikhoan");
			if(usersession.getAttribute("taikhoan")==null){
				return "redirect:/home/dangnhap.html";
			}
			PhieuDatHang oder = new PhieuDatHang();
			RestTemplate rt1 = new RestTemplate();
			oder.setTaiKhoanId(taikhoan.getId());
			oder.setTrangThai(0);
			oder.setNgayLap(new Date());
			oder.setTaiKhoanId(taikhoan.getId());
			oder.setTongTien(line.getAmount());
			oder.setDiachi(taikhoan.getDiaChi());
			String idDH = "PDH"+Home.randomNumber();
			oder.setId(idDH);
			HttpHeaders headers = Home.getHeaders();
			HttpEntity<PhieuDatHang> dh = new HttpEntity<PhieuDatHang>(oder, headers);
	        rt1.postForLocation(URL+"customer/phieudathang", dh);
			if(!oder.getId().isEmpty())
			{
			RestTemplate rt2 = new RestTemplate();
			CT_PhieuDatHang orderDetail = new CT_PhieuDatHang();
			orderDetail.setIdPhieuDatHang(oder.getId());
			orderDetail.setIdHH(line.getProductInfo().getId());
			orderDetail.setSoLuong((line.getQuantity()));
			orderDetail.setId("CTDH"+Home.randomNumber());
			HttpEntity<CT_PhieuDatHang> ctdh = new HttpEntity<CT_PhieuDatHang>(orderDetail, headers);
	        rt2.postForLocation(URL+"customer/chitietdathang", ctdh);
			model.addAttribute("message", "Đặt hàng thành công! Vui lòng kiểm tra Email để biết thêm chi tiết");
			mailer.send("diepkvuong3012@gmail.com", taikhoan.getEmail(), "ĐẶT HÀNG THÀNH CÔNG", "Cám ơn quý khách đã tin tưởng sản phẩm của chúng tôi"
			+"\nChúng tôi sẽ cố gắng giao hàng sớm nhất cho bạn");
			model.addAttribute("message", "Đặt hàng thành công !");
			}
		}

			return "redirect:/home/lichsu.html";
	}


}
