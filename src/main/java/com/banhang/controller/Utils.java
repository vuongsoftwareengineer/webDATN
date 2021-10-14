package com.banhang.controller;

import javax.servlet.http.HttpServletRequest;

import com.banhang.model.SetGioHang;


public class Utils {
	
	public static SetGioHang getCartInSession(HttpServletRequest request) {

		SetGioHang cartInfo = (SetGioHang) request.getSession().getAttribute("myCart");

		if (cartInfo == null) {
			cartInfo = new SetGioHang();
			request.getSession().setAttribute("myCart", cartInfo);
		}

		return cartInfo;
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static void storeLastOrderedCartInSession(HttpServletRequest request, SetGioHang cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	public static SetGioHang getLastOrderedCartInSession(HttpServletRequest request) {
		return (SetGioHang) request.getSession().getAttribute("lastOrderedCart");
	}

}
