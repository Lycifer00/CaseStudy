package com.lycifer.Note;

import com.lycifer.Note.service.Impl.NoteServiceImpl;
import com.lycifer.Note.service.Impl.NoteTypeServiceImpl;
import com.lycifer.Note.service.NoteService;
import com.lycifer.Note.service.NoteTypeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
public class NoteApplication implements WebMvcConfigurer {

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/bootstrap/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
//		registry.addResourceHandler("/resources/jquery/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");
//		registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
//	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
//	}

	@Bean
	public NoteService noteService(){
		return new NoteServiceImpl();
	}

	@Bean
	public NoteTypeService noteTypeService() {
		return new NoteTypeServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}

}

