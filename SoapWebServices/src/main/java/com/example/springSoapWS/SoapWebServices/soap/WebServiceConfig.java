package com.example.springSoapWS.SoapWebServices.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	//message dispatcher servlet
	//application context
	//url
	//mapping message DS to url
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet=new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
		
	}
	
	@Bean(name="course")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
		
		DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://iramwebservices.soap/course");
		definition.setLocationUri("/ws");
		definition.setSchema(courseSchema);
		
		return definition;
	}
	
	
	
	
	//use xsd schema to create WSDL
	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("courseDetailsSchema.xsd"));
	}

}
