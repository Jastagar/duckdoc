package com.duckdoc.duckdoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
	
	@Autowired
	public ConfigurationClass configure;
	
	@RequestMapping("/config")
	public ConfigurationClass getAllConfig() {
		return configure;
	};
	
}
