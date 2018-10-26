package com.ssv.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("ApiFailureHandler")
	private AuthenticationFailureHandler failureHandler;

	@Autowired
	@Qualifier("ApiSuccessHandler")
	private AuthenticationSuccessHandler successHandler;

	@Autowired
	@Qualifier("ApiAuthenticationEntryPoint")
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// 認証していないアクセスがあった場合の設定
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

		// 認可の設定
		http.antMatcher("/api/**").authorizeRequests()
				// 認証無しでアクセスできるURLを設定
				.antMatchers("/api/login/**").permitAll();
				// 上記以外は認証が必要にする設定
				//.anyRequest().authenticated();

		// CSRF無効
		http.csrf().disable();

		// ログイン設定
		http.formLogin()
				// 認証処理のパスを設定
				.loginProcessingUrl("/api/login")
				// 認証成功時に呼ばれるハンドラクラスを設定
				.successHandler(successHandler)
				// 認証失敗時にリダイレクトするURLを設定
				// .failureUrl("/menu/")
				// 認証失敗時に呼ばれるハンドラクラスを設定
				.failureHandler(failureHandler)
				// ユーザー名、パスワードのパラメータ名を設定
				.usernameParameter("email").passwordParameter("password");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(service).passwordEncoder(new Md5PasswordEncoder());
	}
}
