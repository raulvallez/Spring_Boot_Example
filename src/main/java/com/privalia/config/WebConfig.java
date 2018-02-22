package com.privalia.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//url donde podremos gestionar la BBDD

@Configuration
public class WebConfig {

	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
		registrationBean.addUrlMappings("/console/*"); //http://localhost:8080/console
		return registrationBean;
	}
}
