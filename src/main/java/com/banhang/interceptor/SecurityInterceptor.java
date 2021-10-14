package com.banhang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.banhang.model.TaiKhoan;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("admin");
			HttpSession v = request.getSession();
			if(v.getAttribute("admin")==null){
			response.sendRedirect(request.getContextPath()+ "/home/dangnhap.html");
			return false;
		}
		return true;
	}
}
