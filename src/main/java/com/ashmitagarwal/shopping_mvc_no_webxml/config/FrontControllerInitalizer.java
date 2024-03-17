package com.ashmitagarwal.shopping_mvc_no_webxml.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class FrontControllerInitalizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {

		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		
		webApplicationContext.setConfigLocation("/WEB-INF/AppConfig.xml");
		
		DispatcherServlet myDispatcherServlet = new DispatcherServlet(webApplicationContext);

		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
				myDispatcherServlet);

		myCustomDispatcherServlet.setLoadOnStartup(1);
		
		myCustomDispatcherServlet.addMapping("/shopping.com/*");
	}
}
