package com.example.cursorspringhibernate;

import com.example.cursorspringhibernate.repository.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursorSpringHibernateApplication implements CommandLineRunner{

	@Autowired
	Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(CursorSpringHibernateApplication.class, args);

	}


	@Override
	public void run(String... args) {
		menu.run();
	}
}
