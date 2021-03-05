package com.ems.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.servlet.ExceptionHandlingDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	DataSource dataSource;
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception
	{
		
		http.authorizeRequests()
		.antMatchers("/delete**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
	//	.httpBasic()
		.formLogin()
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/accessDenied.jsp")
		.and().csrf().disable();
		
		http.sessionManagement().maximumSessions(1);
		http.logout().logoutUrl("/logoutMe").logoutSuccessUrl("/loggedOut").permitAll();
		http.requiresChannel().anyRequest().requiresSecure();
		
		
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception
	{
		/*builder.inMemoryAuthentication()
		.withUser("VEERBabu").password(encoder.encode("1234")).roles("ADMIN")
		.and()
		.withUser("ravi").password(encoder.encode("456")).roles("TeamLead");*/
		
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from mysql_mahadev.users where username=?")
		.authoritiesByUsernameQuery("select username,authority from mysql_mahadev.authorities where username=?")
		.passwordEncoder(encoder);
	}
	@Bean
	public  BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}
