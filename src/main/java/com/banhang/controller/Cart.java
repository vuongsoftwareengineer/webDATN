package com.banhang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.banhang.model.SetGioHang;
import com.banhang.model.GioHang;
import com.banhang.model.HangHoa;

@Controller
@Transactional
public class Cart {
	@Autowired
	SessionFactory factory;

	private static final String URL = "http://localhost:8080";
//	private static final String URL ="https://khanhvuong.herokuapp.com";

	@RequestMapping("/quantityChange")
	public String xulyTangGiam(HttpServletRequest request, @RequestParam("id") String id,
			@RequestParam("quantity") int quantity, ModelMap model) {
		SetGioHang mycart = Utils.getCartInSession(request);
		for (GioHang line : mycart.getCartLines()) {
			if (line.getProductInfo().getId().equals(id)) {
				line.setQuantity(quantity);
				return "redirect:/mycart.html";
			}
		}
		return "redirect:/mycart";
	}

	@RequestMapping("/mycart")
	public String onAddToCart(HttpServletRequest request, @RequestParam(value = "id", defaultValue = "") String id,
			ModelMap model) {
		SetGioHang mycart = Utils.getCartInSession(request);
		try {
			RestTemplate rt = new RestTemplate();
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			HangHoa product = rt.getForObject(URL+"guest/hanghoa/{id}", HangHoa.class, params);
			if (!id.equals(""))
				mycart.addProduct(product, 1);
			
		}catch (Exception e) {
			
		}
		model.addAttribute("mycart", mycart);
			return "home/giohang";
	}

	public String loadCart() {

		return "";
	}
	
	
}
