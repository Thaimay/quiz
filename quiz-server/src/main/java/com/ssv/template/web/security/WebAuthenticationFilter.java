package com.ssv.template.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssv.template.utils.PasswordUitls;

public class WebAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String pass = request.getParameter("password");
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(code, PasswordUitls.encrypt(pass));

		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}
}
