package com.duckdoc.duckdoc.controllers.authRouter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class Auth {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Authenticate authenticateService;	

	public Auth(Authenticate auth) {
		super();
		this.authenticateService = auth;
	}
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String getLogin() {
		return "login/page";
	}
	@RequestMapping(value="login",method= RequestMethod.POST)
	public String postLogin(@RequestParam String name, @RequestParam String password, ModelMap map) {
		
		if(authenticateService.isValidAuth(name, password)) {
			map.put("name",name);
			map.put("password",password);
			return "welcome";			
		}
		logger.debug("Aapka naam {} hai",name);
		return "failedLogin";
		
//		System.out.println("Name: "+name);
	}
}
