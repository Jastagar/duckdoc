package com.duckdoc.duckdoc.authenticate;

import org.springframework.stereotype.Service;

@Service
public class Authenticate {
	
	public boolean isValidAuth(String name, String password) {
			
		boolean isValidName = name.equalsIgnoreCase("jastagar");
		boolean isValidPassword = password.equalsIgnoreCase("1234");
		
		return isValidName && isValidPassword;
	}
}
