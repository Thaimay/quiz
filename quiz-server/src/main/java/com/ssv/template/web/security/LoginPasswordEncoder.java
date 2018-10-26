package com.ssv.template.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return "";
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.equals(encodedPassword);
	}

}
