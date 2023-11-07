package com.orders.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetails() {

		List<UserDetails> users = new ArrayList<>();
		
		users.add(User.withUsername("admin").password("{noop}admin").roles("USERS", "ADMIN").build());

		return new InMemoryUserDetailsManager(users);

	}

	  @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	     
	        
	        http.authorizeRequests()
	        .antMatchers(HttpMethod.GET, "/orders/get/all").hasRole("ADMIN")
	        .antMatchers(HttpMethod.GET, "/orders/single/{orderId}").hasRole("ADMIN")
	        .antMatchers(HttpMethod.POST, "/orders/add").hasRole("ADMIN")
	        .antMatchers(HttpMethod.POST, "/orders/payment").hasRole("ADMIN")
			.anyRequest().permitAll()				
			.and().csrf().disable()
			.httpBasic(Customizer.withDefaults());
			

	return http.build();
	       
	    }
}
