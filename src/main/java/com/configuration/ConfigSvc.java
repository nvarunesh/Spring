package com.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigSvc {
	
	@Value("${app.name}")
	public String name;

	@PostMapping("/name")
	public String getname() {
		return name;
	}
}
