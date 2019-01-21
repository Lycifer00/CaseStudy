package com.lycifer.Note;

import com.lycifer.Note.service.Impl.NoteServiceImpl;
import com.lycifer.Note.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteApplication {

	@Bean
	public NoteService noteService(){
		return new NoteServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}

}

