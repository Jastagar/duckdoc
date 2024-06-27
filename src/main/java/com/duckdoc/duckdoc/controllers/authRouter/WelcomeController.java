package com.duckdoc.duckdoc.controllers.authRouter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.duckdoc.duckdoc.authenticate.Authenticate;

//@SessionAttributes // These are used to save attribute across the controllers.
@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Authenticate authenticateService;	

	public WelcomeController(Authenticate auth) {
		super();
		this.authenticateService = auth;
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getLogin(ModelMap model) {
		model.put("name", getLoggedUser());
		return "welcome";
	}
	
	private String getLoggedUser() {
		Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
		return authUser.getName();
	}
}
