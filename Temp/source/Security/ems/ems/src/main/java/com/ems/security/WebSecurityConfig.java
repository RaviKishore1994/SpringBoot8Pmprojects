package com.ems.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder  encoder;
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers("/delete**").hasAnyRole("ADMIN")
		 .anyRequest().authenticated()
		 .and()
		// .httpBasic()  -- basic authentication model
		 .formLogin()  // form based authentication model
		 .and()
		 .exceptionHandling().accessDeniedPage("/WEB-INF/views/accessDenied.jsp")
		 .and().csrf().disable();
		
		http.sessionManagement().maximumSessions(1);
		
		http.logout().logoutUrl("/logoutMe").logoutSuccessUrl("/loggedOut").permitAll();
		
		http.requiresChannel().anyRequest().requiresSecure();
		
	}
	
	@Autowired
	public void  configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		/*
		builder.inMemoryAuthentication()
		.withUser("Ritik").password(encoder.encode("123456")).roles("ADMIN")
		.and()
		.withUser("Ankit").password(encoder.encode("ankit@123")).roles("LEAD");
		*/
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority  from authorities where username=?")
		.passwordEncoder(encoder);
	}
	
	@Bean
	public  BCryptPasswordEncoder  bcrypt() {
		return  new  BCryptPasswordEncoder();
	}

}
