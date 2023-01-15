package com.campingmapping.team4.spring.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


//相當於mvc-servlet.xml的Java程式組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.campingmapping.team4.spring")
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".html");
		return irvr;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("t4_24camp/admin/CampIndex");
//		registry.addRedirectViewController("/", "membersmain.controller");
//		registry.addViewController("/funny.action").setViewName("form");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView mjView = new MappingJackson2JsonView();
		mjView.setPrettyPrint(true);
		return mjView;
	}
	
	@Bean
	public Jaxb2Marshaller jaxb2() {
		Jaxb2Marshaller jm2 = new Jaxb2Marshaller();
		jm2.setPackagesToScan("com.campingmapping.team4.spring");
		return jm2;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		ArrayList<View> list = new ArrayList<View>();
		list.add(jsonView());
		cnvr.setDefaultViews(list);
		return cnvr;
	}
}
