package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userdetailsService;

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().
	 * anyRequest().authenticated(); }
	 */

	@Bean 
	public AuthenticationProvider authenticationProvider() 
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	  	provider.setUserDetailsService(userdetailsService);
	  	provider.setPasswordEncoder(new BCryptPasswordEncoder()); 
	  	return provider; 
	}

	/*
	 * @Bean public AuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userdetailsService);
	 * provider.setPasswordEncoder(new BCryptPasswordEncoder()); return provider; }
	 */

	/*
	 * @Bean public AuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userdetailsService);
	 * provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); return
	 * provider; }
	 */

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("admin").password(
	 * "admin").roles("USER").build()); return new
	 * InMemoryUserDetailsManager(users); }
	 */

}
