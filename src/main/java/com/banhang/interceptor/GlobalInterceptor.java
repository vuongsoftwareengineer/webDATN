package com.banhang.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.banhang.model.HangHoa;


public class GlobalInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	SessionFactory factory;
//	private static final String URL ="https://khanhvuong.herokuapp.com";

	@Override
	public boolean preHandle (HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception{
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<HangHoa[]> responseEntity = 
	restTemplate.getForEntity("http://localhost:8080/hanghoa", HangHoa[].class);
	HangHoa[] responseBody = responseEntity.getBody();
	List<HangHoa> list = Arrays.asList(responseBody);
		request.setAttribute("sanphams", list);
		System.out.println("Load danh sách sản phẩm");
		return true;
	}
}
