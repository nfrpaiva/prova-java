package br.com.tokiomarine.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProvaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/webjars/**")
        .addResourceLocations("/webjars/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	

}
