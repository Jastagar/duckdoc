package com.duckdoc.duckdoc.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails userDObject1 = createUser("jastagar", "1234");
		UserDetails userDObject2 = createUser("aryan", "5678");
		UserDetails userDObject3 = createUser("tanish", "2468");
		UserDetails userDObject4 = createUser("arya", "1357");
		
		
		return new InMemoryUserDetailsManager(userDObject1,userDObject2,userDObject3,userDObject4); 
	}

	private UserDetails createUser(String username, String password) {
		Function<String, String> passwordEncoderLambdaFunction = input -> passwordEncoder().encode(input);
		UserDetails userDObject = User
			.builder()
			.passwordEncoder(passwordEncoderLambdaFunction)
			.username(username)
			.password(password)
			.roles("USER","ADMIN")
			.build();
		return userDObject;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
