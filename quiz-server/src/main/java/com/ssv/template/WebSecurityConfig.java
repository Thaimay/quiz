package com.ssv.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ssv.template.web.security.AuthenticationFilter;
import com.ssv.template.web.security.LoginPasswordEncoder;
import com.ssv.template.web.security.WebAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationFilter authenticationProvider;

	@Autowired
	@Qualifier("WebUserDetailsService")
	private UserDetailsService service;

	@Autowired
	@Qualifier("WebSuccessHandler")
	private AuthenticationSuccessHandler successHandler;

	@Autowired
	@Qualifier("WebFailureHandler")
	private AuthenticationFailureHandler failureHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// 認証していないアクセスがあった場合の設定
		// http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

		// 認可の設定
		http.antMatcher("/web/**").authorizeRequests()
				// 認証無しでアクセスできるURLを設定
				.antMatchers("/web/login/**").permitAll()
				// 上記以外は認証が必要にする設定
				.anyRequest().authenticated();

		// CSRF無効
		http.csrf().disable();

		WebAuthenticationFilter filter = new WebAuthenticationFilter();
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/web/login/process", "GET"));
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationSuccessHandler(successHandler);
		filter.setAuthenticationFailureHandler(failureHandler);
		http.addFilterBefore(filter, WebAuthenticationFilter.class);

		// ログイン設定
		http.formLogin()
				// 認証処理のパスを設定
				.loginProcessingUrl("/web/login/process")
				// ログインフォームのパスを設定
				.loginPage("/web/login")
				// 認証成功時にリダイレクトするURLを設定
				.defaultSuccessUrl("/web/")
				// 認証成功時に呼ばれるハンドラクラスを設定
				.successHandler(successHandler)
				// 認証失敗時にリダイレクトするURLを設定
				.failureUrl("/web/login?error=true")
				// ユーザー名、パスワードのパラメータ名を設定
				.usernameParameter("code").passwordParameter("password");
		// ログアウト設定
		http.logout().logoutUrl("/web/logout");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new LoginPasswordEncoder());
	}
}
