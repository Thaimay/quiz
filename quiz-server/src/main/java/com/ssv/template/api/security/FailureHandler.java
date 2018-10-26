package com.ssv.template.api.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("ApiFailureHandler")
public class FailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		request.getSession().invalidate();
		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		response.getWriter().append("login failed : " + exception.getMessage());
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().flush();
	}

}
