package com.ssafy.ssafit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.ssafit.util.JwtUtil;


@Component
public class JwtInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "access-token";

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(request.getMethod().equals("OPTIONS")) {
			System.out.println("1번");
			return true;			
		}
		
		String token = request.getHeader(HEADER_AUTH);

		if (token != null) {
			jwtUtil.valid(token);
			System.out.println("2번");
			return true; // 진행시켜
		}

		throw new Exception("유효하지 않는 접근이다.");

	}

}
