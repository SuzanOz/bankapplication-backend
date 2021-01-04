package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bank.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity 
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {

	@Autowired //Dependency Injection
	UserDetailsServiceImpl userDetailService; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//inMemoryAuthentication() hard coding. Will change it later.
		//Authentication 
		auth.userDetailsService(userDetailService);									
	}
	
	//Authorization 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMIN", "USER")
			.antMatchers("/").permitAll().and().formLogin();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
