package com.ssv.template.web.security;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ssv.template.data.repository.AccountRepository;
import com.ssv.template.model.Account;

@Configuration
public class AuthenticationFilter implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String email = (String) auth.getPrincipal();
		Optional<Account> account = new AccountRepository().findByEmail(email);

		if (account.isPresent()) {
			return new UsernamePasswordAuthenticationToken(account.get(), new LoginPasswordEncoder());
		} else {
			throw new BadCredentialsException("Authentication Error");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
