package com.ssv.template.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ssv.template.data.repository.AccountRepository;

@Component("WebUserDetailsService")
public class AccountAuthService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new AccountRepository().findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("存在しないアカウントコードです:" + email));
	}

}
