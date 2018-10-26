package com.ssv.template.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public final class PasswordUitls {

	public static String encrypt(String raw) {
		return new Md5PasswordEncoder().encodePassword(raw, null);
	}
}
